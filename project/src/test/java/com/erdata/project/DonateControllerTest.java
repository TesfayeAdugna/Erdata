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
@WebMvcTest(donateController.class) 
public class DonateControllerTest {
    @Autowired
    private MockMvc mockMvc; 
    @Test
    public void testdisplaydonate()throws Exception {
        mockMvc.perform(get("/donate")) 
            .andExpect(status().isOk()) 
                .andExpect(view().name("donate")) 
                    .andExpect(content().string(containsString("Thank you for your kindness")));
    }
}