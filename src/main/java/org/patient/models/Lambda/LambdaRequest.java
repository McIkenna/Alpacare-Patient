package org.patient.models.Lambda;

import lombok.Data;

@Data
public class LambdaRequest {
    private String patientId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNo;
}
