package com.project.ruleengine.domain.entities.conditions.impl;

import com.project.ruleengine.domain.entities.conditions.Variable;
import com.project.ruleengine.domain.valueobject.Operator;
import com.project.ruleengine.domain.valueobject.DataType;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NotInCondition extends BaseCondition {

    private final String[] values;

    public NotInCondition(Variable variable, String value) {
        super(variable, value);
        values = value.split(";");
    }

    @Override
    public String getMvelExpression() {
        return null;
    }

    @Override
    public String getHumanReadableExpression() { // todo: this logic is technical logic depending on mvel lib, we should separate this into a visitor class
        return variable.getName() + " NOT IN " + Arrays.stream(values).map(v -> "'" + v + "'").collect(Collectors.joining(", ", "[", "]"));
    }

    @Override
    public List<DataType> getValidTypes() {
        return List.of(DataType.STRING);
    }

    @Override
    public Operator getOperator() {
        return Operator.NOT_IN;
    }
}
