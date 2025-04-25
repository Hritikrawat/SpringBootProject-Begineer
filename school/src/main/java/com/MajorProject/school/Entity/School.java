package com.MajorProject.school.Entity;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "School")
public class School {

    @NotNull(message = "Id cannot be blank")
    private Integer school_Id;

    @NotNull @NotEmpty(message = "name is mandatory")
    private String school_name;

    @NotNull @NotEmpty(message = "Email is mandatory")
    private String school_email;

}
