package com.matcracker.pmmanagerservers;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.io.File;

public class DownloaderMenu extends AppCompatActivity {

    public Button beta,dev,soft,back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.downloader_menu);

        beta=(Button) findViewById(R.id.button2);
        dev=(Button) findViewById(R.id.button3);
        soft=(Button) findViewById(R.id.button4);
        back=(Button) findViewById(R.id.button5);

        final String linkbeta = "https://github.com/PocketMine/PocketMine-MP/releases/download/1.4.1dev-936/PocketMine-MP_1.4.1dev-936.phar";
        final String linkdev = "https://bintray.com/artifact/download/pocketmine/PocketMine/PocketMine-MP_1.6dev-23_6ba0abf5_API-2.0.0.phar";
        final String linksoft = "http://jenkins.pocketmine.net/job/PocketMine-Soft/lastSuccessfulBuild/artifact/PocketMine-Soft_1.5dev-245_cb9f360e_API-1.12.0.phar";

        beta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File beta = new File("/data/data/com.matcracker.pmmanagerservers/files/Utils" + File.separator + "PocketMine-MP_BETA.phar");

                if(beta.exists()) {
                    new AlertDialog.Builder(DownloaderMenu.this)
                            .setTitle("Error")
                            .setMessage("You have already downloaded this file!")
                            .setCancelable(false)
                            .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    //Do Nothing
                                }
                            })
                            .create().show();
                }else{
                    Intent viewIntent = new Intent("android.intent.action.VIEW", Uri.parse(linkbeta));
                    startActivity(viewIntent);
                }
            }
        });

        dev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File dev = new File("/data/data/com.matcracker.pmmanagerservers/files/Utils" + File.separator + "PocketMine-MP_DEV.phar");

                if(dev.exists()) {
                    new AlertDialog.Builder(DownloaderMenu.this)
                            .setTitle("Error")
                            .setMessage("You have already downloaded this file!")
                            .setCancelable(false)
                            .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    //Do Nothing
                                }
                            })
                            .create().show();
                }else{
                    Intent viewIntent = new Intent("android.intent.action.VIEW", Uri.parse(linkdev));
                    startActivity(viewIntent);
                }
            }
        });

        soft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File soft = new File("/data/data/com.matcracker.pmmanagerservers/files/Utils" + File.separator + "PocketMine-MP_SOFT.phar");

                if(soft.exists()) {
                    new AlertDialog.Builder(DownloaderMenu.this)
                            .setTitle("Error")
                            .setMessage("You have already downloaded this file!")
                            .setCancelable(false)
                            .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    //Do Nothing
                                }
                            })
                            .create().show();
                }else{
                    Intent viewIntent = new Intent("android.intent.action.VIEW", Uri.parse(linksoft));
                    startActivity(viewIntent);
                }
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back=new Intent(DownloaderMenu.this,MainActivity.class);
                startActivity(back);
                DownloaderMenu.this.finish();
            }
        });
    }
}
