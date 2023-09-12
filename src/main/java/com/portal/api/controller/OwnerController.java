package com.portal.api.controller;

import com.portal.api.dto.OwnerDTO;
import com.portal.api.service.OwnerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/owner")
public class OwnerController {

    private static final Logger LOG = LoggerFactory.getLogger(OwnerController.class);

    @Autowired
    protected OwnerService ownerService;

    @PostMapping
    public ResponseEntity<Void> createOwnerCar(@RequestBody OwnerDTO ownerDTO) {
        LOG.info("USING REST API - Creating New User: {}", ownerDTO);

        ownerService.createdOwnerCar(ownerDTO);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
