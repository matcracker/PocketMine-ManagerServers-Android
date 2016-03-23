package com.matcracker.pmmanagerservers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.matcracker.pmmanagerservers.Installer.ManagerInstaller;

//import com.matcracker.pmmanagerservers.Utility.Utility;

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
            @Override
            public void onClick(View v) {
                //
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
