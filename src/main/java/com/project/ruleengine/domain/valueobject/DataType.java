package com.project.ruleengine.domain.valueobject;

import com.project.ruleengine.shared.utils.ValidateUtils;
import io.micrometer.common.util.StringUtils;

public enum DataType {
    STRING {
        @Override
        public Object getValue() {
            return null;
        }

        @Override
        public boolean isValueValid(String value) {
            return StringUtils.isNotBlank(value);
        }
    },
    NUMBER {
        @Override
        public Object getValue() {
            return null;
        }

        @Override
        public boolean isValueValid(String value) {
            return ValidateUtils.isNumeric(value) && ValidateUtils.canParseToDouble(value);
        }
    },
    BOOLEAN {
        @Override
        public Object getValue() {
            return null;
        }

        @Override
        public boolean isValueValid(String value) {
            return "true".equalsIgnoreCase(value) || "false".equalsIgnoreCase(value);
        }
    };

    public abstract Object getValue();
    public abstract boolean isValueValid(String value);

}
