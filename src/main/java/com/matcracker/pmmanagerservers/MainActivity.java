package com.matcracker.pmmanagerservers;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/*import com.matcracker.pmmanagerservers.Informations.Informations;
import com.matcracker.pmmanagerservers.Installer.Installator;
import com.matcracker.pmmanagerservers.Loaders.Loader;
import com.matcracker.pmmanagerservers.Settings.Settings;
import com.matcracker.pmmanagerservers.Utility.Utility;*/

public class MainActivity extends AppCompatActivity
{
    public Button installator,options,informations,exit,manage;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        installator=(Button) findViewById(R.id.button2);
        manage=(Button) findViewById(R.id.button3);
        options=(Button) findViewById(R.id.button4);
        informations=(Button) findViewById(R.id.button5);
        exit=(Button) findViewById(R.id.button6);

        installator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent installator=new Intent(MainActivity.this,ManagerInstallerMenu.class);
                startActivity(installator);
                MainActivity.this.finish();
                //Installator.installatorMenu();
            }
        });

        manage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
            }
        });

        options.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent settings= new Intent(MainActivity.this,SettingsMenu.class);
                startActivity(settings);
                MainActivity.this.finish();
                //Settings.settingsMenu();
            }
        });

        informations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inf=new Intent(MainActivity.this,InformationsMenu.class);
                startActivity(inf);
                MainActivity.this.finish();
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Exit")
                        .setMessage("Do you want to exit?")
                        .setCancelable(false)
                        .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //android.os.Process.killProcess(android.os.Process.myPid());
                                //System.exit(1);
                                MainActivity.this.finish();
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
        });
    }
}
