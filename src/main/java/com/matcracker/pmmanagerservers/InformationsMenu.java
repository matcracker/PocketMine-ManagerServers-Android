package com.matcracker.pmmanagerservers;



import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class InformationsMenu extends AppCompatActivity {

    private Button license,credits,more_information,disclaimer,back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.informations_menu);

        license=(Button) findViewById(R.id.button2);
        credits=(Button) findViewById(R.id.button3);
        more_information=(Button) findViewById(R.id.button4);
        disclaimer=(Button) findViewById(R.id.button5);
        back=(Button) findViewById(R.id.button6);

        license.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
            }
        });

        credits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(InformationsMenu.this)
                        .setTitle("Credits")
                        .setMessage("This program is free software made by matcracker: you can redistribute it and/or modify it under the terms of the GNU Lesser General Public License as published by the Free Software Foundation, either version 3 of the License, or at your option) any later version. This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more details. You should have received a copy of the GNU Lesser General Public License along with this program.  If not, see in this program in the section 'Informations ->  License'.")
                        .setCancelable(false)
                        .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //Do Nothing
                            }
                        })
                        .create().show();
            }
        });

        more_information.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] elements = {"Twitter", "GitHub"};

                new AlertDialog.Builder(InformationsMenu.this)
                        .setTitle("More Informations")
                        .setItems(elements, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {

                                Intent viewIntent = new Intent("android.intent.action.VIEW", Uri.parse("https://twitter.com/matcracker98"));
                                startActivity(viewIntent);

                            }
                        })
                        .create().show();
            }
        });

        disclaimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(InformationsMenu.this)
                        .setTitle("Disclaimer")
                        .setMessage("I do not assume responsibility for the use of this program if being deleted folders or files, for you, important. The use is personal and therefore the connections you supply will have to be primarily related to the creation program server 'PocketMine-MP' or relative.")
                        .setCancelable(false)
                        .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //Do Nothing
                            }
                        })
                        .create().show();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back=new Intent(InformationsMenu.this,MainActivity.class);
                startActivity(back);
                InformationsMenu.this.finish();
            }
        });
    }
}