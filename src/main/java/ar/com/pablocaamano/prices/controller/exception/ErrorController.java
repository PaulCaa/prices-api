package ar.com.pablocaamano.prices.controller.exception;

import ar.com.pablocaamano.prices.exception.PriceServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

@ControllerAdvice
@Slf4j
public class ErrorController {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<HttpStatus> handleGeneralException(Exception exception) {
        log.error(exception.getMessage(), exception);
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(PriceServiceException.class)
    public ResponseEntity<Object> handleServiceException(PriceServiceException exception) {
        log.error(exception.getMessage(), exception);
        return new ResponseEntity<>(Map.of("message", exception.getMessage()),
                exception.getHttpStatus());
    }
}
