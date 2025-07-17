package com.yixu.Event.Vanilla;

import com.yixu.Config.Property.ConfigConfig;
import com.yixu.Token.WelcomeTokenManager;
import com.yixu.Util.Chat.PlayerMessageUtil;
import com.yixu.Util.Database.DatabaseTableUtil;
import com.yixu.Util.Sound.PlayerSoundUtil;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.event.ClickEvent;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.sql.SQLException;

public class PlayerJoin implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) throws SQLException {

        Player player = event.getPlayer();

        if (DatabaseTableUtil.playerExists(player)) {
            return;
        }

        DatabaseTableUtil.recordPlayer(player);

        String token = WelcomeTokenManager.generateWelcomeToken(player);

        String soundName = ConfigConfig.getJoinSoundName();
        int soundVolume = ConfigConfig.getJoinSoundVolume();
        int soundPitch = ConfigConfig.getJoinSoundPitch();

        String clickContent = ConfigConfig.getClickContent();
        Component componentClickContent =
                LegacyComponentSerializer.
                        legacyAmpersand().
                        deserialize(clickContent).
                        clickEvent(ClickEvent.clickEvent(ClickEvent.Action.RUN_COMMAND, "/welcomeplayer token " + token));

        PlayerSoundUtil.sendAllPlayerSound(player, soundName, soundVolume, soundPitch);
        PlayerMessageUtil.sendAllPlayerMessage(player, componentClickContent);

    }

}
