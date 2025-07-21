package com.yixu.Util.Thread;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

public class ServerThreadUtils {

    private static Plugin plugin;

    public static void init(Plugin plugin) {
        ServerThreadUtils.plugin = plugin;
    }

    public static void runAsyncTask(Runnable task) {
        Bukkit.getScheduler().runTaskAsynchronously(plugin, task);
    }

    public static void runSyncTask(Runnable task) {
        Bukkit.getScheduler().runTask(plugin, task);
    }

}
