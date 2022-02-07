package net.digitalingot.feather;

import net.minecraft.client.*;
import org.lwjgl.input.*;

public final class in
{
    public static final int Bx = 0;
    public static final int By = 1;
    public static final int Bz = 2;
    public static final int BA = 3;
    public static final int BB = 4;
    public static final int BC = 5;
    public static final int BD = 6;
    public static final int BE = 7;
    public static final int BF = 7;
    public static final int BG = 0;
    public static final int BH = 1;
    public static final int BI = 2;
    private static final Minecraft minecraft;
    
    private in() {
        throw new AssertionError();
    }
    
    public static boolean ad(final int n) {
        return n <= 7 && Mouse.isButtonDown(n);
    }
    
    public static int mf() {
        return Mouse.getDWheel();
    }
    
    public static boolean mg() {
        return Mouse.isGrabbed();
    }
    
    public static void t(final boolean grabbed) {
        Mouse.setGrabbed(grabbed);
    }
    
    public static void p(final int n, final int n2) {
        Mouse.setCursorPosition(n, n2);
    }
    
    static {
        minecraft = Minecraft.getMinecraft();
    }
    
    public static final class a
    {
        private a() {
            throw new AssertionError();
        }
        
        public static double ez() {
            return Mouse.getX();
        }
        
        public static double eA() {
            return Mouse.getY();
        }
    }
    
    public static final class b
    {
        private b() {
            throw new AssertionError();
        }
        
        public static double ez() {
            return a.ez() * ip.mp() / ip.ml();
        }
        
        public static double eA() {
            return a.eA() * ip.mq() / ip.ml();
        }
    }
}
