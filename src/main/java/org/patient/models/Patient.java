package org.patient.models;

import lombok.Data;

@Data

public class Patient {
    private String patientId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNo;
}
