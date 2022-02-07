package net.digitalingot.feather;

import net.minecraft.client.gui.*;
import org.jetbrains.annotations.*;

public interface al
{
    public static final ao<al> bv = ap.a((Class<? super al>)al.class, array -> guiScreen -> {
        for (length = array.length; i < length; ++i) {
            array[i].render(guiScreen);
        }
    });
    
    void render(@NotNull final GuiScreen p0);
    
    default static {
        int length;
        int i = 0;
    }
}
