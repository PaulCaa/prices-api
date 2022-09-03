package ar.com.pablocaamano.prices.repository;

import ar.com.pablocaamano.prices.model.dao.Price;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PriceRepository extends CrudRepository<Price,Long> {

    List<Price> findPriceByProductIdAndBrandId(Long productId, Long brandId);
}
