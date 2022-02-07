package net.digitalingot.feather;

import org.jetbrains.annotations.*;

public enum kj
{
    BLACK("BLACK", '0', 0, Integer.valueOf(0)), 
    DARK_BLUE("DARK_BLUE", '1', 1, Integer.valueOf(170)), 
    DARK_GREEN("DARK_GREEN", '2', 2, Integer.valueOf(43520)), 
    DARK_AQUA("DARK_AQUA", '3', 3, Integer.valueOf(43690)), 
    DARK_RED("DARK_RED", '4', 4, Integer.valueOf(11141120)), 
    DARK_PURPLE("DARK_PURPLE", '5', 5, Integer.valueOf(11141290)), 
    GOLD("GOLD", '6', 6, Integer.valueOf(16755200)), 
    GRAY("GRAY", '7', 7, Integer.valueOf(11184810)), 
    DARK_GRAY("DARK_GRAY", '8', 8, Integer.valueOf(5592405)), 
    BLUE("BLUE", '9', 9, Integer.valueOf(5592575)), 
    GREEN("GREEN", 'a', 10, Integer.valueOf(5635925)), 
    AQUA("AQUA", 'b', 11, Integer.valueOf(5636095)), 
    RED("RED", 'c', 12, Integer.valueOf(16733525)), 
    LIGHT_PURPLE("LIGHT_PURPLE", 'd', 13, Integer.valueOf(16733695)), 
    YELLOW("YELLOW", 'e', 14, Integer.valueOf(16777045)), 
    WHITE("WHITE", 'f', 15, Integer.valueOf(16777215)), 
    OBFUSCATED("OBFUSCATED", 'k', true), 
    BOLD("BOLD", 'l', true), 
    STRIKETHROUGH("STRIKETHROUGH", 'm', true), 
    UNDERLINE("UNDERLINE", 'n', true), 
    ITALIC("ITALIC", 'o', true), 
    RESET("RESET", 'r', -1, (Integer)null);
    
    public static final String PREFIX_CHAR = "§";
    public final String name;
    public final char code;
    public final boolean isFormat;
    public final String toString;
    public final int id;
    @Nullable
    public final Integer color;
    
    private kj(final String s2, @Nullable final char c, final int n2, final Integer n3) {
        this(s2, c, false, n2, n3);
    }
    
    private kj(final String s2, final char c, final boolean b) {
        this(s2, c, b, -1, null);
    }
    
    private kj(final String name, final char code, @Nullable final boolean isFormat, final int id, final Integer color) {
        this.name = name;
        this.code = code;
        this.isFormat = isFormat;
        this.id = id;
        this.color = color;
        this.toString = "§" + code;
    }
    
    public void apply(final StringBuilder sb) {
        sb.append(this.toString);
    }
    
    @Override
    public String toString() {
        return this.toString;
    }
    
    public static kj getByColor(final int n) {
        for (final kj kj : values()) {
            if (kj.color != null && kj.color == n) {
                return kj;
            }
        }
        return null;
    }
    
    private static /* synthetic */ kj[] $values() {
        return new kj[] { kj.BLACK, kj.DARK_BLUE, kj.DARK_GREEN, kj.DARK_AQUA, kj.DARK_RED, kj.DARK_PURPLE, kj.GOLD, kj.GRAY, kj.DARK_GRAY, kj.BLUE, kj.GREEN, kj.AQUA, kj.RED, kj.LIGHT_PURPLE, kj.YELLOW, kj.WHITE, kj.OBFUSCATED, kj.BOLD, kj.STRIKETHROUGH, kj.UNDERLINE, kj.ITALIC, kj.RESET };
    }
    
    static {
        $VALUES = $values();
    }
}
