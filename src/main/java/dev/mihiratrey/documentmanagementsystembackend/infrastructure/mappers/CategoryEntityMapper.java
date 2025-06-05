package dev.mihiratrey.documentmanagementsystembackend.infrastructure.mappers;

import dev.mihiratrey.documentmanagementsystembackend.domain.models.Category;
import dev.mihiratrey.documentmanagementsystembackend.infrastructure.entities.CategoryEntity;

import java.util.Optional;

public class CategoryEntityMapper {
    
    public static Category toDomain(CategoryEntity category) {
        return new Category(Optional.ofNullable(category.getCategoryId()), category.getCategoryName(), 
                UserEntityMapper.toDomain(category.getCreatedBy()), category.getCreatedAt(), 
                category.getIsDeleted());
    }
    
    public static CategoryEntity toEntity(Category category) {
        return new CategoryEntity(category.getCategoryId().get(), category.getCategoryName(), 
                UserEntityMapper.toEntity(category.getCreatedBy()), category.getCreatedAt(),
                category.getDeleted());
    }
}
