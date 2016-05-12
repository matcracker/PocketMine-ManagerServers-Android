package com.matcracker.pmmanagerservers.Loaders;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.InputType;
import android.widget.EditText;
import android.widget.Toast;

import com.matcracker.pmmanagerservers.API.StatusAPI;
import com.matcracker.pmmanagerservers.API.UtilityServersAPI;
import com.matcracker.pmmanagerservers.Utility.Utility;

import java.io.File;

public class LoaderAndroid {

    public static void createDirectory(Context context) {
        String[] dirsName = {
                Utility.pathSD,
                Utility.pathSD + File.separator + "Data",
                Utility.pathSD + File.separator + "ServersName",
                Utility.pathSD + File.separator + "Path",
                Utility.pathSD + File.separator + "Performance",
                Utility.pathSD + File.separator + "Utils",
                Utility.pathSD + File.separator + "Installations",
                Utility.pathSD + File.separator + "Installations" + File.separator + "Status",
                Utility.pathSD + File.separator + "Installations" + File.separator + "Version",
                Utility.pathSD + File.separator + "Installations" + File.separator + "Downloads",
                Utility.pathSD + File.separator + "Languages",
                Utility.pathSD + File.separator + "Backups",
                Utility.pathSD + File.separator + "Backups" + File.separator + "Status",
                Utility.pathSD + File.separator + "Backups" + File.separator + "Servers"
        };

        for (int i = 0; i < dirsName.length; i++) {
            File path = new File(dirsName[i]);
            if (!path.exists()) {
                Toast.makeText(context, "Path Created " + dirsName[i], Toast.LENGTH_LONG).show();
                path.mkdir();
            }
        }

        completeLoader(context);
    }

    public static void completeLoader(Context context) {

        final File checknservers = new File(Utility.pathSD + File.separator + "Data" + File.separator + "nservers.pm");
        int nservers = 5;

        if (checknservers.exists()) {
            return;
        } else {

            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle("Input");


            final EditText input = new EditText(context);

            input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_CLASS_NUMBER);
            builder.setView(input);
            builder.setMessage("Number of Server");
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    String nservers = input.getText().toString();
                    Utility.writeIntData(checknservers, Integer.parseInt(nservers));
                }
            });
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });

            builder.show();
        }

        try {
            nservers = Utility.readIntData(checknservers);
        } catch(Exception e) {

        }
        /*Intent fileIntent = new Intent(Intent.ACTION_GET_CONTENT);
        fileIntent.setType("file/*");
        startActivityForResult(fileIntent,1);*/

        if (nservers >= 1) {
            String[] nameServers = new String[nservers];
            String[] path = new String[nservers];

            if (UtilityServersAPI.checkServersFile("ServersName", "ServerName_", nservers - 1)) {
                return;
            } else {
                selection(nservers, nameServers, path);

                for (int i = 1; i <= nservers; i++) {
                    UtilityServersAPI.setNameServer(i - 1, nameServers[i - 1]);
                    StatusAPI.setStatus("Not Downloaded", i - 1);
                    StatusAPI.setVersion("No version", i - 1);
                    StatusAPI.setPerformance("Personal", i - 1);
                    UtilityServersAPI.setPath(i - 1, path[i - 1]);
                }
            }
        }
    }

    private static void selection(int nservers, String[] nameServers, String[] path) {
        for (int i = 0; i <= nservers; i++) {
            Utility.defaultServersName = "Server_Minecraft_PE_" + i;
            //System.out.printf("%d) Name of %d° server: ", i, i);

            nameServers[i-1] = Utility.defaultServersName;
        }
    }
}
