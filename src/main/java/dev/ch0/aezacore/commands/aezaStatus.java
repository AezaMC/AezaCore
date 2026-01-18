package dev.ch0.aezacore.commands;

import dev.ch0.aezacore.AezaCore;
import dev.ch0.aezacore.initApi.AezaAddon;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static dev.ch0.aezacore.chat.chatMessages.sendChatMessage;

public class aezaStatus implements CommandExecutor, TabExecutor {


    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String @NotNull [] args) {
        sendChatMessage(sender, "Core", "§aLoaded Aeza Addons:§f");

        AezaCore core = (AezaCore) Bukkit.getPluginManager().getPlugin("AezaCore");
        List<AezaAddon> addons = core.getAddons();
        if (!addons.isEmpty()) {
            for (AezaAddon addon : addons) {
                sendChatMessage(sender, "Core",
                        "§a - §f" + addon.name() + " " + Bukkit.getPluginManager().getPlugin(addon.name()).getPluginMeta().getVersion());
            }
        } else {
            sendChatMessage(sender, "Core", "  §cNone§f");
        }


        sendChatMessage(sender, "Core", "§cAeza Addons That Failed To Load:§f");
        List<AezaAddon> failedAddons = core.getFailedAddons();
        if (!failedAddons.isEmpty()) {
            for (AezaAddon addon : failedAddons) {
                sendChatMessage(sender, "Core",
                        "§c - §f" + addon.name() + " " + Bukkit.getPluginManager().getPlugin(addon.name()).getPluginMeta().getVersion());
            }
        } else {
            sendChatMessage(sender, "Core", "   §cNone§f");
        }

        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String @NotNull [] args) {
        return List.of();
    }
}
