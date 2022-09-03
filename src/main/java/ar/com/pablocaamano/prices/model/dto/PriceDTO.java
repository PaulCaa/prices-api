package ar.com.pablocaamano.prices.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class PriceDTO {

    private Long productId;

    private Long brandId;

    private Long priceList;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private Float priceFinal;
}
