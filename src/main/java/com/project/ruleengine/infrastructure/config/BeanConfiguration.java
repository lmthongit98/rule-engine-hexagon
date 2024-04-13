package com.project.ruleengine.infrastructure.config;

import com.project.ruleengine.domain.services.interfaces.RuleRepository;
import com.project.ruleengine.domain.services.interfaces.RuleEngineService;
import com.project.ruleengine.domain.services.impl.VariableDataResolver;
import com.project.ruleengine.domain.services.interfaces.VariableDataRepository;
import com.project.ruleengine.domain.services.interfaces.VariableService;
import com.project.ruleengine.domain.services.impl.RuleEngineServiceImpl;
import com.project.ruleengine.domain.services.impl.VariableServiceImpl;
import com.project.ruleengine.infrastructure.persistence.mapper.RuleMapper;
import com.project.ruleengine.infrastructure.persistence.rule.RuleRepositoryImpl;
import com.project.ruleengine.infrastructure.persistence.variable.SQLVariableDataService;
import com.project.ruleengine.infrastructure.persistence.repositories.mysql.RuleJpaRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class BeanConfiguration {


    @Bean
    VariableDataRepository variableDataService() {
        return new SQLVariableDataService();
    }

    @Bean
    VariableDataResolver variableDataResolver(List<VariableDataRepository> variableDataRepositories) {
        return new VariableDataResolver(variableDataRepositories);
    }

    @Bean
    VariableService variableService() {
        return new VariableServiceImpl();
    }

    @Bean
    RuleEngineService ruleService(RuleRepository ruleRepository, VariableDataResolver variableDataResolver) {
        return new RuleEngineServiceImpl(ruleRepository, variableDataResolver);
    }

    @Bean
    RuleRepository ruleRepository(RuleJpaRepository ruleJpaRepository, RuleMapper ruleMapper) {
        return new RuleRepositoryImpl(ruleJpaRepository, ruleMapper);
    }

}
