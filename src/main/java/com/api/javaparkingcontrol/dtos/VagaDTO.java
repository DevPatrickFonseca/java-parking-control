package com.api.javaparkingcontrol.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public class VagaDTO {
    @NotBlank
    private String numeroVaga;
    @NotBlank
    @Size(max = 7)
    private String carroPlaca;
    @NotBlank
    private String carroMarca;
    @NotBlank
    private String carroModelo;
    @NotBlank
    private String carroCor;
    @NotBlank
    private String nomeDoResponsavel;
    @NotBlank
    private String apartamento;
    @NotBlank
    private String bloco;

    public String getNumeroVaga() {
        return numeroVaga;
    }

    public void setNumeroVaga(String numeroVaga) {
        this.numeroVaga = numeroVaga;
    }

    public String getCarroPlaca() {
        return carroPlaca;
    }

    public void setCarroPlaca(String carroPlaca) {
        this.carroPlaca = carroPlaca;
    }

    public String getCarroMarca() {
        return carroMarca;
    }

    public void setCarroMarca(String carroMarca) {
        this.carroMarca = carroMarca;
    }

    public String getCarroModelo() {
        return carroModelo;
    }

    public void setCarroModelo(String carroModelo) {
        this.carroModelo = carroModelo;
    }

    public String getCarroCor() {
        return carroCor;
    }

    public void setCarroCor(String carroCor) {
        this.carroCor = carroCor;
    }

    public String getNomeDoResponsavel() {
        return nomeDoResponsavel;
    }

    public void setNomeDoResponsavel(String nomeDoResponsavel) {
        this.nomeDoResponsavel = nomeDoResponsavel;
    }

    public String getApartamento() {
        return apartamento;
    }

    public void setApartamento(String apartamento) {
        this.apartamento = apartamento;
    }

    public String getBloco() {
        return bloco;
    }

    public void setBloco(String bloco) {
        this.bloco = bloco;
    }
}
