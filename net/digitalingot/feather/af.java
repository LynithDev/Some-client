package net.digitalingot.feather;

import org.jetbrains.annotations.*;

public class af
{
    public static ao<b> bo;
    public static ao<a> bp;
    public static ao<a> bw;
    
    static {
        final int length;
        int i = 0;
        final aq aq;
        af.bo = ap.a(b.class, array -> (im, c) -> {
            length = array.length;
            while (i < length) {
                array[i].render(im, c);
                if (aq != net.digitalingot.feather.aq.PASS) {
                    return aq;
                }
                else {
                    ++i;
                }
            }
            return net.digitalingot.feather.aq.PASS;
        });
        int length2;
        int j = 0;
        af.bp = ap.a((Class<? super a>)a.class, array2 -> (im2, c2) -> {
            for (length2 = array2.length; j < length2; ++j) {
                array2[j].render(im2, c2);
            }
            return;
        });
        int length3;
        int k = 0;
        af.bw = ap.a((Class<? super a>)a.class, array3 -> (im3, c3) -> {
            for (length3 = array3.length; k < length3; ++k) {
                array3[k].render(im3, c3);
            }
        });
    }
    
    public enum c
    {
        ALL, 
        CROSSHAIRS, 
        FOOD;
        
        private static /* synthetic */ c[] $values() {
            return new c[] { c.ALL, c.CROSSHAIRS, c.FOOD };
        }
        
        static {
            $VALUES = $values();
        }
    }
    
    public interface a
    {
        void render(@NotNull final im p0, @NotNull final c p1);
    }
    
    public interface b
    {
        @NotNull
        aq render(@NotNull final im p0, @NotNull final c p1);
    }
}
