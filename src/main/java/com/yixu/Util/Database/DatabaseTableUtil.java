package com.yixu.Util.Database;

import com.yixu.Database.DatabaseManager;
import org.bukkit.entity.Player;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

public class DatabaseTableUtil {

    public static void createTable() throws SQLException {

        String sql = "CREATE TABLE IF NOT EXISTS player_logins (" +
                "uuid VARCHAR(36) PRIMARY KEY," +
                "name VARCHAR(32) NOT NULL" +
                ");";

        Connection connection = DatabaseManager.getConnection();
        Statement statement = connection.createStatement();

        statement.execute(sql);

        connection.close();

    }

    public static boolean playerExists(Player player) throws SQLException {

        UUID uuid = player.getUniqueId();

        String sql = "SELECT 1 FROM player_logins WHERE uuid = ? LIMIT 1";

        Connection connection = DatabaseManager.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, uuid.toString());

        boolean queryResult = statement.executeQuery().next();

        connection.close();

        return queryResult;

    }

    public static void recordPlayer(Player player) throws SQLException {

        UUID uuid = player.getUniqueId();
        String name = player.getName();

        String sql = "INSERT INTO player_logins (uuid, name) VALUES (?, ?) " +
                "ON DUPLICATE KEY UPDATE name = ?";

        Connection connection = DatabaseManager.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, uuid.toString());
        statement.setString(2, name);
        statement.setString(3, name);

        statement.executeUpdate();

        connection.close();

    }

}
