package com.crio.LearningNavigator.exchanges;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SubjectRequest {

    @NotEmpty
    private String subjectName;
}
