package com.project.ruleengine.application.dtos.request;

import com.project.ruleengine.domain.valueobject.Operator;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ConditionDto {
    private Long variableId;
    private String value;
    private Operator operator;
}
