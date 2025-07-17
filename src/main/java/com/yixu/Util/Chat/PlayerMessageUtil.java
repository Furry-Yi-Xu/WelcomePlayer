package com.yixu.Util.Chat;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class PlayerMessageUtil {

    public static void sendAllPlayerMessage(Player player, Component text) {
        for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            if (onlinePlayer.getUniqueId().equals(player.getUniqueId())) {
                continue;
            }
            onlinePlayer.sendMessage(text);
        }
    }

}
