package com.quindel.test.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * DTO class used for reponse of API.
 */
@Getter
@Setter
@Builder
public class PriceResponseDTO {


    /**
     * Attribute product id
      */
    private int productId;

    /**
     * Attribute brand id.
     */
    private Long brandId;

    /**
     * Attribute price list.
     */
    private int priceList;

    /**
     * Attribute start date.
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime startDate;

    /**
     * Attribute end date.
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime endDate;

    /**
     * Attribute price.
     */
    private Double price;
}