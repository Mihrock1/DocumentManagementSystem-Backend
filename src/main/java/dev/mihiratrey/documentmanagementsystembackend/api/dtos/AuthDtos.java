package dev.mihiratrey.documentmanagementsystembackend.api.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

public class AuthDtos {
    @Data
    public static class AuthRequest {
        private String username;
        private String password;
    }

    @Data
    @AllArgsConstructor
    public static class AuthResponse {
        private String token;
    }
}
