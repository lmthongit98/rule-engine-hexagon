package com.project.ruleengine.domain.services.interfaces;

import com.project.ruleengine.domain.entities.rule.Rule;

import java.util.List;

public interface RuleEngineService {

    List<String> executeRules(String applicationId);

    Rule createRule(Rule rule);

}
