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
    private Button installa,opzioni,informazioni,esci,manutenzione;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        installa=(Button) findViewById(R.id.button2);
        manutenzione=(Button) findViewById(R.id.button3);
        opzioni=(Button) findViewById(R.id.button4);
        informazioni=(Button) findViewById(R.id.button5);
        esci=(Button) findViewById(R.id.button6);

        installa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                //Installator.installatorMenu();
            }
        });

        manutenzione.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
            }
        });

        opzioni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent impostazioni = new Intent(MainActivity.this,SettingsMenu.class);
                startActivity(impostazioni);
                //Settings.settingsMenu();
            }
        });

        informazioni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
            }
        });

        esci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                }
        });
    }
}
