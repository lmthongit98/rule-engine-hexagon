package com.project.ruleengine.infrastructure.persistence.repositories.mysql;

import com.project.ruleengine.infrastructure.persistence.entities.VariableEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VariableJpaRepository extends JpaRepository<VariableEntity, Long> {
}
