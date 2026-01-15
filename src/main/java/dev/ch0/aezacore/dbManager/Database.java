package dev.ch0.aezacore.dbManager;

import java.sql.Connection;
import java.sql.SQLException;

public interface Database {
    Connection getConnection() throws SQLException;

    void shutdown();
}