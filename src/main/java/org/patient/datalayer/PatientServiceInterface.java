package org.patient.datalayer;

import com.amazonaws.services.lambda.runtime.LambdaLogger;
import org.patient.models.Lambda.LambdaResponse;
import org.patient.models.Patient;

public interface PatientServiceInterface {
    public LambdaResponse save(Patient patient);
    boolean saveData(Patient patient);
    void setLogger(LambdaLogger logger);
}
