package com.crio.LearningNavigator.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crio.LearningNavigator.dto.Student;
import com.crio.LearningNavigator.exceptions.ExamNotFoundException;
import com.crio.LearningNavigator.exceptions.StudentNotFoundException;
import com.crio.LearningNavigator.exceptions.SubjectNotEnrolledException;
import com.crio.LearningNavigator.exceptions.SubjectNotFoundException;
import com.crio.LearningNavigator.exchanges.RegisterStudentRequest;
import com.crio.LearningNavigator.repositoryServices.IStudentRepositoryService;

@Service
public class StudentService implements IStudentService {

    @Autowired
    private IStudentRepositoryService studentRepositoryService;

    @Override
    public Student addStudent(RegisterStudentRequest registerStudentRequest) {
        String studentName = registerStudentRequest.getStudentName();
        Student student = studentRepositoryService.addStudent(studentName);
        return student;
    }

    @Override
    public Student getStudentById(long studentId) throws StudentNotFoundException {
        Student student = studentRepositoryService.getStudentById(studentId);
        return student;
    }

    @Override
    public Student enrollStudentInSubject(long studentId, long subjectId)
            throws StudentNotFoundException, SubjectNotFoundException {
        Student student = studentRepositoryService.enrollStudentInSubject(studentId, subjectId);
        return student;
    }

    @Override
    public Student registerStudentForExam(long studentId, long examId)
            throws StudentNotFoundException, ExamNotFoundException, SubjectNotEnrolledException {
        Student student = studentRepositoryService.registerStudentForExam(studentId, examId);
        return student;
    }

    @Override
    public List<Student> getAllStudents() {
        List<Student> students = studentRepositoryService.getAllStudents();
        return students;
    }

    @Override
    public void deleteStudent(long studentId) throws StudentNotFoundException {
        studentRepositoryService.deleteStudent(studentId);
    }

}
