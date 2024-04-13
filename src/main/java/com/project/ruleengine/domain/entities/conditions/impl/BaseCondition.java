package com.project.ruleengine.domain.entities.conditions.impl;

import com.project.ruleengine.domain.entities.common.BaseEntity;
import com.project.ruleengine.domain.entities.conditions.GenericCondition;
import com.project.ruleengine.domain.entities.conditions.Variable;
import com.project.ruleengine.domain.valueobject.ConditionId;
import com.project.ruleengine.domain.valueobject.DataType;
import com.project.ruleengine.domain.valueobject.Operator;

import java.util.List;


public abstract class BaseCondition extends BaseEntity<ConditionId> implements GenericCondition {

    protected final Variable variable;
    protected final String value;

    protected BaseCondition(Variable variable, String value) {
        getOperator().validateValue(value);
        this.variable = variable;
        this.value = value;
    }

    public abstract List<DataType> getValidTypes();

    public abstract Operator getOperator();

    public Variable getVariable() {
        return variable;
    }

}
