package com.api.cardmanagementapp.repository;

import com.api.cardmanagementapp.model.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractRepository extends JpaRepository<Contract, Integer> {
    Page<Contract> findByClientId(int clientId, Pageable pageable);
}