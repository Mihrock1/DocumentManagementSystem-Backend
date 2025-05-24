package dev.mihiratrey.documentmanagementsystembackend.application.useCases.createUser;

public class CreateUserInput {
    private final String email;
    private final String pwdRaw;
    private final String name;
    private final String contactNo;
    private final String role;

    public CreateUserInput(String email, String pwdRaw, String name, String contactNo, String role) {
        this.email = email;
        this.pwdRaw = pwdRaw;
        this.name = name;
        this.contactNo = contactNo;
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public String getPwdRaw() {
        return pwdRaw;
    }

    public String getName() {
        return name;
    }

    public String getContactNo() {
        return contactNo;
    }

    public String getRole() {
        return role;
    }
}
