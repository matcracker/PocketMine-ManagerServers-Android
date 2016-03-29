package com.matcracker.pmmanagerservers.Installer;

import android.provider.MediaStore;

import java.io.File;
import java.io.IOException;

import com.matcracker.pmmanagerservers.Utility.Utility;

public class ManagerInstaller {
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

    public static void managerInstallerMenu() throws IOException{
        Utility.cleanScreen();
        System.out.println("========================<PocketMine Manager Servers>============================");
        System.out.println("-------------------------<Initialize PocketMine-MP>-----------------------------");
        System.out.println("1- Download");
        System.out.println("2- Install");
        System.out.println("3- Back");
        System.out.print("\nChoose what do you want to do: ");
        String inst = Utility.keyword.readLine();

        if(inst.equalsIgnoreCase("1"))
            Downloader.downloaderMenu();

        if(inst.equalsIgnoreCase("2"))
            Installator.installatorMenu();

        if(inst.equalsIgnoreCase("3"))
            return;

    }

    public static void changeInstallationsFile(String path, String version) throws IOException{
        File newPhar = new File(path + File.separator + "PocketMine-MP.phar");
        File oldPhar = new File(path + File.separator + "PocketMine-MP_OLD.phar");

        File pharToMove = new File("Utils" + File.separator + "PocketMine-MP_" + version + ".phar");
        File pharDest = new File(path + File.separator + "PocketMine-MP_" + version + ".phar");

        /*if(newPhar.exists()){
            if(oldPhar.exists()){
                MediaStore.Files.delete(oldPhar.toPath());
                MediaStore.Files.copy(pharToMove.toPath(), pharDest.toPath(), StandardCopyOption.REPLACE_EXISTING);
                newPhar.renameTo(oldPhar);
                pharDest.renameTo(newPhar);
            }else{
                newPhar.renameTo(oldPhar);
                MediaStore.Files.copy(pharToMove.toPath(), pharDest.toPath(), StandardCopyOption.REPLACE_EXISTING);
                pharDest.renameTo(newPhar);
            }
        }else{
            MediaStore.Files.copy(pharToMove.toPath(), pharDest.toPath(), StandardCopyOption.REPLACE_EXISTING);
            pharDest.renameTo(newPhar);
        }*/

    }
}