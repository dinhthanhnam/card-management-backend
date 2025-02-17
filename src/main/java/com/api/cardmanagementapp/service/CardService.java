package com.api.cardmanagementapp.service;

import com.api.cardmanagementapp.model.Card;
import com.api.cardmanagementapp.model.Contract;
import com.api.cardmanagementapp.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CardService {
    private final CardRepository cardRepository;

    @Transactional
    public Card issueCard(Contract issuing) {
        Card card = new Card();
        card.setContract(issuing);
        return cardRepository.save(card);
    }

    @Transactional
    public Card renewCard(Card oldCard) {
        Card newCard = new Card();
        newCard.setContract(oldCard.getContract());
        newCard.setPreviousCard(oldCard);
        return cardRepository.save(newCard);
    }
}
