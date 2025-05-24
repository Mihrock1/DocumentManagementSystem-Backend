package dev.mihiratrey.documentmanagementsystembackend.application.exceptions;

import dev.mihiratrey.documentmanagementsystembackend.domain.exceptions.ValidationExceptionBase;

public class ApplicationValidationException extends ValidationExceptionBase {
    
    public ApplicationValidationException(String message) {
        super(message);
    }
}
