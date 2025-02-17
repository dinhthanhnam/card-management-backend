package com.api.cardmanagementapp.repository;

import com.api.cardmanagementapp.model.Client;
import com.api.cardmanagementapp.model.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface ContractRepository extends JpaRepository<Contract, Integer> {

    Collection<Contract> findByClient(Client client);
}
