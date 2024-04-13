package com.project.ruleengine.domain.valueobject;

import java.util.UUID;

public class VariableId extends BaseId<UUID> {
    protected VariableId(UUID value) {
        super(value);
    }
}
