package ar.com.pablocaamano.prices.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class PriceServiceException extends RuntimeException {

    private static final long serialVersionUID = 927492036196039844L;
    private final HttpStatus httpStatus;

    public PriceServiceException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public PriceServiceException(String message, Throwable cause, HttpStatus httpStatus) {
        super(message, cause);
        this.httpStatus = httpStatus;
    }
}
