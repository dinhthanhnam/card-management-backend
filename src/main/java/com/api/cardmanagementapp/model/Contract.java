package com.api.cardmanagementapp.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.Collections;
import java.util.List;
import java.util.Random;

@Entity
@Table(name = "contracts")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 16, unique = true, nullable = false)
    private String contractNumber; // Dùng chung cho cả Liability & Issuing

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ContractType contractType; // PARENT hoặc CHILD

    @ManyToOne
    @JoinColumn(name = "parent_id") // Self-Reference: Chỉ có Issuing mới có Parent
    @JsonManagedReference
    private Contract parent;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    private List<Contract> children;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    @JsonManagedReference
    private Client client;

    @OneToMany(mappedBy = "contract", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Card> issuedCards;

    public Contract getParent() {
        if (this.contractType == ContractType.ISSUING && this.parent != null) {
            return Contract.builder()
                    .id(parent.getId())
                    .contractNumber(parent.getContractNumber())
                    .contractType(parent.getContractType())
                    .build(); // ✅ Không chứa client để tránh lặp dữ liệu
        }
        return null;
    }

    public List<Contract> getChildren() {
        if (this.contractType == ContractType.LIABILITY && this.children != null) {
            return this.children.stream()
                    .map(child -> Contract.builder()
                            .id(child.getId())
                            .contractNumber(child.getContractNumber())
                            .contractType(child.getContractType())
                            .build()) // ✅ Không chứa client để tránh lặp dữ liệu
                    .toList();
        }
        return Collections.emptyList();
    }


    @PrePersist
    private void generateContractNumber() {
        if (this.contractNumber == null) {
            this.contractNumber = generateUniqueContractNumber();
        }
    }

    private String generateUniqueContractNumber() {
        Random random = new Random();
        return String.format("%016d", random.nextLong(1_000_000_000_000_0000L));
    }

    public enum ContractType {
        LIABILITY, ISSUING
    }
}
