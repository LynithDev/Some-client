package net.digitalingot.feather;

import net.minecraft.client.*;
import java.net.*;
import java.awt.*;
import java.io.*;
import net.minecraft.client.gui.*;

public final class io
{
    private static final Minecraft minecraft;
    private static final a BJ;
    
    private io() {
        throw new AssertionError();
    }
    
    public static boolean mh() {
        return io.BJ == a.WINDOWS;
    }
    
    public static boolean mi() {
        return io.BJ == a.LINUX;
    }
    
    public static boolean mj() {
        return io.BJ == a.MACOS;
    }
    
    public static boolean a(final URI uri) {
        return b(uri) || aA(uri.toString());
    }
    
    public static boolean k(final File file) {
        return l(file) || aA(file.getPath());
    }
    
    private static boolean aA(final String s) {
        return io.BJ.open(s);
    }
    
    private static boolean l(final File file) {
        final Desktop a = a(Desktop.Action.OPEN);
        if (a != null) {
            try {
                a.open(file);
                return true;
            }
            catch (IOException ex) {}
        }
        return false;
    }
    
    private static boolean b(final URI uri) {
        final Desktop a = a(Desktop.Action.BROWSE);
        if (a != null) {
            try {
                a.browse(uri);
                return true;
            }
            catch (IOException ex) {}
        }
        return false;
    }
    
    private static Desktop a(final Desktop.Action action) {
        if (!Desktop.isDesktopSupported()) {
            return null;
        }
        final Desktop desktop = Desktop.getDesktop();
        if (!desktop.isSupported(action)) {
            return null;
        }
        return desktop;
    }
    
    private static boolean aB(final String s) {
        try {
            return new ProcessBuilder(new String[] { s }).redirectInput(ProcessBuilder.Redirect.DISCARD).redirectOutput(ProcessBuilder.Redirect.DISCARD).redirectError(ProcessBuilder.Redirect.DISCARD).start().isAlive();
        }
        catch (IOException ex) {
            return false;
        }
    }
    
    public static String mk() {
        return GuiScreen.getClipboardString();
    }
    
    public static void aC(final String clipboardString) {
        GuiScreen.setClipboardString(clipboardString);
    }
    
    static {
        minecraft = Minecraft.getMinecraft();
        BJ = get();
    }
    
    enum a
    {
        WINDOWS("explorer"), 
        LINUX("xdg-open"), 
        MACOS("open");
        
        private final String command;
        
        private a(final String command) {
            this.command = command;
        }
        
        private boolean open(final String s) {
            return aB(this.command + " \"" + s + "\"");
        }
        
        private static a get() {
            final String osName = getOsName();
            if (osName != null) {
                if (osName.startsWith("Linux") || osName.startsWith("LINUX")) {
                    return a.LINUX;
                }
                if (osName.startsWith("Mac")) {
                    return a.MACOS;
                }
                if (osName.startsWith("Windows")) {
                    return a.WINDOWS;
                }
            }
            throw new IllegalStateException("Unable to detect OS");
        }
        
        private static String getOsName() {
            try {
                return System.getProperty("os.name");
            }
            catch (SecurityException ex) {
                return null;
            }
        }
        
        private static /* synthetic */ a[] $values() {
            return new a[] { a.WINDOWS, a.LINUX, a.MACOS };
        }
        
        static {
            $VALUES = $values();
        }
    }
}
