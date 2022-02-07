package net.digitalingot.feather;

import org.jetbrains.annotations.*;

public class l extends Exception
{
    public l(@NotNull final String s) {
        super(s);
    }
    
    public l(@NotNull final Throwable t) {
        super(t);
    }
}
