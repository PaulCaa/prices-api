package ar.com.pablocaamano.prices.util;

import ar.com.pablocaamano.prices.model.dao.Price;
import ar.com.pablocaamano.prices.model.dto.PriceDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface PriceMapper {

    @Mappings({
            @Mapping(source = "productId", target = "productId"),
            @Mapping(source = "brandId", target = "brandId"),
            @Mapping(source = "priceList", target = "priceList"),
            @Mapping(source = "startDate", target = "startDate"),
            @Mapping(source = "endDate", target = "endDate"),
            @Mapping(source = "price", target = "priceFinal")
    })
    PriceDTO toDTO(Price entity);
}
