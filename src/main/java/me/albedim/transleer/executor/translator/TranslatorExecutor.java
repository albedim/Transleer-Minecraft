package me.albedim.transleer.executor.translator;

import me.albedim.transleer.Transleer;
import me.albedim.transleer.http.HttpCall;
import me.albedim.transleer.service.Chat;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TranslatorExecutor implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (command.getName().equals("translate")) {

            if (!(commandSender instanceof Player)) {
                commandSender.sendMessage("§7[§aTransleer§7] §8▪ §cYou must be a player to execute this command.");
                return true;
            }

            String translatePermission = Transleer.getCStr("translation_perm");
            if (!commandSender.hasPermission(translatePermission)
                    && !commandSender.isOp()
            ) {
                commandSender.sendMessage("§7[§aTransleer§7] §8▪ You don't have permission to execute this command.");
                return true;
            }

            if (strings.length != 2) {
                commandSender.sendMessage("§7[§aTransleer§7] §8▪ §7Usage: /translate <player:messageIndex> <language>");
                return true;
            }

            String player = strings[0].split(":")[0];
            String messageIndex = strings[0].split(":")[1];
            try {
                String message = Chat.getMessage(player, messageIndex);
                String res = HttpCall.translateMessage(message, strings[1]);
                commandSender.sendMessage(res);
            } catch (IndexOutOfBoundsException | NumberFormatException e) {
                commandSender.sendMessage("§7[§aTransleer§7] §8▪ §cMessage not found");
            }
        }
        return false;
    }
}
