package com.matcracker.pmmanagerservers.API;

import com.matcracker.pmmanagerservers.Utility.Utility;

public class APIManager
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
    private final String APIVersion = "0.1";

    public String getAPIVersion(){
        return APIVersion;
    }

    /*public String getVersion(){
        return Utility.version;
    }*/
}
