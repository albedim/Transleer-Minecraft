package me.albedim.transleer.service;

import me.albedim.transleer.Transleer;
import me.albedim.transleer.classes.Message;

import java.util.ArrayList;

public class Chat {

    public static void saveMessage(String username, String message) {
        int messagesLength = Transleer.messages.size();
        if (messagesLength >= 50) {
            Transleer.messages.remove(0);
        }
        Transleer.messages.add(new Message(username, message));
    }

    public static String getMessage(String username, String index) throws NumberFormatException, IndexOutOfBoundsException {
        ArrayList<Message> filteredMessages = new ArrayList<>();
        for (int i = 0; i < Transleer.messages.size(); i++) {
            if (Transleer.messages.get(i).getUsername().equals(username)) {
                filteredMessages.add(Transleer.messages.get(i));
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
