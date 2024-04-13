package com.project.ruleengine.application.services;

import com.project.ruleengine.application.dtos.request.RuleDto;
import com.project.ruleengine.application.mapper.RuleMapper;
import com.project.ruleengine.application.port.in.RuleEngineApplicationService;
import com.project.ruleengine.domain.services.interfaces.RuleEngineService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RuleEngineApplicationServiceImpl implements RuleEngineApplicationService {

    private final RuleMapper ruleMapper;
    private final RuleEngineService ruleEngineService;

    @Override
    public List<String> findEligibleLender(String applicationId) {
        return ruleEngineService.executeRules(applicationId);
    }

    @Override
    @Transactional
    public RuleDto createRule(RuleDto ruleDto) {
        return ruleMapper.ruleToRuleDto(ruleEngineService.createRule(ruleMapper.ruleDtoToRule(ruleDto)));
    }

}
