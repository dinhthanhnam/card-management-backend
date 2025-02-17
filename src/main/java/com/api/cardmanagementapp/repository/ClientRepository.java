package com.api.cardmanagementapp.repository;

import com.api.cardmanagementapp.model.Client;
import com.api.cardmanagementapp.model.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {

}
