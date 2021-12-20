package org.patient.datalayer;

import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.table.CloudTable;
import com.microsoft.azure.storage.table.CloudTableClient;
import com.microsoft.azure.storage.table.TableOperation;
import org.patient.datalayer.dataConfig.Config;
import org.patient.models.Lambda.LambdaResponse;
import org.patient.models.Patient;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;

public class PatientStorage implements PatientServiceInterface {

    private static CloudStorageAccount _storageAccount;
    private static CloudTableClient _tableClient;

    static {
        create();
        _tableClient = createTableClient();
    }


    public static CloudStorageAccount create(){
        try{
            _storageAccount = CloudStorageAccount.parse(Config.getConfig());
        }catch(InvalidKeyException e){
            e.printStackTrace();
        }catch(URISyntaxException e){
            e.printStackTrace();
        }
        return _storageAccount;
    }

    public static CloudTableClient createTableClient(){
        return _storageAccount.createCloudTableClient();
    }

    @Override
    public LambdaResponse save(Patient patient) {
        PatientEntity entity = new PatientEntity(patient);
        return null;
    }

    @Override
    public boolean saveData(Patient patient) {
        CloudTable cloudTable = null;
        try{
            String tableName = "patient" + patient.getPhoneNo();
            PatientEntity entity = new PatientEntity(patient);
            cloudTable = createOrGetTable(tableName);
            TableOperation insertOperation = TableOperation.insertOrReplace(entity); //this is how the tables are inserted
            cloudTable.execute(insertOperation);
        }catch(Exception ex){
            return false;
        }
          return true;
    }

    @Override
    public void setLogger(LambdaLogger logger) {

    }

    private CloudTable createOrGetTable(String tableName){
        CloudTable cloudTable = null;
        try{
            cloudTable = _tableClient.getTableReference(tableName);
            cloudTable.createIfNotExists();
        }catch(URISyntaxException url){

        }catch(StorageException se){

        }catch(Exception e){

        }
        return cloudTable;
    }
}
