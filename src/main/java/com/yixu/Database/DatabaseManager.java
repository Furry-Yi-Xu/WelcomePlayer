package com.yixu.Database;

import com.yixu.Config.Property.DatabaseConfig;
import com.yixu.Util.Database.DatabaseTableUtil;
import com.yixu.WelcomePlayer;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.bukkit.plugin.Plugin;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseManager {

    private static HikariDataSource dataSource;
    private static Plugin plugin;

    public static void init(Plugin plugin) throws SQLException {
        DatabaseManager.plugin = plugin;

        String host = DatabaseConfig.getHost();
        int port = DatabaseConfig.getPort();
        String database = DatabaseConfig.getDatabase();
        String user = DatabaseConfig.getUser();
        String password = DatabaseConfig.getPassword();
        int poolSize = DatabaseConfig.getPoolSize();

        HikariConfig hikariConfig = new HikariConfig();

        hikariConfig.setJdbcUrl("jdbc:mysql://" + host + ":" + port + "/" + database + "?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC");
        hikariConfig.setUsername(user);
        hikariConfig.setPassword(password);
        hikariConfig.setMaximumPoolSize(poolSize);
        hikariConfig.setPoolName(WelcomePlayer.class.getName() + "-HikariPool");

        DatabaseManager.dataSource = new HikariDataSource(hikariConfig);

        createPlayerJoinTable();

    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public static void closeConnection() {
        if (dataSource != null && !dataSource.isClosed()) {
            dataSource.close();
        }
    }

    public static void createPlayerJoinTable() throws SQLException {
        DatabaseTableUtil.createTable();
    }

}
