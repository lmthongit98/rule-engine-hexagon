package com.project.ruleengine.domain.services.impl;

import com.project.ruleengine.domain.entities.conditions.GenericCondition;
import com.project.ruleengine.domain.entities.conditions.Variable;
import com.project.ruleengine.domain.entities.conditions.impl.BaseCondition;
import com.project.ruleengine.domain.entities.conditions.impl.composite.CompositeCondition;
import com.project.ruleengine.domain.entities.rule.Rule;
import com.project.ruleengine.domain.entities.rule.RuleSegment;
import com.project.ruleengine.domain.exceptions.MvelParserException;
import com.project.ruleengine.domain.langparser.MVELParser;
import com.project.ruleengine.domain.services.interfaces.RuleEngineService;
import com.project.ruleengine.domain.services.interfaces.RuleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class RuleEngineServiceImpl implements RuleEngineService {

    private static final Logger logger = LoggerFactory.getLogger(RuleEngineServiceImpl.class);

    private final RuleRepository ruleRepository;

    private final VariableDataResolver variableDataResolver;

    public RuleEngineServiceImpl(RuleRepository ruleRepository, VariableDataResolver variableDataResolver) {
        this.ruleRepository = ruleRepository;
        this.variableDataResolver = variableDataResolver;
    }

    @Override
    public List<String> executeRules(String applicationId) {
        List<String> eligibleLenders = new ArrayList<>();
        List<Rule> rules = ruleRepository.findAllByPrimary(true);
        Map<String, Object> variableDataMap = getVariableDataMap(rules, applicationId);
        for (Rule rule : rules) {
            try {
                GenericCondition compositeCondition = getCompositeCondition(rule, variableDataMap);
                String mvelExpression = compositeCondition.getMvelExpression();
                boolean isRuleSatisfied = MVELParser.parseMvelExpression(mvelExpression, variableDataMap);
                if (isRuleSatisfied) {
                    eligibleLenders.add(rule.getLender());
                }
            } catch (MvelParserException mvelParserException) {
                logger.error("Fail to parse mvel expression for rule {} applicationId {}", rule.getName(), applicationId);
            }
        }
        return eligibleLenders;
    }

    @Override
    public Rule createRule(Rule rule) {
        rule.validateRule();
        return ruleRepository.save(rule);
    }


    private Map<String, Object> getVariableDataMap(List<Rule> rules, String applicationId) {
        Set<Variable> variables = findVariables(rules);
        Map<String, Object> result = new HashMap<>();
        for (Variable variable : variables) {
            result.put(variable.getName(), variableDataResolver.getVariableValue(variable, applicationId));
        }
        return result;
    }

    private Set<Variable> findVariables(List<Rule> rules) {
        Set<Variable> variableSet = new HashSet<>();
        for (Rule rule : rules) {
            for (RuleSegment ruleSegment : rule.getRuleSegments()) {
                if (Objects.nonNull(ruleSegment.getRuleApplicability())) {
                    variableSet.add(ruleSegment.getRuleApplicability().getVariable());
                    variableSet.add(ruleSegment.getDefaultValue().getVariable());
                }
                variableSet.add(ruleSegment.getRuleApplicability().getVariable());
            }
        }
        return variableSet;
    }

    private GenericCondition getCompositeCondition(Rule rule, Map<String, Object> variableDataMap) {
        CompositeCondition composite = rule.getLogicOperator().createCompositeCondition();
        List<BaseCondition> conditions = rule.getRuleSegments().stream().map(ruleSegment -> ruleSegment.getCondition(variableDataMap)).toList();
        for (BaseCondition condition : conditions) {
            if (condition.getVariable().isComposite()) {
                Rule subRule = ruleRepository.findByNotPrimaryAndName(condition.getVariable().getName()).orElseThrow();
                composite.add(getCompositeCondition(subRule, variableDataMap));
                continue;
            }
            composite.add(condition);
        }
        return composite;
    }


}
