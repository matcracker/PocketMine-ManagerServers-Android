package com.matcracker.pmmanagerservers.Installer;

import com.matcracker.pmmanagerservers.API.InstallatorAPI;
import com.matcracker.pmmanagerservers.API.UtilityServersAPI;
import com.matcracker.pmmanagerservers.Utility.Utility;

import java.io.File;
import java.io.IOException;

public class Installator
{
    /** _____           _        _   __  __ _                   __  __                                   _____
     *|  __ \         | |      | | |  \/  (_)                 |  \/  |                                 / ____|
     *| |__) |__   ___| | _____| |_| \  / |_ _ __   ___ ______| \  / | __ _ _ __   __ _  __ _  ___ _ _| (___   ___ _ ____   _____ _ __ ___
     *|  ___/ _ \ / __| |/ / _ \ __| |\/| | | '_ \ / _ \______| |\/| |/ _` | '_ \ / _` |/ _` |/ _ \ '__\___ \ / _ \ '__\ \ / / _ \ '__/ __|
     *| |  | (_) | (__|   <  __/ |_| |  | | | | | |  __/      | |  | | (_| | | | | (_| | (_| |  __/ |  ____) |  __/ |   \ V /  __/ |  \__ \
     *|_|   \___/ \___|_|\_\___|\__|_|  |_|_|_| |_|\___|      |_|  |_|\__,_|_| |_|\__,_|\__, |\___|_| |_____/ \___|_|    \_/ \___|_|  |___/
     *                                                                                   __/ |
     *                                                                                  |___/
     *Copyright (C) 2015-2016 @author matcracker
     *
     *This program is free software: you can redistribute it and/or modify
     *it under the terms of the GNU Lesser General Public License as published by
     *the Free Software Foundation, either version 3 of the License, or
     *(at your option) any later version.
     */

