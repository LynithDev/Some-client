package net.digitalingot.feather;

import org.jetbrains.annotations.*;
import java.io.*;

public class d implements f
{
    @NotNull
    private final bV s;
    @NotNull
    private final dU t;
    @NotNull
    private final bg u;
    @NotNull
    private final File v;
    @NotNull
    private final File w;
    @NotNull
    private final String x;
    
    public d(@NotNull final bV s, @NotNull final dU t, @NotNull final bg u, @NotNull final File v, @NotNull final File w, @NotNull final String x) {
        this.s = s;
        this.t = t;
        this.u = u;
        this.v = v;
        this.w = w;
        this.x = x;
    }
    
    @NotNull
    @Override
    public bV l() {
        return this.s;
    }
    
    @NotNull
    @Override
    public dU m() {
        return this.t;
    }
    
    @NotNull
    @Override
    public bg n() {
        return this.u;
    }
    
    @NotNull
    @Override
    public File o() {
        return this.v;
    }
    
    @NotNull
    @Override
    public File p() {
        return this.w;
    }
    
    @NotNull
    @Override
    public String g() {
        return this.x;
    }
}
