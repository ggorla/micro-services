package com.mySpringBootApplication.demo.dao;

import com.mySpringBootApplication.demo.model.student;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("fakeDao")
public class FakeStudentDaoimpl implements StudentDao{

    private final Map<UUID,student> database;

    public FakeStudentDaoimpl() {
        database = new HashMap<>();
        UUID studentId = UUID.randomUUID();
        database.put(studentId,new student(studentId,4,"Alex","Montana","CS"));
    }

    @Override
    public int insertNewStudent(UUID studentID, student student) {
        database.put(studentID,student);
        return 1;
    }

    @Override
    public student selectStudentByID(UUID studentID) {
        return database.get(studentID);
    }

    @Override
    public List<student> selectAllStudent() {
        return new ArrayList<>(database.values());
    }

    @Override
    public int updateStudentByID(UUID studentId, student newStudent) {
        database.put(studentId,newStudent);
        return 1;
    }

    @Override
    public int deleteStudentByID(UUID studentId) {
        database.remove(studentId);
        return 0;
    }
}
