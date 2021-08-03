package com.wemanity.foobarqix.exception;

import com.wemanity.foobarqix.model.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

/**
 * The type Global exception handler.
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handle invalid bidder exception response entity.
     *
     * @param ex      the ex
     * @param request the request
     * @return the response entity
     */
    @ExceptionHandler(InvalidNumberException.class)
    public final ResponseEntity<Object> handleInvalidBidderException(Exception ex, WebRequest request) {
        log.error("InvalidNumberException Occurred in  Auction  API : {}", ex.getMessage(), ex);

        ErrorResponse errorResponse = ErrorResponse.builder()
                .status(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .message(ex.getMessage()).build();

        return ResponseEntity.badRequest().body(errorResponse);
    }
}
