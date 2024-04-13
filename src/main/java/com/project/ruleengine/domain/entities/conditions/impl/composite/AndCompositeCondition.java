package com.project.ruleengine.domain.entities.conditions.impl.composite;

import com.project.ruleengine.domain.valueobject.LogicOperator;

public class AndCompositeCondition extends CompositeCondition {
    @Override
    public LogicOperator getLogicalOperator() {
        return LogicOperator.AND;
    }
}
