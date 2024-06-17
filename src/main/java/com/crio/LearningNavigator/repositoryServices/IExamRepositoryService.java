package com.crio.LearningNavigator.repositoryServices;

import java.util.List;

import com.crio.LearningNavigator.dto.Exam;
import com.crio.LearningNavigator.exceptions.ExamNotFoundException;
import com.crio.LearningNavigator.exceptions.SubjectNotFoundException;

public interface IExamRepositoryService {
    Exam addExam(long subjectId) throws SubjectNotFoundException;

    Exam getExamById(long examId) throws ExamNotFoundException;

    List<Exam> getAllExams();

    void deleteExam(long examId) throws ExamNotFoundException;
}
