package com.crio.LearningNavigator.repositoryServices;

import java.util.List;

import com.crio.LearningNavigator.dto.Exam;
import com.crio.LearningNavigator.exceptions.ExamNotFoundException;
import com.crio.LearningNavigator.exceptions.SubjectNotFoundException;

public interface IExamRepositoryService {
    Exam createExam(long subjectId) throws SubjectNotFoundException;

    Exam findExamById(long examId) throws ExamNotFoundException;

    List<Exam> findAllExams();

    void deleteExam(long examId) throws ExamNotFoundException;
}
