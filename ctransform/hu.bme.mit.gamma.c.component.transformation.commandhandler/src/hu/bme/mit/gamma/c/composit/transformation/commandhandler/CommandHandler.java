package hu.bme.mit.gamma.c.composit.transformation.commandhandler;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;

import com.google.inject.Injector;

import hu.bme.mit.gamma.c.transformation.ActionSerializer;
import hu.bme.mit.gamma.c.transformation.CTransformer;
import hu.bme.mit.gamma.c.transformation.CommonizedVariableActionSerializer;
import hu.bme.mit.gamma.c.transformation.InlinedChoiceActionSerializer;
import hu.bme.mit.gamma.expression.model.Expression;
import hu.bme.mit.gamma.lowlevel.xsts.transformation.actionprimer.ActionPrimer;
import hu.bme.mit.gamma.lowlevel.xsts.transformation.actionprimer.ChoiceInliner;
import hu.bme.mit.gamma.lowlevel.xsts.transformation.actionprimer.VariableCommonizer;
import hu.bme.mit.gamma.statechart.interface_.Package;
import hu.bme.mit.gamma.statechart.language.ui.internal.LanguageActivator;
import hu.bme.mit.gamma.statechart.language.ui.serializer.StatechartLanguageSerializer;
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
						IContainer parentFolder = firstElement.getParent();
						ResourceSet resSet = new ResourceSetImpl();
						URI compositeSystemURI = URI.createPlatformResourceURI(firstElement.getFullPath().toString(), true);
						Resource resource = resSet.getResource(compositeSystemURI, true);
						// Model processing
						Package compositeSystem = (Package) resource.getContents().get(0);
						
						String filePathModel = parentFolder.getLocation().toString() + File.separator + firstElement.getName().replaceFirst("[.][^.]+$", "")+ "Component.c";
						
						List<Expression> expressionList = new ArrayList<Expression>();
						
						GammaToXSTSTransformer gammaToXSTSTransformer = new GammaToXSTSTransformer();
						
						File outputFile = new File(filePathModel);
						XSTS xSts = gammaToXSTSTransformer.preprocessAndExecute(compositeSystem,expressionList,outputFile);
						ActionSerializer cActionSerializer = null;
						ActionPrimer actionPrimer;// Good for the original actions too
						ActionPrimingSetting setting = ActionPrimingSetting.CHOICE_INLINER;
						if(setting == ActionPrimingSetting.CHOICE_INLINER) {
							actionPrimer = new ChoiceInliner();
							cActionSerializer = new InlinedChoiceActionSerializer(null);
							xSts.setVariableInitializingAction(actionPrimer.transform(xSts.getVariableInitializingAction()));
		                    xSts.setConfigurationInitializingAction(actionPrimer.transform(xSts.getConfigurationInitializingAction()));
		                    xSts.setEntryEventAction(actionPrimer.transform(xSts.getEntryEventAction()));
		                    xSts.setMergedAction(actionPrimer.transform(xSts.getMergedAction()));
		                    xSts.setInEventAction(actionPrimer.transform(xSts.getInEventAction()));
		                    xSts.setOutEventAction(actionPrimer.transform(xSts.getOutEventAction()));							
						}else {
							actionPrimer = new VariableCommonizer();
							cActionSerializer = new CommonizedVariableActionSerializer(null);
							xSts.setVariableInitializingAction(actionPrimer.transform(xSts.getVariableInitializingAction()));
		                    xSts.setConfigurationInitializingAction(actionPrimer.transform(xSts.getConfigurationInitializingAction()));
		                    xSts.setEntryEventAction(actionPrimer.transform(xSts.getEntryEventAction()));
		                    xSts.setMergedAction(actionPrimer.transform(xSts.getMergedAction()));
		                    xSts.setInEventAction(actionPrimer.transform(xSts.getInEventAction()));
		                    xSts.setOutEventAction(actionPrimer.transform(xSts.getOutEventAction()));							
						}
						
						
						hu.bme.mit.gamma.xsts.transformation.serializer.ActionSerializer xStsActionSerializer = hu.bme.mit.gamma.xsts.transformation.serializer.ActionSerializer.INSTANCE;
						CharSequence xStsString = xStsActionSerializer.serializeXSTS(xSts);
						System.out.println(xStsString);
						
						String compositionHeaderPath = parentFolder.getLocation().toString() + File.separator + firstElement.getName().replaceFirst("[.][^.]+$", "")+ "ComponentHeader.h";
						String compositionWrapperPath = parentFolder.getLocation().toString() + File.separator + firstElement.getName().replaceFirst("[.][^.]+$", "")+ "ComponentWrapper.c";
						String compositionWrapperHeaderPath = parentFolder.getLocation().toString() + File.separator + firstElement.getName().replaceFirst("[.][^.]+$", "")+ "ComponentWrapperHeader.h";
						
						
						//CTransformer cTransformer = new CTransformer
						
						//String filepath = parentFolder + File.separator + firstElement.getName().replaceFirst("[.][^.]+$", "")+ "SystemVerilog.sv";
						
						PrintWriter printModel = new PrintWriter(filePathModel, "UTF-8");
						CTransformer cTransformer = new CTransformer(resource, xSts, true);
						cActionSerializer.setStructName(cTransformer.getStructName());
						cTransformer.setWrapperHeaderName(firstElement.getName().replaceFirst("[.][^.]+$", "")+ "ComponentWrapperHeader.h");
						cTransformer.execute(firstElement.getName().replaceFirst("[.][^.]+$", "")+ "ComponentHeader.h");
						
						printModel.println(cTransformer.getModel());
						printModel.close();
						
						printModel = new PrintWriter(compositionHeaderPath, "UTF-8");
						printModel.println(cTransformer.getHeader());
						printModel.close();
						
						printModel = new PrintWriter(compositionWrapperPath, "UTF-8");
						printModel.println(cTransformer.getWrapper());
						printModel.close();
						
						printModel = new PrintWriter(compositionWrapperHeaderPath, "UTF-8");
						printModel.println(cTransformer.getWrapperHeader());
						printModel.close();
						
						
					} 
					logger.log(Level.INFO, "The Gamma statechart - Gamma statechart example transformation has been finished.");
				}
			}
		} catch (IOException e) {
				e.printStackTrace();
		}
		return null;
	}
	
	
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
				// Trying to serialize the model
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

}