package io.demo.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    /*
    private List<Topic> topics = new ArrayList<>(Arrays.asList(
            new Topic("spring", "spring framework", "spring framework description"),
            new Topic("java", "core java", "Core java description"),
            new Topic("python", "python3", "python description")
    ));
    */

    public List<Topic> getAllTopics()
    {
        //return topics;

        //return (List<Topic>) topicRepository.findAll();

        //another way
        List<Topic> topics = new ArrayList<>();
        topicRepository.findAll()
                .forEach(topics::add);
        return topics;
    }

    public Optional<Topic> getTopic(String id)
    {
        //return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
        return topicRepository.findById(id);
    }

    public List<Topic> getTopicByName(String name)
    {
        return topicRepository.findByNameContaining(name);
    }
    public void addTopic(Topic topic)
    {
        //topics.add(topic);
        topicRepository.save(topic);
    }

    public void updateTopic(String id, Topic topic)
    {
       // for(int i = 0; i < topics.size(); i++)
       // {
       //     Topic t = topics.get(i);
       //     if (t.getId().equals(id))
       //     {
       //         topics.set(i, topic);
       //         return;
       //     }
       // }

        // save will automatically update the data with id or if not present, a new topic will be created.
        topicRepository.save(topic);
    }

    public void deleteTopic(String id)
    {
        //topics.removeIf(t -> t.getId().equals(id));
        topicRepository.deleteById(id);
    }


}
