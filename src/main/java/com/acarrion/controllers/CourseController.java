package com.acarrion.controllers;

import com.acarrion.model.Course;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CourseController {

    private List<Course> courses;

    @PostConstruct
    public void init() {
        courses = new ArrayList<>();
        courses.add(new Course("Spring", 25, "Afternoon"));
        courses.add(new Course("Spring Boot", 20, "Morning"));
        courses.add(new Course("Python", 50, "Evening"));
        courses.add(new Course("Java EE", 60, "Afternoon"));
    }

    @GetMapping(value = "course", produces = MediaType.APPLICATION_JSON_VALUE)
    public Course getCurso() {
        return new Course("Java", 100, "Morning");
    }

    @GetMapping(value = "courses", produces = MediaType.APPLICATION_XML_VALUE)
    public List<Course> getCourses() {
        return courses;
    }

    @GetMapping(value = "findCourses/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Course> findCourses(@PathVariable("name") String name) {
        List<Course> listCourses = new ArrayList<>();
        for (Course c : courses) {
            if (c.getName().contains(name)) {
                listCourses.add(c);
            }
        }
        return listCourses;
    }

    @DeleteMapping(value = "course/{name}")
    public void deleteCourse(@PathVariable("name") String name) {
        courses.removeIf(c -> c.getName().equals(name));
    }

    @PostMapping(value = "course", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Course> createCourse(@RequestBody Course course) {
        courses.add(course);
        return courses;
    }

    @PutMapping(value="course", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Course updateCourse(@RequestBody Course course){
        Course auxCourse = new Course();
        for (int i=0; i>= courses.size();i++){
            if(courses.get(i).getName().equals(course.getName())){
                courses.set(i, course);
                auxCourse = courses.get(i);
            }
        }
        return auxCourse;
    }

}
