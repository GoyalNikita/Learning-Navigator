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

import com.crio.LearningNavigator.dto.Subject;
import com.crio.LearningNavigator.exceptions.SubjectNotFoundException;
import com.crio.LearningNavigator.exchanges.CreateSubjectRequest;
import com.crio.LearningNavigator.exchanges.GetAllSubjectsResponse;
import com.crio.LearningNavigator.services.ISubjectService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(SubjectController.SUBJECT_API_ENDPOINT)
public class SubjectController {
    public static final String SUBJECT_API_ENDPOINT = "/subjects";

    @Autowired
    private ISubjectService subjectService;

    // create a new subuject
    @PostMapping
    public ResponseEntity<Subject> createSubject(@Valid @RequestBody CreateSubjectRequest createSubjectRequest) {
        Subject subject = subjectService.addSubject(createSubjectRequest);
        return ResponseEntity.ok().body(subject);
    }

    // retrieve the subject details by subject id.
    @GetMapping("/{subjectId}")
    public ResponseEntity<Subject> getSubjectById(@PathVariable(value = "subjectId") long subjectId)
            throws SubjectNotFoundException {
        Subject subject = subjectService.getSubjectById(subjectId);
        return ResponseEntity.ok().body(subject);
    }

    // retrieve all the subject lsits
    @GetMapping
    public ResponseEntity<GetAllSubjectsResponse> getAllSubjects() {
        List<Subject> subjects = subjectService.getAllSubjects();
        GetAllSubjectsResponse getAllSubjectsResponse = new GetAllSubjectsResponse(subjects);
        return ResponseEntity.ok().body(getAllSubjectsResponse);
    }

    // delete the particular subject based on subject id.
    @DeleteMapping("/{subjectId}")
    public ResponseEntity<String> deleteSubject(@PathVariable long subjectId) throws SubjectNotFoundException {
        String message = "Successfully deleted subject with ID: " + String.valueOf(subjectId);
        subjectService.deleteSubject(subjectId);
        return ResponseEntity.ok().body(message);
    }
}
