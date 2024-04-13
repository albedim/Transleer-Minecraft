package me.albedim.transleer.listener.chat;

import me.albedim.transleer.service.Chat;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        Chat.saveMessage(e.getPlayer().getName(), e.getMessage());
    }

}
