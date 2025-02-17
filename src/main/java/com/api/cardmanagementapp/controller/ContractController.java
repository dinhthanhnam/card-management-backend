package com.api.cardmanagementapp.controller;

import com.api.cardmanagementapp.model.Contract;
import com.api.cardmanagementapp.model.Contract;
import com.api.cardmanagementapp.service.ContractService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/contracts")
@RequiredArgsConstructor
public class ContractController {
    private final ContractService contractService;

    @GetMapping
    public ResponseEntity<Collection<Contract>> getAllContracts (@RequestParam(required = false) Integer clientId) {
        Collection<Contract> contracts = contractService.getAllContracts();
        return ResponseEntity.ok(contracts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contract> getContractById(@PathVariable int id) {
        return contractService.getContractById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/client/{clientId}")
    public ResponseEntity<Collection<Contract>> getContractsByClientId(@PathVariable int clientId) {
        Collection<Contract> contracts = contractService.getContractsByClientId(clientId);

        if (contracts.isEmpty()) {
            return ResponseEntity.noContent().build(); // 204 nếu không có hợp đồng nào
        }

        return ResponseEntity.ok(contracts); // 200 + danh sách hợp đồng
    }


}

