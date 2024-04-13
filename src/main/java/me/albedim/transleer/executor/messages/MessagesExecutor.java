package me.albedim.transleer.executor.messages;

import me.albedim.transleer.Transleer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MessagesExecutor implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!command.getName().equals("messages")) {
            return false;
        }
        if (commandSender instanceof Player) {
            if (!commandSender.hasPermission("transleer.admin") && !commandSender.isOp()) {
                commandSender.sendMessage("§7[§aTransleer§7] §8▪ You don't have permission to execute this command.");
                return true;
            }
            commandSender.sendMessage("§7[§a§lTransleer§7] §8▪ §7Messages:");
            commandSender.sendMessage(" ");
            Transleer.messages.forEach(message -> {
                commandSender.sendMessage("§8▪ §7[§a" + message.getUsername() + "§7] §8➜ §7§o" + message.getMessage());
            });
        }
        return false;
    }
}
