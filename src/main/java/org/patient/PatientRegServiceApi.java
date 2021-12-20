package org.patient;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import org.patient.datalayer.PatientServiceInterface;
import org.patient.factory.PatientRegFactory;
import org.patient.models.Lambda.LambdaResponse;
import org.patient.models.Patient;

public class PatientRegServiceApi implements RequestHandler<Patient, LambdaResponse> {


    LambdaLogger logger = null;
       @Override
        public LambdaResponse handleRequest(Patient input, Context context) {
           logger =context.getLogger();
           logger.log("input data: "+ input);
           PatientServiceInterface svc = PatientRegFactory.createPatientProfile();
           svc.setLogger(logger);

           LambdaResponse lambdaResponse = new LambdaResponse();
           lambdaResponse.setStatusCode(200);

           boolean response = svc.saveData(input);

        if(response) {
            lambdaResponse.setBody("Patient save successful!");
            lambdaResponse.setStatusCode(200);

        }else {
            lambdaResponse.setBody("failure");
            lambdaResponse.setStatusCode(401);
        }
        return lambdaResponse;
    }
}
