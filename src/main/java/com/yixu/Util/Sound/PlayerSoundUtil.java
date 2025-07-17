package com.yixu.Util.Sound;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class PlayerSoundUtil {

    public static void sendAllPlayerSound(Player player, String sound, int volume, int pitch) {
        Sound soundName = Sound.valueOf(sound.toUpperCase());
        for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            if (onlinePlayer.getUniqueId().equals(player.getUniqueId())) {
                continue;
            }
            onlinePlayer.playSound(onlinePlayer, soundName, volume, pitch);
        }
    }

}
