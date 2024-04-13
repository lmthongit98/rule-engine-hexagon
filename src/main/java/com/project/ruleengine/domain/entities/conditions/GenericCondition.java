package com.project.ruleengine.domain.entities.conditions;

public interface GenericCondition {
    String getMvelExpression();
    String getHumanReadableExpression();
}
