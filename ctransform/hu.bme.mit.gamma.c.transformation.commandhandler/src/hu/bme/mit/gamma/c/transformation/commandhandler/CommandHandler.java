package hu.bme.mit.gamma.c.transformation.commandhandler;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;

import com.google.inject.Injector;

import hu.bme.mit.gamma.c.transformation.CTransformer;
import hu.bme.mit.gamma.c.transformation.ActionSerializer;
import hu.bme.mit.gamma.lowlevel.xsts.transformation.LowlevelToXSTSTransformer;
import hu.bme.mit.gamma.lowlevel.xsts.transformation.actionprimer.ActionPrimer;
import hu.bme.mit.gamma.lowlevel.xsts.transformation.actionprimer.ChoiceInliner;
import hu.bme.mit.gamma.lowlevel.xsts.transformation.actionprimer.VariableCommonizer;
import hu.bme.mit.gamma.lowlevel.xsts.transformation.traceability.L2STrace;
import hu.bme.mit.gamma.statechart.language.ui.internal.LanguageActivator;
import hu.bme.mit.gamma.statechart.language.ui.serializer.StatechartLanguageSerializer;
import hu.bme.mit.gamma.statechart.lowlevel.transformation.GammaToLowlevelTransformer;
import hu.bme.mit.gamma.statechart.interface_.Package;
import hu.bme.mit.gamma.statechart.statechart.StatechartDefinition;
import hu.bme.mit.gamma.statechart.interface_.Component;

import hu.bme.mit.gamma.xsts.model.XSTS;
import hu.bme.mit.gamma.xsts.transformation.GammaToXSTSTransformer;

public class CommandHandler extends AbstractHandler {
	
