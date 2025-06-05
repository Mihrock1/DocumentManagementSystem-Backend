package dev.mihiratrey.documentmanagementsystembackend.domain.models;

import java.util.Date;
import java.util.Optional;

public class Category {
    
    private Optional<Integer> categoryId;
    private String categoryName;
    private User createdBy;
    private Date createdAt;
    private Boolean isDeleted;

    public Category(Optional<Integer> categoryId, String categoryName, User createdBy, Date createdAt, Boolean isDeleted) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
        this.isDeleted = isDeleted;
    }

    public Optional<Integer> getCategoryId() {
        return categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }
}
