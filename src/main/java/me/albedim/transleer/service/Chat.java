package me.albedim.transleer.service;

import me.albedim.transleer.Transleer;
import me.albedim.transleer.classes.Message;

import java.util.ArrayList;

public class Chat {

    public static void saveMessage(String username, String message) {
        int messagesLength = Transleer.messages.size();
        int maxMessagesSavable = Integer.parseInt(Transleer.getCStr("max_messages_savable"));
        if (messagesLength >= maxMessagesSavable) {
            Transleer.messages.remove(0);
        }
        Transleer.messages.add(new Message(username, message));
    }

    public static String getMessage(String username, String index)
            throws NumberFormatException, IndexOutOfBoundsException {

        ArrayList<Message> filteredMessages = new ArrayList<>();
        for (Message message : Transleer.messages) {
            if (message.getUsername().equals(username)) {
                filteredMessages.add(message);
            }
        }

        try {
            return filteredMessages.get(filteredMessages.size() - 1 - Integer.parseInt(index)).getMessage();
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        } catch (IndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException();
        }
    }

}
