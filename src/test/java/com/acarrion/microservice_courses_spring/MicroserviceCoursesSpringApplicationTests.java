package com.acarrion.microservice_courses_spring;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@AutoConfigureMockMvc
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class MicroserviceCoursesSpringApplicationTests {

    @Autowired
    MockMvc mock;

    @Test
    @Order(0)
    void deleteCourseTest() throws Exception {
        mock.perform(delete("/course/Python")).andDo(print());
    }

    @Test
    @Order(1)
    void getCoursesTest() throws Exception {
        mock.perform(get("/courses")).andDo(print());
    }

    @Test
    @Order(2)
    void insertCourseTest() throws Exception {
        mock.perform(post("/course")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"Angular\",\"duration\":40,\"schedule\":\"Morning\"}")
        ).andDo(print());
    }

    @Test
    @Order(3)
    void updateCourseTest() throws Exception {
        mock.perform(put("/course")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"Angular\",\"duration\":80,\"schedule\":\"Evening\"}")
        ).andDo(print());
    }

    @Test
    @Order(4)
    void getCoursesTest2() throws Exception {
        mock.perform(get("/courses")).andDo(print());
    }
}
