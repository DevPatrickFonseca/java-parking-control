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
}