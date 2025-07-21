package com.yixu.Event.Vanilla;

import com.yixu.Task.PlayerJoinTask;
import com.yixu.Util.Thread.ServerThreadUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;

import java.sql.SQLException;

public class PlayerJoin implements Listener {

    private Plugin plugin;

    public PlayerJoin(Plugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) throws SQLException {

        Player player = event.getPlayer();

        ServerThreadUtils.runAsyncTask(new PlayerJoinTask(player));

    }

}
