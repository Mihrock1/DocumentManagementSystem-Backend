package dev.mihiratrey.documentmanagementsystembackend.infrastructure.mappers;

import dev.mihiratrey.documentmanagementsystembackend.domain.models.User;
import dev.mihiratrey.documentmanagementsystembackend.infrastructure.entities.UserEntity;

import java.util.Optional;

public class UserEntityMapper {
    public static User toDomain(UserEntity userEntity) {
        return new User(userEntity.getUserId(), userEntity.getEmail(), userEntity.getPwdHash(), 
                userEntity.getName(), userEntity.getContactNo(), userEntity.getRole());
    }
    
    public static Optional<User> toDomain(Optional<UserEntity> userEntityOptional) {
        return userEntityOptional.map(UserEntityMapper::toDomain);
    }
    
    public static UserEntity toEntity(User user) {
        return new UserEntity(user.getUserId(), user.getEmail(), user.getPwdHash(), user.getName(), 
                user.getContactNo(), user.getRole());
    }
    
    public static Optional<UserEntity> toEntity(Optional<User> userOptional) {
        return userOptional.map(UserEntityMapper::toEntity);
    }
}
