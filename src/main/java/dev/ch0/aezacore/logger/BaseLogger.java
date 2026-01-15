package dev.ch0.aezacore.logger;

import org.bukkit.Bukkit;

public class BaseLogger {
    public static void send(String msg) {
        Bukkit.getConsoleSender().sendMessage(prefix() + " " + msg);
    }

    public static String prefix() {
        return "§a[§f Aeza §a]§f";
    }
}
