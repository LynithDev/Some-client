package net.digitalingot.feather;

import java.awt.event.*;
import java.lang.reflect.*;

final class bu
{
    private static final a cM;
    
    static void b(final KeyEvent keyEvent, final int n) {
        bu.cM.b(keyEvent, n);
    }
    
    static {
        if (System.getProperty("os.name").startsWith("Windows")) {
            cM = new c();
        }
        else {
            cM = new b();
        }
    }
    
    static class b implements a
    {
        private b() {
        }
        
        @Override
        public void b(final KeyEvent keyEvent, final int n) {
        }
    }
    
    static class c extends b
    {
        private static final int cN = 0;
        private static final int cO = 0;
        private static final Method cP;
        
        private c() {
        }
        
        @Override
        public void b(final KeyEvent keyEvent, final int n) {
            final int a = A(n);
            if (a != 0) {
                final int z = z(a);
                if (z != 0) {
                    bp.a(keyEvent, z);
                }
            }
        }
        
        private static int z(final int n) {
            try {
                return (int)c.cP.invoke(null, n, 0);
            }
            catch (Throwable t) {
                return 0;
            }
        }
        
        private static int A(final int n) {
            switch (n) {
                case 1: {
                    return 27;
                }
                case 2: {
                    return 49;
                }
                case 3: {
                    return 50;
                }
                case 4: {
                    return 51;
                }
                case 5: {
                    return 52;
                }
                case 6: {
                    return 53;
                }
                case 7: {
                    return 54;
                }
                case 8: {
                    return 55;
                }
                case 9: {
                    return 56;
                }
                case 10: {
                    return 57;
                }
                case 11: {
                    return 48;
                }
                case 12: {
                    return 189;
                }
                case 13: {
                    return 187;
                }
                case 14: {
                    return 8;
                }
                case 15: {
                    return 9;
                }
                case 16: {
                    return 81;
                }
                case 17: {
                    return 87;
                }
                case 18: {
                    return 69;
                }
                case 19: {
                    return 82;
                }
                case 20: {
                    return 84;
                }
                case 21: {
                    return 89;
                }
                case 22: {
                    return 85;
                }
                case 23: {
                    return 73;
                }
                case 24: {
                    return 79;
                }
                case 25: {
                    return 80;
                }
                case 26: {
                    return 219;
                }
                case 27: {
                    return 221;
                }
                case 28: {
                    return 13;
                }
                case 29: {
                    return 162;
                }
                case 30: {
                    return 65;
                }
                case 31: {
                    return 83;
                }
                case 32: {
                    return 68;
                }
                case 33: {
                    return 70;
                }
                case 34: {
                    return 71;
                }
                case 35: {
                    return 72;
                }
                case 36: {
                    return 74;
                }
                case 37: {
                    return 75;
                }
                case 38: {
                    return 76;
                }
                case 39: {
                    return 186;
                }
                case 40: {
                    return 222;
                }
                case 41: {
                    return 192;
                }
                case 42: {
                    return 160;
                }
                case 43: {
                    return 220;
                }
                case 44: {
                    return 90;
                }
                case 45: {
                    return 88;
                }
                case 46: {
                    return 67;
                }
                case 47: {
                    return 86;
                }
                case 48: {
                    return 66;
                }
                case 49: {
                    return 78;
                }
                case 50: {
                    return 77;
                }
                case 51: {
                    return 188;
                }
                case 52: {
                    return 190;
                }
                case 53: {
                    return 191;
                }
                case 54: {
                    return 161;
                }
                case 55: {
                    return 106;
                }
                case 56: {
                    return 164;
                }
                case 57: {
                    return 32;
                }
                case 58: {
                    return 20;
                }
                case 59: {
                    return 112;
                }
                case 60: {
                    return 113;
                }
                case 61: {
                    return 114;
                }
                case 62: {
                    return 115;
                }
                case 63: {
                    return 116;
                }
                case 64: {
                    return 117;
                }
                case 65: {
                    return 118;
                }
                case 66: {
                    return 119;
                }
                case 67: {
                    return 120;
                }
                case 68: {
                    return 121;
                }
                case 69: {
                    return 144;
                }
                case 70: {
                    return 145;
                }
                case 71: {
                    return 103;
                }
                case 72: {
                    return 104;
                }
                case 73: {
                    return 105;
                }
                case 74: {
                    return 109;
                }
                case 75: {
                    return 100;
                }
                case 76: {
                    return 101;
                }
                case 77: {
                    return 102;
                }
                case 78: {
                    return 107;
                }
                case 79: {
                    return 97;
                }
                case 80: {
                    return 98;
                }
                case 81: {
                    return 99;
                }
                case 82: {
                    return 96;
                }
                case 83: {
                    return 110;
                }
                case 87: {
                    return 122;
                }
                case 88: {
                    return 123;
                }
                case 100: {
                    return 124;
                }
                case 101: {
                    return 125;
                }
                case 102: {
                    return 126;
                }
                case 112: {
                    return 21;
                }
                case 121: {
                    return 28;
                }
                case 123: {
                    return 29;
                }
                case 148: {
                    return 25;
                }
                case 157: {
                    return 163;
                }
                case 179: {
                    return 108;
                }
                case 181: {
                    return 111;
                }
                case 183: {
                    return 44;
                }
                case 184: {
                    return 165;
                }
                case 197: {
                    return 19;
                }
                case 199: {
                    return 36;
                }
                case 200: {
                    return 38;
                }
                case 201: {
                    return 33;
                }
                case 203: {
                    return 37;
                }
                case 205: {
                    return 39;
                }
                case 207: {
                    return 35;
                }
                case 208: {
                    return 40;
                }
                case 209: {
                    return 34;
                }
                case 210: {
                    return 45;
                }
                case 211: {
                    return 46;
                }
                case 219: {
                    return 91;
                }
                case 220: {
                    return 92;
                }
                case 221: {
                    return 93;
                }
                case 223: {
                    return 95;
                }
                default: {
                    return 0;
                }
            }
        }
        
        static {
            Class<?> forName;
            try {
                forName = Class.forName("org.lwjgl.opengl.WindowsKeyboard");
            }
            catch (Throwable t) {
                throw new IllegalStateException();
            }
            try {
                (cP = forName.getDeclaredMethod("MapVirtualKey", Integer.TYPE, Integer.TYPE)).setAccessible(true);
            }
            catch (Throwable t2) {
                throw new IllegalStateException();
            }
        }
    }
    
    interface a
    {
        void b(final KeyEvent p0, final int p1);
    }
}
