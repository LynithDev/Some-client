package net.digitalingot.feather;

import org.jetbrains.annotations.*;
import java.io.*;
import java.util.*;

public class bg
{
    @NotNull
    private final bi ce;
    @NotNull
    private final File bi;
    
    public bg(@NotNull final File file) {
        this.bi = new File(file, "client_preferences.json");
        try {
            if (!this.bi.exists()) {
                this.bi.getParentFile().mkdirs();
                this.bi.createNewFile();
            }
        }
        catch (IOException ex) {
            kk.FT.error("Error while trying to create preferences file", (Throwable)ex);
        }
        bi ce;
        try {
            ce = jt.m(this.bi).a(bV.GSON, bi.class);
        }
        catch (Exception ex2) {
            ce = this.bc();
        }
        if (ce == null) {
            ce = this.bc();
        }
        this.a(ce);
        this.ce = ce;
    }
    
    private void a(final bi bi) {
        final cO be = bi.be();
        if (be.dl() == null) {
            be.f(new ArrayList<dW>());
        }
        if (be.dm() == null) {
            be.g(new ArrayList<dW>());
        }
        if (be.dn() == null) {
            be.c(false);
        }
        if (be.do() == null) {
            be.u("https://assets.feathercdn.net/game/modpreview/background1.webp");
        }
    }
    
    public void bb() {
        jt.m(this.bi).a(bV.GSON, this.ce);
    }
    
    @NotNull
    private bi bc() {
        return new bi(new cO(false, false, new ArrayList<dW>(), new ArrayList<dW>(), false, "https://assets.feathercdn.net/game/modpreview/background1.webp"), new cK(new ArrayList<String>(), new ArrayList<String>()));
    }
    
    @NotNull
    public bi bd() {
        return this.ce;
    }
}
