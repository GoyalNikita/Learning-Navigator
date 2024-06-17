package com.crio.LearningNavigator.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crio.LearningNavigator.dto.Subject;
import com.crio.LearningNavigator.exceptions.SubjectNotFoundException;
import com.crio.LearningNavigator.exchanges.CreateSubjectRequest;
import com.crio.LearningNavigator.repositoryServices.ISubjectRepositoryService;

@Service
public class SubjectService implements ISubjectService {

    @Autowired
    private ISubjectRepositoryService subjectRepositoryService;

    @Override
    public Subject addSubject(CreateSubjectRequest createSubjectRequest) {
        String subjectName = createSubjectRequest.getSubjectName();
        Subject subject = subjectRepositoryService.addSubject(subjectName);
        return subject;
    }

    @Override
    public Subject getSubjectById(long subjectId) throws SubjectNotFoundException {
        Subject subject = subjectRepositoryService.getSubjectById(subjectId);
        return subject;
    }

    @Override
    public List<Subject> getAllSubjects() {
        List<Subject> subjects = subjectRepositoryService.getAllSubjects();
        return subjects;
    }

    @Override
    public void deleteSubject(long subjectId) throws SubjectNotFoundException {
        subjectRepositoryService.deleteSubject(subjectId);
    }

}
