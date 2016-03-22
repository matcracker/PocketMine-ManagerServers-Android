package com.matcracker.pmmanagerservers;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.matcracker.pmmanagerservers.Settings.Resetter;
import com.matcracker.pmmanagerservers.Utility.Utility;

import java.io.File;
import java.io.IOException;

public class ResetterMenu extends Activity
{



    public static String[] dirsName = {
            "Data",
            "ServersName",
            "Path",
            "Performance",
            "Utils",
            "Installations",
            "Languages",
            //"Backups",
            "Backups" + File.separator + "Status",
            "Backups" + File.separator + "Servers"
    };

    private Button resetprog,resetserv,resetall,indietro;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.resetter);

        resetprog=(Button) findViewById(R.id.button2);
        resetserv=(Button) findViewById(R.id.button3);
        resetall=(Button) findViewById(R.id.button4);
        indietro=(Button) findViewById(R.id.button6);

        resetprog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    //resetProgram();
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

        indietro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Indietro = new Intent(ResetterMenu.this, MainActivity.class);
                startActivity(Indietro);
            }
        });
    }

    public static void resetProgram() throws IOException {
        String confirm = null;
        //File dirDeleter;
        do{
            /*Utility.cleanScreen();
            System.out.println("========================<PocketMine Manager Servers>============================");
            System.out.println("-------------------------------<Reset Program>----------------------------------");
            System.out.print("Are you sure to want reset data of servers (only program)? <y/n>: ");
            confirm = Utility.keyword.readLine();*/




        }while(!confirm.equalsIgnoreCase("y") && !confirm.equalsIgnoreCase("n"));

        if(confirm.equalsIgnoreCase("y")){
            for(int i = 0; i < dirsName.length; i++)
                Utility.deleteFile(dirsName[i]); //TODO Check why some file can't be deleted
            System.out.println("Closing program...");
            //Desktop.getDesktop().open(new File("run.bat"));

        }else{
            Resetter.resetterMenu();
        }
    }

    public static void resetServers(){
        //Utility.cleanScreen();
        System.out.println("========================<PocketMine Manager Servers>============================");
        System.out.println("-------------------------------<Reset Program>----------------------------------");
    }

    public static void resetAllData(){

    }

}
