package dev.ch0.aezacore;

import dev.ch0.aezacore.dbManager.DatabaseManager;
import dev.ch0.aezacore.dbManager.SQLiteDatabase;
import dev.ch0.aezacore.initApi.AezaAddon;
import dev.ch0.aezacore.initApi.CoreReadyEvent;
import dev.ch0.aezacore.initApi.VersionChecker;
import dev.ch0.aezacore.logger.CoreLogger;
import dev.ch0.aezacore.logger.CounterLogger;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public final class AezaCore extends JavaPlugin {
    private final List<AezaAddon> addons = new ArrayList<>();
    private final List<AezaAddon> failedAddons = new ArrayList<>();
    private DatabaseManager databaseManager;

    public DatabaseManager getDatabaseManager() {
        return databaseManager;
    }

    @Override
    public void onEnable() {
        getServer().getScheduler().runTask(this, () -> {
            CoreLogger.LogInit();

            CounterLogger initCounter = new CounterLogger(1, 1);
            initCounter.Step("Initializing database");
            try {
                SQLiteDatabase db = new SQLiteDatabase(this, "aeza");
                databaseManager = new DatabaseManager(this, db);
                initCounter.Step("Initializing database");
            } catch (Exception e) {
                e.printStackTrace();
                getServer().getPluginManager().disablePlugin(this);
                return;
            }

            CoreLogger.LogAddonRegStart();
            getServer().getPluginManager().callEvent(new CoreReadyEvent());
            CoreLogger.LogAddonRegDone();

            CoreLogger.LogAddonInit();
            loadAddons();
            CoreLogger.LogAddonInitDone();

            CoreLogger.LogInitDone();
        });
    }

    public void registerAddon(AezaAddon addon) {
        CoreLogger.LogAddonReg(addon.name());
        CounterLogger regCounter = new CounterLogger(2, 2);

        regCounter.Step("Verifying required core version");
        String reqVer = addon.GetCoreVer();
        if (!VersionChecker.Satisfies(this.getDescription().getVersion(), reqVer)) {
            getLogger().severe("[ Aeza ] plugin " + addon.name() + " requires AezaCore version " + reqVer + " but only " + this.getDescription().getVersion() + " is present! Plugin will not load");
            failedAddons.add(addon);
            return;
        }
        regCounter.Step("Adding addon to registry");
        addons.add(addon);
    }

    private void loadAddons() {
        int t = addons.size();
        int i = 1;
        CounterLogger counterLogger = new CounterLogger(1, t);

        for (AezaAddon addon : addons) {
            counterLogger.Step("Initializing addon " + addon.name());
            addon.load(this);
            i++;
        }
    }

    @Override
    public void onDisable() {
        if (databaseManager != null) {
            databaseManager.shutdown();
        }
        getLogger().info("AezaCore has been disabled");
    }
}
