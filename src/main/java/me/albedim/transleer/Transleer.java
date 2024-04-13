package me.albedim.transleer;

import me.albedim.transleer.classes.Message;
import me.albedim.transleer.executor.messages.MessagesExecutor;
import me.albedim.transleer.executor.translator.TranslatorExecutor;
import me.albedim.transleer.listener.chat.ChatListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public final class Transleer extends JavaPlugin {

    private static Transleer plugin;
    public static ArrayList<Message> messages;

    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;
        messages = new ArrayList<>();
        saveDefaultConfig();
        getCommand("messages").setExecutor(new MessagesExecutor());
        getCommand("translate").setExecutor(new TranslatorExecutor());
        Bukkit.getServer().getPluginManager().registerEvents(new ChatListener(), this);
        System.out.println("[Transleer] - active");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Transleer getPlugin() {
        return plugin;
    }

    public static String getCStr(String str) {
        String res = plugin.getConfig().getString(str);
        if (res != null) {
            return plugin.getConfig().getString(str);
        }
        return "§cAn error occurred while performing this comma";
    }
}
