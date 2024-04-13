package com.project.ruleengine.infrastructure.kafka;

import com.project.ruleengine.domain.events.RuleEngineEvent;
import com.project.ruleengine.domain.events.publisher.RuleEngineMessagePublisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RuleEngineEventKafkaPublisher implements RuleEngineMessagePublisher {

    @Override
    public void publish(RuleEngineEvent ruleEvent) {
        log.info("Received RuleEngineEvent for applicationId: {} ", ruleEvent.getApplicationId());
        System.out.println(ruleEvent.getEligibleLenders());
    }

}
