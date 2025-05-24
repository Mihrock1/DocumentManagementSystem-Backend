package dev.mihiratrey.documentmanagementsystembackend.domain.exceptions;


public class DomainValidationException extends ValidationExceptionBase {
    
    public DomainValidationException(String message) {
        super(message);
    }
}
