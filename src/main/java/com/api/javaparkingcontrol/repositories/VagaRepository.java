package com.api.javaparkingcontrol.repositories;

import com.api.javaparkingcontrol.models.VagaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface VagaRepository extends JpaRepository<VagaModel, UUID> {

    boolean existsByCarroPlaca(String carroPlaca);

    boolean existsByNumeroVaga(String numeroVaga);

    boolean existsByApartamentoAndBloco(String apartamento, String bloco);
}
