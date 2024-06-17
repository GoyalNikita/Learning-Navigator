package com.crio.LearningNavigator.exceptions;

import java.io.IOException;

public class SubjectNotFoundException extends IOException {

    public SubjectNotFoundException() {
        super();
    }

    public SubjectNotFoundException(String ex) {
        super(ex);
    }
}
