package com.project.ruleengine.infrastructure.persistence.mapper;

import com.project.ruleengine.domain.entities.conditions.impl.BaseCondition;
import com.project.ruleengine.domain.entities.conditions.impl.EqualCondition;
import com.project.ruleengine.domain.entities.conditions.impl.GreaterThanCondition;
import com.project.ruleengine.domain.entities.conditions.impl.InRangeCondition;
import com.project.ruleengine.domain.entities.rule.Rule;
import com.project.ruleengine.domain.entities.rule.RuleSegment;
import com.project.ruleengine.infrastructure.persistence.entities.ConditionEntity;
import com.project.ruleengine.infrastructure.persistence.entities.RuleEntity;
import com.project.ruleengine.infrastructure.persistence.entities.RuleSegmentEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@Component
public class RuleMapper {

    private final VariableMapper variableMapper;

    public Rule ruleEntityToRule(RuleEntity ruleEntity) {
        List<RuleSegment> ruleSegments = ruleEntity.getRuleSegments().stream().map(this::ruleSegmentEntityToRuleSegment).toList();
        Rule rule = new Rule.RuleBuilder()
                .setLender(ruleEntity.getLender())
                .setName(ruleEntity.getName())
                .setRuleSegments(ruleSegments)
                .setLogicOperator(ruleEntity.getLogicOperator())
                .setIsPrimary(ruleEntity.isPrimary())
                .build();
        rule.validateRule(); // need to validate, because data could be changed incorrectly from DB
        return rule;
    }

    private RuleSegment ruleSegmentEntityToRuleSegment(RuleSegmentEntity ruleSegmentEntity) {
        return new RuleSegment.Builder()
                .setSegmentName(ruleSegmentEntity.getSegmentName())
                .setRuleApplicability(createCondition(ruleSegmentEntity.getRuleApplicability()))
                .setFormula(createCondition(ruleSegmentEntity.getFormula()))
                .setDefaultValue(createCondition(ruleSegmentEntity.getDefaultValue()))
                .build();
    }

    public BaseCondition createCondition(ConditionEntity conditionEntity) {
        if (Objects.isNull(conditionEntity)) {
            return null;
        }
        return switch (conditionEntity.getOperator()) {
            case IN_RANGE ->
                    new InRangeCondition(variableMapper.variableEntityToVariable(conditionEntity.getVariable()), conditionEntity.getValue());
            case GREATER_THẠN ->
                    new GreaterThanCondition(variableMapper.variableEntityToVariable(conditionEntity.getVariable()), conditionEntity.getValue());
            case EQUAL ->
                    new EqualCondition(variableMapper.variableEntityToVariable(conditionEntity.getVariable()), conditionEntity.getValue());
            default ->
                    throw new IllegalArgumentException("The operator " + conditionEntity.getOperator() + " is not supported");
        };
    }


}
