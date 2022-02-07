package net.digitalingot.feather;

import net.minecraft.client.gui.*;

public interface aj
{
    public static final ao<aj> bv = ap.a((Class<? super aj>)aj.class, array -> guiScreen -> {
        for (length = array.length; i < length; ++i) {
            array[i].postInitialization(guiScreen);
        }
    });
    
    void postInitialization(final GuiScreen p0);
    
    default static {
        int length;
        int i = 0;
    }
}
