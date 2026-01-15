package dev.ch0.aezacore.dbManager;

import org.bukkit.plugin.java.JavaPlugin;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DatabaseManager {

    private final ExecutorService executor = Executors.newSingleThreadExecutor();
    private final Database database;

    public DatabaseManager(JavaPlugin plugin, Database database) {
        this.database = database;
    }

    public void run(SQLConsumer<Connection> action) {
        executor.execute(() -> {
            try {
                action.accept(database.getConnection());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }

    public void shutdown() {
        executor.shutdown();
        database.shutdown();
    }
}
