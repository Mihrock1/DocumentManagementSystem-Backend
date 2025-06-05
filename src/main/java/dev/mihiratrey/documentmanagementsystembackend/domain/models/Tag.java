package dev.mihiratrey.documentmanagementsystembackend.domain.models;

import java.util.Date;
import java.util.Optional;

public class Tag {
    private Optional<Long> tagId;
    private String tagName;
    private User createdBy;
    private Date createdAt;
    private Boolean isDeleted;

    public Tag(Optional<Long> tagId, String tagName, User createdBy, Date createdAt, Boolean isDeleted) {
        this.tagId = tagId;
        this.tagName = tagName;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
        this.isDeleted = isDeleted;
    }

    public Optional<Long> getTagId() {
        return tagId;
    }

    public String getTagName() {
        return tagName;
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
