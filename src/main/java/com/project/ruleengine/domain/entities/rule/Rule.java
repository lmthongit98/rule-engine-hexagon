package com.project.ruleengine.domain.entities.rule;

import com.project.ruleengine.domain.entities.common.AggregateRoot;
import com.project.ruleengine.domain.exceptions.DomainException;
import com.project.ruleengine.domain.valueobject.LogicOperator;
import com.project.ruleengine.domain.valueobject.RuleId;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;

public class Rule extends AggregateRoot<RuleId> {
    private String lender; // for primary rule only
    private String name;
    private List<RuleSegment> ruleSegments;
    private LogicOperator logicOperator;
    private boolean isPrimary; // if not primary, it is a composite condition


    private Rule(String lender, String name, List<RuleSegment> ruleSegments, LogicOperator logicOperator, boolean isPrimary) {
        this.ruleSegments = ruleSegments;
        this.lender = lender;
        this.name = name;
        this.logicOperator = logicOperator;
        this.isPrimary = isPrimary;
    }

    private void validateRuleSegment() {
        if (CollectionUtils.isEmpty(ruleSegments)) {
            throw new IllegalArgumentException("Rule must have at least one rule segment");
        }
        ruleSegments.forEach(RuleSegment::validate);
    }

    public void validateRule() {
        if (isPrimary) {
            validateLender();
        }
        validateRuleSegment();
        validateOperator();
        validateRuleName();

    }

    private void validateLender() {
        if (!StringUtils.hasText(lender)) {
            throw new DomainException("Lender name cannot be blank");
        }
    }

    private void validateOperator() {
        if (Objects.isNull(logicOperator)) {
            throw new DomainException("Logical operator cannot be null");
        }
    }

    private void validateRuleName() {
        if (!StringUtils.hasText(name)) {
            throw new DomainException("Rule name cannot be blank");
        }
    }

    public List<RuleSegment> getRuleSegments() {
        return ruleSegments;
    }

    public String getLender() {
        return lender;
    }

    public String getName() {
        return name;
    }

    public LogicOperator getLogicOperator() {
        return logicOperator;
    }

    public boolean isPrimary() {
        return isPrimary;
    }

    // Static Builder Class
    public static class RuleBuilder {
        private String lender;
        private String name;
        private List<RuleSegment> ruleSegments;
        private LogicOperator logicOperator;
        private boolean isPrimary;

        public RuleBuilder setLender(String lender) {
            this.lender = lender;
            return this;
        }

        public RuleBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public RuleBuilder setRuleSegments(List<RuleSegment> ruleSegments) {
            this.ruleSegments = ruleSegments;
            return this;
        }

        public RuleBuilder setLogicOperator(LogicOperator logicOperator) {
            this.logicOperator = logicOperator;
            return this;
        }

        public RuleBuilder setIsPrimary(boolean isPrimary) {
            this.isPrimary = isPrimary;
            return this;
        }

        public Rule build() {
            return new Rule(lender, name, ruleSegments, logicOperator, isPrimary);
        }
    }


}
