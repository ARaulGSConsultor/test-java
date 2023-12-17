package com.quindel.test.integration;

import com.quindel.test.utils.UtilTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class PriceControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void givenHour10Day14whenGetPricesThenReturnList() throws Exception {
        var requestService = UtilTest.buildPriceRequestDTO("2020-06-14T10:00:00");

        ResultActions perform = mockMvc.perform(MockMvcRequestBuilders.get("/price")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .param("productId", String.valueOf(requestService.getProductId()))
                .param("brandId", String.valueOf(requestService.getBrandId()))
                .param("applyDate", requestService.getApplyDate().toString()));

        perform.andExpect(status().isOk()).andDo(MockMvcResultHandlers.print())
                .andExpect(jsonPath("$").exists())
                .andExpect(jsonPath("$").isNotEmpty())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0].price").value(35.50))
                .andExpect(jsonPath("$[0].priceList").value(1))
                .andExpect(jsonPath("$[0].brandId").value(1))
                .andExpect(jsonPath("$[0].startDate").exists())
                .andExpect(jsonPath("$[0].endDate").exists());
    }

    @Test
    void givenHour16Day14whenGetPricesThenReturnList() throws Exception {
        var requestService = UtilTest.buildPriceRequestDTO("2020-06-14T16:00:00");

        ResultActions perform = mockMvc.perform(MockMvcRequestBuilders.get("/price")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .param("productId", String.valueOf(requestService.getProductId()))
                .param("brandId", String.valueOf(requestService.getBrandId()))
                .param("applyDate", requestService.getApplyDate().toString()));

        perform.andExpect(status().isOk()).andDo(MockMvcResultHandlers.print())
                .andExpect(jsonPath("$").exists())
                .andExpect(jsonPath("$").isNotEmpty())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0].price").value(35.50))
                .andExpect(jsonPath("$[0].priceList").value(1))
                .andExpect(jsonPath("$[0].brandId").value(1))
                .andExpect(jsonPath("$[0].startDate").exists())
                .andExpect(jsonPath("$[0].endDate").exists())
                .andExpect(jsonPath("$[1].price").value(25.45))
                .andExpect(jsonPath("$[1].priceList").value(2))
                .andExpect(jsonPath("$[1].brandId").value(1))
                .andExpect(jsonPath("$[1].startDate").exists())
                .andExpect(jsonPath("$[1].endDate").exists());
    }

    @Test
    void givenHour21Day14whenGetPricesThenReturnList() throws Exception {
        var requestService = UtilTest.buildPriceRequestDTO("2020-06-14T21:00:00");

        ResultActions perform = mockMvc.perform(MockMvcRequestBuilders.get("/price")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .param("productId", String.valueOf(requestService.getProductId()))
                .param("brandId", String.valueOf(requestService.getBrandId()))
                .param("applyDate", requestService.getApplyDate().toString()));

        perform.andExpect(status().isOk()).andDo(MockMvcResultHandlers.print())
                .andExpect(jsonPath("$").exists())
                .andExpect(jsonPath("$").isNotEmpty())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0].price").value(35.50))
                .andExpect(jsonPath("$[0].priceList").value(1))
                .andExpect(jsonPath("$[0].brandId").value(1))
                .andExpect(jsonPath("$[0].startDate").exists())
                .andExpect(jsonPath("$[0].endDate").exists());
    }

    @Test
    void givenHour10Day15whenGetPricesThenReturnList() throws Exception {
        var requestService = UtilTest.buildPriceRequestDTO("2020-06-15T10:00:00");

        ResultActions perform = mockMvc.perform(MockMvcRequestBuilders.get("/price")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .param("productId", String.valueOf(requestService.getProductId()))
                .param("brandId", String.valueOf(requestService.getBrandId()))
                .param("applyDate", requestService.getApplyDate().toString()));

        perform.andExpect(status().isOk()).andDo(MockMvcResultHandlers.print())
                .andExpect(jsonPath("$").exists())
                .andExpect(jsonPath("$").isNotEmpty())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0].price").value(35.50))
                .andExpect(jsonPath("$[0].priceList").value(1))
                .andExpect(jsonPath("$[0].brandId").value(1))
                .andExpect(jsonPath("$[0].startDate").exists())
                .andExpect(jsonPath("$[0].endDate").exists())
                .andExpect(jsonPath("$[1].price").value(30.50))
                .andExpect(jsonPath("$[1].priceList").value(3))
                .andExpect(jsonPath("$[1].brandId").value(1))
                .andExpect(jsonPath("$[1].startDate").exists())
                .andExpect(jsonPath("$[1].endDate").exists());
    }

    @Test
    void givenHour21Day16whenGetPricesThenReturnList() throws Exception {
        var requestService = UtilTest.buildPriceRequestDTO("2020-06-16T21:00:00");

        ResultActions perform = mockMvc.perform(MockMvcRequestBuilders.get("/price")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .param("productId", String.valueOf(requestService.getProductId()))
                .param("brandId", String.valueOf(requestService.getBrandId()))
                .param("applyDate", requestService.getApplyDate().toString()));

        perform.andExpect(status().isOk()).andDo(MockMvcResultHandlers.print())
                .andExpect(jsonPath("$").exists())
                .andExpect(jsonPath("$").isNotEmpty())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0].price").value(35.50))
                .andExpect(jsonPath("$[0].priceList").value(1))
                .andExpect(jsonPath("$[0].brandId").value(1))
                .andExpect(jsonPath("$[0].startDate").exists())
                .andExpect(jsonPath("$[0].endDate").exists())
                .andExpect(jsonPath("$[1].price").value(38.95))
                .andExpect(jsonPath("$[1].priceList").value(4))
                .andExpect(jsonPath("$[1].brandId").value(1))
                .andExpect(jsonPath("$[1].startDate").exists())
                .andExpect(jsonPath("$[1].endDate").exists());
    }
}