package com.api.cardmanagementapp.repository;

import com.api.cardmanagementapp.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Integer> {

}
