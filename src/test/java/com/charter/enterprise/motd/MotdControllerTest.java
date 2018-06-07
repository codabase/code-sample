package com.charter.enterprise.motd;

import com.charter.enterprise.motd.repository.MotdRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.regex.Matcher;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MotdControllerTest {

    @Autowired
    private WebApplicationContext context;
    private MockMvc mockMvc;

    @InjectMocks
    private Motd motd;


    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }
    @Test
    public void getMotd() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Welcome to Charter.  All systems are nominal.")));
    }

    @Test
    public void motd() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/motds"))
                .andExpect(status().isOk())
                .andExpect(content().string(Matcher.quoteReplacement("[{\"id\":1,\"msg\":\"Message for day one\"},{\"id\":2,\"msg\":\"The second day message\"}]")));
                //.andExpect(content().string(Matcher.quoteReplacement("The second day message")));
              //  .andExpect(content().string(equalTo("[{\"id\":1,\"msg\":\"Msg of the Day one\"},{\"id\":2,\"msg\":\"Msg of the Day two\"}")));
    }

    @Test
    public void delete() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/motds/1"))
                .andExpect(status().isOk());
        mockMvc.perform(MockMvcRequestBuilders.get("/motds/1"))
                .andExpect(status().isNotFound());
    }


}
