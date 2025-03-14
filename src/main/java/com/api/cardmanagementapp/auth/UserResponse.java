package com.api.cardmanagementapp.auth;
import com.api.cardmanagementapp.model.auth.User;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponse {
    private int id;
    private String name;
    private String email;
    private User.Role role;
}

