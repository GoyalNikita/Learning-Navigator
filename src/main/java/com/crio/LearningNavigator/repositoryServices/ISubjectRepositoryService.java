package com.crio.LearningNavigator.repositoryServices;

import java.util.List;

import com.crio.LearningNavigator.dto.Subject;
import com.crio.LearningNavigator.exceptions.SubjectNotFoundException;

public interface ISubjectRepositoryService {

    Subject addSubject(String subjectName);

    Subject getSubjectById(long subjectId) throws SubjectNotFoundException;

    List<Subject> getAllSubjects();

    void deleteSubject(long subjectId) throws SubjectNotFoundException;
}
