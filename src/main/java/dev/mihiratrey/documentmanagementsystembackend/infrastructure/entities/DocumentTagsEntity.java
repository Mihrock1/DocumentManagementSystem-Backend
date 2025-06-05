package dev.mihiratrey.documentmanagementsystembackend.infrastructure.entities;

import dev.mihiratrey.documentmanagementsystembackend.infrastructure.compositeKeys.DocumentTagsId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
public class DocumentTagsEntity {
    
    @EmbeddedId
    private DocumentTagsId docTagsId;
    
    @MapsId("doc_id")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "doc_id", referencedColumnName = "doc_id")
    private DocumentMetadataEntity document;
    
    @MapsId("tag_id")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "tag_id", referencedColumnName = "tag_id")
    private TagEntity tag;
}
