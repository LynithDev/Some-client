package net.digitalingot.feather;

import org.jetbrains.annotations.*;
import java.util.*;

class hs implements hr
{
    @NotNull
    private final hu yW;
    static final /* synthetic */ boolean ac;
    
    public hs(@NotNull final hu yw) {
        this.yW = yw;
    }
    
    @Override
    public void jp() {
    }
    
    @Override
    public void a(final UUID uuid, final long n, final byte[] array, final hT.c c) {
        System.out.println("receiving audio from " + uuid + " -> " + n);
        hF hf = this.yW.jt().computeIfAbsent(uuid, p0 -> new hF());
        if (hf.ka() + 500L < System.currentTimeMillis()) {
            hf.close();
            hf = new hF();
            this.yW.jt().put(uuid, hf);
        }
        if (n < hf.kb()) {
            System.out.println("ignoring old packets: " + n + " vs. " + hf.kb());
            return;
        }
        final hC jc = this.yW.jC();
        if (!hs.ac && jc == null) {
            throw new AssertionError();
        }
        jc.jX().add(new hx(hf, uuid, c, n, array));
    }
    
    static {
        ac = !hs.class.desiredAssertionStatus();
    }
}
