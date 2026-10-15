package com.example.Point.of.sale;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class HelloApiTest {
  @Autowired MockMvc mvc;

  @Test
  void homeResponds() throws Exception {
    mvc.perform(get("/"))
        .andExpect(status().isOk())
        .andExpect(content().string("Hello from spring boot application :)"));
  }

  @Test
  void usersRespond() throws Exception {
    mvc.perform(get("/user")).andExpect(status().isOk()).andExpect(content().string("Users"));
  }

  @Test
  void presentationResponds() throws Exception {
    mvc.perform(get("/presentation"))
        .andExpect(status().isOk())
        .andExpect(content().string("presentation"));
  }
}
