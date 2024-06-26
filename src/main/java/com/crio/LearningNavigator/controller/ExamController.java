package com.crio.LearningNavigator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crio.LearningNavigator.dto.Exam;
import com.crio.LearningNavigator.exceptions.ExamNotFoundException;
import com.crio.LearningNavigator.exceptions.SubjectNotFoundException;
import com.crio.LearningNavigator.exchanges.CreateExamRequest;
import com.crio.LearningNavigator.exchanges.GetAllExamsResponse;
import com.crio.LearningNavigator.services.IExamService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(ExamController.EXAM_API_ENDPOINT)
public class ExamController {
    public static final String EXAM_API_ENDPOINT = "/exams";

    @Autowired
    private IExamService examService;

    // Endpoint to create a new exam.
    @PostMapping
    public ResponseEntity<Exam> createExam(@Valid @RequestBody CreateExamRequest createExamRequest)
            throws SubjectNotFoundException {
        Exam exam = examService.addExam(createExamRequest);
        return ResponseEntity.ok().body(exam);
    }

    // Endpoint to retieve all the exam list.
    @GetMapping
    public ResponseEntity<GetAllExamsResponse> getAllExams() {
        List<Exam> exams = examService.getAllExams();
        GetAllExamsResponse getAllExamsResponse = new GetAllExamsResponse(exams);
        return ResponseEntity.ok().body(getAllExamsResponse);
    }

    // Endpoint to retrieve the exam details by examId.
    @GetMapping("/{examId}")
    public ResponseEntity<Exam> getExamById(@PathVariable(value = "examId") long examId) throws ExamNotFoundException {
        Exam exam = examService.getExamById(examId);
        return ResponseEntity.ok().body(exam);
    }

    // Endpoint to delete the exam by examId.
    @DeleteMapping("/{examId}")
    public ResponseEntity<String> deleteExam(@PathVariable long examId) throws ExamNotFoundException {
        String message = "Successfully deleted exam with ID: " + String.valueOf(examId);
        examService.deleteExam(examId);
        return ResponseEntity.ok().body(message);
    }
}
