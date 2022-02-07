package net.digitalingot.feather;

import net.minecraft.client.gui.*;
import org.jetbrains.annotations.*;

public interface ak
{
    public static final ao<ak> bk = ap.a(ak.class, array -> p1 -> {
        for (length = array.length; i < length; ++i) {
            array[i].openScreen(guiScreen);
        }
        return guiScreen;
    });
    
    @NotNull
    GuiScreen openScreen(@NotNull final GuiScreen p0);
    
    default static {
        int length;
        int i = 0;
        final GuiScreen guiScreen;
    }
}
