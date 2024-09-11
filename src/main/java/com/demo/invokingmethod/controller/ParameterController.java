package com.demo.invokingmethod.controller;

import com.demo.invokingmethod.model.ManagerConfig;
import com.demo.invokingmethod.service.parameter.IManagerConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/parameter")
public class ParameterController {
    private final IManagerConfigService iManagerConfigService;

    @Autowired
    public ParameterController(IManagerConfigService iManagerConfigService) {
        this.iManagerConfigService = iManagerConfigService;
    }

    @PostMapping("/config")
    public ResponseEntity<?> config(@RequestBody ManagerConfig configRequestEntity) {
        try {
            switch (configRequestEntity.getType()) {
                case USER:
                    // Process user config
                    iManagerConfigService.CreateOrUpdateUser(configRequestEntity.getUser(), configRequestEntity.getIsDelete());
                    break;
                case CATEGORY:
                    // Process category config
                    iManagerConfigService.createOrUpdateCategory(configRequestEntity.getCategory(), configRequestEntity.getIsDelete());
                    break;
                case PRODUCT:
                    // Process product config
                    iManagerConfigService.createOrUpdateProduct(configRequestEntity.getProduct(), configRequestEntity.getIsDelete());
                    break;
                default:
            }
            return ResponseEntity.ok("Config saved successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Invalid request");
        }
    }

    @GetMapping("/load-parameters")
    public ResponseEntity<?> loadParameters(@RequestParam(value = "type", required = false) String type) {
        try {
            return ResponseEntity.status(200).body(iManagerConfigService.getParameter(type));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Invalid request");
        }
    }
}
