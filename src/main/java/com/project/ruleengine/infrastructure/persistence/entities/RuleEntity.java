package com.project.ruleengine.infrastructure.persistence.entities;


import com.project.ruleengine.domain.valueobject.LogicOperator;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "rules")
public class RuleEntity extends BaseEntity {
    private String lender; // for primary rule only
    private String name;

    @OneToMany(mappedBy = "rule")
    private Set<RuleSegmentEntity> ruleSegments;

    private LogicOperator logicOperator;
    private boolean isPrimary; // if not primary, it is a composite condition

}
