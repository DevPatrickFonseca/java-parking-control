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
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/vaga-estacionamento")
public class VagaController {
    final VagaService vagaService;

    public VagaController(VagaService vagaService) {
        this.vagaService = vagaService;
    }

    @PostMapping
    public ResponseEntity<Object> saveVaga(@RequestBody @Valid VagaDTO vagaDTO) {
        if (vagaService.existsByCarroPlaca(vagaDTO.getCarroPlaca())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflito: Carro com Placa já está em uso!");
        }
        if (vagaService.existsByNumeroVaga(vagaDTO.getNumeroVaga())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflito: Vaga já está em uso!");
        }
        if (vagaService.existsByApartamentoAndBloco(vagaDTO.getApartamento(), vagaDTO.getBloco())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflito: Vaga já está em uso pelo apartemento/bloco!");
        }
        var vagaModel = new VagaModel();
        BeanUtils.copyProperties(vagaDTO, vagaModel);
        vagaModel.setDataRegistro(LocalDateTime.now(ZoneId.of("UTC")));

        return ResponseEntity.status(HttpStatus.CREATED).body(vagaService.save(vagaModel));
    }

    @GetMapping
    public ResponseEntity<List<VagaModel>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(vagaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable(value = "id") UUID id) {
        Optional<VagaModel> vagaModelOptional = vagaService.findById(id);
        if (!vagaModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vaga não encontrada.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(vagaModelOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable(value = "id") UUID id) {
        Optional<VagaModel> vagaModelOptional = vagaService.findById(id);
        if (!vagaModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vaga não encontrada.");
        }
        vagaService.delete(vagaModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Vaga deletada com sucesso!");
    }
}
