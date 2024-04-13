package com.project.ruleengine.infrastructure.persistence.mapper;

import com.project.ruleengine.domain.entities.conditions.Variable;
import com.project.ruleengine.infrastructure.persistence.entities.VariableEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class VariableMapper {

    public Variable variableEntityToVariable(VariableEntity variableEntity) {
        return new Variable.Builder()
                .setName(variableEntity.getName())
                .setDataSource(variableEntity.getDataSource())
                .setDataType(variableEntity.getDataType())
                .setIsComposite(variableEntity.isComposite())
                .setTemplate(variableEntity.getTemplate())
                .build();
    }

}
