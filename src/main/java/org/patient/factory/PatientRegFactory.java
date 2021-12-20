package org.patient.factory;

import org.patient.datalayer.PatientStorage;

public class PatientRegFactory {

   // public static LambdaLogger logger;
    public static PatientStorage createPatientProfile(){
           // Patient patient = new Patient();
                //patient.setPatientId(CommonUtils.generateID());
        try {
           // logger.log("Creating Patient Storage class");
             return new PatientStorage();
            //logger.log("Finished Creating Patient Storage class");
        }catch(Exception e){
            e.printStackTrace();
           // logger.log("ERROR: FactoryBase");
        }
        return null;
    }
}
