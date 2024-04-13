package com.project.ruleengine.application.dtos.email.templates;

import com.project.ruleengine.application.dtos.email.EmailTemplate;

public class RuleUpdateTemplate implements EmailTemplate {

    private String ruleName;
    private String UpdatedAt;
    private String updatedBy;

    @Override
    public String getTemplateName() {
        return "rule-update";
    }
}
