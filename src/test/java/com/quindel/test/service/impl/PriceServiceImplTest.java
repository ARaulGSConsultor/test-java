package com.quindel.test.service.impl;

import com.quindel.test.dto.PriceResponseDTO;
import com.quindel.test.repository.PriceRepository;
import com.quindel.test.service.PriceService;
import com.quindel.test.utils.UtilTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static com.quindel.test.utils.UtilTest.formatter;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PriceServiceImplTest {

    private PriceService priceService;

    private PriceRepository priceRepository;

    @BeforeEach
    void setUp_BeforeEach() {
        priceRepository = mock(PriceRepository.class);

        priceService = new PriceServiceImpl(priceRepository);
    }

    @Test
    void whenGetProductPriceThenReturnList() {
        LocalDateTime dateTime = LocalDateTime.of(2020,6, 14, 0, 0,0);

        when(priceRepository.findAllByStartDateLessThanEqualAndEndDateGreaterThanEqualAndProductIdAndBrandId(
                dateTime, dateTime, 35455, 1L))
                .thenReturn(Optional.of(UtilTest.buildPriceList()));

        final List<PriceResponseDTO> productPrice = priceService.getProductPrice(UtilTest.buildPriceRequestDTO(dateTime.format(formatter)));

        assertNotNull(productPrice);
        assertTrue(productPrice.size() > 0);
    }

}