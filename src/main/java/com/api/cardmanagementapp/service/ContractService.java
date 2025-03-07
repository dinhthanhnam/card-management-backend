package com.api.cardmanagementapp.service;

import com.api.cardmanagementapp.model.Contract;
import com.api.cardmanagementapp.repository.ContractRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContractService {
    private final ContractRepository contractRepository;

    public Page<Contract> getAllContracts(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return contractRepository.findAll(pageable);
    }

    public Optional<Contract> getContractById(int id) {
        return contractRepository.findById(id);
    }

    public Page<Contract> getContractsByClientId(int clientId, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return contractRepository.findByClientId(clientId, pageable);
    }

    // Giữ nguyên các method khác nếu có (create, delete, v.v.)
}