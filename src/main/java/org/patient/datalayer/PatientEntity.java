package org.patient.datalayer;

import com.microsoft.azure.storage.table.TableServiceEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.patient.models.Patient;

@Data
@NoArgsConstructor
public class PatientEntity extends TableServiceEntity {

    public PatientEntity(Patient patient) {
        super.setPartitionKey("PatientEntity");
        super.setRowKey(patient.getPhoneNo());
        this.setPatientId(patient.getPatientId());
        this.setFirstName(patient.getFirstName());
        this.setLastName(patient.getLastName());
       // this.setDateOfBirth(patient.getDateOfBirth());
        this.setEmail(patient.getEmail());
        this.setPhoneNo(patient.getPhoneNo());
        //this.setAddress(patient.getAddress());
       // this.setStatus(patient.getStatus());
       // this.setGender(patient.getGender());
       // this.setHeight(patient.getHeight());
       // this.setWeight(patient.getWeight());
         }

    private String patientId;
    private String firstName;
    private String lastName;
  //  private Date dateOfBirth;
    private String email;
    private String phoneNo;
   // private Address address;
  //  private String status;
  //  private Gender gender;
  //  private double height;
 //   private double weight;
}
