package com.project.ruleengine.infrastructure.persistence.entities;

import com.project.ruleengine.domain.valueobject.Operator;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "condtions")
public class ConditionEntity extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "variable_id")
    private VariableEntity variable;
    private String value;
    private Operator operator;

}
