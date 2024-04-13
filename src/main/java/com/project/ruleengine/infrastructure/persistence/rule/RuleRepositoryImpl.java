package com.project.ruleengine.infrastructure.persistence.rule;

import com.project.ruleengine.domain.entities.rule.Rule;
import com.project.ruleengine.domain.services.interfaces.RuleRepository;
import com.project.ruleengine.domain.valueobject.RuleId;
import com.project.ruleengine.infrastructure.persistence.mapper.RuleMapper;
import com.project.ruleengine.infrastructure.persistence.repositories.mysql.RuleJpaRepository;
import com.project.ruleengine.infrastructure.persistence.entities.RuleEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class RuleRepositoryImpl implements RuleRepository {

    private final RuleJpaRepository ruleJpaRepository;
    private final RuleMapper ruleMapper;


    @Override
    public List<Rule> findAllByPrimary(boolean isPrimary) {
        List<RuleEntity> ruleEntityList = ruleJpaRepository.findAllByPrimary(isPrimary);
        return ruleEntityList.stream().map(ruleMapper::ruleEntityToRule).toList();
    }

    @Override
    public Optional<Rule> findByNotPrimaryAndName(String name) {
        return Optional.empty();
    }

    @Override
    public Optional<Rule> findById(RuleId ruleId) {
       return ruleJpaRepository.findById(ruleId.getValue()).map(ruleMapper::ruleEntityToRule);
    }

    @Override
    public Rule save(Rule entity) {
        return null;
    }

    @Override
    public void deleteById(RuleId ruleId) {
        ruleJpaRepository.deleteById(ruleId.getValue());
    }
}
