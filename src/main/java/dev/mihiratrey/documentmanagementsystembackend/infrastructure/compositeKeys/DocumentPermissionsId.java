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
public class DocumentPermissionsId implements Serializable {
    
    private Long docId;
    
    private Integer userId;

    @Override
    public int hashCode() {
        int result = docId.hashCode();
        result = 31 * result + userId.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        
        if (this == obj) return true;
        
        if (obj == null || getClass() != obj.getClass()) return false;
        
        DocumentPermissionsId that = (DocumentPermissionsId) obj;
        
        return (this.docId.equals(that.docId) && this.userId.equals(that.userId));
    }
}
