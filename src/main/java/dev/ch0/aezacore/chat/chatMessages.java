package dev.ch0.aezacore.chat;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.command.CommandSender;

public class chatMessages {
    static MiniMessage mm = MiniMessage.miniMessage();
    public static void sendChatMessage(CommandSender player, String name, String message) {
        player.sendMessage(mm.deserialize("<green>[ <white>Aeza <green>] [ <white>" + name + " <green>]<white> " + message));
    }
}
