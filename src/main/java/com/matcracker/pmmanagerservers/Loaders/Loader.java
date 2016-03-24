package com.matcracker.pmmanagerservers.Loaders;

import java.io.File;
import java.io.IOException;

import com.matcracker.pmmanagerservers.API.UtilityServersAPI;
import com.matcracker.pmmanagerservers.Utility.Utility;
import com.matcracker.pmmanagerservers.Utility.UtilityServers;

public class Loader {
    /** _____           _        _   __  __ _                   __  __                                   _____
     *|  __ \         | |      | | |  \/  (_)                 |  \/  |                                 / ____|
     *| |__) |__   ___| | _____| |_| \  / |_ _ __   ___ ______| \  / | __ _ _ __   __ _  __ _  ___ _ _| (___   ___ _ ____   _____ _ __ ___
     *|  ___/ _ \ / __| |/ / _ \ __| |\/| | | '_ \ / _ \______| |\/| |/ _` | '_ \ / _` |/ _` |/ _ \ '__\___ \ / _ \ '__\ \ / / _ \ '__/ __|
     *| |  | (_) | (__|   <  __/ |_| |  | | | | | |  __/      | |  | | (_| | | | | (_| | (_| |  __/ |  ____) |  __/ |   \ V /  __/ |  \__ \
     *|_|   \___/ \___|_|\_\___|\__|_|  |_|_|_| |_|\___|      |_|  |_|\__,_|_| |_|\__,_|\__, |\___|_| |_____/ \___|_|    \_/ \___|_|  |___/
     *                                                                                   __/ |
     *                                                                                  |___/
     *Copyright (C) 2015 @author matcracker
     *
     *This program is free software: you can redistribute it and/or modify
     *it under the terms of the GNU Lesser General Public License as published by
     *the Free Software Foundation, either version 3 of the License, or
     *(at your option) any later version.
     */

    public static void startLoader() throws InterruptedException, IOException{

        String[] dirsName = {
                "Data",
                "ServersName",
                "Path",
                "Performance",
                "Utils",
                "Installations",
                "Languages",
                "Backups",
                "Backups" + File.separator + "Status",
                "Backups" + File.separator + "Servers"
        };

        //File checkLicense = new File("LICENSE.pdf");
        File dirMaker;

        boolean[] firstStart = new boolean[dirsName.length];

        for(int i = 0; i < dirsName.length; i++){
            firstStart[i] = false;
            dirMaker = new File(dirsName[i]);
            if(!dirMaker.exists()){
                firstStart[i] = true;
                dirMaker.mkdir(); //Make first directory for the start.pm
            }
        }

        if(!firstStart[(int)(Math.random() * dirsName.length)]){
            return;
        }else {
            System.out.println("Preparing the first start...");
            Thread.sleep(1500);

            for(int i = 1; i < dirsName.length; i++){
                dirMaker = new File(dirsName[i]);
                dirMaker.mkdir();
            }

            for(int i = 0; i <= 100; i++)
                System.out.println("Loading resource " + i + "%");

            completeLoader();
        }
    }

    public static void completeLoader() throws IOException{
        int nservers = 1;
        if(UtilityServers.checknservers.exists()){
            nservers = Utility.readIntData(new File("Data" + File.separator + "nservers.pm"));
            return;
        }else{
            do{
                //Utility.cleanScreen();
                //System.out.println("========================<PocketMine Manager Servers>============================");
                //System.out.println("-------------------------<Complete the informations>----------------------------");
                //System.out.print("How many servers do you want to manage? <1/2/3/.../10> : ");

                try{
                    nservers = Integer.valueOf(Utility.keyword.readLine());

                }catch (IOException e){
                    System.out.println(Utility.inputError);
                }

                if(nservers > 10){
                    //System.out.println("ERROR! You have exceeded the maximum number of servers available. Please reduce the amount!");
                    Utility.keyword.readLine();

                }else if(nservers <= 0){
                    //System.out.println("ERROR! You have to manage one or more server! (MAX TEN!!)");
                    Utility.keyword.readLine();
                }
            }while(nservers > 10 || nservers <= 0);

            UtilityServersAPI.setNumberServer(nservers);

        }

        Utility.checking(UtilityServers.checkNameServer, UtilityServers.checkPath);

        //Utility.cleanScreen();
        System.out.println("========================<PocketMine Manager Servers>============================");
        System.out.println("-------------------------<Complete the informations>----------------------------");
        System.out.printf("If you do not enter a name for your server , by default it will be '%s'\n", UtilityServers.defaultServersName);

        if(nservers >= 1){
            if(!UtilityServers.checkNameServer[nservers - 1]){
                return;
            }else{
                Utility.selection(nservers, UtilityServers.nameServers, UtilityServers.numberServers, UtilityServers.numberServers2);

                for(int i = 1; i <= nservers; i++)
                    UtilityServersAPI.setNameServer(i - 1, UtilityServers.nameServers[i-1]);
            }
        }else{
            System.out.println(Utility.generalError);
        }

        System.out.println("Complete! Press ENTER to continue.");
        Utility.keyword.readLine();

    }
}