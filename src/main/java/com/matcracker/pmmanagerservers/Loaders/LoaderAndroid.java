package com.matcracker.pmmanagerservers.Loaders;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LoaderAndroid {

    public static void CreateDirectory() {
        String[] dirsName = {
                "/data/data/com.matcracker.pmmanagerservers/files/Data",
                "/data/data/com.matcracker.pmmanagerservers/files/ServersName",
                "/data/data/com.matcracker.pmmanagerservers/files/Path",
                "/data/data/com.matcracker.pmmanagerservers/files/Performance",
                "/data/data/com.matcracker.pmmanagerservers/files/Utils",
                "/data/data/com.matcracker.pmmanagerservers/files/Installations",
                "/data/data/com.matcracker.pmmanagerservers/files/Installations" + File.separator + "Status",
                "/data/data/com.matcracker.pmmanagerservers/files/Installations" + File.separator + "Version",
                "/data/data/com.matcracker.pmmanagerservers/files/Installations" + File.separator + "Downloads",
                "/data/data/com.matcracker.pmmanagerservers/files/Languages",
                "/data/data/com.matcracker.pmmanagerservers/files/Backups",
                "/data/data/com.matcracker.pmmanagerservers/files/Backups" + File.separator + "Status",
                "/data/data/com.matcracker.pmmanagerservers/files/Backups" + File.separator + "Servers"
        };

        File path;
        for(int i = 0; i < dirsName.length; i++){
            path = new File(dirsName[i]);
            if(!path.exists()){
                path.mkdir();
            }
        }
        try {
            LoaderAndroid.completeLoader();
        }
        catch (Exception e) {
            //Errors
        }
        /*FileOutputStream fOut;
        fOut = openFileOutput("prova.pm", MODE_WORLD_READABLE);
        String str = "data";
        fOut.write(str.getBytes());
        fOut.close();*/
    }

    public static void completeLoader() throws IOException {

        int nservers = 1;
        File checknservers = new File("/data/data/com.matcracker.pmmanagerservers/files/Data" + File.separator + "nservers.pm");

        if(checknservers.exists()){

            FileReader readerData = null;
            int data = 0;

            try{
                readerData = new FileReader(checknservers);
            }catch (FileNotFoundException e1) {
            }

            try{
                readerData = new FileReader(checknservers);
                char[] chars = new char[(int) checknservers.length()];
                data = readerData.read(chars);
            }catch (IOException e){
                //Errors
            }

        }else{

            /*AlertDialog.Builder builder = new AlertDialog.Builder(LoaderAndroid.this);
            builder.setTitle("Title");


            final EditText input = new EditText(LoaderAndroid.this);

            input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_CLASS_NUMBER);
            builder.setView(input);
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    String prova = input.getText().toString();
                }
            });
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });

            builder.show();*/
        }
    }
}
