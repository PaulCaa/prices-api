package ar.com.pablocaamano.prices.service;

import ar.com.pablocaamano.prices.exception.NotFoundException;
import ar.com.pablocaamano.prices.model.dao.Price;
import ar.com.pablocaamano.prices.model.dto.PriceDTO;
import ar.com.pablocaamano.prices.repository.PriceRepository;
import ar.com.pablocaamano.prices.service.impl.PriceServiceImpl;
import ar.com.pablocaamano.prices.util.PriceMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class PriceServiceTest {

    @InjectMocks
    private PriceServiceImpl service;

    @Mock
    private PriceRepository repository;

    @Mock
    private PriceMapper mapper;

    @Test
    void getPriceOk() {
        Price p = new Price();
        p.setStartDate(LocalDateTime.of(2020, Month.JUNE,14,0,0));
        p.setEndDate(LocalDateTime.of(2020, Month.DECEMBER,31,23,59));

        PriceDTO dto = new PriceDTO();
        dto.setPriceFinal(35.50f);

        when(this.repository.findPriceByProductIdAndBrandId(any(), any())).thenReturn(List.of(p));
        when(this.mapper.toDTO(p)).thenReturn(dto);

        PriceDTO result = this.service.getPrice(35455L,1L,
                LocalDateTime.of(2020, Month.JUNE,14,10,0));

        Assertions.assertNotNull(result);
        Assertions.assertEquals(35.50, result.getPriceFinal().floatValue());
    }

    @Test
    void getPrinceNotFound() {
        when(this.repository.findPriceByProductIdAndBrandId(any(), any())).thenReturn(Collections.emptyList());

        Assertions.assertThrows(NotFoundException.class, ()-> this.service.getPrice(35455L,1L,
                LocalDateTime.of(2020, Month.JUNE,14,10,0)));
    }
}
