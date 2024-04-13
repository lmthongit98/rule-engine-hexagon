package com.project.ruleengine.apis;

import com.project.ruleengine.application.dtos.request.RuleDto;
import com.project.ruleengine.application.port.in.RuleEngineApplicationService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/rules")
public class RuleEngineController {

    private final RuleEngineApplicationService ruleEngineApplicationService;

    @GetMapping("/{applicationId}")
    public ResponseEntity<?> executeRules(@PathVariable String applicationId) {
        List<String> applicationIds = ruleEngineApplicationService.findEligibleLender(applicationId);
        return ResponseEntity.ok(applicationIds);
    }

    @PostMapping
    public ResponseEntity<?> createRule(@RequestBody RuleDto ruleDto) {
        return ResponseEntity.ok(ruleEngineApplicationService.createRule(ruleDto));
    }

}
