package dev.ch0.aezacore.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static dev.ch0.aezacore.chat.chatMessages.sendChatMessage;

public class aezaHelp implements CommandExecutor, TabExecutor {


    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String @NotNull [] args) {
        sendChatMessage(sender, "Core", "Heres some ways of learning how to use / get support for the §aAeza§f ecosystem!");
        sendChatMessage(sender, "Core", "  - §bThe official discord!§f (Coming soon)");
        sendChatMessage(sender, "Core", "  - §aThe official documentation!§f");

        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String @NotNull [] args) {
        return List.of();
    }
}
