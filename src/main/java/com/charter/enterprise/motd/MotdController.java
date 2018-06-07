package com.charter.enterprise.motd;

import com.charter.enterprise.motd.repository.MessageOfTheDay;
import com.charter.enterprise.motd.repository.MotdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/")
@RestController
public class MotdController {

    @Autowired
    private MotdRepository motdRepository;

    @GetMapping
    public String getMotd() {
        return "Welcome to Charter.  All systems are nominal.";
    }

    @GetMapping("/motds/{id}")
    public MessageOfTheDay findById(@PathVariable Long id) {
        return motdRepository.findOne(id);
    }


    @GetMapping("/motds")
    public Iterable<MessageOfTheDay>  findAll() {
        return motdRepository.findAll();
    }

    private MessageOfTheDay findMsg(String msg) {
        Iterable<MessageOfTheDay> messages = motdRepository.findAll();
        MessageOfTheDay msgFoud = null;
        for (MessageOfTheDay msgd : messages) {
            if (msgd.getMsg().equals(msg)) {
                msgFoud = msgd;
                break;
            }
        }
        return msgFoud;
    }


    @PostMapping("/motds")
    public HttpStatus addMsgOfTheDay(@RequestBody String message) {
        if (message==null||message.trim().isEmpty())
        {
            return HttpStatus.BAD_REQUEST;
        }
        MessageOfTheDay msgFound = findMsg(message);
        if (msgFound == null) {
            motdRepository.save(new MessageOfTheDay(message));
            return HttpStatus.OK;
        } else {
            return HttpStatus.FOUND;
        }
    }

    @PutMapping("/motd/{id}")
    public HttpStatus updateMsg(@PathVariable Long id, @RequestBody String message) {
        if (message==null||message.trim().isEmpty())
        {
            return HttpStatus.BAD_REQUEST;
        }
        MessageOfTheDay messageOfTheDay = motdRepository.findOne(id);
        if (messageOfTheDay == null) {
            return HttpStatus.NOT_FOUND;
        } else {
            messageOfTheDay.setMsg(message);
            motdRepository.save(messageOfTheDay);
            return HttpStatus.OK;
        }
    }

    @PutMapping("/motd")
    public HttpStatus updateMsg(@RequestBody MessageOfTheDay msgOfTheDay) {
        if (msgOfTheDay==null||msgOfTheDay.getMsg().trim().isEmpty())
        {
            return HttpStatus.BAD_REQUEST;
        }
        if (motdRepository.exists(msgOfTheDay.getId())) {
            motdRepository.save(msgOfTheDay);
            return HttpStatus.OK;
        } else {
            return HttpStatus.NOT_FOUND;
        }
    }

    @DeleteMapping("/motds/{id}")
    public HttpStatus deleteMsg(@PathVariable Long id) {
        if (motdRepository.exists(id)) {
            motdRepository.delete(id);
            return HttpStatus.OK;
        } else {
            return HttpStatus.NOT_FOUND;
        }
    }

    @DeleteMapping("/motds")
    public HttpStatus deleteAllMsg() {
        motdRepository.deleteAll();
        return HttpStatus.OK;
    }
}
