package com.project.ruleengine.domain.exceptions;

public class MvelParserException extends DomainException {
    public MvelParserException(String message) {
        super(message);
    }

    public MvelParserException(String message, Throwable cause) {
        super(message, cause);
    }
}
