package com.crio.LearningNavigator.repositoryServices;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crio.LearningNavigator.dto.Subject;
import com.crio.LearningNavigator.exceptions.SubjectNotFoundException;
import com.crio.LearningNavigator.models.SubjectEntity;
import com.crio.LearningNavigator.repositories.SubjectRepository;

import jakarta.inject.Provider;

@Service
public class SubjectRepositoryService implements ISubjectRepositoryService {

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private Provider<ModelMapper> modelMapperProvider;

    @Override
    public Subject addSubject(String subjectName) {
        ModelMapper modelMapper = modelMapperProvider.get();
        SubjectEntity subjectEntity = new SubjectEntity();
        subjectEntity.setName(subjectName);

        Subject subject = modelMapper.map(subjectRepository.save(subjectEntity), Subject.class);
        return subject;
    }

    @Override
    public Subject getSubjectById(long subjectId) throws SubjectNotFoundException {
        String message = "No subject with subjectId: " + String.valueOf(subjectId) + " found.";
        ModelMapper modelMapper = modelMapperProvider.get();

        SubjectEntity subjectEntity = subjectRepository.findById(subjectId)
                .orElseThrow(() -> new SubjectNotFoundException(message));
        Subject subject = modelMapper.map(subjectEntity, Subject.class);
        return subject;
    }

    @Override
    public List<Subject> getAllSubjects() {
        List<SubjectEntity> subjectEntities = subjectRepository.findAll();
        List<Subject> subjects = mapToSubjectList(subjectEntities);
        return subjects;
    }

    @Override
    public void deleteSubject(long subjectId) throws SubjectNotFoundException {
        String message = "No subject with subjectId: " + String.valueOf(subjectId) + " found.";
        SubjectEntity subjectEntity = subjectRepository.findById(subjectId)
                .orElseThrow(() -> new SubjectNotFoundException(message));
        subjectRepository.delete(subjectEntity);
    }

    private List<Subject> mapToSubjectList(List<SubjectEntity> subjectEntities) {
        List<Subject> subjects = new ArrayList<>();
        ModelMapper modelMapper = modelMapperProvider.get();

        for (SubjectEntity subjectEntity : subjectEntities) {
            Subject subject = modelMapper.map(subjectEntity, Subject.class);
            subjects.add(subject);
        }

        return subjects;
    }

}
