package com.yixu.Config;

import com.yixu.Config.Base.BaseConfig;
import com.yixu.Config.Property.DatabaseConfig;
import org.bukkit.plugin.Plugin;

import java.io.FileNotFoundException;

public class ConfigManager {

    private static BaseConfig configConfig;
    private static BaseConfig messagesConfig;
    private static BaseConfig databaseConfig;

    public static void init(Plugin plugin) throws FileNotFoundException {
        configConfig = new BaseConfig(plugin, "config.yml");
        messagesConfig = new BaseConfig(plugin, "messages.yml");
        databaseConfig = new BaseConfig(plugin, "database.yml");
    }

    public static BaseConfig getConfigConfig() {
        return configConfig;
    }

    public static BaseConfig getMessagesConfig() {
        return messagesConfig;
    }

    public static BaseConfig getDatabaseConfig() {
        return databaseConfig;
    }

    public static void reloadAll() {
        configConfig.reload();
        messagesConfig.reload();
        databaseConfig.reload();
    }
}
