package com.matcracker.pmmanagerservers;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import com.matcracker.pmmanagerservers.Informations.Informations;
import com.matcracker.pmmanagerservers.Installer.Installator;
import com.matcracker.pmmanagerservers.Loaders.Loader;
import com.matcracker.pmmanagerservers.Settings.Settings;
import com.matcracker.pmmanagerservers.Utility.Utility;

public class MainActivity extends AppCompatActivity
{
    private Button installator,options,informations,exit,manage;

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
                Intent impostazioni = new Intent(MainActivity.this,SettingsMenu.class);
                startActivity(impostazioni);
                //Settings.settingsMenu();
            }
        });

        informations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                }
        });
    }
}
