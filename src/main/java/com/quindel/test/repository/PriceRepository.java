package com.quindel.test.repository;

import com.quindel.test.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;

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
     * @param endDate A end date {@link LocalDateTime}.
     * @param productId A product id {@link int}
     * @param brandId A brand id {@link Long}
     * @return A List of type {@link Price}.
     */
    Optional<List<Price>> findAllByStartDateLessThanEqualAndEndDateGreaterThanEqualAndProductIdAndBrandId(
            LocalDateTime startDate, LocalDateTime endDate, int productId, Long brandId
    );

}