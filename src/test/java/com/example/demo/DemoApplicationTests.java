package com.example.demo;

import com.example.demo.controller.MainController;
import com.example.demo.data.entity.Numerus;
import com.example.demo.data.service.NumerusServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    private WebApplicationContext wac;

    @InjectMocks
    MainController mainController;

    @InjectMocks
    NumerusServiceImpl numerusService;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void testAddNumerus() {

        Calendar calendar = Calendar.getInstance();
        String json = "{" +
                "   \"number\": 23," +
                "   \"insert_date\": \"2010-03-18 12:21:48\"" +
                "}";
        try {
            mockMvc.perform(
                    post("/numerus").contentType(MediaType.APPLICATION_JSON_UTF8).content(json))
                    .andExpect(status().isOk());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testAddNumerusWrongParam() {

        Calendar calendar = Calendar.getInstance();
        String json = "{" +
                "   \"number\": 23," +
                "   \"insert_date\": \"2010-03-18 12:21:48\"" +
                "   \"dummyParam\": \"2010-03-18 12:21:48\"" +
                "}";
        try {
            mockMvc.perform(
                    post("/numerus").contentType(MediaType.APPLICATION_JSON_UTF8).content(json))
                    .andExpect(status().isBadRequest());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetNumerus() {

        try {
            mockMvc.perform(
                    get("/numerus").contentType(MediaType.APPLICATION_JSON_UTF8).param("param", "1"))
                    .andExpect(status().isOk());
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            mockMvc.perform(
                    get("/numerus").contentType(MediaType.APPLICATION_JSON_UTF8).param("param", "ascending"))
                    .andExpect(status().isOk());
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            mockMvc.perform(
                    get("/numerus").contentType(MediaType.APPLICATION_JSON_UTF8).param("param", "descending"))
                    .andExpect(status().isOk());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDeleteNumerus() {

        try {
            mockMvc.perform(
                    delete("/numerus").contentType(MediaType.APPLICATION_JSON_UTF8).param("number", "1"))
                    .andExpect(status().isBadRequest());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
