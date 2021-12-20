package org.patient.service;

import com.amazonaws.services.lambda.runtime.LambdaLogger;
import org.patient.datalayer.PatientServiceInterface;
import org.patient.factory.PatientRegFactory;
import org.patient.models.Lambda.LambdaResponse;
import org.patient.models.Patient;

public class PatientRegService implements PatientServiceInterface {

    private PatientRegFactory factory;


    LambdaLogger logger;
    PatientServiceInterface newPatient = factory.createPatientProfile();


    @Override
    public LambdaResponse save(Patient patient) {
        return null;
    }

    @Override
    public boolean saveData(Patient patient) {
        logger.log("About to save data in azure");
        boolean response = newPatient.saveData(patient);
        logger.log("Successfully saved data in azure");
        return response;
    }

    @Override
    public void setLogger(LambdaLogger logger) {
        this.logger= logger;
    }
}
