package com.quindel.test.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * DTO Class for set parameters from API
 */
@Setter
@Getter
@Builder
public class PriceRequestDTO {

    /**
     * Attribute apply date.
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime applyDate;

    /**
     * Attribute product id.
     */
    private int productId;

    /**
     * Attribute brand id.
     */
    private Long brandId;

    /**
     * Attribute that indicate limit response rows.
     */
    private int limit;
}