package dev.mihiratrey.documentmanagementsystembackend.application.useCases.createUser;

import dev.mihiratrey.documentmanagementsystembackend.domain.models.User;

import java.util.Optional;

public interface ICreateUser {
    Optional<User> Execute(CreateUserInput iCreateUserInput);
}
