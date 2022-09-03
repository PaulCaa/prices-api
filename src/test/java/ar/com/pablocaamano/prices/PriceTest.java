package ar.com.pablocaamano.prices;

import ar.com.pablocaamano.prices.controller.PriceController;
import ar.com.pablocaamano.prices.model.dto.PriceDTO;
import ar.com.pablocaamano.prices.service.PriceService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@ActiveProfiles("test")
@WebMvcTest(controllers = PriceController.class)
class PriceTest {

    private static final String BASE_URL = "/v1/api/prices";

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testPrice1() throws Exception {
        var result = this.mvc.perform(get(BASE_URL + "/product/35455/brand/1/date/2020-06-14-10:00:00")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        var dto = objectMapper.readValue(result.getResponse().getContentAsString(), PriceDTO.class);
        Assertions.assertEquals(35.50, dto.getPriceFinal().floatValue());
    }

    @Test
    void testPrice2() throws Exception {
        var result = this.mvc.perform(get(BASE_URL + "/product/35455/brand/1/date/2020-06-14-16:00:00")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        var dto = objectMapper.readValue(result.getResponse().getContentAsString(), PriceDTO.class);
        Assertions.assertEquals(25.45, dto.getPriceFinal().floatValue());
    }

    @Test
    void testPrice3() throws Exception {
        var result = this.mvc.perform(get(BASE_URL + "/product/35455/brand/1/date/2020-06-14-21:00:00")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        var dto = objectMapper.readValue(result.getResponse().getContentAsString(), PriceDTO.class);
        Assertions.assertEquals(35.50, dto.getPriceFinal().floatValue());
    }

    @Test
    void testPrice4() throws Exception {
        var result = this.mvc.perform(get(BASE_URL + "/product/35455/brand/1/date/2020-06-15-10:00:00")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        var dto = objectMapper.readValue(result.getResponse().getContentAsString(), PriceDTO.class);
        Assertions.assertEquals(30.5, dto.getPriceFinal().floatValue());
    }

    @Test
    void testPrice5() throws Exception {
        var result = this.mvc.perform(get(BASE_URL + "/product/35455/brand/1/date/2020-06-16-21:00:00")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        var dto = objectMapper.readValue(result.getResponse().getContentAsString(), PriceDTO.class);
        Assertions.assertEquals(38.95, dto.getPriceFinal().floatValue());
    }
}
