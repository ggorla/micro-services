package com.mySpringBootApplication.demo.service;

import com.mySpringBootApplication.demo.dao.StudentDao;
import com.mySpringBootApplication.demo.model.student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StudentService {

    private final StudentDao studentDao;

    @Autowired
    public StudentService(@Qualifier("fakeDao") StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public int persitNewStudent(UUID studentID, student student){
        UUID studentUid = studentID==null?UUID.randomUUID():studentID;
        student.setId(studentUid);
        return studentDao.insertNewStudent(studentUid,student);
    }

    public student getStudentByID(UUID studentID){
        return studentDao.selectStudentByID(studentID);
    }

    public List<student> getAllStudent(){
        return studentDao.selectAllStudent();

    }

    public int updateStudentByID(UUID studentId, student newStudent){
        return studentDao.updateStudentByID(studentId,newStudent);
    }

    public int deleteStudentByID(UUID studentId){
        return studentDao.deleteStudentByID(studentId);

    }
}
