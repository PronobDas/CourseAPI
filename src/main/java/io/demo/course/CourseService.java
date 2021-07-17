package io.demo.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    /*
    private List<Course> courses = new ArrayList<>(Arrays.asList(
            new Course("spring", "spring framework", "spring framework description"),
            new Course("java", "core java", "Core java description"),
            new Course("python", "python3", "python description")
    ));
    */

    public List<Course> getAllCourses(String topicId)
    {
        List<Course> courses = new ArrayList<>();
        courseRepository.findByTopicId(topicId)
                .forEach(courses::add);
        return courses;
    }

    public Optional<Course> getCourse(String id)
    {
        //return courses.stream().filter(t -> t.getId().equals(id)).findFirst().get();
        return courseRepository.findById(id);
    }

    public void addCourse(Course course)
    {
        //courses.add(course);
        courseRepository.save(course);
    }

    public void updateCourse(Course course)
    {
       // for(int i = 0; i < courses.size(); i++)
       // {
       //     Course t = courses.get(i);
       //     if (t.getId().equals(id))
       //     {
       //         courses.set(i, course);
       //         return;
       //     }
       // }

        // save will automatically update the data with id or if not present, a new Course will be created.
        courseRepository.save(course);
    }

    public void deleteCourse(String id)
    {
        //courses.removeIf(t -> t.getId().equals(id));
        courseRepository.deleteById(id);
    }
}
