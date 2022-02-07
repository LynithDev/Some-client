package net.digitalingot.feather;

import org.jetbrains.annotations.*;
import java.io.*;

public class jv implements jr
{
    @NotNull
    private final jr EU;
    @Nullable
    private BufferedInputStream EV;
    
    public jv(@NotNull final jr eu) {
        this.EU = eu;
    }
    
    @NotNull
    @Override
    public InputStream th() {
        return this.EV = new BufferedInputStream(this.EU.th());
    }
    
    @Override
    public void close() {
        jq.a(this.EV);
        this.EU.close();
    }
}
