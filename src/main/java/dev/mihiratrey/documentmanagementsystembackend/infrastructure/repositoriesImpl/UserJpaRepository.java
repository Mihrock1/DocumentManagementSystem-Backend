package dev.mihiratrey.documentmanagementsystembackend.infrastructure.repositoriesImpl;

import dev.mihiratrey.documentmanagementsystembackend.infrastructure.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserJpaRepository extends JpaRepository<UserEntity, Integer> {
    
    Optional<UserEntity> findByUserId(Integer userId);
    
    Optional<UserEntity> findByEmail(String email);
    
    Boolean existsByUserId(Integer userId);

    Boolean existsByEmail(String email);
    
    Void deleteByUserId(Integer userId);
    
    Void deleteByEmail(String email);
}
