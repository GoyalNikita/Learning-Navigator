package com.crio.LearningNavigator.exceptions;

import java.io.IOException;

public class SubjectNotEnrolledException extends IOException {

    public SubjectNotEnrolledException() {
        super();
    }

    public SubjectNotEnrolledException(String ex) {
        super(ex);
    }

}
