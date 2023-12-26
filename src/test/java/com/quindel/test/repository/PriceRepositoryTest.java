package com.quindel.test.repository;

import com.quindel.test.model.Price;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class PriceRepositoryTest {

    @Autowired
    PriceRepository priceRepository;


    @Test
    void givenStartDateAndEndDateAndProductIdAndBrandIdWhenFindByParametersThenReturnList() {
        LocalDateTime applyDate = LocalDateTime.of(2020, 6, 19, 23, 12, 14);

        final Optional<List<Price>> result = priceRepository.findAllBy(
                applyDate, applyDate, 35455, 1L,
        100);

        assertThat(result.get()).isNotNull();
        assertThat(result.get()).isNotEmpty();
    }
}