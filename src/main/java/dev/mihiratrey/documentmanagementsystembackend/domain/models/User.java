package dev.mihiratrey.documentmanagementsystembackend.domain.models;

import dev.mihiratrey.documentmanagementsystembackend.domain.enums.UserType;

public record User(Integer userId, String email, String pwdHash, String name, String contactNo, UserType role) {}
