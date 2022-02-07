package net.digitalingot.feather;

import java.util.*;

public class kt
{
    private static final NavigableMap<Integer, String> Gr;
    private static final TreeMap<Integer, String> Gs;
    
    public static int aV(String s) {
        s = s.toUpperCase();
        int n = 0;
        for (final Map.Entry<Object, Object> entry : kt.Gr.entrySet()) {
            final String s2 = entry.getValue();
            final int intValue = entry.getKey();
            while (s.startsWith(s2)) {
                n += intValue;
                s = s.substring(s2.length());
            }
        }
        return n;
    }
    
    public static String aQ(int i) {
        final StringBuilder sb = new StringBuilder();
        while (i > 0) {
            final Map.Entry<Integer, String> floorEntry = kt.Gs.floorEntry(i);
            i -= floorEntry.getKey();
            sb.append(floorEntry.getValue());
        }
        return sb.toString();
    }
    
    static {
        (Gs = new TreeMap<Integer, String>()).put(1, "I");
        kt.Gs.put(4, "IV");
        kt.Gs.put(5, "V");
        kt.Gs.put(9, "IX");
        kt.Gs.put(10, "X");
        kt.Gs.put(40, "XL");
        kt.Gs.put(50, "L");
        kt.Gs.put(90, "XC");
        kt.Gs.put(100, "C");
        kt.Gs.put(400, "CD");
        kt.Gs.put(500, "D");
        kt.Gs.put(900, "CM");
        kt.Gs.put(1000, "M");
        kt.Gs.put(4000, "MV\u0305");
        kt.Gs.put(5000, "V\u0305");
        kt.Gs.put(9000, "MX\u0305");
        kt.Gs.put(10000, "X\u0305");
        kt.Gs.put(40000, "X\u0305L\u0305");
        kt.Gs.put(50000, "L\u0305");
        kt.Gs.put(90000, "X\u0305C\u0305");
        kt.Gs.put(100000, "C\u0305");
        kt.Gs.put(400000, "C\u0305D\u0305");
        kt.Gs.put(500000, "D\u0305");
        kt.Gs.put(900000, "C\u0305M\u0305");
        kt.Gs.put(1000000, "M\u0305");
        Gr = kt.Gs.descendingMap();
    }
}
