package dev.mihiratrey.documentmanagementsystembackend.domain.exceptions;

public class DocumentNotFoundException extends RuntimeException {
    
    public DocumentNotFoundException(Long docId) {
        super("Document with id: " + docId + " was not found");
    }
    
    public DocumentNotFoundException(String email) {
        super("No Documents uploaded by: " + email);
    }
}
