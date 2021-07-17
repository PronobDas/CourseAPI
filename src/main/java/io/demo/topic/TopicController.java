package io.demo.topic;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class TopicController {
    @RequestMapping("/topics")
    public List<Topic> getAllTopics(){
        return Arrays.asList(
                new Topic("spring", "spring framework", "spring framework description"),
                new Topic("java", "core java", "Core java description"),
                new Topic("python", "python3", "python description")
        );
    }
}
