package com.api.cardmanagementapp.seeder;

import com.api.cardmanagementapp.model.*;
import com.api.cardmanagementapp.repository.CardRepository;
import com.api.cardmanagementapp.repository.ClientRepository;
import com.api.cardmanagementapp.repository.ContractRepository;
import com.api.cardmanagementapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.ApplicationArguments;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DatabaseSeeder implements ApplicationRunner {
    private final PasswordEncoder passwordEncoder;
    private final ClientRepository clientRepository;
    private final CardRepository cardRepository;
    private final ContractRepository contractRepository;
    private final UserRepository userRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // Sử dụng Builder để khởi tạo nhiều Client cùng lúc
        List<User> users = List.of(
                User.builder()
                        .name("Nam")
                        .email("nam@user.com")
                        .password(passwordEncoder.encode("12345678"))
                        .role(User.Role.USER)
                        .build(),
                User.builder()
                        .name("Lam")
                        .email("lam@user.com")
                        .password(passwordEncoder.encode("12345678"))
                        .role(User.Role.USER)
                        .build()
        );

        userRepository.saveAll(users);

        System.out.println("✅ Seed dữ liệu user thành công!");


        // Sử dụng Builder để khởi tạo nhiều Client cùng lúc
        List<Client> clients = List.of(
                Client.builder()
                        .firstName("John")
                        .lastName("Doe")
                        .email("john.doe@example.com")
                        .phone("0123456789")
                        .identityNumber("123456789")
                        .dateOfBirth(LocalDateTime.of(2003, 4, 10, 0 ,0))
                        .address(Address.builder()
                                .country("Viet Nam")
                                .city("Ha Noi")
                                .street("Au Co")
                                .build()
                        )
                        .build(),
                Client.builder()
                        .firstName("Alice")
                        .lastName("Smith")
                        .email("alice.smith@example.com")
                        .phone("0987654321")
                        .identityNumber("987654321")
                        .dateOfBirth(LocalDateTime.of(2002, 11, 4, 0 ,0))
                        .build(),
                Client.builder()
                        .firstName("Lai")
                        .lastName("Gia")
                        .email("gia.lai@example.com")
                        .phone("0987654451")
                        .identityNumber("982654321")
                        .dateOfBirth(LocalDateTime.of(2002, 11, 4, 0 ,0))
                        .build(),
                Client.builder()
                        .firstName("Nghia")
                        .lastName("The")
                        .email("nghia.the@example.com")
                        .phone("0987631231")
                        .identityNumber("232654321")
                        .dateOfBirth(LocalDateTime.of(2002, 11, 4, 0 ,0))
                        .build(),
                Client.builder()
                        .firstName("Tung")
                        .lastName("Soi")
                        .email("tung.soi@example.com")
                        .phone("0987654431")
                        .identityNumber("43254321")
                        .dateOfBirth(LocalDateTime.of(2002, 11, 4, 0 ,0))
                        .build(),
                Client.builder()
                        .firstName("Do")
                        .lastName("Phung")
                        .email("do.phung@example.com")
                        .phone("0984534451")
                        .identityNumber("456724321")
                        .dateOfBirth(LocalDateTime.of(2002, 11, 4, 0 ,0))
                        .build(),
                Client.builder()
                        .firstName("Tuoi")
                        .lastName("Vui")
                        .email("vui.tuoi@example.com")
                        .phone("0987449451")
                        .identityNumber("933424321")
                        .dateOfBirth(LocalDateTime.of(2002, 11, 4, 0 ,0))
                        .build(),
                Client.builder()
                        .firstName("Mun")
                        .lastName("Be")
                        .email("be.mun@example.com")
                        .phone("0983482151")
                        .identityNumber("982349821")
                        .dateOfBirth(LocalDateTime.of(2002, 11, 4, 0 ,0))
                        .build(),
                Client.builder()
                        .firstName("Nhi")
                        .lastName("Nhu")
                        .email("nhu.nhi@example.com")
                        .phone("0987644432")
                        .identityNumber("232654345")
                        .dateOfBirth(LocalDateTime.of(2002, 11, 4, 0 ,0))
                        .build(),
                Client.builder()
                        .firstName("Lai")
                        .lastName("Nhu")
                        .email("nhu.lai@example.com")
                        .phone("0987327632")
                        .identityNumber("232552345")
                        .dateOfBirth(LocalDateTime.of(2002, 11, 4, 0 ,0))
                        .build(),
                Client.builder()
                        .firstName("Lam")
                        .lastName("Van")
                        .email("van.lam@example.com")
                        .phone("0989973432")
                        .identityNumber("233379345")
                        .dateOfBirth(LocalDateTime.of(2002, 11, 4, 0 ,0))
                        .build()
        );


        clientRepository.saveAll(clients);

        System.out.println("✅ Seed dữ liệu client thành công!");

        List<Client> savedClients = clientRepository.findAll();

        Contract parentContract = Contract.builder()
                .contractType(Contract.ContractType.LIABILITY)
                .client(savedClients.getFirst()) // ✅ Đảm bảo client không phải null
                .build();

        Contract childContract = Contract.builder()
                .contractType(Contract.ContractType.ISSUING)
                .parent(parentContract)
                .client(savedClients.getFirst())// ✅ Gán parent contract
                .build();

        contractRepository.save(parentContract);
        contractRepository.save(childContract);

        List<Contract> savedContracts = contractRepository.findAll();

        List<Card> cards = List.of(
                Card.builder()
                        .cardType(Card.CardType.DEBIT)
                        .cardStatus(Card.CardStatus.ACTIVE)
                        .cardScope(Card.CardScope.VISA)
                        .cardLimit(BigDecimal.valueOf(50000000))
                        .cardBalance(BigDecimal.valueOf(100000000))
                        .expireAt(LocalDateTime.of(2028, 12, 12, 5, 0))
                        .contract(savedContracts.get(1))
                        .build(),
                Card.builder()
                        .cardType(Card.CardType.PREPAID)
                        .cardStatus(Card.CardStatus.ACTIVE)
                        .cardScope(Card.CardScope.VISA)
                        .cardLimit(BigDecimal.valueOf(50000000))
                        .cardBalance(BigDecimal.valueOf(100000000))
                        .expireAt(LocalDateTime.of(2028, 12, 12, 5, 0))
                        .contract(savedContracts.get(1))
                        .build(),
                Card.builder()
                        .cardType(Card.CardType.CREDIT)
                        .cardStatus(Card.CardStatus.ACTIVE)
                        .cardScope(Card.CardScope.VISA)
                        .cardLimit(BigDecimal.valueOf(50000000))
                        .cardBalance(BigDecimal.valueOf(100000000))
                        .expireAt(LocalDateTime.of(2028, 12, 12, 5, 0))
                        .contract(savedContracts.get(1))
                        .build()
        );

        cardRepository.saveAll(cards);
        System.out.println("Seed card thanh cong");
    }
}

