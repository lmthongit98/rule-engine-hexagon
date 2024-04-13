package com.project.ruleengine.application.dtos.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RuleSegmentDto {
    private ConditionDto ruleApplicability;
    private ConditionDto formula;
    private ConditionDto defaultValue;
}
