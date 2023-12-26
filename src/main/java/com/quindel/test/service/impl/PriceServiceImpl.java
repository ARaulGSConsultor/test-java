package com.quindel.test.service.impl;

import com.quindel.test.converter.PriceConverter;
import com.quindel.test.dto.PriceRequestDTO;
import com.quindel.test.dto.PriceResponseDTO;
import com.quindel.test.repository.PriceRepository;
import com.quindel.test.service.PriceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

/**
 * Service class that implement the functionality the query prices by filters.
 */
@Service
@RequiredArgsConstructor
public class PriceServiceImpl implements PriceService {

    /**
     * Injection price repository bean by constructor.
     */
    private final PriceRepository priceRepository;

    /**
     *
     */
    private final static int DEFAULT_LIMIT = 100;
    /**
     * Method that query to database with some parameters and return the result in an Object TDO.
     *
     * @param priceRequestDTO A price request DTO {@link PriceRequestDTO}.
     * @return A List of type {@link PriceResponseDTO}.
     */
    @Override
    public List<PriceResponseDTO> getProductPrice(PriceRequestDTO priceRequestDTO) {

        return priceRepository.findAllBy(
                        priceRequestDTO.getApplyDate(), priceRequestDTO.getApplyDate(),
                        priceRequestDTO.getProductId(), priceRequestDTO.getBrandId(),
                        Optional.of(priceRequestDTO.getLimit()).filter(limit -> limit > 0).orElse(DEFAULT_LIMIT)
                ).orElse(emptyList())
                .stream()
                .map(PriceConverter.INSTANCE::convertPriceResponseDTO)
                .collect(Collectors.toList());
    }

}