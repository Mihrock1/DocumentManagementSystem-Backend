package dev.mihiratrey.documentmanagementsystembackend.application.repositories;

import dev.mihiratrey.documentmanagementsystembackend.domain.models.DocumentMetadata;
import dev.mihiratrey.documentmanagementsystembackend.domain.models.User;

import java.util.List;
import java.util.Optional;

public interface IDocumentRepository {
    
    Optional<DocumentMetadata> findByDocId(Long docId);
    
    List<DocumentMetadata> findAllByUser(User user);
    
    Boolean existsByDocId(Long docId);
    
    DocumentMetadata save(DocumentMetadata documentMetadata);
    
    DocumentMetadata update(DocumentMetadata documentMetadata);
    
    Boolean deleteByDocId(Long docId);
    
    Boolean deleteAllByUser(User user);
}
