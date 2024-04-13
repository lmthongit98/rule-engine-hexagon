package com.project.ruleengine.application.port.in;

import com.project.ruleengine.application.dtos.request.RuleDto;

import java.util.List;

public interface RuleEngineApplicationService {
    List<String> findEligibleLender(String applicationId);

    RuleDto createRule(RuleDto ruleDto);
}
