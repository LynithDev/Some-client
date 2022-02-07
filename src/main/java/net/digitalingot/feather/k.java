package net.digitalingot.feather;

import org.jetbrains.annotations.*;
import java.util.*;
import java.util.concurrent.*;
import java.io.*;

public class k implements Closeable
{
    @NotNull
    private final i F;
    @NotNull
    private final Timer G;
    @Nullable
    private String H;
    private long I;
    @Nullable
    private String J;
    private long K;
    
    public k(@NotNull final i f) {
        this.G = new Timer();
        this.F = f;
        this.G.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                k.this.J = k.this.E();
            }
        }, TimeUnit.MINUTES.toMillis(14L), TimeUnit.MINUTES.toMillis(14L));
    }
    
    public void I() {
        this.D();
        this.J = this.E();
        this.G.purge();
        this.G.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                k.this.J = k.this.E();
            }
        }, TimeUnit.MINUTES.toMillis(14L), TimeUnit.MINUTES.toMillis(14L));
        this.G.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                k.this.D();
            }
        }, TimeUnit.HOURS.toMillis(23L), TimeUnit.HOURS.toMillis(23L));
        this.F.G();
    }
    
    @Nullable
    public String J() {
        if (System.currentTimeMillis() > this.I + TimeUnit.HOURS.toMillis(23L)) {
            this.D();
        }
        return this.H;
    }
    
    void i(@NotNull final String h) {
        kk.FT.info("Setting core backend token");
        this.I = System.currentTimeMillis();
        this.H = h;
    }
    
    private void D() {
        this.I = System.currentTimeMillis();
        try {
            this.F.D();
        }
        catch (IOException ex) {
            kk.FT.error("Error during fetching JWT Token", (Throwable)ex);
        }
    }
    
    @Nullable
    public String K() {
        if (System.currentTimeMillis() > this.K + TimeUnit.SECONDS.toMillis(870L)) {
            this.J = this.E();
        }
        return this.J;
    }
    
    @Nullable
    private String E() {
        this.K = System.currentTimeMillis();
        try {
            kk.FT.debug("Fetching new game token...");
            return this.F.E();
        }
        catch (IOException ex) {
            kk.FT.error("Error during fetching game token", (Throwable)ex);
            return null;
        }
    }
    
    @Override
    public void close() {
        this.G.cancel();
    }
}
