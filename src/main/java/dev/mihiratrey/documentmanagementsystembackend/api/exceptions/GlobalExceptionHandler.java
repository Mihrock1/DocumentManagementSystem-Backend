package dev.mihiratrey.documentmanagementsystembackend.api.exceptions;

import dev.mihiratrey.documentmanagementsystembackend.domain.exceptions.ValidationExceptionBase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(ValidationExceptionBase.class)
    public ResponseEntity<Map<String, Object>> handleValidationException(ValidationExceptionBase ex) {
        Map<String, Object> body = Map.of(
            "error", ex.getMessage(),
            "type", ex.getClass().getSimpleName(),
            "timestamp", LocalDateTime.now()
        );
        
        return ResponseEntity.badRequest().body(body);
    }
}
