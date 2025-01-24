package com.crio.learnigNavigator.controller;

import com.crio.learnigNavigator.model.Student;
import com.crio.learnigNavigator.service.StudentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import java.net.URI;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext
public class StudentControllerTests {

    private MockMvc mockMvc;
    private ObjectMapper objectMapper;

    @InjectMocks
    private StudentController studentController;

    @MockitoBean
    private StudentService studentService;

    @BeforeEach
    public void setUp() {
        objectMapper = new ObjectMapper();
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(studentController).build();
    }

    @Test
    public void testGetAllStudents() throws Exception {
        String expected = objectMapper.writeValueAsString(List.of());

        List<Student> sl = List.of();
        when(studentService.getAllStudents()).thenReturn(sl);

        URI uri = new URI("/student");

        MockHttpServletResponse resp = mockMvc.perform(
                MockMvcRequestBuilders
                        .get(uri)
                        .contentType("application/json")
        ).andReturn().getResponse();

        assertEquals(200, resp.getStatus());
        assertEquals(expected, resp.getContentAsString());
    }

    @Test
    public void testPostStudent() throws Exception {

        Student student = new Student(1, "vivek", List.of(), List.of());
        String expected = objectMapper.writeValueAsString(student);


        when(studentService.createStudent(ArgumentMatchers.any()))
                .thenReturn(student);

        URI uri = new URI("/student");

        MockHttpServletResponse resp = mockMvc.perform(
                MockMvcRequestBuilders
                        .post(uri)
                        .contentType("application/json")
                        .content(expected)
        ).andReturn().getResponse();

        assertEquals(200, resp.getStatus());
        assertEquals(expected, resp.getContentAsString());
    }

}
