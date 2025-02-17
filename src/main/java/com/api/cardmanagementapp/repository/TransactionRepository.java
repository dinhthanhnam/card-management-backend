package com.api.cardmanagementapp.repository;

import com.api.cardmanagementapp.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

}
