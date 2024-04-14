package me.albedim.transleer.utils;

public class Utils {

    public static Integer parseInt(String str) {
        try {
            int r = Integer.parseInt(str);
            return Math.max(r, 0);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
