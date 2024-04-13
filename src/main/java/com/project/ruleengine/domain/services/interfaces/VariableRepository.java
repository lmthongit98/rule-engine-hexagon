package com.project.ruleengine.domain.services.interfaces;

import com.project.ruleengine.domain.entities.conditions.Variable;
import com.project.ruleengine.domain.valueobject.VariableId;

public interface VariableRepository extends CurdRepository<Variable, VariableId> {
}
