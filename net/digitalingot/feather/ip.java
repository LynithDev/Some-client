package net.digitalingot.feather;

import net.minecraft.client.*;
import net.minecraft.client.gui.*;

public final class ip
{
    private static final Minecraft minecraft;
    private static ScaledResolution BK;
    private static int BL;
    private static int BM;
    private static int BN;
    
    private ip() {
        throw new AssertionError();
    }
    
    public static int ml() {
        return ip.minecraft.displayWidth;
    }
    
    public static int mm() {
        return ip.minecraft.displayHeight;
    }
    
    public static int mn() {
        return ip.minecraft.displayWidth;
    }
    
    public static int mo() {
        return ip.minecraft.displayHeight;
    }
    
    public static int mp() {
        return ms().getScaledWidth();
    }
    
    public static int mq() {
        return ms().getScaledHeight();
    }
    
    public static double mr() {
        return ms().getScaleFactor();
    }
    
    private static ScaledResolution ms() {
        if (ip.BL != mn() || ip.BM != mo() || ip.BN != ip.minecraft.gameSettings.guiScale || ip.BK == null) {
            ip.BL = mn();
            ip.BM = mo();
            ip.BN = ip.minecraft.gameSettings.guiScale;
            ip.BK = new ScaledResolution(ip.minecraft);
        }
        return ip.BK;
    }
    
    static {
        minecraft = Minecraft.getMinecraft();
        ip.BK = null;
        ip.BL = -1;
        ip.BM = -1;
        ip.BN = -1;
    }
}
