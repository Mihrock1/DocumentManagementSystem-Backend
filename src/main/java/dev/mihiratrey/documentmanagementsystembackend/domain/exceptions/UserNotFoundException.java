package dev.mihiratrey.documentmanagementsystembackend.domain.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Integer userId) {
        super("User with Id: " + userId + " was not found");
    }
    
    public UserNotFoundException(String email) {
        super("User with Email: " + email + " was not found");
    }
}
