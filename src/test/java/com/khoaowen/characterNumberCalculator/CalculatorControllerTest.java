package com.khoaowen.characterNumberCalculator;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(CalculatorController.class)
class CalculatorControllerTest {

  @Autowired
  protected MockMvc mockMvc;

  @Test
  void testEndpointResponse() throws Exception {
    final String aBirthDay = "03/12/2020";
    mockMvc.perform(post("/").content(aBirthDay))
        .andExpect(content().string("1"));
  }

}