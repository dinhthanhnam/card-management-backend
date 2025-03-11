package com.api.cardmanagementapp.seeder;

import com.api.cardmanagementapp.model.*;
import com.api.cardmanagementapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.ApplicationArguments;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DatabaseSeeder implements ApplicationRunner {
    private final PasswordEncoder passwordEncoder;
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
        System.out.println("Seed card thanh cong");
    }
}

