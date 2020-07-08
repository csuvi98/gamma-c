/**

  Copyright (c) 2018 Contributors to the Gamma project
 
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
 
  SPDX-License-Identifier: EPL-1.0
*/
package hu.bme.mit.gamma.validation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Arrays;

import org.eclipse.viatra.addon.validation.core.api.Severity;
import org.eclipse.viatra.addon.validation.core.api.IConstraintSpecification;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.api.IQuerySpecification;
import org.eclipse.viatra.query.runtime.api.ViatraQueryMatcher;

import hu.bme.mit.gamma.validation.ChoicesWithTriggeredOutgoingTransitions;

public class ChoicesWithTriggeredOutgoingTransitionsConstraint0 implements IConstraintSpecification {

    private ChoicesWithTriggeredOutgoingTransitions querySpecification;

    public ChoicesWithTriggeredOutgoingTransitionsConstraint0() {
        querySpecification = ChoicesWithTriggeredOutgoingTransitions.instance();
    }

    @Override
    public String getMessageFormat() {
        return "Outgoing transitions of choices must not have triggers apart from default triggers.";
    }


    @Override
    public Map<String,Object> getKeyObjects(IPatternMatch signature) {
        Map<String,Object> map = new HashMap<>();
        map.put("choice",signature.get("choice"));
        map.put("transition",signature.get("transition"));
        return map;
    }

    @Override
    public List<String> getKeyNames() {
        List<String> keyNames = Arrays.asList(
            "choice",
            "transition"
        );
        return keyNames;
    }

    @Override
    public List<String> getPropertyNames() {
        List<String> propertyNames = Arrays.asList(
        );
        return propertyNames;
    }

    @Override
    public Set<List<String>> getSymmetricPropertyNames() {
        Set<List<String>> symmetricPropertyNamesSet = new HashSet<>();
        return symmetricPropertyNamesSet;
    }

    @Override
    public Set<List<String>> getSymmetricKeyNames() {
        Set<List<String>> symmetricKeyNamesSet = new HashSet<>();
        return symmetricKeyNamesSet;
    }

    @Override
    public Severity getSeverity() {
        return Severity.ERROR;
    }

    @Override
    public IQuerySpecification<? extends ViatraQueryMatcher<? extends IPatternMatch>> getQuerySpecification() {
        return querySpecification;
    }

}
