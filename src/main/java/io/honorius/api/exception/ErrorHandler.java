package io.honorius.api.exception;

import io.honorius.api.exception.exceptions.UserCcException;
import io.honorius.api.exception.exceptions.UserNameException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(UserCcException.class)
    public ResponseEntity<ErrorResponse> handlerUserCcException(UserCcException ex) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        ErrorResponse error = new ErrorResponse(100, "INVALID_DOCUMENT", ex.getMessage());
        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponse> handlerHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        ErrorResponse error = new ErrorResponse(100, "INVALID_DOCUMENT", "Invalid document");
        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(UserNameException.class)
    public ResponseEntity<ErrorResponse> handlerUserNameException(UserNameException ex) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        ErrorResponse error = new ErrorResponse(101, "INVALID_NAME", ex.getMessage());
        return ResponseEntity.status(status).body(error);
    }
}
