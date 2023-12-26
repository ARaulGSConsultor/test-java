package com.quindel.test.integration;

import com.quindel.test.utils.UtilTest;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class PriceControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    private static final String HOUR_10_DAY_14 = "2020-06-14T10:00:00";

    private static final String HOUR_16_DAY_14 = "2020-06-14T16:00:00";

    private static final String HOUR_21_DAY_14 = "2020-06-14T21:00:00";

    private static final String HOUR_10_DAY_15 = "2020-06-15T10:00:00";

    private static final String HOUR_21_DAY_16 = "2020-06-16T21:00:00";

    static Stream<Arguments> givenDateTimeWhenGetPricesThenReturnList() {
        return Stream.of(
                Arguments.of(HOUR_10_DAY_14, List.of(35.50D), List.of(1), 1),
                Arguments.of(HOUR_16_DAY_14, List.of(35.50, 25.45), List.of(1, 2), 2),
                Arguments.of(HOUR_21_DAY_14, List.of(35.50), List.of(1), 1),
                Arguments.of(HOUR_10_DAY_15, List.of(35.50, 30.50), List.of(1, 3), 2),
                Arguments.of(HOUR_21_DAY_16, List.of(35.50, 38.95), List.of(1, 4), 2)
        );
    }

    @ParameterizedTest
    @MethodSource
    void givenDateTimeWhenGetPricesThenReturnList(
            String dateTime,
            List<Double> prices,
            List<Integer> priceList,
            int sizeCollection) throws Exception {
        var requestService = UtilTest.buildPriceRequestDTO(dateTime);

        ResultActions perform = mockMvc.perform(MockMvcRequestBuilders.get("/price")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .param("productId", String.valueOf(requestService.getProductId()))
                .param("brandId", String.valueOf(requestService.getBrandId()))
                .param("applyDate", requestService.getApplyDate().toString()));

        perform.andExpect(status().isOk()).andDo(MockMvcResultHandlers.print())
                .andExpect(jsonPath("$").exists())
                .andExpect(jsonPath("$").isNotEmpty())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$", hasSize(sizeCollection)));

        IntStream.range(0, sizeCollection).forEach(index -> {
            try {
                perform.andExpect(jsonPath("$[" + index + "].price").value(prices.get(index)))
                        .andExpect(jsonPath("$[" + index + "].priceList").value(priceList.get(index)))
                        .andExpect(jsonPath("$[" + index + "].brandId").value(1))
                        .andExpect(jsonPath("$[" + index + "].startDate").exists())
                        .andExpect(jsonPath("$[" + index + "].endDate").exists());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

    }

}