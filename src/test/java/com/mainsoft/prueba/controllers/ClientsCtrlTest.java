package com.mainsoft.prueba.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.gson.Gson;
import com.mainsoft.prueba.PruebaApplication;
import com.mainsoft.prueba.services.IClientsServ;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.Assert;

import javax.servlet.http.HttpServletResponse;


@WebMvcTest(value = ClientsCtrl.class)
class ClientsCtrlTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IClientsServ iClientsServ;

    @TestConfiguration
    static class TestConfigurationApp {
        @Bean
        ObjectMapper objectMapperPrettyPrinting() {
            return new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        }
    }

    @Test
    void getClients() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/rest/clients")
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        Assert.isTrue(result.getResponse().getStatus()== HttpServletResponse.SC_OK, "Correcto");
    }


    @Test
    void getClient() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/rest/clients/1")
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        Assert.isTrue(result.getResponse().getStatus()== HttpServletResponse.SC_OK, "Correcto");
    }

}