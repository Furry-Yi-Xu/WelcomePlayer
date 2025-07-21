package com.yixu.Task;

import com.yixu.Config.Property.ConfigConfig;
import com.yixu.Token.WelcomeTokenManager;
import com.yixu.Util.Chat.PlayerMessageUtil;
import com.yixu.Util.Database.DatabaseTableUtil;
import com.yixu.Util.Sound.PlayerSoundUtil;
import com.yixu.Util.Thread.ServerThreadUtils;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.event.ClickEvent;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.sql.SQLException;

public class PlayerJoinTask implements Runnable {

    private Player player;

    public PlayerJoinTask(Player player) {
        this.player = player;
    }

    @Override
    public void run() {

        boolean playerExists;

        try {
            playerExists = DatabaseTableUtil.playerExists(player);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if (playerExists) {
            return;
        }

        try {
            DatabaseTableUtil.recordPlayer(player);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        ServerThreadUtils.runSyncTask(new Runnable() {
            @Override
            public void run() {

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
        });

    }
}
