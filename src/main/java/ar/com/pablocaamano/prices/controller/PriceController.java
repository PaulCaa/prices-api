package ar.com.pablocaamano.prices.controller;

import ar.com.pablocaamano.prices.model.dto.PriceDTO;
import ar.com.pablocaamano.prices.service.PriceService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping(value = "/v1/api/prices")
public class PriceController {

    private final PriceService priceService;

    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    @GetMapping(value = "/product/{productId}/brand/{brandId}/date/{date}")
    public PriceDTO getProductData(@PathVariable final Long productId,
                                   @PathVariable final Long brandId,
                                   @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd-HH:mm:ss") final LocalDateTime date) {
        return this.priceService.getPrice(productId, brandId, date);
    }
}
