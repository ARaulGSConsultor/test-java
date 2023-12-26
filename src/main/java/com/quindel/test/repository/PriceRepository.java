package com.quindel.test.repository;

import com.quindel.test.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * Interface that used for extends the functionality of JPA for operation to DB.
 */
public interface PriceRepository extends JpaRepository<Price, Long> {

    /**
     * Method that query to database for the filter that receive by parameters.
     *
     * @param startDate A start date {@link LocalDateTime}.
     * @param endDate   An end date {@link LocalDateTime}.
     * @param productId A product id {@link int}
     * @param brandId   A brand id {@link Long}
     * @param limit
     * @return A List of type {@link Price}.
     */
    @Query("SELECT price FROM Price price WHERE (:startDate >= price.startDate   AND :endDate <= price.endDate  ) AND "
            + "price.productId = :productId AND price.brand.id = :brandId ORDER BY price.priceList LIMIT :limitPrice")
    Optional<List<Price>> findAllBy(
            @Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate,
            @Param("productId") int productId, @Param("brandId") Long brandId,
            @Param("limitPrice") int limit);

}