package net.digitalingot.feather;

import org.jetbrains.annotations.*;
import java.util.*;

public class ie implements iz
{
    @NotNull
    private final ih Bh;
    @NotNull
    private final if qw;
    
    ie(@NotNull final ih bh, @NotNull final if qw) {
        this.Bh = bh;
        this.qw = qw;
    }
    
    @Override
    public void a(final UUID uuid, final List<UUID> list, final iF.b b) {
        final id id = new id(uuid, list, b);
        this.qw.b(id);
        this.Bh.a(id);
    }
    
    @Override
    public void a(final int n, final UUID uuid) {
        final ig ig = new ig(n, uuid);
        this.qw.lu().add(ig);
        this.Bh.a(ig);
    }
    
    @Override
    public void h(final UUID uuid) {
        this.Bh.h(uuid);
    }
    
    @Override
    public void hU() {
        this.qw.b(null);
        this.Bh.hU();
    }
}
