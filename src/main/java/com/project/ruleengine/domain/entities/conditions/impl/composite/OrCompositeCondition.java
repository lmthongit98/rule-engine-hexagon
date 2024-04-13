package com.project.ruleengine.domain.entities.conditions.impl.composite;

import com.project.ruleengine.domain.valueobject.LogicOperator;

public class OrCompositeCondition extends CompositeCondition {
    @Override
    public LogicOperator getLogicalOperator() {
        return LogicOperator.OR;
    }
}
