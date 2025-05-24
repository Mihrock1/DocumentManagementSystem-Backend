package dev.mihiratrey.documentmanagementsystembackend.infrastructure.factories;

import dev.mihiratrey.documentmanagementsystembackend.domain.enums.UserType;
import dev.mihiratrey.documentmanagementsystembackend.domain.models.User;

public class UserFactory {
    public User createFromRegistration(String email, String pwdHash, String name, String contactNo, UserType role) {
        return new User(null, email, pwdHash, name, contactNo, role);
    }
}
