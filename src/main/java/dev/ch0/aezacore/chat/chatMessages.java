package dev.ch0.aezacore.chat;

import org.bukkit.command.CommandSender;

public class chatMessages {
    public static void sendChatMessage(CommandSender player, String name, String message) {
        player.sendMessage("§a[ §fAeza §a] [ §f" + name + " §a]§f " + message);
    }
}
