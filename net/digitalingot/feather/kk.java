package net.digitalingot.feather;

import org.jetbrains.annotations.*;
import org.apache.logging.log4j.*;

public class kk
{
    @NotNull
    public static final Logger FT;
    
    static {
        FT = LogManager.getLogger("Feather");
    }
}
