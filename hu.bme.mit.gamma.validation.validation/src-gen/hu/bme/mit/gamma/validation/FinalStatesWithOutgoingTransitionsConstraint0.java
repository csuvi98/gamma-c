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

import hu.bme.mit.gamma.validation.FinalStatesWithOutgoingTransitions;

public class FinalStatesWithOutgoingTransitionsConstraint0 implements IConstraintSpecification {

    private FinalStatesWithOutgoingTransitions querySpecification;

    public FinalStatesWithOutgoingTransitionsConstraint0() {
        querySpecification = FinalStatesWithOutgoingTransitions.instance();
    }

    @Override
    public String getMessageFormat() {
        return "The following node is a final state and should have no outgoing transitions: $node.name$.";
    }


    @Override
    public Map<String,Object> getKeyObjects(IPatternMatch signature) {
        Map<String,Object> map = new HashMap<>();
        map.put("node",signature.get("node"));
        return map;
    }

    @Override
    public List<String> getKeyNames() {
        List<String> keyNames = Arrays.asList(
            "node"
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
        return Severity.WARNING;
    }

    @Override
    public IQuerySpecification<? extends ViatraQueryMatcher<? extends IPatternMatch>> getQuerySpecification() {
        return querySpecification;
    }

}