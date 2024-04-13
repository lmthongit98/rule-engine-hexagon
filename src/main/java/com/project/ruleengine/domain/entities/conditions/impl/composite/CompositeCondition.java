package com.project.ruleengine.domain.entities.conditions.impl.composite;

import com.project.ruleengine.domain.entities.conditions.GenericCondition;
import com.project.ruleengine.domain.valueobject.LogicOperator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class CompositeCondition implements GenericCondition {

    protected final List<GenericCondition> conditions = new ArrayList<>();
    public void add(GenericCondition condition) {
        conditions.add(condition);
    }

    public List<GenericCondition> getConditions() {
        return conditions;
    }

    @Override
    public String getMvelExpression() {
        return conditions.stream().map(GenericCondition::getMvelExpression).collect(Collectors.joining(getLogicalOperator().getMvelOperator(), "(", ")"));
    }

    @Override
    public String getHumanReadableExpression() {
        return conditions.stream().map(GenericCondition::getMvelExpression).collect(Collectors.joining(getLogicalOperator().getHumanReadableOperator(), "(", ")"));
    }

    public abstract LogicOperator getLogicalOperator();

}
