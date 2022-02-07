package net.digitalingot.feather;

import java.util.*;
import org.jetbrains.annotations.*;

public interface hv
{
    float jD();
    
    float jE();
    
    float jF();
    
    @NotNull
    hT.a jG();
    
    @NotNull
    List<UUID> jH();
    
    @Nullable
    hT.c[] jI();
    
    @Nullable
    a jJ();
    
    @Nullable
    kN n(final UUID p0);
    
    public static class a
    {
        @NotNull
        private final kN zH;
        private final boolean zI;
        private final float zJ;
        private final float zK;
        
        public a(@NotNull final kN zh, final boolean zi, final float zj, final float zk) {
            this.zH = zh;
            this.zI = zi;
            this.zJ = zj;
            this.zK = zk;
        }
        
        @NotNull
        public kN jK() {
            return this.zH;
        }
        
        public boolean jL() {
            return this.zI;
        }
        
        public float jM() {
            return this.zJ;
        }
        
        public float jN() {
            return this.zK;
        }
    }
}
