package com.quindel.test.controller;

import com.quindel.test.service.PriceService;
import com.quindel.test.utils.UtilTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PriceController.class)
class PriceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PriceService priceService;

    @Test
    void whenGetPricesThenReturnResponse() throws Exception {
        var requestService = UtilTest.buildPriceRequestDTO("2020-06-14T00:00:00");
        var responseService = UtilTest.buildPriceResponseDTOList();

        when(priceService.getProductPrice(any()))
                .thenReturn(responseService);

        ResultActions perform = mockMvc.perform(MockMvcRequestBuilders.get("/price")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .param("productId", String.valueOf(requestService.getProductId()))
                .param("brandId", String.valueOf(requestService.getBrandId()))
                .param("applyDate", requestService.getApplyDate().toString()));

        perform.andExpect(status().isOk()).andDo(MockMvcResultHandlers.print())
                .andExpect(jsonPath("$[0].price").value(responseService.get(0).getPrice()))
                .andExpect(jsonPath("$[0].priceList").value(responseService.get(0).getPriceList()))
                .andExpect(jsonPath("$[0].brandId").value(responseService.get(0).getBrandId()))
                .andExpect(jsonPath("$[0].startDate").exists())
                .andExpect(jsonPath("$[0].endDate").exists());
    }
}