/********************************************************************************
 * Copyright (c) 2018-2020 Contributors to the Gamma project
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * SPDX-License-Identifier: EPL-1.0
 ********************************************************************************/
package hu.bme.mit.gamma.querygenerator.controller;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;

import hu.bme.mit.gamma.querygenerator.ThetaQueryGenerator;
import hu.bme.mit.gamma.querygenerator.application.View;
import hu.bme.mit.gamma.statechart.model.Package;
import hu.bme.mit.gamma.theta.verification.ThetaVerifier;
import hu.bme.mit.gamma.verification.util.AbstractVerifier;

public class ThetaController extends AbstractController {
	
	final Package gammaPackage;

	public ThetaController(View view, IFile file) {
		this.file = file;
		this.view = view;
		URI uri = URI.createFileURI(getUnwrappedFile());
		this.gammaPackage = (Package) ecoreUtil.normalLoad(uri);
		this.queryGenerator = new ThetaQueryGenerator(gammaPackage); // For state-location
	}

	@Override
	public String getParameters() {
		return "";//"--domain EXPL";
	}

	@Override
	public String getModelFile() {
		return getLocation(file).substring(0, getLocation(file).lastIndexOf(".")) + ".xsts";
	}

	@Override
	public String getGeneratedQueryFile() {
		return null;
	}

	@Override
	public Object getTraceability() {
		return gammaPackage;
	}

	@Override
	public AbstractVerifier createVerifier() {
		return new ThetaVerifier();
	}

}
