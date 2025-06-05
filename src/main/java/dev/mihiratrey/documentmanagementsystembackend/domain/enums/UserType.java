package dev.mihiratrey.documentmanagementsystembackend.domain.enums;

import java.util.Arrays;
import java.util.List;

public enum UserType {
    NORMAL,
    ADMIN;

    public static UserType fromString(String role) {
        if (role == null) return NORMAL;
        try {
            return UserType.valueOf(role.toUpperCase());
        } catch (IllegalArgumentException e) {
            return NORMAL;
        }
    }
    
    public static List<String> getUserRoles() {
        return Arrays.stream(UserType.values())
                .map(role -> "ROLE_" + role.name())
                .toList();
    }
}
