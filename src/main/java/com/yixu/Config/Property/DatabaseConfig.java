package com.yixu.Config.Property;

import com.yixu.Config.ConfigManager;

public class DatabaseConfig {

    public static String getHost(){
        return ConfigManager.
                getDatabaseConfig().
                getConfig().
                getString("mysql.host");
    }

    public static int getPort(){
        return ConfigManager.
                getDatabaseConfig().
                getConfig().
                getInt("mysql.port");
    }

    public static String getDatabase(){
        return ConfigManager.
                getDatabaseConfig().
                getConfig().
                getString("mysql.database");
    }

    public static String getUser(){
        return ConfigManager.
                getDatabaseConfig().
                getConfig().
                getString("mysql.user");
    }

    public static String getPassword(){
        return ConfigManager.
                getDatabaseConfig().
                getConfig().
                getString("mysql.password");
    }

    public static int getPoolSize(){
        return ConfigManager.
                getDatabaseConfig().
                getConfig().
                getInt("mysql.pool-size");
    }

}