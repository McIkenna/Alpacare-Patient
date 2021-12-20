package org.patient.models.Lambda;

import lombok.Data;

@Data
public class LambdaResponse {
    private int statusCode;
    private String body;
    private String errorMessage;
    private String errorDetails;
}
