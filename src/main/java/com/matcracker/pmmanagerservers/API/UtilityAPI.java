package com.matcracker.pmmanagerservers.API;

import java.io.File;

import com.matcracker.pmmanagerservers.Utility.Utility;

public class UtilityAPI
{
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
    public static int getNumberServers(String folder){
        if(folder.contains("/"))
            folder = folder.replace("/", File.separator);

        return Utility.readIntData(new File(folder));
    }

    public static void setNameServer(File file, String content){
        Utility.writeStringData(file, content);
    }

    public static void setNumberServer(File file, int content){
        Utility.writeIntData(file, content);
    }

    public static String getNameServer(String folder){
        if(folder.contains("/"))
            folder = folder.replace("/", File.separator);

        return Utility.readStringData(new File(folder));
    }
}
