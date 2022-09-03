package ar.com.pablocaamano.prices.service;

import ar.com.pablocaamano.prices.model.dto.PriceDTO;

import java.time.LocalDateTime;

public interface PriceService {

    /**
     * Find product price in database filtering by productId, brandId and a date that matches the product's date range.
     * In case of multiple results, the price with the highest priority is returned.
     * @param productId (Long)
     * @param brandId (Long)
     * @param date (LocalDateTime)
     * @return PriceDTO
     */
    PriceDTO getPrice(final Long productId, final Long brandId, final LocalDateTime date);
}
