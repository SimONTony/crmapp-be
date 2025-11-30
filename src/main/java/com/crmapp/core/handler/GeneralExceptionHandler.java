package com.crmapp.core.handler;

import com.crmapp.Constants;
import com.crmapp.core.response.dto.BaseResponseDto;
import com.crmapp.core.response.dto.ValidationErrorDto;
import lombok.RequiredArgsConstructor;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
@RequiredArgsConstructor
public class GeneralExceptionHandler extends ResponseEntityExceptionHandler {

    private final MessageSourceAccessor messages;

    @ExceptionHandler(RuntimeException.class)
    protected ResponseEntity<Object> handleRuntimeException(RuntimeException exception, WebRequest request) {
        BaseResponseDto<String> responseBody = BaseResponseDto.<String>builder()
            .data("")
            .message(exception.getMessage())
            .success(false)
            .statusCode(HttpStatus.BAD_REQUEST.value())
            .build();

        return handleExceptionInternal(exception, responseBody, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(SQLException.class)
    protected ResponseEntity<Object> handleSQLException(SQLException exception, WebRequest request) {
        BaseResponseDto<String> responseBody = BaseResponseDto.<String>builder()
            .data("")
            .message(exception.getMessage())
            .success(false)
            .statusCode(HttpStatus.BAD_REQUEST.value())
            .build();

        return handleExceptionInternal(exception, responseBody, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception,
                                                               HttpHeaders headers,
                                                               HttpStatusCode status,
                                                               WebRequest request) {
        Map<String, String> fieldValidationErrors = new HashMap<>();
        List<String> generalValidationErrors = new ArrayList<>();

        exception.getBindingResult().getAllErrors()
            .forEach(error -> {
                if (error instanceof FieldError) {
                    String fieldName = ((FieldError) error).getField();
                    String errorMessage = error.getDefaultMessage();
                    fieldValidationErrors.put(fieldName, errorMessage);
                } else {
                    generalValidationErrors.add(error.getDefaultMessage());
                }
            });

        ValidationErrorDto validationErrorDto = new ValidationErrorDto(fieldValidationErrors, generalValidationErrors);

        BaseResponseDto<ValidationErrorDto> responseBody = BaseResponseDto.<ValidationErrorDto>builder()
            .data(validationErrorDto)
            .statusCode(HttpStatus.BAD_REQUEST.value())
            .success(false)
            .message(messages.getMessage(Constants.MessageConstants.BEAN_VALIDATION_FAIL))
            .build();

        return handleExceptionInternal(exception, responseBody, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

}
