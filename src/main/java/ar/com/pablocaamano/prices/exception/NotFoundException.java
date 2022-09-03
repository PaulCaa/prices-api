package ar.com.pablocaamano.prices.exception;

import org.springframework.http.HttpStatus;

public class NotFoundException extends PriceServiceException {

    private static final long serialVersionUID = -7661834633469254376L;

    public NotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
