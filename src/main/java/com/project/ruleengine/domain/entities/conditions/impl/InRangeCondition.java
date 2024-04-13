package com.project.ruleengine.domain.entities.conditions.impl;

import com.project.ruleengine.domain.entities.conditions.Variable;
import com.project.ruleengine.domain.valueobject.LogicOperator;
import com.project.ruleengine.domain.valueobject.Operator;
import com.project.ruleengine.domain.valueobject.DataType;

import java.util.List;

public class InRangeCondition extends BaseCondition {

    private final Double min;
    private final Double max;

    public InRangeCondition(Variable variable, String value) {
        super(variable, value);
        String[] values = value.split(";");
        min = Double.parseDouble(values[0]);
        max = Double.parseDouble(values[1]);
    }


    @Override
    public List<DataType> getValidTypes() {
        return List.of(DataType.NUMBER);
    }

    @Override
    public Operator getOperator() {
        return Operator.IN_RANGE;
    }

    @Override
    public String getMvelExpression() {
        return "(" + variable.getName() +
                " >= " +
                min.toString() +
                LogicOperator.AND.getMvelOperator() +
                variable.getName() +
                " <= " +
                max.toString()
                + ")";
    }

    @Override
    public String getHumanReadableExpression() {
        return "(" + variable.getName() +
                " >= " +
                min.toString() +
                LogicOperator.AND.getHumanReadableOperator() +
                variable.getName() +
                " <= " +
                max.toString() + ")";
    }

}
