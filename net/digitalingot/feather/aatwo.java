package net.digitalingot.feather;

import net.minecraft.entity.*;
import org.jetbrains.annotations.*;

public interface aa
{
    public static final ao<aa> bo = ap.a((Class<? super aa>)aa.class, array -> entity -> {
        for (length = array.length; i < length; ++i) {
            array[i].orient(entity);
        }
        return;
    });
    public static final ao<aa> bp = ap.a((Class<? super aa>)aa.class, array2 -> entity2 -> {
        for (length2 = array2.length; j < length2; ++j) {
            array2[j].orient(entity2);
        }
    });
    
    void orient(@NotNull final Entity p0);
    
    default static {
        int length;
        int i = 0;
        int length2;
        int j = 0;
    }
}
