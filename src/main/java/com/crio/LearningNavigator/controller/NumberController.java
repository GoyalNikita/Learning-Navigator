package com.crio.LearningNavigator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.crio.LearningNavigator.services.INumberService;

@RestController
public class NumberController {

    @Autowired
    private INumberService numberService;

    // EASTER EGG FEATURE
    // Endpoint to generate a fact about the number which is passed as the path
    // parameter
    @GetMapping("/hidden-feature/{number}")
    public ResponseEntity<String> getRandomNumberFact(@PathVariable int number) {
        String numberFact = numberService.getNumberFact(number);
        return ResponseEntity.ok().body(numberFact);
    }
}
