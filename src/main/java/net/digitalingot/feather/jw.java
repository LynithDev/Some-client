package net.digitalingot.feather;

import org.jetbrains.annotations.*;
import java.io.*;

public class jw implements ju
{
    @NotNull
    private final ju EW;
    @Nullable
    private BufferedOutputStream EX;
    
    public jw(@NotNull final ju ew) {
        this.EW = ew;
    }
    
    @NotNull
    @Override
    public OutputStream tm() {
        return this.EX = new BufferedOutputStream(this.EW.tm());
    }
    
    @Override
    public void close() {
        jq.a(this.EX);
        this.EW.close();
    }
}
