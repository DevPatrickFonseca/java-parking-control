package com.api.javaparkingcontrol.controllers;

import com.api.javaparkingcontrol.dtos.VagaDTO;
import com.api.javaparkingcontrol.models.VagaModel;
import com.api.javaparkingcontrol.services.VagaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/vaga-estacionamento")
@Tag(
    name = "Vaga",
    description = "APIs para controle de vagas de estacionamento"
)
public class VagaController {

  final VagaService vagaService;

  public VagaController(VagaService vagaService) {
    this.vagaService = vagaService;
  }

  @Operation(summary = "Cadastrar uma vaga de estacionamento", method = "POST")
  @ApiResponse(responseCode = "201", description = "Vaga cadastrada com sucesso!")
  @ApiResponse(responseCode = "400", description = "Requisição inválida!")
  @ApiResponse(responseCode = "409", description = "Conflito: Vaga já está em uso!")
  @ApiResponse(responseCode = "500", description = "Erro interno do servidor!")
  @PostMapping
  public ResponseEntity<Object> save(@RequestBody @Valid VagaDTO vagaDTO) {
    if (vagaService.existsByCarroPlaca(vagaDTO.getCarroPlaca())) {
      return ResponseEntity.status(HttpStatus.CONFLICT)
          .body("Conflito: Carro com Placa já está em uso!");
    }
    if (vagaService.existsByNumeroVaga(vagaDTO.getNumeroVaga())) {
      return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflito: Vaga já está em uso!");
    }
    if (vagaService.existsByApartamentoAndBloco(vagaDTO.getApartamento(), vagaDTO.getBloco())) {
      return ResponseEntity.status(HttpStatus.CONFLICT)
          .body("Conflito: Vaga já está em uso pelo apartemento/bloco!");
    }
    var vagaModel = new VagaModel();
    BeanUtils.copyProperties(vagaDTO, vagaModel);
    vagaModel.setDataRegistro(LocalDateTime.now(ZoneId.of("UTC")));

    return ResponseEntity.status(HttpStatus.CREATED).body(vagaService.save(vagaModel));
  }

  @Operation(summary = "Listar todas as vagas de estacionamento", method = "GET")
  @ApiResponse(responseCode = "200", description = "Vagas listadas com sucesso!")
  @ApiResponse(responseCode = "500", description = "Erro interno do servidor!")
  @GetMapping
  public ResponseEntity<Page<VagaModel>> getAll(
      @PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
    return ResponseEntity.status(HttpStatus.OK).body(vagaService.findAll(pageable));
  }

  @Operation(summary = "Buscar uma vaga de estacionamento pelo ID", method = "GET")
  @ApiResponse(responseCode = "200", description = "Vaga encontrada com sucesso!")
  @ApiResponse(responseCode = "404", description = "Vaga não encontrada!")
  @ApiResponse(responseCode = "500", description = "Erro interno do servidor!")
  @GetMapping("/{id}")
  public ResponseEntity<Object> getById(@PathVariable(value = "id") UUID id) {
    Optional<VagaModel> vagaModelOptional = vagaService.findById(id);
    if (!vagaModelOptional.isPresent()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vaga n\u00E3o encontrada.");
    }
    return ResponseEntity.status(HttpStatus.OK).body(vagaModelOptional.get());
  }

  @Operation(summary = "Deletar uma vaga de estacionamento pelo ID", method = "DELETE")
  @ApiResponse(responseCode = "200", description = "Vaga deletada com sucesso!")
  @ApiResponse(responseCode = "404", description = "Vaga não encontrada!")
  @ApiResponse(responseCode = "500", description = "Erro interno do servidor!")
  @DeleteMapping("/{id}")
  public ResponseEntity<Object> delete(@PathVariable(value = "id") UUID id) {
    Optional<VagaModel> vagaModelOptional = vagaService.findById(id);
    if (!vagaModelOptional.isPresent()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vaga não encontrada.");
    }
    vagaService.delete(vagaModelOptional.get());
    return ResponseEntity.status(HttpStatus.OK).body("Vaga deletada com sucesso!");
  }

  @Operation(summary = "Atualizar uma vaga de estacionamento pelo ID", method = "PUT")
  @ApiResponse(responseCode = "200", description = "Vaga atualizada com sucesso!")
  @ApiResponse(responseCode = "404", description = "Vaga não encontrada!")
  @ApiResponse(responseCode = "500", description = "Erro interno do servidor!")
  @PutMapping("/{id}")
  public ResponseEntity<Object> update(@PathVariable(value = "id") UUID id,
      @RequestBody @Valid VagaDTO vagaDTO) {
    Optional<VagaModel> vagaModelOptional = vagaService.findById(id);
    if (!vagaModelOptional.isPresent()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vaga não encontrada.");
    }
    var vagaModel = vagaModelOptional.get();
    vagaModel.setNumeroVaga(vagaDTO.getNumeroVaga());
    vagaModel.setCarroPlaca(vagaDTO.getCarroPlaca());
    vagaModel.setCarroMarca(vagaDTO.getCarroMarca());
    vagaModel.setCarroModelo(vagaDTO.getCarroModelo());
    vagaModel.setCarroCor(vagaDTO.getCarroCor());
    vagaModel.setNomeDoResponsavel(vagaDTO.getNomeDoResponsavel());
    vagaModel.setApartamento(vagaDTO.getApartamento());
    vagaModel.setBloco(vagaDTO.getBloco());
    vagaService.save(vagaModel);
    return ResponseEntity.status(HttpStatus.OK).body("Vaga atualizada com sucesso!");
  }
}
