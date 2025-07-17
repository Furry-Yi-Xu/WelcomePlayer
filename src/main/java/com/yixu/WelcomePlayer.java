package com.yixu;

import com.yixu.Command.CommandManager;
import com.yixu.Command.MainCommand.MainTabCompleter;
import com.yixu.Config.ConfigManager;
import com.yixu.Database.DatabaseManager;
import com.yixu.Event.EventManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.FileNotFoundException;
import java.sql.SQLException;

public final class WelcomePlayer extends JavaPlugin {

    private static WelcomePlayer instance;

    @Override
    public void onEnable() {

        instance = this;

        saveDefaultConfig();

        try {
            ConfigManager.init(this);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        EventManager.init(this);

        try {
            DatabaseManager.init(this);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        getCommand("welcomeplayer").setExecutor(new CommandManager());
        getCommand("welcomeplayer").setTabCompleter(new MainTabCompleter());

        getLogger().info("WelcomePlayer 插件已加载！");

    }

    @Override
    public void onDisable() {

        DatabaseManager.closeConnection();
        getLogger().info("WelcomePlayer 插件已卸载！");

    }

    public static WelcomePlayer getInstance() {
        return instance;
    }
}
