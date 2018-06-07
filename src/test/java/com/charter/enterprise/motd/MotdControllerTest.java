package com.charter.enterprise.motd;

import com.charter.enterprise.motd.repository.MessageOfTheDay;
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

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

import static junit.framework.TestCase.assertTrue;
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

    @Autowired
    private MotdRepository motdRepository;

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
    public void findAll() throws Exception {
        motdRepository.deleteAll();
        motdRepository.save(new MessageOfTheDay("Msg 1"));
        motdRepository.save(new MessageOfTheDay("Msg 2"));
        Iterable<MessageOfTheDay> msgs = motdRepository.findAll();
        for (MessageOfTheDay msg:
        msgs) {
            assertTrue(msg.getMsg().matches("Msg \\d"));
        }
    }

    @Test
    public void delete() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/motds")) // delete all
                .andExpect(status().isOk());
        motdRepository.save(new MessageOfTheDay("Here we are!"));
        mockMvc.perform(MockMvcRequestBuilders.delete("/motds/1"))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteAll() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/motds"))
                .andExpect(status().isOk());
        mockMvc.perform(MockMvcRequestBuilders.get("/motds"))
                .andExpect(status().isOk())
                .andExpect(content().string(Matcher.quoteReplacement("[]")));
    }

    @Test
    public void testAdd()
    {
        motdRepository.deleteAll();
        motdRepository.save(new MessageOfTheDay("Here we are!"));

    }



}
