package dev.ch0.aezacore.chat;

import org.bukkit.entity.Player;

public class chatMessages {
    public static void sendChatMessage(Player player, String name, String message) {
        player.sendMessage("§a[ §fAeza §a] [ §f" + name + " §a]§f " + message);
    }
}
