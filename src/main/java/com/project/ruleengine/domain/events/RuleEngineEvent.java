package com.project.ruleengine.domain.events;

import com.project.ruleengine.domain.entities.rule.Rule;
import lombok.Getter;

import java.time.ZonedDateTime;
import java.util.List;

public class RuleEngineEvent implements DomainEvent<Rule> {

    private final String applicationId;
    private final List<String> eligibleLenders;
    private final ZonedDateTime createdAt;

    public RuleEngineEvent(String applicationId, List<String> eligibleLenders, ZonedDateTime createdAt) {
        this.applicationId = applicationId;
        this.eligibleLenders = eligibleLenders;
        this.createdAt = createdAt;
    }


    public String getApplicationId() {
        return applicationId;
    }

    public List<String> getEligibleLenders() {
        return eligibleLenders;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

}
