package com.studentsos.studentsos.controller;

import com.studentsos.studentsos.dto.SosRequestDTO;
import com.studentsos.studentsos.service.SosService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/sos")
public class SosController {

    private final SosService service;

    public SosController(SosService service) {
        this.service = service;
    }

    @PostMapping("/{phoneNumber}")
    public SosRequestDTO createSos(
            @PathVariable String phoneNumber,
            @RequestParam String item,
            @RequestParam String location) {

        return service.createSos(phoneNumber, item, location);
    }

    @GetMapping
    public List<SosRequestDTO> getAllRequests() {
        return service.getAllRequests();
    }
}