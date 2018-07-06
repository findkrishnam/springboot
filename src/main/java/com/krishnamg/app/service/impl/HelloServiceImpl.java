package com.krishnamg.app.service.impl;

import com.krishnamg.app.dtos.Topic;
import com.krishnamg.app.service.HelloService;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

/**
 * Created by krishnamg on 5/8/17.
 */
@Transactional
@Service
public class HelloServiceImpl implements HelloService {

    static List<Topic> topics = null;

    static {
        topics = new ArrayList<Topic>() {{
            add(new Topic("0", "Mother of All Topics"));
            add(new Topic("1", "Wild Animals"));
            add(new Topic("2", "Fruits"));
            add(new Topic("3", "Vegetables"));
            add(new Topic("4", "Numbers"));
            add(new Topic("5", "Alphabets"));
        }};
    }

    @Override
    public List<Topic> getAllTopics() {
        return this.topics;
    }

    @Override
    public Topic getTopicById(String id) {
        return topics.get(Integer.parseInt(id));
    }

    @Override
    public Topic addTopic(Topic topic) {
        topics.add(topic);
        return getTopicById(topic.getId());
    }

    @Override
    public Topic updateTopic(Topic topic, String id) {
        Topic topic1 = getTopicById(id);
        topic1.setName(topic.getName());
        topic1.setId(topic1.getId());
        return getTopicById(topic.getId());
    }

    @Override
    public String deleteTopic(String id) {
        topics.remove(Integer.parseInt(id));
        return "topic deleted, "+topics.size()+" topics remaining.";
    }


}
