package dev.ch0.aezacore.commands;

import dev.ch0.aezacore.AezaCore;
import dev.ch0.aezacore.initApi.AezaAddon;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.stream.Collectors;

import static dev.ch0.aezacore.chat.chatMessages.sendChatMessage;

public class aezaStatus implements CommandExecutor, TabExecutor {


    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String @NotNull [] args) {
        sendChatMessage((Player) sender, "Core", "Loaded Aeza Plugins:");

        AezaCore core = (AezaCore) Bukkit.getPluginManager().getPlugin("AezaCore");
        List<AezaAddon> addons = core.getAddons();
        sendChatMessage((Player) sender, "Core", "    " + addons.stream()
                .map(AezaAddon::name)
                .collect(Collectors.joining(", ")));

        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String @NotNull [] args) {
        return List.of();
    }
}
