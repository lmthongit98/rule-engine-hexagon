package com.project.ruleengine.domain.valueobject;

import java.util.UUID;

public class RuleId extends BaseId<UUID> {
    public RuleId(UUID value) {
        super(value);
    }
}
