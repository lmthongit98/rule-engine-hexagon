package com.project.ruleengine.domain.valueobject;

public enum Operator {
    IN {
        @Override
        public boolean validateValue(String value) {
            return false;
        }
    },
    NOT_IN {
        @Override
        public boolean validateValue(String value) {
            return false;
        }
    },
    IN_RANGE {
        @Override
        public boolean validateValue(String value) {
            return false;
        }
    },
    EQUAL {
        @Override
        public boolean validateValue(String value) {
            return false;
        }
    },
    GREATER_THẠN {
        @Override
        public boolean validateValue(String value) {
            return false;
        }
    },
    GREATER_THẠN_OR_EQUAL {
        @Override
        public boolean validateValue(String value) {
            return false;
        }
    },
    LESS_THAN {
        @Override
        public boolean validateValue(String value) {
            return false;
        }
    },
    LESS_THAN_OR_EQUAL {
        @Override
        public boolean validateValue(String value) {
            return false;
        }
    };

    public abstract boolean validateValue(String value);

}
