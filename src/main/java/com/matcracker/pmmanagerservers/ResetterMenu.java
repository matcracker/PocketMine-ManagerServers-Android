package com.matcracker.pmmanagerservers;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.matcracker.pmmanagerservers.Utility.Utility;

import java.io.File;
import java.io.IOException;

public class ResetterMenu extends AppCompatActivity {

    public Button resetprog, resetserv, back;

    private static String[] dirsName = {
            Utility.pathSD,
            Utility.pathSD + File.separator + "Data",
            Utility.pathSD + File.separator + "ServersName",
            Utility.pathSD + File.separator + "Path",
            Utility.pathSD + File.separator + "Performance",
            Utility.pathSD + File.separator + "Utils",
            Utility.pathSD + File.separator + "Installations",
            Utility.pathSD + File.separator + "Installations" + File.separator + "Status",
            Utility.pathSD + File.separator + "Installations" + File.separator + "Version",
            Utility.pathSD + File.separator + "Installations" + File.separator + "Downloads",
            Utility.pathSD + File.separator + "Languages",
            Utility.pathSD + File.separator + "Backups",
            Utility.pathSD + File.separator + "Backups" + File.separator + "Status",
            Utility.pathSD + File.separator + "Backups" + File.separator + "Servers"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.resetter);

        resetprog = (Button) findViewById(R.id.button2);
        resetserv = (Button) findViewById(R.id.button3);
        back = (Button) findViewById(R.id.button6);

        resetprog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    resetProgram();
                } catch (Exception e) {
                    //Errors
                }
            }
        });

        resetserv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetServers();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Back = new Intent(ResetterMenu.this, MainActivity.class);
                startActivity(Back);
                ResetterMenu.this.finish();
            }
        });
    }

    public void resetProgram() throws IOException {

        new AlertDialog.Builder(ResetterMenu.this)
                .setTitle("Reset")
                .setMessage("Are you sure to want reset data of servers (only program)?")
                .setCancelable(false)
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        for (int i = 1; i < dirsName.length; i++) {
                            deleteFiles(dirsName[i]);
                            deleteFolder(dirsName[i], dirsName.length);
                        }
                    }
                })

                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Do Nothing
                    }
                })

                .create().show();

    }

    public void resetServers() {
        new AlertDialog.Builder(ResetterMenu.this)
                .setTitle("Reset")
                .setMessage("Are you sure to want reset data of servers (only servers)?")
                .setCancelable(false)
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //
                    }
                })

                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Do Nothing
                    }
                })

                .create().show();
    }

    private static void deleteFolder(String folder, int index) {
        File dir = new File(folder);

        for (int i = 0; i < index; i++)
            dir.delete();
    }

    private static void deleteFiles(String folder) {
        File dir = new File(folder);
        File[] files = dir.listFiles();

        for (File file : files) {
            if (!file.delete()) {
                System.out.print("Error");
            }
        }
    }

}
