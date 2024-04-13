package com.project.ruleengine.infrastructure.persistence.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "rule_segments")
public class RuleSegmentEntity extends BaseEntity {

    @Column(name = "segment_name")
    private String segmentName;

    @OneToOne
    @JoinColumn(name = "ruleApplicability")
    private ConditionEntity ruleApplicability;

    @OneToOne
    @JoinColumn(name = "formula_id")
    private ConditionEntity formula;

    @OneToOne
    @JoinColumn(name = "default_value_id")
    private ConditionEntity defaultValue;

    @ManyToOne
    @JoinColumn(name = "rule_id")
    private RuleEntity rule;

}
