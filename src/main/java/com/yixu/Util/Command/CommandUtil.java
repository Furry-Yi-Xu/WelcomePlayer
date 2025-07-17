package com.yixu.Util.Command;

import com.yixu.Util.Message.MessageUtil;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class CommandUtil {

    public static void CommandWithPermission(String sender, String command, Player player) {

        switch (sender) {
            case "console":
                ConsoleCommandSender console = Bukkit.getConsoleSender();
                Bukkit.dispatchCommand(console, command);
                MessageUtil.sendMessage(player, "welcome.welcome_succeed");
                break;
            case "op":
                // ToDo
                break;
            case "player":
                player.performCommand(command);
                MessageUtil.sendMessage(player, "welcome.welcome_succeed");
                break;
            default:
                player.sendMessage("未知的命令执行者，请检查配置！");
                break;
        }

    }

}
