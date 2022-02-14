package com.erdata.project;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
@WebMvcTest(ChildrenController.class) 
public class ChildrenControllerTest {
    @Autowired
    private MockMvc mockMvc; 
    @Test
    public void testHomePageHome() throws Exception {
        mockMvc.perform(get("/")) 
            .andExpect(status().isOk()) 
                .andExpect(view().name("home")) 
                    .andExpect(content().string(containsString("Let's all stand together")));
    }
    @Test
    public void testHome() throws Exception {
        mockMvc.perform(get("/newentry")) 
            .andExpect(status().isOk()) 
                .andExpect(view().name("newentry"));
    }
}