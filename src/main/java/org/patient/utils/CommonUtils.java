package org.patient.utils;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.UUID;

public class CommonUtils {
    public static String generateID() {
        return UUID.randomUUID().toString();
    }

    public static String getStackTrace(Exception ex) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        ex.printStackTrace(pw);
        return sw.toString();
    }
}
