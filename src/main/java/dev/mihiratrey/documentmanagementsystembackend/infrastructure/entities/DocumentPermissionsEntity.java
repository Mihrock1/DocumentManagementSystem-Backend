package dev.mihiratrey.documentmanagementsystembackend.infrastructure.entities;

import dev.mihiratrey.documentmanagementsystembackend.infrastructure.compositeKeys.DocumentPermissionsId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
public class DocumentPermissionsEntity {
    
    @EmbeddedId
    private DocumentPermissionsId docPermissionsId;
    
    @MapsId(value = "docId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "doc_id", referencedColumnName = "doc_id", nullable = false)
    private DocumentMetadataEntity document;
    
    @MapsId(value = "userId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private UserEntity user;
    
    @Column(nullable = false)
    private Boolean canView;
    
    @Column(nullable = false)
    private Boolean canEdit;
    
    @Column(nullable = false)
    private Boolean canDelete;
    
    @Column(nullable = false)
    private Boolean isDeleted;
}
