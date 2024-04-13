package com.project.ruleengine.infrastructure.persistence.repositories.mysql;


import com.project.ruleengine.infrastructure.persistence.entities.RuleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface RuleJpaRepository extends JpaRepository<RuleEntity, UUID> {

    List<RuleEntity> findAllByPrimary(boolean isPrimary);

}
