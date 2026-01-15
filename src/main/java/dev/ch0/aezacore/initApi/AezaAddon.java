package dev.ch0.aezacore.initApi;

import dev.ch0.aezacore.AezaCore;

public interface AezaAddon {
    String name();

    String GetCoreVer();

    void load(AezaCore core);
}