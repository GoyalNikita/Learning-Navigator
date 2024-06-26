package com.crio.LearningNavigator.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crio.LearningNavigator.dto.Exam;
import com.crio.LearningNavigator.exceptions.ExamNotFoundException;
import com.crio.LearningNavigator.exceptions.SubjectNotFoundException;
import com.crio.LearningNavigator.exchanges.CreateExamRequest;
import com.crio.LearningNavigator.repositoryServices.IExamRepositoryService;

@Service
public class ExamService implements IExamService {

    @Autowired
    private IExamRepositoryService examRepositoryService;

    @Override
    public Exam addExam(CreateExamRequest createExamRequest) throws SubjectNotFoundException {
        long subjectId = createExamRequest.getSubjectId();
        Exam exam = examRepositoryService.addExam(subjectId);
        return exam;
    }

    @Override
    public Exam getExamById(long examId) throws ExamNotFoundException {
        Exam exam = examRepositoryService.getExamById(examId);
        return exam;
    }

    @Override
    public List<Exam> getAllExams() {
        List<Exam> exams = examRepositoryService.getAllExams();
        return exams;
    }

    @Override
    public void deleteExam(long examId) throws ExamNotFoundException {
        examRepositoryService.deleteExam(examId);
    }

}
