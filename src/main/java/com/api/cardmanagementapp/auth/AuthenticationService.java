package com.api.cardmanagementapp.auth;

import com.api.cardmanagementapp.service.JwtService;
import com.api.cardmanagementapp.model.auth.User;
import com.api.cardmanagementapp.repository.auth.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        var user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(User.Role.USER)
                .build();
        userRepository.save(user);

        var accessToken = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(user); // 🔹 Thêm Refresh Token

        return AuthenticationResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken) // 🔹 Trả về Refresh Token
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow();

        var accessToken = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(user); // 🔹 Thêm Refresh Token

        return AuthenticationResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken) // 🔹 Trả về Refresh Token
                .build();
    }

    public AuthenticationResponse refreshToken(RefreshTokenRequest request) {
        String refreshToken = request.getRefreshToken();
        String username = jwtService.extractUsername(refreshToken);

        var user = userRepository.findByEmail(username).orElseThrow();

        if (jwtService.isTokenValid(refreshToken, user)) {
            var newAccessToken = jwtService.generateToken(user);
            return AuthenticationResponse.builder()
                    .accessToken(newAccessToken)
                    .refreshToken(refreshToken)
                    .build();
        }
        throw new RuntimeException("Invalid refresh token");
    }

    public UserResponse getCurrentUser(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .role(user.getRole())
                .build();
    }
}
