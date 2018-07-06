package com.krishnamg.app.controllers;

import com.krishnamg.app.dtos.Topic;
import com.krishnamg.app.service.HelloService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by krishnamg on 4/8/17.
 */
@RestController
public class HelloController {

    @Autowired
    HelloService helloService;

    @RequestMapping(value="/topics", method = RequestMethod.GET)
    public List<Topic> getAllTopics(){
        return helloService.getAllTopics();
    }

    @RequestMapping(value="/topics/{id}", method = RequestMethod.GET)
    public Topic getTopicById(@PathVariable String id){
        return helloService.getTopicById(id);
    }

    @RequestMapping(value="/topics", method = RequestMethod.POST)
    public Topic addTopic(@RequestBody Topic topic){
        return helloService.addTopic(topic);
    }

    @RequestMapping(value="/topics/{id}", method = RequestMethod.PUT)
    public Topic updateTopic(@RequestBody Topic topic, @PathVariable String id){
        return helloService.updateTopic(topic, id);
    }

    @RequestMapping(value="/topics/{id}", method = RequestMethod.DELETE)
    public String deleteTopic(@PathVariable String id){
        return helloService.deleteTopic(id);
    }

}
