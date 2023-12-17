package com.quindel.test.controller;

import com.quindel.test.dto.PriceRequestDTO;
import com.quindel.test.dto.PriceResponseDTO;
import com.quindel.test.service.PriceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * Controller class that exposes the resource of microservice of functionality prices.
 */
@RestController
@RequestMapping("/price")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PriceController {

    /**
     * Injection price service by constructor.
     */
    private final PriceService priceService;

    /**
     * Method that exposes the endpoint to consult product prices through a filter.
     *
     * @param applyDate
     * @param productId
     * @param brandId
     * @return A {@link ResponseEntity} of type {@link List}<{@link PriceResponseDTO}>.
     */
    @Operation(summary = "API that get prices of ZARA", description = "API that get prices of ZARA")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation.",
            content = @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = PriceResponseDTO.class)))
    })
    @GetMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PriceResponseDTO>> get(
            @RequestParam("applyDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime applyDate,
            @RequestParam("productId") Integer productId,
            @RequestParam("brandId") Long brandId
            ) {
        final var response = priceService.getProductPrice(PriceRequestDTO.builder()
                        .applyDate(applyDate)
                        .brandId(brandId)
                        .productId(productId)
                .build());

        return ResponseEntity.ok(response);
    }

}