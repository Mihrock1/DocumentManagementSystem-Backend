package dev.mihiratrey.documentmanagementsystembackend.infrastructure.entities;

import dev.mihiratrey.documentmanagementsystembackend.domain.enums.DocType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
public class DocumentMetadataEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long docId;
    
    @Column(nullable = false)
    private String docName;
    
    @Column(unique = true, nullable = false)
    private String blobStoreKey;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "uploaded_by", referencedColumnName = "user_id", nullable = false)
    private UserEntity uploadedBy;
    
    @Column(nullable = false)
    private String uploadTime;
    
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private DocType docType;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category", referencedColumnName = "category_id", nullable = false)
    private CategoryEntity category;
    
    @Column(nullable = false)
    private Boolean isDeleted;
}
