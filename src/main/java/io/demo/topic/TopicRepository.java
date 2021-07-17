package io.demo.topic;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface TopicRepository extends CrudRepository<Topic, String> {
    List<Topic> findByNameContaining(String name);
}
