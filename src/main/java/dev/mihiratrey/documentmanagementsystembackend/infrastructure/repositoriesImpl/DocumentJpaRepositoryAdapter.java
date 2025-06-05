package dev.mihiratrey.documentmanagementsystembackend.infrastructure.repositoriesImpl;

import dev.mihiratrey.documentmanagementsystembackend.application.repositories.IDocumentRepository;
import dev.mihiratrey.documentmanagementsystembackend.domain.exceptions.DocumentNotFoundException;
import dev.mihiratrey.documentmanagementsystembackend.domain.models.DocumentMetadata;
import dev.mihiratrey.documentmanagementsystembackend.domain.models.User;
import dev.mihiratrey.documentmanagementsystembackend.infrastructure.entities.DocumentMetadataEntity;
import dev.mihiratrey.documentmanagementsystembackend.infrastructure.mappers.DocumentMetadataEntityMapper;
import dev.mihiratrey.documentmanagementsystembackend.infrastructure.mappers.UserEntityMapper;

import java.util.List;
import java.util.Optional;

public class DocumentJpaRepositoryAdapter implements IDocumentRepository {
    
    private final DocumentJpaRepository documentJpaRepository;

    public DocumentJpaRepositoryAdapter(DocumentJpaRepository documentJpaRepository) {
        this.documentJpaRepository = documentJpaRepository;
    }

    @Override
    public Optional<DocumentMetadata> findByDocId(Long docId) {

        DocumentMetadataEntity docEntity = documentJpaRepository.getReferenceById(docId);
        
        return Optional.ofNullable(DocumentMetadataEntityMapper.toDomain(docEntity));
    }

    @Override
    public List<DocumentMetadata> findAllByUser(User user) {
        
        List<DocumentMetadataEntity> docEntityList = documentJpaRepository
                .findAllByUploadedBy(UserEntityMapper.toEntity(user));
        
        return docEntityList.stream()
                .map(DocumentMetadataEntityMapper::toDomain).toList();
    }

    @Override
    public Boolean existsByDocId(Long docId) {
        
        return documentJpaRepository.existsByDocId(docId);
    }

    @Override
    public DocumentMetadata save(DocumentMetadata documentMetadata) {
        
        return DocumentMetadataEntityMapper.toDomain(documentJpaRepository
                .save(DocumentMetadataEntityMapper.toEntity(documentMetadata)));
    }

    @Override
    public DocumentMetadata update(DocumentMetadata documentMetadata) {
        
        return DocumentMetadataEntityMapper.toDomain(documentJpaRepository
                .save(DocumentMetadataEntityMapper.toEntity(documentMetadata)));
    }

    @Override
    public Boolean deleteByDocId(Long docId) {
        
        if (!existsByDocId(docId)) throw new DocumentNotFoundException(docId);
        
        documentJpaRepository.deleteByDocId(docId);
        
        return !existsByDocId(docId);
    }

    @Override
    public Boolean deleteAllByUser(User user) {
        
        if (findAllByUser(user).isEmpty()) throw new DocumentNotFoundException(user.getEmail());
        
        documentJpaRepository.deleteAllByUploadedBy(UserEntityMapper.toEntity(user));
        
        return findAllByUser(user).isEmpty();
    }
}
