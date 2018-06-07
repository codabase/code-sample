package com.charter.enterprise.motd;


import com.charter.enterprise.motd.repository.MessageOfTheDay;
import com.charter.enterprise.motd.repository.MotdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Motd {

    public static void main(String[] args) {
        SpringApplication.run(Motd.class, args);
    }

    private MotdRepository modtsRepository;


    @PostConstruct
    public void init() {
        List<MessageOfTheDay> motdsList = new ArrayList<>();
        motdsList.add(new MessageOfTheDay("Message for day one"));
        motdsList.add(new MessageOfTheDay("The second day message"));
        modtsRepository.save(motdsList);
    }
}

