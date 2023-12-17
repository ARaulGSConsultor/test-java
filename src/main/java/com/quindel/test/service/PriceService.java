package com.quindel.test.service;


import com.quindel.test.dto.PriceRequestDTO;
import com.quindel.test.dto.PriceResponseDTO;

import java.util.List;

/**
 * Interface that declared functionality of price service.
 */
public interface PriceService {
    List<PriceResponseDTO> getProductPrice(PriceRequestDTO priceRequestDTO);
}