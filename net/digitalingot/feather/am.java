package net.digitalingot.feather;

import net.minecraft.util.*;
import java.io.*;
import org.jetbrains.annotations.*;

public interface am
{
    public static final ao<b> bD = ap.a((Class<? super b>)b.class, array -> () -> {
        for (length = array.length; i < length; ++i) {
            array[i].screenshot();
        }
        return;
    });
    public static final ao<a> bv = ap.a(a.class, array2 -> (file, p2) -> {
        for (length2 = array2.length; j < length2; ++j) {
            array2[j].screenshot(file, chatComponent);
        }
        return chatComponent;
    });
    
    default static {
        int length;
        int i = 0;
        int length2;
        int j = 0;
        final IChatComponent chatComponent;
    }
    
    public interface a
    {
        @Nullable
        IChatComponent screenshot(@NotNull final File p0, @Nullable final IChatComponent p1);
    }
    
    public interface b
    {
        void screenshot();
    }
}
