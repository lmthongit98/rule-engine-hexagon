package com.project.ruleengine.infrastructure.persistence.variable;

import com.project.ruleengine.domain.entities.conditions.Variable;
import com.project.ruleengine.domain.services.interfaces.VariableDataRepository;
import com.project.ruleengine.domain.valueobject.VariableDataSource;

public class SQLVariableDataService implements VariableDataRepository {
    @Override
    public Object getValue(Variable variable, String applicationId) {
        return null;
    }

    @Override
    public VariableDataSource getVariableDataSource() {
        return VariableDataSource.SQL;
    }
}
