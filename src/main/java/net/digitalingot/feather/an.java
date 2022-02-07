package net.digitalingot.feather;

import net.minecraft.entity.player.*;
import net.minecraft.world.*;
import org.jetbrains.annotations.*;

public class an
{
    public static ao<a> bE;
    public static ao<b> bF;
    public static ao<d> bG;
    public static ao<e> bH;
    
    static {
        int length;
        int i = 0;
        an.bE = ap.a((Class<? super a>)a.class, array -> c -> {
            for (length = array.length; i < length; ++i) {
                array[i].tick(c);
            }
            return;
        });
        int length2;
        int j = 0;
        an.bF = ap.a((Class<? super b>)b.class, array2 -> (c2, world) -> {
            for (length2 = array2.length; j < length2; ++j) {
                array2[j].tick(c2, world);
            }
            return;
        });
        int length3;
        int k = 0;
        an.bG = ap.a((Class<? super d>)d.class, array3 -> (c3, entityPlayer) -> {
            for (length3 = array3.length; k < length3; ++k) {
                array3[k].tick(c3, entityPlayer);
            }
            return;
        });
        int length4;
        int l = 0;
        an.bH = ap.a((Class<? super e>)e.class, array4 -> (c4, n) -> {
            for (length4 = array4.length; l < length4; ++l) {
                array4[l].tick(c4, n);
            }
        });
    }
    
    public enum c
    {
        START, 
        END;
        
        private static /* synthetic */ c[] $values() {
            return new c[] { c.START, c.END };
        }
        
        static {
            $VALUES = $values();
        }
    }
    
    public interface e
    {
        void tick(@NotNull final c p0, final float p1);
    }
    
    public interface d
    {
        void tick(@NotNull final c p0, @NotNull final EntityPlayer p1);
    }
    
    public interface b
    {
        void tick(@NotNull final c p0, @NotNull final World p1);
    }
    
    public interface a
    {
        void tick(@NotNull final c p0);
    }
}
