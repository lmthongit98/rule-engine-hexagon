package com.project.ruleengine.infrastructure.persistence.variable;

import com.project.ruleengine.domain.entities.conditions.Variable;
import com.project.ruleengine.domain.services.interfaces.VariableRepository;
import com.project.ruleengine.domain.valueobject.VariableId;
import com.project.ruleengine.infrastructure.persistence.repositories.mysql.VariableJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class VariableRepositoryImpl implements VariableRepository {

    private final VariableJpaRepository variableJpaRepository;

    @Override
    public Optional<Variable> findById(VariableId variableId) {
        return Optional.empty();
    }

    @Override
    public Variable save(Variable entity) {
        return null;
    }

    @Override
    public void deleteById(VariableId variableId) {

    }
}
