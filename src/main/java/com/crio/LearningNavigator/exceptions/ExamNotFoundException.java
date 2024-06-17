package com.crio.LearningNavigator.exceptions;

import java.io.IOException;

public class ExamNotFoundException extends IOException {

    public ExamNotFoundException() {
        super();
    }

    public ExamNotFoundException(String ex) {
        super(ex);
    }
}
