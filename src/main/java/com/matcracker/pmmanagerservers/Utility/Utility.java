package com.matcracker.pmmanagerservers.Utility;

import android.os.Environment;

import com.matcracker.pmmanagerservers.API.UtilityServersAPI;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Utility {

    public static String pathSD = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "PocketMine Manager Servers";
    public static String defaultServersName = "Server_Minecraft_PE";

    public static void writeIntData(File file, int data) {
        BufferedWriter writerData = null;

        try {
            writerData = new BufferedWriter(new FileWriter(file));
            writerData.write(new Integer(data).toString());

        } catch (IOException e) {
            //Errors
        }

        try {
            if (writerData != null)
                writerData.close();
        } catch (IOException e1) {
            //Errors
        }
    }

    public static int readIntData(File file) {
        FileReader readerData = null;
        String data = null;

        try {
            readerData = new FileReader(file);
        } catch (FileNotFoundException e1) {
            //Errors
        }
        BufferedReader buffer = new BufferedReader(readerData);


        try {
            data = buffer.readLine();
            if (readerData != null)
                readerData.close();
        } catch (IOException e) {
            //Errors
        }

        return Integer.parseInt(data);
    }

    public static String readStringData(File file) {
        FileReader readerData = null;
        String data = null;

        try {
            readerData = new FileReader(file);
        } catch (FileNotFoundException e1) {
            //Errors
        }
        BufferedReader buffer = new BufferedReader(readerData);

        try {
            data = buffer.readLine();
            if (readerData != null)
                readerData.close();
        } catch (IOException e) {
            //Errors
        }

        return data;
    }

    public static void writeStringData(File file, String data) {
        BufferedWriter writerData = null;

        try {
            writerData = new BufferedWriter(new FileWriter(file));
            writerData.write(data);

        } catch (IOException e) {
            //Errors

        } finally {
            try {
                if (writerData != null)
                    writerData.close();
            } catch (IOException e) {
                //Errors
            }
        }
    }

    public static void showServers() {
        int nservers = UtilityServersAPI.getNumberServers();
        for (int i = 0; i < nservers; i++) {
            /*System.out.print((i+1) + ") " + UtilityServersAPI.getNameServer(i));
            System.out.println();*/
            //@TODO List in Android
        }
    }

    public static boolean is_numeric(String content) {
        try {
            Integer.parseInt(content);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
