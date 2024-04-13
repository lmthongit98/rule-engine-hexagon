package com.project.ruleengine.domain.langparser;

import com.project.ruleengine.domain.exceptions.MvelParserException;
import org.mvel2.MVEL;

import java.util.Map;


public class MVELParser {

    public static boolean parseMvelExpression(String expression, Map<String, Object> variableDataInput) {
        try {
            return MVEL.evalToBoolean(expression, variableDataInput);
        } catch (Exception e) {
            throw new MvelParserException("Getting exception while parsing mvel expression", e);
        }
    }
}
