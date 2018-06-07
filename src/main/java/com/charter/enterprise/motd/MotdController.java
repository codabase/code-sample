package com.charter.enterprise.motd;

import com.charter.enterprise.motd.repository.MessageOfTheDay;
import com.charter.enterprise.motd.repository.MotdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/")
@RestController
public class MotdController {

    @GetMapping
    public String getMotd() {
        return "Welcome to Charter.  All systems are nominal.";
    }

    private MotdRepository motdRepository;


    @GetMapping("/motds/{id}")
    public MessageOfTheDay getMotd(@PathVariable Long id){
        return motdRepository.findOne(id);
    }


    @GetMapping("/motds")
    public Iterable<MessageOfTheDay> getMotds(){
        return motdRepository.findAll();
    }

    private MessageOfTheDay findByMsg(String msg)
    {
        Iterable<MessageOfTheDay> messages = motdRepository.findAll();
        MessageOfTheDay msgFoud = null;
        for (MessageOfTheDay msgd:messages)
        {
            if (msgd.getMsg().equals(msg)) {
                msgFoud = msgd;
                break;
            }
        }
        return msgFoud;
    }


    @PostMapping("/motds")
    public HttpStatus addMember(@RequestBody String message) {
        MessageOfTheDay msgFound = findByMsg(message);
        if (msgFound==null) {
            motdRepository.save(new MessageOfTheDay(message));
            return HttpStatus.OK;
        } else
        {
            return HttpStatus.FOUND;
        }
    }

    @PutMapping("/motd/{id}")
    public HttpStatus updateStringMotd(@PathVariable Long id, @RequestBody String msg){
        MessageOfTheDay messageOfTheDay = motdRepository.findOne(id);
        if (messageOfTheDay==null) {
            return HttpStatus.NOT_FOUND;
        } else
        {
            messageOfTheDay.setMsg(msg);
            motdRepository.save(messageOfTheDay);
            return HttpStatus.OK;
        }
    }

    @PutMapping("/motd")
    public HttpStatus updateMotd(@RequestBody MessageOfTheDay msgOfTheDay){
        if (motdRepository.exists(msgOfTheDay.getId()))
        {
            motdRepository.save(msgOfTheDay);
            return HttpStatus.OK;
        } else
        {
            return HttpStatus.NOT_FOUND;
        }
    }

    @DeleteMapping("/motd/{id}")
    public HttpStatus deleteMotd(@PathVariable Long id){
        if (motdRepository.exists(id))
        {
            motdRepository.delete(id);
            return HttpStatus.OK;
        } else
        {
            return HttpStatus.NOT_FOUND;
        }
    }
}
