package com.krishnamg.app.service;

import com.krishnamg.app.dtos.Topic;
import java.util.List;

/**
 * Created by krishnamg on 5/8/17.
 */

public interface HelloService {

    List<Topic> getAllTopics();

    Topic getTopicById(String id);

    Topic addTopic(Topic topic);

    Topic updateTopic(Topic topic, String id);

    String deleteTopic(String id);

}
