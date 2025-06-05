package dev.mihiratrey.documentmanagementsystembackend.infrastructure.compositeKeys;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Embeddable
public class DocumentTagsId implements Serializable {
    
    private Long docId;
    
    private Long tagId;

    @Override
    public int hashCode() {
        int result = docId.hashCode();
        result = 31 * result + tagId.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        
        if (this == obj) return true;

        if (obj == null || getClass() != obj.getClass()) return false;

        DocumentTagsId that = (DocumentTagsId) obj;

        return (this.docId.equals(that.docId) && this.tagId.equals(that.tagId));
    }
}
