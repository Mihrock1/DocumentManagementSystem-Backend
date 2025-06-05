package dev.mihiratrey.documentmanagementsystembackend.infrastructure.repositoriesImpl;

import dev.mihiratrey.documentmanagementsystembackend.infrastructure.entities.DocumentMetadataEntity;
import dev.mihiratrey.documentmanagementsystembackend.infrastructure.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DocumentJpaRepository extends JpaRepository<DocumentMetadataEntity, Long> {
    
    List<DocumentMetadataEntity> findAllByUploadedBy(UserEntity user);
    
    Boolean existsByDocId(Long docId);
    
    Void deleteByDocId(Long docId);
    
    Void deleteAllByUploadedBy(UserEntity user);
}
