package com.project.ruleengine.domain.exceptions;

public class RuleNotFoundException extends DomainException {
    public RuleNotFoundException(String message) {
        super(message);
    }

    public RuleNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
