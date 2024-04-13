package com.project.ruleengine.domain.services.interfaces;

import com.project.ruleengine.domain.entities.common.AggregateRoot;
import com.project.ruleengine.domain.entities.common.BaseEntity;

import java.util.Optional;

public interface CurdRepository<T extends BaseEntity<ID>, ID> {
    Optional<T> findById(ID id);
    T save(T entity);
    void deleteById(ID id);

}
