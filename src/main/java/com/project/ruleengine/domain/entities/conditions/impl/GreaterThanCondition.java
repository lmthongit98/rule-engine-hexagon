package com.project.ruleengine.domain.entities.conditions.impl;

import com.project.ruleengine.domain.valueobject.Operator;
import com.project.ruleengine.domain.valueobject.DataType;
import com.project.ruleengine.domain.entities.conditions.Variable;

import java.util.List;

public class GreaterThanCondition extends BaseCondition {


    public GreaterThanCondition(Variable variable, String value) {
        super(variable, value);
    }

    @Override
    public List<DataType> getValidTypes() {
        return List.of(DataType.NUMBER);
    }

    @Override
    public Operator getOperator() {
        return Operator.GREATER_THẠN;
    }


    @Override
    public String getMvelExpression() {
        return variable.getName() + " > " + value;
    }

    @Override
    public String getHumanReadableExpression() {
        return variable.getName() + " > " + value;
    }

}
