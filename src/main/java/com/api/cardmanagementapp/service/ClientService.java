package com.api.cardmanagementapp.service;

import com.api.cardmanagementapp.model.Client;
import com.api.cardmanagementapp.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;

    @Transactional
    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    @Transactional
    public void deleteClientById(int id) {
        clientRepository.deleteById(id);
    }

    // Phương thức phân trang lấy tất cả client
    public Page<Client> getAllClients(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return clientRepository.findAll(pageable);
    }

    public Optional<Client> getClientById(int id) {
        return clientRepository.findById(id);
    }
}