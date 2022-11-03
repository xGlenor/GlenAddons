package pl.gduraj.glenaddons.utils;

import org.bukkit.ChatColor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChatUtil {

    private static Pattern pattern = Pattern.compile("&#[a-fA-F0-9]{6}");

    public static String color(String msg){
        return ChatColor.translateAlternateColorCodes('&', msg);
    }

    public static String colorHex(String msg){
        return msg;
    }



}