	protected Logger logger = Logger.getLogger("GammaLogger");

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		try {
			ISelection sel = HandlerUtil.getActiveMenuSelection(event);
			if (sel instanceof IStructuredSelection) {
				IStructuredSelection selection = (IStructuredSelection) sel;
				if (selection.size() == 1) {
					if (selection.getFirstElement() instanceof IFile) {
						IFile firstElement = (IFile) selection.getFirstElement();
						String fileURISubstring = firstElement.getLocationURI().toString().substring(5);
						String parentFolder = fileURISubstring.substring(0, fileURISubstring.lastIndexOf("/"));
						String fileName = firstElement.getName();
						//String fileNameWithoutExtenstion = fileName.substring(0, fileName.lastIndexOf("."));
						ResourceSet resSet = new ResourceSetImpl();
						URI compositeSystemURI = URI.createPlatformResourceURI(firstElement.getFullPath().toString(), true);
						Resource resource = resSet.getResource(compositeSystemURI, true);
						Package gammaPackage = (Package) resource.getContents().get(0);
						StatechartDefinition gammaStatechart = getStatechart(gammaPackage);

						
						

						String fileNameWithoutExtenstion = gammaStatechart.getName();
						//Package gammaPackage = (Package) gammaStatechart.eContainer();
						GammaToLowlevelTransformer transformer = new GammaToLowlevelTransformer();
						hu.bme.mit.gamma.statechart.lowlevel.model.Package lowlevelPackage = transformer.execute(gammaPackage);
						normalSave(lowlevelPackage, parentFolder, fileNameWithoutExtenstion + ".lgsm");
						logger.log(Level.INFO, "The Gamma - low level statechart transformation has been finished.");
						logger.log(Level.INFO, "Starting Gamma low level - xSTS transformation.");
						// Note: the package is not in a resource
						LowlevelToXSTSTransformer lowlevelTransformer = new LowlevelToXSTSTransformer(lowlevelPackage);
						Entry<XSTS, L2STrace> resultModels = lowlevelTransformer.execute();
						XSTS xSts = resultModels.getKey();
						lowlevelTransformer.dispose();
						// XSTS to Java serializer
						ActionSerializer cActionSerializer = null;
						// Set the following variable to specify the action priming setting
						ActionPrimingSetting setting = ActionPrimingSetting.VARIABLE_COMMONIZER;
						if (setting == ActionPrimingSetting.VARIABLE_COMMONIZER) {
							ActionPrimer actionPrimer = new VariableCommonizer(); // Not necessary to use it for code generation
							cActionSerializer = new hu.bme.mit.gamma.c.transformation.CommonizedVariableActionSerializer(null); // Good for the original actions too
							// If we wanted to commonize the actions of the XSTS, we would have to do it here
							// ...
							xSts.setVariableInitializingAction(actionPrimer.transform(xSts.getVariableInitializingAction()));
							xSts.setConfigurationInitializingAction(actionPrimer.transform(xSts.getConfigurationInitializingAction()));
							xSts.setEntryEventAction(actionPrimer.transform(xSts.getEntryEventAction()));
							xSts.setMergedAction(actionPrimer.transform(xSts.getMergedAction()));
							xSts.setInEventAction(actionPrimer.transform(xSts.getInEventAction()));
							xSts.setOutEventAction(actionPrimer.transform(xSts.getOutEventAction()));
						}
						else {
							ActionPrimer actionPrimer = new ChoiceInliner(true);
							cActionSerializer = new hu.bme.mit.gamma.c.transformation.InlinedChoiceActionSerializer(null);
							xSts.setVariableInitializingAction(actionPrimer.transform(xSts.getVariableInitializingAction()));
							xSts.setConfigurationInitializingAction(actionPrimer.transform(xSts.getConfigurationInitializingAction()));
							xSts.setEntryEventAction(actionPrimer.transform(xSts.getEntryEventAction()));
							xSts.setMergedAction(actionPrimer.transform(xSts.getMergedAction()));
							xSts.setInEventAction(actionPrimer.transform(xSts.getInEventAction()));
							xSts.setOutEventAction(actionPrimer.transform(xSts.getOutEventAction()));
						}
						// Saving the xSTS model
						normalSave(xSts, parentFolder, fileNameWithoutExtenstion + ".gsts");
						normalSave(resultModels.getValue(), parentFolder, "." + fileNameWithoutExtenstion + ".l2s");
						logger.log(Level.INFO, "The Gamma low level - xSTS transformation has been finished.");
						logger.log(Level.INFO, "Starting xSTS serialization.");
						// Serializing the xSTS
						hu.bme.mit.gamma.xsts.transformation.serializer.ActionSerializer actionSerializer = hu.bme.mit.gamma.xsts.transformation.serializer.ActionSerializer.INSTANCE;
						CharSequence xStsString = actionSerializer.serializeXSTS(xSts);
						System.out.println(xStsString);
						logger.log(Level.INFO, "Starting xSTS Java code generation.");
						CTransformer exampleTransformer = new CTransformer(resource, xSts, true);
						cActionSerializer.setStructName(exampleTransformer.getStructName());
						
						
						
						
						IContainer pFolder = firstElement.getParent();
						
						String filePathHeader = pFolder.getLocation().toString() + File.separator + firstElement.getName().replaceFirst("[.][^.]+$", "")+ "StatechartHeader.h";
						//String filepath = parentFolder + File.separator + firstElement.getName().replaceFirst("[.][^.]+$", "")+ "SystemVerilog.sv";
						String filePathModel = pFolder.getLocation().toString() + File.separator + firstElement.getName().replaceFirst("[.][^.]+$", "")+ "CStatemachine.c";
						PrintWriter printModel = new PrintWriter(filePathModel, "UTF-8");
						exampleTransformer.setWrapperHeaderName(firstElement.getName().replaceFirst("[.][^.]+$", "")+ "WrappedStatemachineHeader.h");
						
						exampleTransformer.execute(firstElement.getName().replaceFirst("[.][^.]+$", "")+ "StatechartHeader.h");
						printModel.println(exampleTransformer.getModel());
						printModel.close();
						
						//String filePathHeader = pFolder.getLocation().toString() + File.separator + firstElement.getName().replaceFirst("[.][^.]+$", "")+ "StatechartHeader.h";
						PrintWriter printHeader = new PrintWriter(filePathHeader, "UTF-8");
						printHeader.println(exampleTransformer.getHeader());
						printHeader.close();
						
						List<String> publicHeaderFiles = exampleTransformer.getPublicHeaders();
						List<String> publicHeaderFileNames = exampleTransformer.getPublicHeaderFileNames();
						
						for(int header = 0; header < publicHeaderFiles.size(); header++) {
							String publicHeaderFilePath = pFolder.getLocation().toString() + File.separator + publicHeaderFileNames.get(header) + ".h";
							PrintWriter printPublicHeader = new PrintWriter(publicHeaderFilePath, "UTF-8");
							printPublicHeader.print(publicHeaderFiles.get(header));
							printPublicHeader.close();
						}
						
						String wrapperHeaderPathModel = pFolder.getLocation().toString() + File.separator + firstElement.getName().replaceFirst("[.][^.]+$", "")+ "WrappedStatemachineHeader.h";
						
						PrintWriter wrapperHeaderPrintModel = new PrintWriter(wrapperHeaderPathModel, "UTF-8");
						wrapperHeaderPrintModel.println(exampleTransformer.getWrapperHeader());
						wrapperHeaderPrintModel.close();
						
						
						String wrapperPathModel = pFolder.getLocation().toString() + File.separator + firstElement.getName().replaceFirst("[.][^.]+$", "")+ "WrappedStatemachine.c";
						PrintWriter wrapperPrintModel = new PrintWriter(wrapperPathModel, "UTF-8");
						wrapperPrintModel.println(exampleTransformer.getWrapper());
						wrapperPrintModel.close();
						
						logger.log(Level.INFO, "The xSTS transformation has been finished.");
						//Trace trace = exampleTransformer.execute();
						//saveModel(trace.getTargetPackage(), parentFolder.getLocation().toString(),
						//		trace.getTargetPackage().getName() + "Copy.gcd");
						
						
					} 
					logger.log(Level.INFO, "The Gamma statechart - Gamma statechart C transformation has been finished.");
				}
			}
		} catch (IOException e) {
				e.printStackTrace();
		}
		return null;
	}
	
	
	//public void run(StatechartDefinition gammaStatechart, String parentFolder, String targetFolderUri, String basePackageName, IFile firstElement, Resource resoure) {
		
	//}
	
	enum ActionPrimingSetting {
		VARIABLE_COMMONIZER, CHOICE_INLINER
	}
	
	/**
	 * Responsible for saving the given element into a resource file.
	 */
	public void saveModel(EObject rootElem, String parentFolder, String fileName) throws IOException {
		if (rootElem instanceof Package) {
			// A Gamma statechart model
			try {
				serialize(rootElem, parentFolder, fileName);
			} catch (Exception e) {
				e.printStackTrace();
				logger.log(Level.WARNING, e.getMessage() + System.lineSeparator() +
					"Possibly you have two more model elements with the same name specified in the previous error message.");
				new File(parentFolder + File.separator + fileName).delete();
				// Saving like an EMF model
				String newFileName = fileName.substring(0, fileName.lastIndexOf(".")) + ".gsm";
				normalSave(rootElem, parentFolder, newFileName);
			}
		}
		else {
			// It is not a statechart model, regular saving
			normalSave(rootElem, parentFolder, fileName);
		}
	}

	private StatechartDefinition getStatechart(Package _package) {
		Component component = _package.getComponents().get(0);
		return (StatechartDefinition) component;
	}
	
	protected void normalSave(EObject rootElem, String parentFolder, String fileName) throws IOException {
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource saveResource = resourceSet.createResource(URI.createFileURI(
				URI.decode(parentFolder + File.separator + fileName)));
		saveResource.getContents().add(rootElem);
		saveResource.save(Collections.EMPTY_MAP);
	}
	
	private void serialize(EObject rootElem, String parentFolder, String fileName) throws IOException {
		// This is how an injected object can be retrieved
		Injector injector = LanguageActivator.getInstance()
				.getInjector(LanguageActivator.HU_BME_MIT_GAMMA_STATECHART_LANGUAGE_STATECHARTLANGUAGE);
		StatechartLanguageSerializer serializer = injector.getInstance(StatechartLanguageSerializer.class);
		serializer.serialize(rootElem, parentFolder , fileName);
	}
	
	private void resolveResources(EObject object, ResourceSet resourceSet, Set<Resource> resolvedResources) {
		for (EObject crossObject : object.eCrossReferences()) {
			Resource resource = crossObject.eResource();
			if (resource != null && !resolvedResources.contains(resource)) {
				resourceSet.getResource(resource.getURI(), true);
				resolvedResources.add(resource);
			}
			resolveResources(crossObject, resourceSet, resolvedResources);
		}
		for (EObject containedObject : object.eContents()) {
			resolveResources(containedObject, resourceSet, resolvedResources);
		}
	}

}