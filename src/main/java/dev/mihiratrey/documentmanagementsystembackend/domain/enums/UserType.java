package dev.mihiratrey.documentmanagementsystembackend.domain.enums;

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
}
