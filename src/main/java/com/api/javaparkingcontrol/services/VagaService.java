package com.api.javaparkingcontrol.services;

import com.api.javaparkingcontrol.models.VagaModel;
import com.api.javaparkingcontrol.repositories.VagaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class VagaService {
    final VagaRepository vagaRepository;

    public VagaService(VagaRepository vagaRepository) {
        this.vagaRepository = vagaRepository;
    }

    @Transactional
    public VagaModel save(VagaModel vagaModel) {
        return vagaRepository.save(vagaModel);
    }

    public boolean existsByCarroPlaca(String carroPlaca) {
        return vagaRepository.existsByCarroPlaca(carroPlaca);
    }

    public boolean existsByNumeroVaga(String numeroVaga) {
        return vagaRepository.existsByNumeroVaga(numeroVaga);
    }

    public boolean existsByApartamentoAndBloco(String apartamento, String bloco) {
        return vagaRepository.existsByApartamentoAndBloco(apartamento, bloco);
    }
}
