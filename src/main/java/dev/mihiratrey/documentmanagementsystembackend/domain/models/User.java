package dev.mihiratrey.documentmanagementsystembackend.domain.models;

import dev.mihiratrey.documentmanagementsystembackend.domain.enums.UserType;
import dev.mihiratrey.documentmanagementsystembackend.domain.exceptions.DomainValidationException;

public class User {
    private Integer userId;
    private String email;
    private String pwdHash;
    private String name;
    private String contactNo;
    private UserType role;

    public User(Integer userId, String email, String pwdHash, String name, String contactNo, UserType role) {

        if (email == null || !email.matches("[^@\\s]+@[^@\\s]+\\.[^@\\s]+")) {
            throw new DomainValidationException("Invalid Email format: " + email);
        }
        if (name == null || name.isBlank()) {
            throw new DomainValidationException("Name cannot be blank");
        }
        if (pwdHash == null || pwdHash.isBlank()) {
            throw new DomainValidationException("Password cannot be blank");
        }
        if (role == null) {
            throw new DomainValidationException("Role cannot be blank");
        }
        
        this.userId = userId;
        this.email = email;
        this.pwdHash = pwdHash;
        this.name = name;
        this.contactNo = contactNo;
        this.role = role;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public String getPwdHash() {
        return pwdHash;
    }

    public String getName() {
        return name;
    }

    public String getContactNo() {
        return contactNo;
    }

    public UserType getRole() {
        return role;
    }
    
    
}
