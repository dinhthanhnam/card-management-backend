package com.api.cardmanagementapp.controller;

import com.api.cardmanagementapp.model.Card;
import com.api.cardmanagementapp.model.Client;
import com.api.cardmanagementapp.model.Contract;
import com.api.cardmanagementapp.repository.ClientRepository;
import com.api.cardmanagementapp.service.CardService;
import com.api.cardmanagementapp.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/cards")
@RequiredArgsConstructor
public class CardController {
    private final CardService cardService;

    @GetMapping
    public ResponseEntity<Collection<Card>> getAllCards() {
        return ResponseEntity.ok(cardService.getAllCards());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Card> getCardById(@PathVariable int id) {
        return cardService.getCardById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
