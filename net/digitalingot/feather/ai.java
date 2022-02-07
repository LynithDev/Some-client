package net.digitalingot.feather;

import net.minecraft.item.*;
import org.jetbrains.annotations.*;

public interface ai
{
    public static final ao<ai> bA = ap.a((Class<? super ai>)ai.class, array -> (void1, itemStack, n, n4, n7, n10) -> {
        for (length = array.length; i < length; ++i) {
            array[i].render(void1, itemStack, n, n4, n7, n10);
        }
        return;
    });
    public static final ao<ai> bB = ap.a((Class<? super ai>)ai.class, array2 -> (void2, itemStack2, n2, n5, n8, n11) -> {
        for (length2 = array2.length; j < length2; ++j) {
            array2[j].render(void2, itemStack2, n2, n5, n8, n11);
        }
        return;
    });
    public static final ao<ai> bv = ap.a((Class<? super ai>)ai.class, array3 -> (void3, itemStack3, n3, n6, n9, n12) -> {
        for (length3 = array3.length; k < length3; ++k) {
            array3[k].render(void3, itemStack3, n3, n6, n9, n12);
        }
    });
    
    void render(final Void p0, @NotNull final ItemStack p1, final int p2, final int p3, final int p4, final int p5);
    
    default static {
        int length;
        int i = 0;
        int length2;
        int j = 0;
        int length3;
        int k = 0;
    }
    
    public static class a
    {
        public static ItemStack bC;
        
        static {
            a.bC = null;
        }
    }
}