    public static void installatorMenu() throws IOException{
        Utility.cleanScreen();
        int nservers = UtilityServersAPI.getNumberServers();

        System.out.println("========================<PocketMine Manager Servers>============================");
        System.out.println("---------------------------<Install PocketMine-MP>------------------------------");
        for(int i = 0; i < nservers; i++){
            System.out.printf("%d) %s -> Version: %s -> Status: %s\n", i+1, UtilityServersAPI.getNameServer(i), InstallatorAPI.getVersion(i), InstallatorAPI.getStatus(i));
        }
        System.out.println((nservers + 1) + ") Back");
        System.out.print("\nOn which server do you want install PocketMine-MP?: ");
        String sel = Utility.keyword.readLine();

        if(sel.equalsIgnoreCase(String.valueOf(nservers + 1))){ //Back
            ManagerInstaller.managerInstallerMenu();
        }else{
            System.out.println("\n1- Stable (Setup File)");
            System.out.println("2- Beta (Phar File)");
            System.out.println("3- Dev (Phar File)");
            System.out.println("4- Soft (Phar File)");
            System.out.println("5- Back");

            System.out.print("\nSelect a version for your server: ");
            String ver = Utility.keyword.readLine();

            if(ver.equalsIgnoreCase("1")){ //Stable
                System.out.println("\nAvaiable types:");
                System.out.println("1) 1.4.1 API 1.11.0 Zekkou-Cake {MC:PE 0.10.x}");
                System.out.print("\nSelect the type of version: ");
                String type = Utility.keyword.readLine();

                if(type.equalsIgnoreCase("1")){
                    File installer = new File("Utils" + File.separator + "PocketMine-MP_Installer_1.4.1_x86.exe");
                    if(installer.exists()){
                        Utility.openSoftware("software", String.valueOf(installer));
                        InstallatorAPI.setVersion("Stable", Integer.valueOf(sel) - 1);
                        InstallatorAPI.setStatus("Installed", Integer.valueOf(sel) - 1);
                        Installator.installatorMenu();
                    }else{
                        System.err.println("Installer not found! Please download the installer!");
                        Utility.keyword.readLine();
                        Installator.installatorMenu();
                    }
                }
            }

            if(ver.equalsIgnoreCase("2")){ //Beta
                if(UtilityServersAPI.checkServersFile("Path", "path_", nservers-1)){
                    System.out.println("\nAvaiable types:");
                    System.out.println("1) 1.4.1 API 1.11.0 Zekkou-Cake {MC:PE 0.10.x}");
                    System.out.print("\nSelect the type of version: ");
                    String type = Utility.keyword.readLine();

                    if(type.equalsIgnoreCase("1")){
                        File beta = new File("Utils" + File.separator + "PocketMine-MP_BETA.phar");

                        if(beta.exists()){
                            System.out.print("Are you sure you want to replace the file phar with the current one? (This will create a copy)? <Y/N>: ");
                            String confirm = Utility.keyword.readLine();

                            if(confirm.equalsIgnoreCase("y")){
                                //ManagerInstaller.changeInstallationsFile(UtilityServersAPI.getPath(nservers-1), "BETA");
                            }else{
                                Installator.installatorMenu();
                            }

                        }else{
                            System.out.println("Phar file not found, before download it!");
                            Installator.installatorMenu();
                        }
                    }
                }else{
                    System.err.println("ERROR! You don't select a path in the first start");
                    Installator.installatorMenu();
                }
            }

            if(ver.equalsIgnoreCase("3")){ //Dev
                if(UtilityServersAPI.checkServersFile("Path", "path_", nservers-1)){
                    System.out.println("\nAvaiable types:");
                    System.out.println("1) 1.6 API 2.0.0 [#Dev Build 23] {MC:PE 0.15.x}");
                    System.out.print("\nSelect the type of version: ");
                    String type = Utility.keyword.readLine();

                    if(type.equalsIgnoreCase("1")){
                        File dev = new File("Utils" + File.separator + "PocketMine-MP_DEV.phar");

                        if(dev.exists()){
                            System.out.print("Are you sure you want to replace the file phar with the current one? (This will create a copy)? <Y/N>: ");
                            String confirm = Utility.keyword.readLine();

                            if(confirm.equalsIgnoreCase("y")){
                                //ManagerInstaller.changeInstallationsFile(UtilityServersAPI.getPath(nservers-1), "DEV");
                            }else{
                                Installator.installatorMenu();
                            }

                        }else{
                            System.out.println("Phar file not found, before download it!");
                            Installator.installatorMenu();
                        }
                    }
                }else{
                    System.err.println("ERROR! You don't select a path in the first start");
                    Installator.installatorMenu();
                }
            }

            if(ver.equalsIgnoreCase("4")){ //Soft
                if(UtilityServersAPI.checkServersFile("Path", "path_", nservers-1)){
                    System.out.println("\nAvaiable types:");
                    System.out.println("1) 1.5 API 1.12.0 Kappatsu-Fugu {MC:PE 0.11.x}");
                    System.out.print("\nSelect the type of version: ");
                    String type = Utility.keyword.readLine();

                    if(type.equalsIgnoreCase("1")){
                        File soft = new File("Utils" + File.separator + "PocketMine-MP_SOFT.phar");

                        if(soft.exists()){
                            System.out.print("Are you sure you want to replace the file phar with the current one? (This will create a copy)? <Y/N>: ");
                            String confirm = Utility.keyword.readLine();

                            if(confirm.equalsIgnoreCase("y")){
                                //ManagerInstaller.changeInstallationsFile(UtilityServersAPI.getPath(nservers-1), "SOFT");
                            }else{
                                Installator.installatorMenu();
                            }

                        }else{
                            System.out.println("Phar file not found, before download it!");
                            Installator.installatorMenu();
                        }
                    }
                }else{
                    System.err.println("ERROR! You don't select a path in the first start");
                    Installator.installatorMenu();
                }
            }

            if(ver.equals("5"))
                Installator.installatorMenu();
        }



    }
}
