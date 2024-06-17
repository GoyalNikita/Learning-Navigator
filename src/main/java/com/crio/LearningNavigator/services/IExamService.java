package com.crio.LearningNavigator.services;

import java.util.List;

import com.crio.LearningNavigator.dto.Exam;
import com.crio.LearningNavigator.exceptions.ExamNotFoundException;
import com.crio.LearningNavigator.exceptions.SubjectNotFoundException;
import com.crio.LearningNavigator.exchanges.CreateExamRequest;

public interface IExamService {

    Exam addExam(CreateExamRequest createExamRequest) throws SubjectNotFoundException;

    Exam getExamById(long examId) throws ExamNotFoundException;

    List<Exam> getAllExams();

    void deleteExam(long examId) throws ExamNotFoundException;

}
