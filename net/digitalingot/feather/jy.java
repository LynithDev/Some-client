package net.digitalingot.feather;

import org.jetbrains.annotations.*;
import java.io.*;

public class jy implements jr, ju
{
    @NotNull
    private final File lO;
    @Nullable
    private InputStream EZ;
    @Nullable
    private OutputStream Fa;
    
    public jy(@NotNull final File lo) {
        this.lO = lo;
    }
    
    @NotNull
    @Override
    public InputStream th() {
        if (this.EZ != null) {
            return this.EZ;
        }
        try {
            return this.EZ = new FileInputStream(this.lO);
        }
        catch (Exception ex) {
            throw new js(ex);
        }
    }
    
    @NotNull
    @Override
    public OutputStream tm() {
        if (this.Fa != null) {
            return this.Fa;
        }
        try {
            return this.Fa = new FileOutputStream(this.lO);
        }
        catch (Exception ex) {
            throw new js(ex);
        }
    }
    
    @Override
    public void close() {
        jq.a(this.EZ, this.Fa);
        this.EZ = null;
        this.Fa = null;
    }
}
