package org.patient.datalayer.dataConfig;

public class Config {
    private static String AZURE_PATIENT_STRING = "DefaultEndpointsProtocol=https;AccountName=aipalcaredatabase;AccountKey=Orii48j3Of8C4Mg2NkzWjVk6ASIOELeQbHZhOvfkuL7m6ohdpbUX9DmRfqN5/hw5TRk69Kf6HatyP86MM48Yzg==;EndpointSuffix=core.windows.net";

    public static String getConfig() {
        return AZURE_PATIENT_STRING;
    }
}
