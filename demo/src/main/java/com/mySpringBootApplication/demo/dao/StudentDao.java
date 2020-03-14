package com.mySpringBootApplication.demo.dao;

import com.mySpringBootApplication.demo.model.student;

import java.util.List;
import java.util.UUID;

public interface StudentDao {
    int insertNewStudent(UUID studentID, student student);

    student selectStudentByID(UUID studentID);

    List<student> selectAllStudent();

    int updateStudentByID(UUID studentId, student newStudent);

    int deleteStudentByID(UUID studentId);

}
