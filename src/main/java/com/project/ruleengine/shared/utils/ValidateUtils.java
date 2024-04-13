package com.project.ruleengine.shared.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ValidateUtils {

    public boolean isNumeric(String value) {
        if (value == null) {
            return false;
        }
        return value.matches("^\\d+(\\.\\d+)?$");
    }

    public boolean canParseToDouble(Object obj) {
        try {
            if (obj instanceof String) {
                Double.parseDouble((String) obj);
                return true;
            } else if (obj instanceof Number) {
                ((Number) obj).doubleValue();
                return true;
            }
            return false;
        } catch (NumberFormatException e) {
            return false;
        }
    }


}