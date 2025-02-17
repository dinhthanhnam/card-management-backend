package com.api.cardmanagementapp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Random;

@Entity
@Getter
@Setter
@Table(name = "cards")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 16, unique = true, nullable = false)
    private String cardNumber;

    @Enumerated(EnumType.STRING)
    private CardType cardType;

    @Enumerated(EnumType.STRING)
    private CardStatus cardStatus;

    @Enumerated(EnumType.STRING)
    private CardScope cardScope;

    @Column
    private BigDecimal cardBalance;

    @Column
    private BigDecimal cardLimit;

    @Column(nullable = false)
    private LocalDateTime expireAt;

    @ManyToOne
    @JoinColumn(name = "contract_id", nullable = false)
    @JsonBackReference
    private Contract contract;

    @ManyToOne
    @JoinColumn(name = "previous_card_id")
    private Card previousCard;

    @PrePersist
    private void generateCardNumber() {
        if (this.cardNumber == null) {
            this.cardNumber = generateUniqueCardNumber();
        }
    }

    private String generateUniqueCardNumber() {
        Random random = new Random();
        return String.format("%016d", random.nextLong(1_000_000_000_000_0000L));
    }

    public enum CardType {
        PREPAID, CREDIT, DEBIT
    }

    public enum CardStatus {
        ACTIVE, INACTIVE, BLOCKED
    }

    public enum CardScope {
        VISA, MASTER, JCB, AMEX, NAPAS
    }
}
