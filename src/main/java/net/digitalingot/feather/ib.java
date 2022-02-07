package net.digitalingot.feather;

import org.jetbrains.annotations.*;
import java.util.*;

public class ib
{
    @NotNull
    private final List<Integer> AX;
    @NotNull
    private final Map<UUID, b> AY;
    @NotNull
    private final Map<UUID, a> AZ;
    @Nullable
    private ir qC;
    
    private ib() {
        this.AX = new ArrayList<Integer>();
        this.AY = new HashMap<UUID, b>();
        this.AZ = new HashMap<UUID, a>();
    }
    
    @NotNull
    public static ib lm() {
        final ib ib = new ib();
        final bV l = e.s().l();
        l.a(bQ.REQUEST_P2P_JOIN, (bW<bT, bT, bT>)new ic.b(ib));
        l.a(bQ.ACCEPT_P2P_JOIN, (bW<bT, bT, bT>)new ic.a(ib));
        return ib;
    }
    
    @NotNull
    public List<Integer> ln() {
        return this.AX;
    }
    
    @NotNull
    public Map<UUID, b> lo() {
        return this.AY;
    }
    
    @NotNull
    public Map<UUID, a> lp() {
        return this.AZ;
    }
    
    @Nullable
    public ir hY() {
        return this.qC;
    }
    
    public void a(@NotNull final ir qc) {
        this.qC = qc;
    }
    
    public static class b
    {
        private final int id;
        private final long Ba;
        
        public b(final int id, final long ba) {
            this.id = id;
            this.Ba = ba;
        }
        
        public int ee() {
            return this.id;
        }
        
        public long jk() {
            return this.Ba;
        }
    }
    
    public static class a
    {
        private final long Ba;
        private final int jX;
        
        public a(final long ba, final int jx) {
            this.Ba = ba;
            this.jX = jx;
        }
        
        public long jk() {
            return this.Ba;
        }
        
        public int ed() {
            return this.jX;
        }
    }
}
