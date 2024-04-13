package com.project.ruleengine.domain.services.interfaces;

import com.project.ruleengine.domain.entities.conditions.Variable;
import com.project.ruleengine.domain.valueobject.VariableDataSource;

public interface VariableDataRepository {

    Object getValue(Variable variable, String applicationId);

    VariableDataSource getVariableDataSource();

}
