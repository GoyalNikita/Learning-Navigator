package com.crio.LearningNavigator.repositoryServices;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crio.LearningNavigator.dto.Exam;
import com.crio.LearningNavigator.exceptions.ExamNotFoundException;
import com.crio.LearningNavigator.exceptions.SubjectNotFoundException;
import com.crio.LearningNavigator.models.ExamEntity;
import com.crio.LearningNavigator.models.SubjectEntity;
import com.crio.LearningNavigator.repositories.ExamRepository;
import com.crio.LearningNavigator.repositories.SubjectRepository;

import jakarta.inject.Provider;

@Service
public class ExamRepositoryServicel implements IExamRepositoryService {

    @Autowired
    private ExamRepository examRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private Provider<ModelMapper> modelMapperProvider;

    @Override
    public Exam addExam(long subjectId) throws SubjectNotFoundException {
        String message = "No subject with subjectId: " + String.valueOf(subjectId) + " found.";
        ModelMapper modelMapper = modelMapperProvider.get();

        ExamEntity examEntity = new ExamEntity();
        SubjectEntity subjectEntity = subjectRepository.findById(subjectId)
                .orElseThrow(() -> new SubjectNotFoundException(message));

        examEntity.setSubjectEntity(subjectEntity);
        Exam exam = modelMapper.map(examRepository.save(examEntity), Exam.class);
        return exam;
    }

    @Override
    public Exam getExamById(long examId) throws ExamNotFoundException {
        String message = "No Exam with examId: " + String.valueOf(examId) + " found.";
        ModelMapper modelMapper = modelMapperProvider.get();
        ExamEntity examEntity = examRepository.findById(examId).orElseThrow(() -> new ExamNotFoundException(message));
        Exam exam = modelMapper.map(examEntity, Exam.class);
        return exam;
    }

    @Override
    public List<Exam> getAllExams() {
        List<ExamEntity> examEntities = examRepository.findAll();
        List<Exam> exams = mapToExamList(examEntities);
        return exams;
    }

    @Override
    public void deleteExam(long examId) throws ExamNotFoundException {
        String message = "No Exam with examId: " + String.valueOf(examId) + " found.";
        ExamEntity examEntity = examRepository.findById(examId).orElseThrow(() -> new ExamNotFoundException(message));
        examRepository.delete(examEntity);
    }

    private List<Exam> mapToExamList(List<ExamEntity> examEntities) {
        List<Exam> exams = new ArrayList<>();
        ModelMapper modelMapper = modelMapperProvider.get();

        for (ExamEntity examEntity : examEntities) {
            Exam exam = modelMapper.map(examEntity, Exam.class);
            exams.add(exam);
        }

        return exams;
    }
}
