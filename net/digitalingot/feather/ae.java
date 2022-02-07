package net.digitalingot.feather;

import net.minecraft.entity.*;
import org.jetbrains.annotations.*;

public interface ae
{
    public static final ao<ae> bo = ap.a((Class<? super ae>)ae.class, array -> (entity, n, n3, n5, im) -> {
        for (length = array.length; i < length; ++i) {
            array[i].render(entity, n, n3, n5, im);
        }
        return;
    });
    public static final ao<ae> bv = ap.a((Class<? super ae>)ae.class, array2 -> (entity2, n2, n4, n6, im2) -> {
        for (length2 = array2.length; j < length2; ++j) {
            array2[j].render(entity2, n2, n4, n6, im2);
        }
    });
    
    void render(@NotNull final Entity p0, final double p1, final double p2, final double p3, final im p4);
    
    default static {
        int length;
        int i = 0;
        int length2;
        int j = 0;
    }
}
