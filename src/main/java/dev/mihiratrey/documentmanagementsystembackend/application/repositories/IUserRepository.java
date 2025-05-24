package dev.mihiratrey.documentmanagementsystembackend.application.repositories;

import dev.mihiratrey.documentmanagementsystembackend.domain.models.User;

import java.util.Optional;

public interface IUserRepository {
    
    Optional<User> findByUserId(Integer userId);
    
    Optional<User> findByEmail(String email);
    
    Boolean existsByUserId(Integer userId);
    
    Boolean existsByEmail(String email);
    
    User save(User user);
    
    User update(User user);
    
    Boolean deleteByUserId(Integer userId);
    
    Boolean deleteByEmail(String email);
}
