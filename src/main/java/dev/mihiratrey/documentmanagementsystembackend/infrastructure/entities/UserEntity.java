package dev.mihiratrey.documentmanagementsystembackend.infrastructure.entities;

import dev.mihiratrey.documentmanagementsystembackend.domain.enums.UserType;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer userId;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(nullable = false)
    private String pwdHash;
    @Column(nullable = false)
    private String name;
    private String contactNo;
    @Column(nullable = false)
    private UserType role;
    
    public UserEntity() {}

    public UserEntity(Integer userId, String email, String pwdHash, String name, String contactNo, UserType role) {
        this.userId = userId;
        this.email = email;
        this.pwdHash = pwdHash;
        this.name = name;
        this.contactNo = contactNo;
        this.role = role;
    }
}
