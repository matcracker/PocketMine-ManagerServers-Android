package com.matcracker.pmmanagerservers;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.matcracker.pmmanagerservers.Settings.Resetter;
import com.matcracker.pmmanagerservers.Utility.Utility;


public class SettingsMenu extends Activity
{

    private Button language,reset,back,change;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_menu);


        language=(Button) findViewById(R.id.button2);
        change=(Button) findViewById(R.id.button3);
        reset=(Button) findViewById(R.id.button4);
        back=(Button) findViewById(R.id.button6);

        language.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
            }
        });

        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent Indietro = new Intent(SettingsMenu.this, MainActivity.class);
                startActivity(Indietro);
            }
        });
    }
}
