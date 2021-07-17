package io.demo.course;

import io.demo.topic.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CourseController {
    // Will be automatically injected here
    @Autowired
    private CourseService courseService;

    @RequestMapping("/topics/{id}/courses")
    public List<Course> getAllCourses(@PathVariable String id)
    {
        return courseService.getAllCourses(id);
    }

    @RequestMapping("/topics/{topicId}/courses/{id}")
    public Optional<Course> getCourse(@PathVariable String id)
    {
        return courseService.getCourse(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "topics/{topicId}/courses")
    //@PostMapping("/courses") // another way
    public void addCourse(@RequestBody Course course, @PathVariable String topicId)
    {
        course.setTopic(new Topic(topicId, "", ""));
        courseService.addCourse(course);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "topics/{topicId}/courses/{id}")
    public void updateCourse(@PathVariable String id, @RequestBody Course course, @PathVariable String topicId)
    {
        course.setTopic(new Topic(topicId, "", ""));
        courseService.updateCourse(course);
    }

    @DeleteMapping("topics/{topicId}/courses/{id}")
    public void deleteCourse(@PathVariable String id)
    {
        courseService.deleteCourse(id);
    }
}
