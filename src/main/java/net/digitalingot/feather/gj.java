package net.digitalingot.feather;

import org.jetbrains.annotations.*;
import net.minecraft.client.entity.*;

public abstract class gj
{
    @NotNull
    protected final i F;
    @NotNull
    protected final ir qC;
    @NotNull
    protected final fX qy;
    @NotNull
    private final a qD;
    
    protected gj(@NotNull final i i, @NotNull final ir ir, @NotNull final fX fx) {
        this(i, fx, ir, a.NONE);
    }
    
    protected gj(@NotNull final i f, @NotNull final fX qy, @NotNull final ir qc, @NotNull final a qd) {
        this.F = f;
        this.qy = qy;
        this.qC = qc;
        this.qD = qd;
    }
    
    public abstract void a(final EntityPlayerSP p0, final String[] p1);
    
    @NotNull
    public a hX() {
        return this.qD;
    }
    
    public enum a
    {
        NONE, 
        NOT_IN_PARTY, 
        IN_PARTY, 
        LEADER;
        
        private static /* synthetic */ a[] $values() {
            return new a[] { a.NONE, a.NOT_IN_PARTY, a.IN_PARTY, a.LEADER };
        }
        
        static {
            $VALUES = $values();
        }
    }
}
