package com.mySpringBootApplication.demo.resource;

import com.mySpringBootApplication.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.mySpringBootApplication.demo.model.student;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/studends")
public class StudentResource {

    private final StudentService studentService;

    @Autowired
    public StudentResource(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<student> getAllStudentds(){
        return studentService.getAllStudent();
    }
    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE,
            path = "{studentId}"
    )
    public student getStudentByID(@PathVariable("studentId") UUID studentID){
        return studentService.getStudentByID(studentID);
    }
    @RequestMapping(
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public void insertNewStudent(@RequestBody student student){
        studentService.persitNewStudent(UUID.randomUUID(), student);
    }
    @RequestMapping(
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            path = "{studentId}"
    )
    public void updateStudentByID(@PathVariable("studentId") UUID studentId, @RequestBody student student){
        studentService.updateStudentByID(studentId,student);
    }
    @RequestMapping(
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE,
            path = "{studentId}"
    )
    public void deleteStudent(@PathVariable("studentId") UUID studentId ){
        studentService.deleteStudentByID(studentId);
    }


}
