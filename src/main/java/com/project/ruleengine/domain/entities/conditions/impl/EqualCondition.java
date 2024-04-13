package com.project.ruleengine.domain.entities.conditions.impl;

import com.project.ruleengine.domain.entities.conditions.Variable;
import com.project.ruleengine.domain.valueobject.Operator;
import com.project.ruleengine.domain.valueobject.DataType;

import java.util.List;

public class EqualCondition extends BaseCondition {

    public EqualCondition(Variable variable, String value) {
        super(variable, value);
    }

    @Override
    public String getMvelExpression() {
        return variable.getName() + " == " + value;
    }

    @Override
    public String getHumanReadableExpression() {
        return variable.getName() + " = " + value;
    }

    @Override
    public List<DataType> getValidTypes() {
        return List.of(DataType.NUMBER, DataType.STRING);
    }

    @Override
    public Operator getOperator() {
        return Operator.EQUAL;
    }
}
