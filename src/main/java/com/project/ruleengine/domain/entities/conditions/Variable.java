package com.project.ruleengine.domain.entities.conditions;

import com.project.ruleengine.domain.entities.common.BaseEntity;
import com.project.ruleengine.domain.entities.rule.Rule;
import com.project.ruleengine.domain.exceptions.DomainException;
import com.project.ruleengine.domain.valueobject.DataType;
import com.project.ruleengine.domain.valueobject.VariableDataSource;
import com.project.ruleengine.domain.valueobject.VariableId;

public class Variable extends BaseEntity<VariableId> {
    private String name;
    private DataType dataType;
    private boolean isComposite; // the name of this variable must be the same name as the rule name (not primary)
    private VariableDataSource dataSource; // API, SQL, CALCULATION
    private String template; // sql query or api template or empty (CALCULATION)

    public void validate() {
        if (!isComposite) {
            validateTemplate();
        }
        validateVariableName();
    }

    private void validateTemplate() {
        if (!VariableDataSource.CALCULATION.equals(dataSource) && (template == null || template.isBlank())) {
            throw new DomainException("Template cannot be blank");
        }
    }

    private void validateVariableName() {
        if (name == null || name.isBlank()) {
            throw new DomainException("Rule name cannot be blank");
        }
    }


    private Variable(Builder builder) {
        this.name = builder.name;
        this.dataType = builder.dataType;
        this.isComposite = builder.isComposite;
        this.dataSource = builder.dataSource;
        this.template = builder.template;
    }

    public static class Builder {
        private String name;
        private DataType dataType;
        private boolean isComposite;
        private VariableDataSource dataSource;
        private String template;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setDataType(DataType dataType) {
            this.dataType = dataType;
            return this;
        }

        public Builder setIsComposite(boolean isComposite) {
            this.isComposite = isComposite;
            return this;
        }

        public Builder setDataSource(VariableDataSource dataSource) {
            this.dataSource = dataSource;
            return this;
        }

        public Builder setTemplate(String template) {
            this.template = template;
            return this;
        }

        public Variable build() {
            return new Variable(this);
        }
    }

    public String getName() {
        return name;
    }

    public DataType getDataType() {
        return dataType;
    }

    public boolean isComposite() {
        return isComposite;
    }

    public VariableDataSource getDataSource() {
        return dataSource;
    }

    public String getTemplate() {
        return template;
    }

}
