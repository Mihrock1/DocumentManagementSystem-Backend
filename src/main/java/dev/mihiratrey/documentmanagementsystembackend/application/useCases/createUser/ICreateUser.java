package dev.mihiratrey.documentmanagementsystembackend.application.useCases.createUser;

public interface ICreateUser {
    CreateUserOutput Execute(CreateUserInput iCreateUserInput);
}
