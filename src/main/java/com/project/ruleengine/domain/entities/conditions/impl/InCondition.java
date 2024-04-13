package com.project.ruleengine.domain.entities.conditions.impl;

import com.project.ruleengine.domain.entities.conditions.Variable;
import com.project.ruleengine.domain.valueobject.Operator;
import com.project.ruleengine.domain.valueobject.DataType;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InCondition extends BaseCondition {

    private final String[] values;

    public InCondition(Variable variable, String value) {
        super(variable, value);
        this.values = value.split(";");
    }

    @Override
    public String getMvelExpression() {
        return null;
    }

    @Override
    public String getHumanReadableExpression() {
        return variable.getName() + " IN " + Arrays.stream(values).map(v -> "'" + v + "'").collect(Collectors.joining(", ", "[", "]"));
    }

    @Override
    public List<DataType> getValidTypes() {
        return List.of(DataType.STRING);
    }

    @Override
    public Operator getOperator() {
        return Operator.IN;
    }
}
