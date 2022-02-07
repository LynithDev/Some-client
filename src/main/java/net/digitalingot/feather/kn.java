package net.digitalingot.feather;

import java.util.regex.*;
import java.util.*;
import org.jetbrains.annotations.*;

public class kn
{
    private static final char FW = '§';
    private static final Pattern FX;
    private static final char FY = 'r';
    private static final char FZ = 'l';
    private static final char Ga = 'k';
    private static final char Gb = 'm';
    private static final char Gc = 'n';
    private static final char Gd = 'o';
    
    private kn() {
        throw new AssertionError();
    }
    
    public static a aU(final String s) {
        final Matcher matcher = kn.FX.matcher(s);
        final ArrayList<b> list = new ArrayList<b>();
        b b = null;
        while (matcher.find()) {
            final int start = matcher.start();
            final char char1 = s.charAt(start + 1);
            if (char1 == 'r') {
                if (b == null) {
                    continue;
                }
                b.Gn = start;
                list.add(b);
                b = null;
            }
            else if (b(char1)) {
                if (b != null) {
                    if (!b.c(char1)) {
                        b.Gn = start;
                        list.add(b);
                        b = a(b);
                        b.Gm = start + 2;
                    }
                }
                else {
                    b = new b();
                    b.Gm = start + 2;
                }
                b.d(char1);
            }
            else {
                if (b != null) {
                    b.Gn = start;
                    list.add(b);
                }
                b = new b();
                b.Gm = start + 2;
                b.Gg = char1;
            }
        }
        if (b != null) {
            b.Gn = s.length();
            list.add(b);
        }
        return new a((List)list);
    }
    
    private static boolean b(final char c) {
        switch (Character.toLowerCase(c)) {
            case 'k':
            case 'l':
            case 'm':
            case 'n':
            case 'o': {
                return true;
            }
            default: {
                return false;
            }
        }
    }
    
    static {
        FX = Pattern.compile("(?i)§[0-9A-FK-OR]");
    }
    
    public static class a
    {
        private final List<b> Ge;
        
        private a(final List<b> ge) {
            this.Ge = ge;
        }
        
        @NotNull
        public b aP(final int n) {
            for (final b b : this.Ge) {
                if (n >= b.Gm && n < b.Gn) {
                    return b;
                }
            }
            return b.Gf;
        }
    }
    
    public static class b
    {
        private static final b Gf;
        private char Gg;
        private boolean Gh;
        private boolean Gi;
        private boolean Gj;
        private boolean Gk;
        private boolean Gl;
        private int Gm;
        private int Gn;
        
        public b() {
            this.Gg = '\uffff';
        }
        
        public String tM() {
            final StringBuilder sb = new StringBuilder();
            if (this.tN()) {
                sb.append('§');
                sb.append(this.Gg);
            }
            if (this.Gh) {
                sb.append('§');
                sb.append('l');
            }
            if (this.Gi) {
                sb.append('§');
                sb.append('o');
            }
            if (this.Gj) {
                sb.append('§');
                sb.append('n');
            }
            if (this.Gk) {
                sb.append('§');
                sb.append('m');
            }
            if (this.Gl) {
                sb.append('§');
                sb.append('k');
            }
            return sb.toString();
        }
        
        public boolean tN() {
            return this.Gg != '\uffff';
        }
        
        public char tO() {
            return this.Gg;
        }
        
        private static b a(final b b) {
            final b b2 = new b();
            if (b != null) {
                b2.Gg = b.Gg;
                b2.Gh = b.Gh;
                b2.Gj = b.Gj;
                b2.Gk = b.Gk;
                b2.Gl = b.Gl;
            }
            return b2;
        }
        
        private boolean c(final char c) {
            switch (Character.toLowerCase(c)) {
                case 'k': {
                    return this.Gl;
                }
                case 'l': {
                    return this.Gh;
                }
                case 'm': {
                    return this.Gk;
                }
                case 'n': {
                    return this.Gj;
                }
                case 'o': {
                    return this.Gi;
                }
                default: {
                    return false;
                }
            }
        }
        
        private void d(final char c) {
            switch (Character.toLowerCase(c)) {
                case 'k': {
                    this.Gl = true;
                    break;
                }
                case 'l': {
                    this.Gh = true;
                    break;
                }
                case 'm': {
                    this.Gk = true;
                    break;
                }
                case 'n': {
                    this.Gj = true;
                    break;
                }
                case 'o': {
                    this.Gi = true;
                    break;
                }
            }
        }
        
        static {
            Gf = new b();
        }
    }
}
