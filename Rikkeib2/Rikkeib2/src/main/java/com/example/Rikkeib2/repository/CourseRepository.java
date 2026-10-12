package com.example.Rikkeib2.repository;

import com.example.Rikkeib2.model.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepository {
    private List<Course> courses = new ArrayList<>();

    public CourseRepository() {
        courses.add(new Course(101, "Java Spring Boot", "Active", 1));
        courses.add(new Course(102, "ReactJS Basic", "Active", 2));
    }

    public List<Course> findAll() {
        return courses;
    }

    public Course findById(int id) {
        return courses.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
    }

    public Course create(Course course) {
        courses.add(course);
        return course;
    }

    public Course update(int id, Course updatedCourse) {
        for (Course course : courses) {
            if (course.getId() == id) {
                course.setTitle(updatedCourse.getTitle());
                course.setStatus(updatedCourse.getStatus());
                course.setInstructorId(updatedCourse.getInstructorId());
                return course;
            }
        }
        return null;
    }

    public boolean deleteById(int id) {
        return courses.removeIf(course -> course.getId() == id);
    }
}