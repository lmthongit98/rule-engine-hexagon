package com.project.ruleengine.infrastructure.persistence.entities;

import com.project.ruleengine.domain.valueobject.DataType;
import com.project.ruleengine.domain.entities.conditions.Variable;
import com.project.ruleengine.domain.valueobject.VariableDataSource;
import jakarta.activation.DataSource;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "variables")
public class VariableEntity extends BaseEntity {

    private String name;
    @Enumerated(EnumType.STRING)
    private DataType dataType;
    private boolean isComposite;
    @Enumerated(EnumType.STRING)
    private VariableDataSource dataSource;
    private String template; // SQL or API template

    @OneToMany(mappedBy = "variable")
    private Set<ConditionEntity> conditions;

}
