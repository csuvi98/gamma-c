package hu.bme.mit.gamma.c.component.transformation.commandhandler;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
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

import hu.bme.mit.gamma.c.transformation.CTransformer;
import hu.bme.mit.gamma.statechart.language.ui.internal.LanguageActivator;
import hu.bme.mit.gamma.statechart.language.ui.serializer.StatechartLanguageSerializer;
import hu.bme.mit.gamma.xsts.model.model.XSTS;
import hu.bme.mit.gamma.xsts.transformation.GammaToXSTSTransformer;
import hu.bme.mit.gamma.statechart.interface_.Package;

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
						
						GammaToXSTSTransformer gammaToXSTSTransformer = new GammaToXSTSTransformer();
						
						XSTS xSts = gammaToXSTSTransformer.preprocessAndExecute(compositeSystem);
						
						//String filepath = parentFolder + File.separator + firstElement.getName().replaceFirst("[.][^.]+$", "")+ "SystemVerilog.sv";
						String filePathModel = parentFolder.getLocation().toString() + File.separator + firstElement.getName().replaceFirst("[.][^.]+$", "")+ "Component.c";
						PrintWriter printModel = new PrintWriter(filePathModel, "UTF-8");
						
						CTransformer cTransformer = new CTransformer(resource, xSts);
						
						cTransformer.execute("mind1");
						
						printModel.println(cTransformer.getModel());
						printModel.println(cTransformer.getHeader());
						printModel.println(cTransformer.getWrapper());
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
