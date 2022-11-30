package com.github.kalininaleksandrv.validation;

import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
class AddressControllerTest {

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new AddressController()).build();
    }

    @Test
    @SneakyThrows
    void newAddress() {
        mockMvc.perform(post("/address")
                        .content("{ \"index\": \"12345\", \"street\":\"Downing\", \"house\":42 }")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.index").value("12345"))
                .andExpect(jsonPath("$.street").value("Downing"))
                .andExpect(jsonPath("$.house").value(42));
    }

    @Test
    @SneakyThrows
    void newAddressEmptyIndex() {
        MvcResult mvcResult = mockMvc.perform(post("/address")
                        .content("{ \"index\": \"\", \"street\":\"Downing\", \"house\":42 }")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andReturn();

        String actualJson = mvcResult.getResponse().getContentAsString();
        assertTrue(actualJson.contains("index can't be empty"));
    }

    @Test
    @SneakyThrows
    void newAddressEmptyStreet() {
        MvcResult mvcResult = mockMvc.perform(post("/address")
                        .content("{ \"index\": \"\", \"street\":\"\", \"house\":42 }")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andReturn();

        String actualJson = mvcResult.getResponse().getContentAsString();
        assertAll("Should return address of Oracle's headquarter",
                () -> assertTrue(actualJson.contains("index can't be empty")),
                () -> assertTrue(actualJson.contains("street can't be empty")));
    }

    @Test
    @SneakyThrows
    void newAddressNumberLessThenMin() {
        MvcResult mvcResult = mockMvc.perform(post("/address")
                        .content("{ \"index\": \"12345\", \"street\":\"Downing\", \"house\":0 }")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andReturn();

        String actualJson = mvcResult.getResponse().getContentAsString();
        assertTrue(actualJson.contains("number can't be less then 1"));
    }

    @Test
    @SneakyThrows
    void newAddressNumberGreaterThenMax() {
        MvcResult mvcResult = mockMvc.perform(post("/address")
                        .content("{ \"index\": \"12345\", \"street\":\"Downing\", \"house\":101 }")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andReturn();

        String actualJson = mvcResult.getResponse().getContentAsString();
        assertTrue(actualJson.contains("number can't be greater then 100"));
    }
}