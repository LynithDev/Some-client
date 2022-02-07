package net.digitalingot.feather;

import org.jetbrains.annotations.*;
import java.io.*;

public class jx implements jr
{
    @NotNull
    private final String EY;
    @Nullable
    private InputStream EZ;
    
    public jx(@NotNull final String ey) {
        this.EY = ey;
    }
    
    @NotNull
    @Override
    public InputStream th() {
        this.EZ = this.getClass().getClassLoader().getResourceAsStream(this.EY);
        if (this.EZ == null) {
            throw new RuntimeException("Could not find resource: " + this.EY);
        }
        return this.EZ;
    }
    
    @Override
    public void close() {
        jq.a(this.EZ);
        this.EZ = null;
    }
}
