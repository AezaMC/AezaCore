package dev.ch0.aezacore.dbManager;

import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLiteDatabase implements Database {

    private final Connection connection;

    public SQLiteDatabase(JavaPlugin plugin, String fileName) throws SQLException {
        File folder = plugin.getDataFolder();
        if (!folder.exists()) {
            folder.mkdirs();
        }

        File file = new File(folder, fileName + ".db");
        String url = "jdbc:sqlite:" + file.getAbsolutePath();
        connection = DriverManager.getConnection(url);
    }

    @Override
    public Connection getConnection() throws SQLException {
        return connection;
    }

    @Override
    public void shutdown() {
        try {
            connection.close();
        } catch (SQLException ignored) {
        }
    }
}
