package com.yixu.Command.MainCommand;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainTabCompleter implements TabCompleter {

    private static final List<String> SUB_COMMANDS = Arrays.asList(
            "reload",
            "token"
    );

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {

        List<String> subCommand = new ArrayList<>();

        if (args.length == 1) {
            String currentInput = args[0].toLowerCase();
            for (String sub : SUB_COMMANDS) {
                if (sub.startsWith(currentInput)) {
                    subCommand.add(sub);
                }
            }
        }

        return subCommand;
    }
}
