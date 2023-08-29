package com.api.javaparkingcontrol.controllers;

import com.api.javaparkingcontrol.dtos.VagaDTO;
import com.api.javaparkingcontrol.models.VagaModel;
import com.api.javaparkingcontrol.services.VagaService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/vaga-estacionamento")
public class VagaController {
    final VagaService vagaService;

    public VagaController(VagaService vagaService) {
        this.vagaService = vagaService;
    }
}
