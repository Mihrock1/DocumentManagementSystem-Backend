package dev.mihiratrey.documentmanagementsystembackend.application.useCases.createUser;

import dev.mihiratrey.documentmanagementsystembackend.domain.enums.UserType;

public class CreateUserOutput {
    private final Integer userId;
    private final String email;
    private final String name;
    private final String contactNo;
    private final String role;

    public CreateUserOutput(Integer userId, String email, String name, String contactNo, UserType role) {
        this.userId = userId;
        this.email = email;
        this.name = name;
        this.contactNo = contactNo;
        this.role = role.toString();
    }

    public Integer getUserId() { return userId; }
    
    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getContactNo() {
        return contactNo;
    }

    public String getRole() { return role; }
}
