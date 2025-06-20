package dev.mihiratrey.documentmanagementsystembackend.infrastructure.entities;

import dev.mihiratrey.documentmanagementsystembackend.domain.enums.UserType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
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
    @Enumerated(EnumType.STRING)
    private UserType role;
}
