package com.project.ruleengine.application.dtos.request;

import com.project.ruleengine.domain.valueobject.LogicOperator;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
public class RuleDto {
    private String lender;
    private String name;
    private final List<RuleSegmentDto> ruleSegments = new ArrayList<>();
    private LogicOperator logicOperator;
    private boolean isPrimary;
}
