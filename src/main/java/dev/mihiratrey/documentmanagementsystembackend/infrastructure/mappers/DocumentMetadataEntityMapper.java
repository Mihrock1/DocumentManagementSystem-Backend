package dev.mihiratrey.documentmanagementsystembackend.infrastructure.mappers;

import dev.mihiratrey.documentmanagementsystembackend.domain.models.DocumentMetadata;
import dev.mihiratrey.documentmanagementsystembackend.infrastructure.entities.DocumentMetadataEntity;

import java.util.Optional;

public class DocumentMetadataEntityMapper {
    
    public static DocumentMetadata toDomain(DocumentMetadataEntity doc) {
        return new DocumentMetadata(Optional.ofNullable(doc.getDocId()), doc.getDocName(), doc.getBlobStoreKey(),
                UserEntityMapper.toDomain(doc.getUploadedBy()), doc.getUploadTime(), doc.getDocType(), 
                CategoryEntityMapper.toDomain(doc.getCategory()), doc.getIsDeleted());
    }
    
    public static DocumentMetadataEntity toEntity(DocumentMetadata doc) {
        return new DocumentMetadataEntity(doc.getDocId().get(), doc.getDocName(), doc.getBlobStoreKey(),
                UserEntityMapper.toEntity(doc.getUploadedBy()), doc.getUploadTime(), doc.getDocType(),
                CategoryEntityMapper.toEntity(doc.getCategory()), doc.getDeleted());
    }
}
