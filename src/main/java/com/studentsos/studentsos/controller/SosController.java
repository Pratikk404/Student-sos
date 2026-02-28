package com.studentsos.studentsos.controller;

import com.studentsos.studentsos.entity.SosRequest;
import com.studentsos.studentsos.service.SosService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sos")
public class SosController {

    private final SosService service;

    public SosController(SosService service) {
        this.service = service;
    }

    @PostMapping("/{phoneNumber}")
    public SosRequest createSos(@PathVariable String phoneNumber) {
        return service.createSos(phoneNumber);
    }
}