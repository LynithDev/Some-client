package net.digitalingot.feather;

import java.util.*;
import org.jetbrains.annotations.*;

public class hx
{
    @Nullable
    private final hF zM;
    @NotNull
    private final UUID zN;
    @NotNull
    private final hT.c zO;
    private final long zP;
    private final byte[] zQ;
    
    public hx(@Nullable final hF zm, @NotNull final UUID zn, @NotNull final hT.c zo, final long zp, final byte[] zq) {
        this.zM = zm;
        this.zN = zn;
        this.zO = zo;
        this.zP = zp;
        this.zQ = zq;
    }
    
    @Nullable
    public hF jO() {
        return this.zM;
    }
    
    @NotNull
    public UUID jP() {
        return this.zN;
    }
    
    @NotNull
    public hT.c jQ() {
        return this.zO;
    }
    
    public long jR() {
        return this.zP;
    }
    
    public byte[] jS() {
        return this.zQ;
    }
}
