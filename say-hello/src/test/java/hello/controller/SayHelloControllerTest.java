package hello.controller;

import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static hello.controller.SayHelloController.GREETINGS;
import static org.hamcrest.Matchers.in;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class SayHelloControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    @DisplayName("Must access home endpoint")
    @SneakyThrows
    void homeEndpoint() {
        mvc.perform(get("/")).andExpect(status().isOk());
    }

    @Test
    @DisplayName("Must access greeting endpoint")
    @SneakyThrows
    void greetingEndpoint() {
        mvc.perform(get("/greeting"))
                .andExpect(status().isOk())
                .andExpect(content().string(in(GREETINGS)));
    }
}