package dev.drtheo.mcemojis;

import java.util.Arrays;

public class EmojiReplace {

    public static final int[] ignore = { 259, 59, 45, 96, 91, 93, 46, 44, 39, 92, 47, 61, 262, 263, 341 };
    private static final String[] emojis = new String[]{ "⛏", "\uD83D\uDDE1", "⭐", "\uD83D\uDEE1", "\uD83E\uDE93", "\uD83D\uDD31", "\uD83C\uDFF9", "\uD83C\uDFA3",
            "⚗", "\uD83E\uDDEA", "\uD83D\uDD25", "❤", "⚡", "✎", "☠", "⚠", "⌛", "⌚", "⚓", "☃", "⛄", "\uD83C\uDF0A", "☽", "☀", "❄", "☁", "\uD83C\uDF27",
            "⛈", "☂", "☔", "☄", "☺", "☹", "☻", "✂", "✔", "✖", "✘", "✚", "✛", "☐", "☑", "☒", "ℹ", "☮", "☯", "Ω", "⏭", "⏯", "⏮", "⏸", "⏹", "⏺", "◆", "◇",
            "■", "□", "♫", "♩", "♪", "♬", "♠", "♣", "♥", "♦", "⚀", "⚁", "⚂", "⚃", "⚄", "⚅", "\uD83D\uDD14",
            "\uD83C\uDF56", "\uD83C\uDF56", "\uD83E\uDEA3", "⏳", "⚐", "⚑", "§0", "§1", "§2", "§3", "§4", "§5", "§6", "§7", "§8", "§9", "§a", "§b", "§c", "§d",
            "§e", "§f", "§k", "§l", "§m", "§n", "§o", "§r" };
    private static final String[] translate = new String[]{ ":pickaxe:", ":sword:", ":star:", ":shield:", ":axe:", ":trident:", ":bow:", ":fishing_rod:",
            ":splash_potion:", ":potion:", ":fire:", ":heart:", ":lightning:", ":pencil:", ":death:", ":warning:", ":hourglass:", ":clock:", ":anchor:",
            ":snowman:", ":snowman2:", ":wave:", ":moon:", ":sun:", ":winter:", ":cloud:", ":rain:", ":thunder:", ":umbrella:", ":umbrella2:", ":meteor:",
            ":happy:", ":sad:", ":smile:", ":shears:", ":check:", ":cross:", ":cross_map:", ":medicine:", ":cursor:", ":mark:", ":check_mark:", ":cross_mark:",
            ":info:", ":pacific:", ":yinyang:", ":omega:", ":next:", ":pauseplay:", ":previous:", ":pause:", ":stop:", ":circle:", ":rhombus:", ":rhombus2:",
            ":square:", ":square2:", ":note:", ":note2:", ":note3:", ":note4:", ":symbol:", ":symbol2:", ":symbol3:", ":symbol4:", ":dice_1:", ":dice_2:",
            ":dice_3:", ":dice_4:", ":dice_5:", ":dice_6:", ":bell:", ":food:", ":meat:", ":bucket:", ":hourglass2:",
            ":flag:", ":flag2:", ":black:", ":dark_blue:", ":dark_green:", ":dark_aqua:", ":dark_red:", ":dark_purple:", ":gold:", ":gray:", ":dark_gray:",
            ":blue:", ":green:", ":aqua:", ":red:", ":light_purple:", ":yellow:", ":white:", ";o;", ";b;", ";s;", ";u;", ";i;", ";r;" };

    public static String GetEmojiText(String text) {
        if(Arrays.stream(translate).anyMatch(text::contains)) {
            String modified = text;
            for (int i = 0; i < emojis.length; i++) {
                if(modified.contains(translate[i])) {
                    modified = modified.replaceAll(translate[i], emojis[i]);
                }
            }
            return modified;
        }
        return null;
    }
}