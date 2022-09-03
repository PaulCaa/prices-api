package ar.com.pablocaamano.prices.service;

import ar.com.pablocaamano.prices.model.dto.PriceDTO;

import java.time.LocalDateTime;

public interface PriceService {

    PriceDTO getPrice(final Long productId, final Long brandId, final LocalDateTime date);
}
