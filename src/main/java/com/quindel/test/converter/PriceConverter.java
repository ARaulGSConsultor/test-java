package com.quindel.test.converter;

import com.quindel.test.dto.PriceResponseDTO;
import com.quindel.test.model.Price;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * Mapper class that using mapstruct for generate implementation of mapping to convert object.
 */
@Mapper
public interface PriceConverter {

    /***
     * Attribute than generate instance by composite.
     */
    PriceConverter INSTANCE = Mappers.getMapper(PriceConverter.class);

    /**
     * Method that convert a entity to response entity.
     *
     * @param price a price entity {@link Price}
     * @return A Price DTO Response {@link PriceResponseDTO}
     */
    @Mapping(target = "brandId", source = "brand.id")
    PriceResponseDTO convertPriceResponseDTO(Price price);

}