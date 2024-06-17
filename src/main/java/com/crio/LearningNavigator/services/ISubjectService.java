package com.crio.LearningNavigator.services;

import java.util.List;

import com.crio.LearningNavigator.dto.Subject;
import com.crio.LearningNavigator.exceptions.SubjectNotFoundException;
import com.crio.LearningNavigator.exchanges.CreateSubjectRequest;

public interface ISubjectService {

    Subject addSubject(CreateSubjectRequest createSubjectRequest);

    Subject getSubjectById(long subjectId) throws SubjectNotFoundException;

    List<Subject> getAllSubjects();

    void deleteSubject(long subjectId) throws SubjectNotFoundException;

}
