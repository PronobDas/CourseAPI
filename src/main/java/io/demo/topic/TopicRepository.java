package io.demo.topic;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TopicRepository extends CrudRepository<Topic, String> {
    Optional<Topic> findByNameContaining(String name);
}
