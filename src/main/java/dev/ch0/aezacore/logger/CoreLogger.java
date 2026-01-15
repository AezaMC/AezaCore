package dev.ch0.aezacore.logger;

import static dev.ch0.aezacore.logger.BaseLogger.send;

public class CoreLogger {
    public static void LogInit() {
        send("§aInitializing Aeza");
    }

    public static void LogInitDone() {
        send("§aFinished Initializing Aeza");
    }

    public static void LogAddonInit() {
        send("§aInitializing Aeza Addons");
    }

    public static void LogAddonInitDone() {
        send("§aFinished Initializing Aeza Addons");
    }

    public static void LogAddonRegStart() {
        send("§aRegistering Aeza Addons");
    }

    public static void LogAddonRegDone() {
        send("§aFinished Registering Aeza Addons");
    }

    public static void LogAddonReg(String name) {
        send("    Starting registry process for " + name);
    }
}