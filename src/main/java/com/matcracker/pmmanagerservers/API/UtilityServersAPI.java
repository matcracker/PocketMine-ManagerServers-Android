package com.matcracker.pmmanagerservers.API;

import java.io.File;

import com.matcracker.pmmanagerservers.Utility.Utility;

public class UtilityServersAPI {

    public static int getNumberServers() {
        return Utility.readIntData(new File(Utility.pathSD + File.separator + "Data" + File.separator + "nservers.pm"));
    }

    public static void setNameServer(int index, String content) {
        index++;
        Utility.writeStringData(new File(Utility.pathSD + File.separator + "ServersName" + File.separator + "ServerName_" + index + ".pm"), content);
    }

    public static void setNumberServer(int content) {
        if (content > 0)
            Utility.writeIntData(new File(Utility.pathSD + File.separator + "Data" + File.separator + "nservers.pm"), content);
        else
            System.err.println("Can't set a negative value!");
    }

    public static String getNameServer(int index) {
        index++;
        return Utility.readStringData(new File(Utility.pathSD + File.separator + "ServersName" + File.separator + "ServerName_" + index + ".pm"));
    }

    public static String getDefaultServerName() {
        return Utility.defaultServersName;
    }

    public static void setDefaultServerName(String name) {
        Utility.defaultServersName = name;
    }

    public static String getPath(int index) {
        index++;
        return Utility.readStringData(new File(Utility.pathSD + File.separator + "Path" + File.separator + "path_" + index + ".pm"));
    }

    public static void setPath(int index, String path) {
        index++;
        if (path != null)
            Utility.writeStringData(new File(Utility.pathSD + File.separator + "Path" + File.separator + "path_" + index + ".pm"), path);
        else
            System.err.println("Path can't be null!");

    }

    public static boolean checkServersFile(String folder, String name, int index) {
        File file;
        if (index < 0) {
            file = new File(Utility.pathSD + folder + File.separator + name + ".pm");
        } else {
            index++;
            file = new File(Utility.pathSD + folder + File.separator + name + index + ".pm");
        }

        if (file.exists())
            return true;
        else
            return false;

    }
}
