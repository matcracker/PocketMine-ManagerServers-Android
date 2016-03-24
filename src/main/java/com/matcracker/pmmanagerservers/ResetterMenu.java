package com.matcracker.pmmanagerservers;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import java.io.File;
import java.io.IOException;

public class ResetterMenu extends AppCompatActivity
{

    String[] dirsName = {"/data/data/com.matcracker.pmmanagerservers/files/Data", "/data/data/com.matcracker.pmmanagerservers/files/ServersName", "/data/data/com.matcracker.pmmanagerservers/files/Path", "/data/data/com.matcracker.pmmanagerservers/files/Performance", "/data/data/com.matcracker.pmmanagerservers/files/Utils", "/data/data/com.matcracker.pmmanagerservers/files/Installations", "/data/data/com.matcracker.pmmanagerservers/files/Languages", "/data/data/com.matcracker.pmmanagerservers/files/Backups", "/data/data/com.matcracker.pmmanagerservers/files/Backups" + File.separator + "Status", "/data/data/com.matcracker.pmmanagerservers/files/Backups" + File.separator + "Servers"};

    public Button resetprog,resetserv,resetall,back;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.resetter);

        resetprog=(Button) findViewById(R.id.button2);
        resetserv=(Button) findViewById(R.id.button3);
        resetall=(Button) findViewById(R.id.button4);
        back=(Button) findViewById(R.id.button6);

        resetprog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    resetProgram();
                }
                catch (Exception e) {
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

        resetall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetAllData();
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

                        File dir=null;

                        for(int i=0;i<dirsName.length;i++) {
                            dir = new File(dirsName[i]);
                            dir.delete();
                        }

                        /*File[] files = dir.listFiles();

                        for(File file : files) {
                            file.delete();
                        }*/
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

    public void resetServers(){
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

    public void resetAllData(){
        new AlertDialog.Builder(ResetterMenu.this)
                .setTitle("Reset")
                .setMessage("Are you sure to want reset data of servers?")
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

}
