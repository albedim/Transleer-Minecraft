package me.albedim.transleer.executor.messages;

import me.albedim.transleer.Transleer;
import me.albedim.transleer.classes.Message;
import me.albedim.transleer.utils.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MessagesExecutor implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (command.getName().equals("messages")) {
            int page = 0;
            if (strings.length == 1) {
                page = Utils.parseInt(strings[0]);
            }

            // If command executor is a Player and doesn't have admin perms it's going to return false
            if (commandSender instanceof Player) {
                String adminPermission = Transleer.getCStr("admin_perm");
                if (!commandSender.hasPermission(adminPermission) && !commandSender.isOp()) {
                    commandSender.sendMessage("§7[§aTransleer§7] §8▪ You don't have permission to execute this command.");
                    return true;
                }
            }

            commandSender.sendMessage("§7[§aTransleer§7] §8▪ §7Messages (" + page + "):");
            commandSender.sendMessage(" ");
            for (int i = page * 10; i < page * 10 + 10; i++) {
                if (i >= Transleer.messages.size()) {
                    break;
                }
                Message message = Transleer.messages.get(i);
                commandSender.sendMessage("§8▪ §7[§a" + message.getUsername() + "§7] §8➜ §7§o" + message.getMessage());
            }

        }
        return false;
    }
}
