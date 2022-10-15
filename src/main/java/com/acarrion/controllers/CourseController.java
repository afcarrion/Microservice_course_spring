package com.acarrion.controllers;

import com.acarrion.model.Course;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CourseController {

    private List<Course> courses;
    @PostConstruct
    public void init(){
        courses = new ArrayList<>();
        courses.add(new Course("Spring",25,"Afternoon"));
        courses.add(new Course("Spring Boot",20,"Morning"));
        courses.add(new Course("Python",50,"Evening"));
        courses.add(new Course("Java EE",60,"Afternoon"));
    }

    @GetMapping(value = "course", produces = MediaType.APPLICATION_JSON_VALUE)
    public Course getCurso(){
        return new Course("Java",100,"Morning");
    }

    @GetMapping(value = "courses", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Course> getCourses(){
        return courses;
    }

    @GetMapping(value = "findCourses/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Course> findCourses(@PathVariable("name") String name){
        List<Course> listCourses = new ArrayList<>();
        for(Course c:courses){
            if(c.getName().contains(name)){
                listCourses.add(c);
            }
        }
        return listCourses;
    }
}
