package ar.com.pablocaamano.prices.service.impl;

import ar.com.pablocaamano.prices.exception.NotFoundException;
import ar.com.pablocaamano.prices.model.dao.Price;
import ar.com.pablocaamano.prices.model.dto.PriceDTO;
import ar.com.pablocaamano.prices.repository.PriceRepository;
import ar.com.pablocaamano.prices.service.PriceService;
import ar.com.pablocaamano.prices.util.PriceMapper;
import com.sun.istack.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class PriceServiceImpl implements PriceService {

    private final PriceRepository repository;

    private final PriceMapper mapper;

    public PriceServiceImpl(PriceRepository repository, PriceMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public PriceDTO getPrice(@NotNull final Long productId, @NotNull final Long brandId, @NotNull final LocalDateTime date) {
        log.debug("Finding prices with productId '{}' and brandId '{}' valid for date '{}'",productId,brandId,date);
        List<Price> results = this.repository.findPriceByProductIdAndBrandId(productId, brandId);
        Price aux = null;
        for(Price p : results) {
            if(p.getStartDate().isBefore(date) &&
                    p.getEndDate().isAfter(date)){
                aux = (aux == null || p.getPriority() > aux.getPriority()) ? p : aux;
            }
        }
        if(aux == null)
            throw new NotFoundException("Haven't prices for productId '"+productId+"' and brandId '"+brandId+"' valid for date '"+date+"'");
        return this.mapper.toDTO(aux);
    }
}
