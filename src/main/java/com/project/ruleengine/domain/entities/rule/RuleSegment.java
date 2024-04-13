package com.project.ruleengine.domain.entities.rule;

import com.project.ruleengine.domain.entities.conditions.impl.BaseCondition;
import com.project.ruleengine.domain.exceptions.DomainException;
import com.project.ruleengine.domain.langparser.MVELParser;
import org.springframework.util.StringUtils;

import java.util.Map;
import java.util.Objects;

/**
 * If ruleApplicability is met, then evaluate formula, otherwise evaluate defaultValue
 */

public class RuleSegment {
    private String segmentName;
    private BaseCondition ruleApplicability; // optional
    private BaseCondition formula;
    private BaseCondition defaultValue; // optional

    // Private constructor
    private RuleSegment(Builder builder) {
        this.segmentName = builder.segmentName;
        this.ruleApplicability = builder.ruleApplicability;
        this.formula = builder.formula;
        this.defaultValue = builder.defaultValue;
    }

    public void validate() {
        if (
                (Objects.isNull(getRuleApplicability()) && Objects.nonNull(getDefaultValue())) ||
                        (Objects.nonNull(getRuleApplicability()) && Objects.isNull(getDefaultValue()))
        ) {
            throw new DomainException("Rule segment is not valid");
        }
        if (!StringUtils.hasText(segmentName)) {
            throw new DomainException("segmentName segment cannot be blank");
        }
        if (Objects.isNull(formula)) {
            throw new IllegalArgumentException("Formula cannot be null");
        }
    }

    public BaseCondition getCondition(Map<String, Object> variableDataMap) {
        if (Objects.isNull(ruleApplicability)) {
            return formula;
        }
        if (MVELParser.parseMvelExpression(ruleApplicability.getMvelExpression(), variableDataMap)) {
            return formula;
        }
        return defaultValue;
    }

    public String getSegmentName() {
        return segmentName;
    }

    public BaseCondition getRuleApplicability() {
        return ruleApplicability;
    }

    public BaseCondition getFormula() {
        return formula;
    }

    public BaseCondition getDefaultValue() {
        return defaultValue;
    }

    // Builder Class
    public static class Builder {
        private String segmentName;
        private BaseCondition ruleApplicability;
        private BaseCondition formula;
        private BaseCondition defaultValue;

        public Builder setSegmentName(String segmentName) {
            this.segmentName = segmentName;
            return this;
        }

        public Builder setRuleApplicability(BaseCondition ruleApplicability) {
            this.ruleApplicability = ruleApplicability;
            return this;
        }

        public Builder setFormula(BaseCondition formula) {
            this.formula = formula;
            return this;
        }

        public Builder setDefaultValue(BaseCondition defaultValue) {
            this.defaultValue = defaultValue;
            return this;
        }

        public RuleSegment build() {
            return new RuleSegment(this);
        }
    }

}
