package com.mainsoft.prueba.configurations;

import com.mainsoft.prueba.repository.dtos.ErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked","rawtypes"})
@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler
{
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
        ErrorResponse error = ErrorResponse.builder()
                .code(500)
                .backendMessage(ex.getLocalizedMessage())
                .httpStatus("ERROR INTERNO DE LA APLICACION")
                .message(ex.getMessage())
                .build();
        return new ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(HttpClientErrorException.NotFound.class)
    public final ResponseEntity<Object> notFoundExceptions(Exception ex, WebRequest request) {
        ErrorResponse error = ErrorResponse.builder()
                .code(404)
                .backendMessage(ex.getLocalizedMessage())
                .httpStatus("ERROR INTERNO DE LA APLICACION")
                .message(ex.getMessage())
                .build();
        return new ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {
        ErrorResponse error = ErrorResponse.builder()
                .code(status.value())
                .backendMessage(ex.getLocalizedMessage())
                .httpStatus(status.getReasonPhrase())
                .message("No se reconoce el metodo")
                .build();
        return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
    }
}
