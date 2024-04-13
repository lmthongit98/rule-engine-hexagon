package com.project.ruleengine.domain.services.interfaces;

import com.project.ruleengine.domain.entities.rule.Rule;
import com.project.ruleengine.domain.valueobject.RuleId;

import java.util.List;
import java.util.Optional;

public interface RuleRepository extends CurdRepository<Rule, RuleId> {
    List<Rule> findAllByPrimary(boolean isPrimary);
    Optional<Rule> findByNotPrimaryAndName(String name);

}
