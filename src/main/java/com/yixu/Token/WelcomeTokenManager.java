package com.yixu.Token;

import org.bukkit.entity.Player;

import java.util.*;

public class WelcomeTokenManager {

    private static final Map<UUID, String> welcomePlayerToken = new HashMap<>();
    private static final Map<String, Set<UUID>> clickPlayerUUID = new HashMap<>();

    public static void addUsedPlayer(Player player, String token) {
        Set<UUID> storedUUID = clickPlayerUUID.get(token);
        storedUUID.add(player.getUniqueId());
    }

    public static Boolean isUsedPlayer(Player player, String token) {
        Set<UUID> storedUUID = clickPlayerUUID.get(token);
        return storedUUID.contains(player.getUniqueId());
    }

    public static Boolean isValidToken(String token) {
        return welcomePlayerToken.containsValue(token);
    }

    public static String getWelcomeToken(Player player) {
        return welcomePlayerToken.get(player.getUniqueId());
    }

    public static String generateWelcomeToken(Player player) {
        String token = UUID.randomUUID().toString().replace("-", "");
        welcomePlayerToken.put(player.getUniqueId(), token);
        clickPlayerUUID.put(token, new HashSet<>());
        return token;
    }

}
