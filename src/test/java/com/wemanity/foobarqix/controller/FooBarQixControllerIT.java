package com.wemanity.foobarqix.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wemanity.foobarqix.model.Result;
import com.wemanity.foobarqix.service.impl.FooBarQixService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * The type Foo bar qix controller it.
 */
@AutoConfigureMockMvc
@ContextConfiguration(classes = {FooBarQixController.class, FooBarQixService.class})
@WebMvcTest
public class FooBarQixControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;


    /**
     * Test computing.
     *
     * @throws Exception the exception
     */
    @Test
    public void testComputing() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/compute?value=5")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        String resultantResponse = result.getResponse().getContentAsString();
        assertNotNull(resultantResponse);
        Result resultant = objectMapper.readValue(resultantResponse, Result.class);
        assertEquals("BarBar", resultant.getResult());
    }

}
