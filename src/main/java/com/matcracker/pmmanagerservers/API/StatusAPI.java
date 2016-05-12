package com.matcracker.pmmanagerservers.API;

import com.matcracker.pmmanagerservers.Utility.Utility;

import java.io.File;

public class StatusAPI {

    public static void setVersion(String version, int index) {
        index++;
        Utility.writeStringData(new File(Utility.pathSD + File.separator + "Installations" + File.separator + "Version" + File.separator + "Status_" + index + ".pm"), version);
    }

    public static String getVersion(int index) {
        index++;
        return Utility.readStringData(new File(Utility.pathSD + File.separator + "Installations" + File.separator + "Version" + File.separator + "Status_" + index + ".pm"));
    }

    public static void setStatus(String status, int index) {
        index++;
        Utility.writeStringData(new File(Utility.pathSD + File.separator + "Installations" + File.separator + "Status" + File.separator + "Status_" + index + ".pm"), status);
    }

    public static String getStatus(int index) {
        index++;
        return Utility.readStringData(new File(Utility.pathSD + File.separator + "Installations" + File.separator + "Status" + File.separator + "Status_" + index + ".pm"));
    }

    public static String getPerformace(int index) {
        index++;
        return Utility.readStringData(new File(Utility.pathSD + File.separator + "Performance" + File.separator + "PerformanceStatus_" + index + ".pm"));
    }

    public static void setPerformance(String status, int index) {
        index++;
        Utility.writeStringData(new File(Utility.pathSD + File.separator + "Performance" + File.separator + "PerformanceStatus_" + index + ".pm"), status);

    }
}
