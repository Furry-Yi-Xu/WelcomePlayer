package com.yixu.Command.SubCommand;

import com.yixu.Config.ConfigManager;
import com.yixu.Util.Message.MessageUtil;
import com.yixu.Util.Permission.PermissionCheck;
import com.yixu.Util.Permission.PermissionNodes;
import org.bukkit.command.CommandSender;

public class ReloadCommand {

    public ReloadCommand(CommandSender sender) {
        if (PermissionCheck.checkPlayerWithPermission(sender, PermissionNodes.RELOAD)) {
            ConfigManager.reloadAll();
            MessageUtil.sendMessage(sender, "commands.reload.reload-succeed");
        }
    }

}
