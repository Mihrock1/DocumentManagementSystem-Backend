package dev.mihiratrey.documentmanagementsystembackend.domain.exceptions;

import jakarta.validation.ValidationException;

public class ValidationExceptionBase extends ValidationException {

    public ValidationExceptionBase(String message) {
        super(message);
    }
}
