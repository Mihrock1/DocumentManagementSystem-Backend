package dev.mihiratrey.documentmanagementsystembackend.domain.models;

import dev.mihiratrey.documentmanagementsystembackend.domain.enums.DocType;
import dev.mihiratrey.documentmanagementsystembackend.domain.exceptions.DomainValidationException;

import java.util.Date;
import java.util.Optional;

public class DocumentMetadata {
    
    private Optional<Long> docId;
    private String docName;
    private String blobStoreKey;
    private User uploadedBy;
    private Date uploadTime;
    private DocType docType;
    private Category category;
    private Boolean isDeleted;

    public DocumentMetadata(Optional<Long> docId, String docName, String blobStoreKey, User uploadedBy, Date uploadTime, DocType docType, Category category, Boolean isDeleted) {
        
        if(docName == null || docName.isEmpty()) {
            throw new DomainValidationException("Document Name must not be null or empty");
        }
        
        if(blobStoreKey == null || blobStoreKey.isBlank()) {
            throw new DomainValidationException("Blob Storage Key must not be null or empty");
        }
        
        if(uploadedBy == null) {
            throw new DomainValidationException("Uploaded By must not be null");
        }

        if(uploadTime == null) {
            throw new DomainValidationException("Uploaded Timestamp must not be null");
        }

        if(docType == null) {
            throw new DomainValidationException("docType must not be null");
        }

        if(category == null) {
            throw new DomainValidationException("Category must not be null");
        }

        if(isDeleted == null) {
            throw new DomainValidationException("Is Deleted Value must not be null");
        }
        
        this.docId = docId;
        this.docName = docName;
        this.blobStoreKey = blobStoreKey;
        this.uploadedBy = uploadedBy;
        this.uploadTime = uploadTime;
        this.docType = docType;
        this.category = category;
        this.isDeleted = isDeleted;
    }

    public Optional<Long> getDocId() {
        return docId;
    }

    public String getDocName() {
        return docName;
    }

    public String getBlobStoreKey() {
        return blobStoreKey;
    }

    public User getUploadedBy() {
        return uploadedBy;
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public DocType getDocType() {
        return docType;
    }

    public Category getCategory() {
        return category;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }
}
