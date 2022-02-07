package net.digitalingot.feather;

import org.jetbrains.annotations.*;
import java.io.*;

public class jz implements jr
{
    @NotNull
    private final InputStream EZ;
    
    public jz(@NotNull final InputStream ez) {
        this.EZ = ez;
    }
    
    @NotNull
    @Override
    public InputStream th() {
        return this.EZ;
    }
    
    @Override
    public void close() {
        jq.a(this.EZ);
    }
}
