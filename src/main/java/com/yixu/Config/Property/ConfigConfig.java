package com.yixu.Config.Property;

import com.yixu.Config.ConfigManager;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class ConfigConfig {

    public static String getJoinSoundName() {
        return ConfigManager.
                getConfigConfig().
                getConfig().
                getString("join.sound");
    }

    public static int getJoinSoundVolume() {
        return ConfigManager.
                getConfigConfig().
                getConfig().
                getInt("join.volume");
    }

    public static int getJoinSoundPitch() {
        return ConfigManager.
                getConfigConfig().
                getConfig().
                getInt("join.pitch");
    }

    public static String getClickContent() {
        return ConfigManager.
                getConfigConfig().
                getConfig().
                getString("welcome.click");
    }

    public static String getWelcomeContent() {
        List<String> welcomeContent = ConfigManager.
                getConfigConfig().
                getConfig().
                getStringList("welcome.content");
        return welcomeContent.get(ThreadLocalRandom.current().nextInt(welcomeContent.size()));
    }

    public static String getActionSender() {
        return ConfigManager.
                getConfigConfig().
                getConfig().
                getString("welcome.action.sender");
    }

    public static String getActionCommand() {
        return ConfigManager.
                getConfigConfig().
                getConfig().
                getString("welcome.action.command");
    }

}
