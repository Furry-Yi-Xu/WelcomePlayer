package com.yixu.Command.SubCommand;

import com.yixu.Config.Property.ConfigConfig;
import com.yixu.Token.WelcomeTokenManager;
import com.yixu.Util.Command.CommandUtil;
import com.yixu.Util.Message.MessageUtil;
import com.yixu.Util.Permission.PermissionCheck;
import com.yixu.Util.Permission.PermissionNodes;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TokenCommand {

    public TokenCommand(CommandSender sender, String token) {
        if (!PermissionCheck.checkPlayerWithPermission(sender, PermissionNodes.TOKEN)) {
            return;
        }

        Player player = (Player) sender;

        if (!WelcomeTokenManager.isValidToken(token)) {
            MessageUtil.sendMessage(player, "welcome.not_exist_welcome");
            return;
        }

        if (WelcomeTokenManager.isUsedPlayer(player, token)) {
            MessageUtil.sendMessage(player, "welcome.already_used_welcome");
            return;
        }

        String welcomeContent = ConfigConfig.getWelcomeContent().replace("%player_name%", player.getName());
        String actionSender = ConfigConfig.getActionSender();
        String actionCommand = ConfigConfig.getActionCommand().replace("%player_name%", player.getName());

        player.chat(welcomeContent);
        CommandUtil.CommandWithPermission(actionSender, actionCommand, player);

        WelcomeTokenManager.addUsedPlayer(player, token);
    }

}
