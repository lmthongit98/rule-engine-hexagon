package com.project.ruleengine.domain.services.impl;

import com.project.ruleengine.domain.entities.conditions.Variable;
import com.project.ruleengine.domain.services.interfaces.VariableDataRepository;
import com.project.ruleengine.domain.valueobject.VariableDataSource;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class VariableDataResolver {
    private final Map<VariableDataSource, VariableDataRepository> cache;

    public VariableDataResolver(List<VariableDataRepository> variableDataRepositories) {
        cache = variableDataRepositories.stream().collect(Collectors.toMap(VariableDataRepository::getVariableDataSource, Function.identity()));
    }

    public Object getVariableValue(Variable variable, String applicationId) {
        VariableDataRepository variableDataRepository = cache.get(variable.getDataSource());
        return variableDataRepository.getValue(variable, applicationId);
    }

}
