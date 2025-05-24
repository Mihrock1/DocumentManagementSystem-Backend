package dev.mihiratrey.documentmanagementsystembackend.infrastructure.useCasesImpl.createUser;

import dev.mihiratrey.documentmanagementsystembackend.application.useCases.createUser.ICreateUser;
import dev.mihiratrey.documentmanagementsystembackend.application.useCases.createUser.CreateUserInput;
import dev.mihiratrey.documentmanagementsystembackend.domain.models.User;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

public class CreateUser implements ICreateUser {
    private final PasswordEncoder passwordEncoder;

    public CreateUser(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<User> Execute(CreateUserInput iCreateUserInput) {
        
    }
}
