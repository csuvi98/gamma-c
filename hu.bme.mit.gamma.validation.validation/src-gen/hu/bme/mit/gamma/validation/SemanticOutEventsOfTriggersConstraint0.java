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

import hu.bme.mit.gamma.validation.SemanticOutEventsOfTriggers;

public class SemanticOutEventsOfTriggersConstraint0 implements IConstraintSpecification {

    private SemanticOutEventsOfTriggers querySpecification;

    public SemanticOutEventsOfTriggersConstraint0() {
        querySpecification = SemanticOutEventsOfTriggers.instance();
    }

    @Override
    public String getMessageFormat() {
        return "Triggers must contain events that \'\'come into\'\' the port. Through $port.name$ $event.name$ goes out.";
    }


    @Override
    public Map<String,Object> getKeyObjects(IPatternMatch signature) {
        Map<String,Object> map = new HashMap<>();
        map.put("eventTrigger",signature.get("eventTrigger"));
        map.put("port",signature.get("port"));
        map.put("event",signature.get("event"));
        return map;
    }

    @Override
    public List<String> getKeyNames() {
        List<String> keyNames = Arrays.asList(
            "eventTrigger",
            "port",
            "event"
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
