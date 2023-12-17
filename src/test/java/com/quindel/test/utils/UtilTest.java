package com.quindel.test.utils;

import com.quindel.test.dto.PriceRequestDTO;
import com.quindel.test.dto.PriceResponseDTO;
import com.quindel.test.model.Brand;
import com.quindel.test.model.Price;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

public class UtilTest {

    public final static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

    public static List<Price> buildPriceList() {
        return Arrays.asList(Price.builder()
                .startDate(LocalDateTime.of(2020, 6, 14, 0, 0, 0))
                .endDate(LocalDateTime.of(2020, 12, 31, 23, 59, 29))
                .price(20.80)
                .priceList(1)
                .id(1L)
                .curr("EUR")
                .brand(Brand.builder()
                        .id(1)
                        .store("ZARA")
                        .build())
                .build());
    }

    public static PriceRequestDTO buildPriceRequestDTO(String dateTime) {
        return PriceRequestDTO.builder()
                .applyDate(LocalDateTime.parse(dateTime, formatter))
                .productId(35455)
                .brandId(1L)
                .build();
    }

    public static List<PriceResponseDTO> buildPriceResponseDTOList() {
        LocalDateTime localDateTime = LocalDateTime.now();

        return Arrays.asList(PriceResponseDTO.builder()
                .price(20.80)
                .priceList(1)
                .brandId(1L)
                .startDate(LocalDateTime.of(localDateTime.getYear(), localDateTime.getMonthValue(),
                        localDateTime.getDayOfMonth(), localDateTime.getHour(), localDateTime.getMinute(), localDateTime.getSecond()))
                .endDate(LocalDateTime.of(localDateTime.getYear(), localDateTime.getMonthValue(),
                        localDateTime.getDayOfMonth(), localDateTime.getHour(), localDateTime.getMinute(), localDateTime.getSecond()))
                .build());
    }
}