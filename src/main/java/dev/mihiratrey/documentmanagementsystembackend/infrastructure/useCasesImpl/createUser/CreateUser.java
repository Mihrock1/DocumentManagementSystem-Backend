package dev.mihiratrey.documentmanagementsystembackend.infrastructure.useCasesImpl.createUser;

import dev.mihiratrey.documentmanagementsystembackend.application.exceptions.ApplicationValidationException;
import dev.mihiratrey.documentmanagementsystembackend.application.repositories.IUserRepository;
import dev.mihiratrey.documentmanagementsystembackend.application.useCases.createUser.CreateUserOutput;
import dev.mihiratrey.documentmanagementsystembackend.application.useCases.createUser.ICreateUser;
import dev.mihiratrey.documentmanagementsystembackend.application.useCases.createUser.CreateUserInput;
import dev.mihiratrey.documentmanagementsystembackend.domain.enums.UserType;
import dev.mihiratrey.documentmanagementsystembackend.domain.models.User;
import dev.mihiratrey.documentmanagementsystembackend.infrastructure.factories.UserFactory;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CreateUser implements ICreateUser {
    private final PasswordEncoder passwordEncoder;
    private final IUserRepository userRepository;

    public CreateUser(PasswordEncoder passwordEncoder, IUserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @Override
    public CreateUserOutput Execute(CreateUserInput createUserInput) {
        
        // Perform Validations
        EmailValidator emailValidator = EmailValidator.getInstance(false, false);
        if(!emailValidator.isValid(createUserInput.getEmail())) {
            throw new ApplicationValidationException("Invalid Email format on: " + createUserInput.getEmail());
        }
        
        if(createUserInput.getPwdRaw().isBlank()) {
            throw new ApplicationValidationException("Password cannot be blank");
        }
        
        String pwdHash = passwordEncoder.encode(createUserInput.getPwdRaw());
        UserType role = UserType.fromString(createUserInput.getRole());
        
        User newUser = UserFactory.createFromRegistration(createUserInput.getEmail(), pwdHash, createUserInput.getName(),
                createUserInput.getContactNo(), role);
        
        User savedUser = userRepository.save(newUser);

        CreateUserOutput createUserOutput = new CreateUserOutput(savedUser.getUserId(), savedUser.getEmail(), savedUser.getName(),
                savedUser.getContactNo(), savedUser.getRole());
        
        return createUserOutput;
    }
}
