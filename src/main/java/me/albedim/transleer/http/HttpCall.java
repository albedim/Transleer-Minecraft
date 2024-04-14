package me.albedim.transleer.http;

import com.google.gson.JsonObject;
import me.albedim.transleer.classes.TransleerRequest;

public class HttpCall {

    public static String translateMessage(String message, String language) {
        JsonObject res = HttpUtils.post(
                "/translate",
                null,
                new TransleerRequest(message, language),
                JsonObject.class
        ).getAsJsonObject();
        
        if (res.get("code").getAsInt() == 200) {
            return "§7[§aTransleer§7] (" + language + ") §8➜ §7§o" + res.get("res").getAsString();
        }
        if (res.get("code").getAsInt() == 400) {
           return "§7[§aTransleer§7] §8▪ §cInvalid language";
        }
        return "§7[§aTransleer§7] §8▪ §cYou're not allowed to perform this command";
    }
}
