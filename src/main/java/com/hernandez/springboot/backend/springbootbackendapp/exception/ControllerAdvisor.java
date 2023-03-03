package com.hernandez.springboot.backend.springbootbackendapp.exception;


import com.hernandez.springboot.backend.springbootbackendapp.utils.ApplicationConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
@Slf4j
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

    @ExceptionHandler(DataAccessException.class)
    public ResponseEntity<Map<String, Object>> handleDaoException(DataAccessException exception) {
        Map<String, Object> errorResponse = new HashMap<>();
        log.error("Exception occurred {}, in {}", exception.getMessage(), exception.getStackTrace()[0].getMethodName());
        errorResponse = buildErrorResponse(ApplicationConstants.ERROR_MESSAGE, exception.getMessage());
        return ResponseEntity.internalServerError().body(errorResponse);
    }

    protected Map<String, Object> buildErrorResponse(String message, String errorMessage) {
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put(ApplicationConstants.MENSAJE, message);
        errorResponse.put(ApplicationConstants.ERROR_MESSAGE, errorMessage);
        errorResponse.put("DateTime: ", LocalDateTime.now());
        return errorResponse;
    }

}