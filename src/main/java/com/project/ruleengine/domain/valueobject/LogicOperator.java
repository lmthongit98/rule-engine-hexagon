package com.project.ruleengine.domain.valueobject;

import com.project.ruleengine.domain.entities.conditions.impl.composite.AndCompositeCondition;
import com.project.ruleengine.domain.entities.conditions.impl.composite.CompositeCondition;
import com.project.ruleengine.domain.entities.conditions.impl.composite.OrCompositeCondition;

public enum LogicOperator {
    AND {
        @Override
        public CompositeCondition createCompositeCondition() {
            return new AndCompositeCondition();
        }

        @Override
        public String getHumanReadableOperator() {
            return " AND ";
        }

        @Override
        public String getMvelOperator() {
            return " && ";
        }
    },
    OR {
        @Override
        public CompositeCondition createCompositeCondition() {
            return new OrCompositeCondition();
        }

        @Override
        public String getHumanReadableOperator() {
            return " OR ";
        }

        @Override
        public String getMvelOperator() {
            return " || ";
        }
    };

    public abstract CompositeCondition createCompositeCondition();
    public abstract String getHumanReadableOperator();
    public abstract String getMvelOperator();


}
