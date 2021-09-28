package com.pluralsight.conference.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RegistrationReport {

    private String name;
    private String courseName;
    private String courseDescription;

}
