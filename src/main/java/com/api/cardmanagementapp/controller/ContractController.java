package com.api.cardmanagementapp.controller;

import com.api.cardmanagementapp.model.Contract;
import com.api.cardmanagementapp.service.ContractService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/contracts")
@RequiredArgsConstructor
public class ContractController {
    private final ContractService contractService;

    @GetMapping
    public ResponseEntity<Page<Contract>> getAllContracts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Page<Contract> contracts = contractService.getAllContracts(page, size);
        return ResponseEntity.ok(contracts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contract> getContractById(@PathVariable int id) {
        return contractService.getContractById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/client/{clientId}")
    public ResponseEntity<Page<Contract>> getContractsByClientId(
            @PathVariable int clientId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Page<Contract> contracts = contractService.getContractsByClientId(clientId, page, size);
        if (contracts.isEmpty()) {
            return ResponseEntity.noContent().build(); // 204 nếu không có hợp đồng nào
        }
        return ResponseEntity.ok(contracts); // 200 + danh sách hợp đồng phân trang
    }
}