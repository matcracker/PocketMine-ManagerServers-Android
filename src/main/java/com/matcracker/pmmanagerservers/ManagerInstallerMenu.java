package com.matcracker.pmmanagerservers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;;
import android.view.View;
import android.widget.Button;

public class ManagerInstallerMenu extends AppCompatActivity {

    public Button download,install,back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.managerinstaller_menu);

        download=(Button) findViewById(R.id.button2);
        install=(Button) findViewById(R.id.button3);
        back=(Button) findViewById(R.id.button4);

        download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
            }
        });

        install.setOnClickListener(new View.OnClickListener() {
            //FileOutputStream fOut;
            @Override
            public void onClick(View v) {
                /*try {
                    fOut = openFileOutput("prova.pm", MODE_WORLD_READABLE);
                    String str = "data";
                    fOut.write(str.getBytes());
                    fOut.close();
                    File prova=new File("/data/data/com.matcracker.pmmanagerservers/files/prova");
                    prova.mkdir();
                }
                catch (IOException e) {
                    new AlertDialog.Builder(ManagerInstallerMenu.this)
                            .setTitle("Error")
                            .setMessage("Error writting file")
                            .setCancelable(false)
                            .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    //Do Nothing
                                }
                            })
                            .create().show();
                }*/
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back=new Intent(ManagerInstallerMenu.this,MainActivity.class);
                startActivity(back);
                ManagerInstallerMenu.this.finish();
            }
        });
    }

}
