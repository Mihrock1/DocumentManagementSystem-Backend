package dev.mihiratrey.documentmanagementsystembackend.infrastructure.repositoriesImpl;

import dev.mihiratrey.documentmanagementsystembackend.application.repositories.IUserRepository;
import dev.mihiratrey.documentmanagementsystembackend.domain.exceptions.UserNotFoundException;
import dev.mihiratrey.documentmanagementsystembackend.domain.models.User;
import dev.mihiratrey.documentmanagementsystembackend.infrastructure.entities.UserEntity;
import dev.mihiratrey.documentmanagementsystembackend.infrastructure.mappers.UserMapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserJpaRepositoryAdapter implements IUserRepository {
    
    private final UserJpaRepository userJpaRepository;

    public UserJpaRepositoryAdapter(UserJpaRepository userJpaRepository) {
        this.userJpaRepository = userJpaRepository;
    }
    
    @Override
    public Optional<User> findByUserId(Integer userId) {
        Optional<UserEntity> userEntityOptional = userJpaRepository.findByUserId(userId);
        
        return UserMapper.toDomain(userEntityOptional);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        Optional<UserEntity> userEntityOptional = userJpaRepository.findByEmail(email);
        
        return UserMapper.toDomain(userEntityOptional);
    }

    @Override
    public Boolean existsByUserId(Integer userId) {
        
        return userJpaRepository.existsByUserId(userId);
    }

    @Override
    public Boolean existsByEmail(String email) {
        
        return userJpaRepository.existsByEmail(email);
    }

    @Override
    public User save(User user) {
        UserEntity userEntity = UserMapper.toEntity(user);
        userEntity = userJpaRepository.save(userEntity);
        
        return UserMapper.toDomain(userEntity);
    }

    @Override
    public User update(User user) {
        UserEntity userEntity = UserMapper.toEntity(user);
        userEntity = userJpaRepository.save(userEntity);

        return UserMapper.toDomain(userEntity);
    }

    @Override
    public Boolean deleteByUserId(Integer userId) {
        if(!existsByUserId(userId)) {
            throw new UserNotFoundException(userId);
        }
        
        userJpaRepository.deleteByUserId(userId);

        if(!existsByUserId(userId)) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public Boolean deleteByEmail(String email) {
        if(!existsByEmail(email)) {
            throw new UserNotFoundException(email);
        }

        userJpaRepository.deleteByEmail(email);

        if(!existsByEmail(email)) {
            return true;
        }
        else {
            return false;
        }
    }
}
