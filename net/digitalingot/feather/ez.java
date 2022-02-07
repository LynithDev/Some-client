package net.digitalingot.feather;

import org.jetbrains.annotations.*;

public interface ez<T>
{
    @NotNull
    T b(@NotNull final String p0, @NotNull final Class<? extends T> p1);
    
    @NotNull
    String f(@NotNull final T p0);
}
