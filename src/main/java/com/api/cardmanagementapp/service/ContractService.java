package com.api.cardmanagementapp.service;

import com.api.cardmanagementapp.model.Client;
import com.api.cardmanagementapp.model.Contract;
import com.api.cardmanagementapp.repository.ClientRepository;
import com.api.cardmanagementapp.repository.ContractRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContractService {

    private final ContractRepository contractRepository;
    private final ClientRepository clientRepository;

    public Collection<Contract> getContractsByClientId(int clientId) {
        // Kiểm tra xem client có tồn tại không
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client không tồn tại!"));

        // Tìm tất cả hợp đồng liên quan đến Client
        return contractRepository.findByClient(client);
    }

    public Collection<Contract> getAllContracts() {
        return  contractRepository.findAll();
    }

    public Optional<Contract> getContractById(int id) {
        return contractRepository.findById(id);
    }
}
