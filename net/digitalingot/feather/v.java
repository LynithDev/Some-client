package net.digitalingot.feather;

import java.util.*;
import org.jetbrains.annotations.*;

public interface v
{
    void a(final UUID p0, final t p1);
    
    void b(final List<a> p0);
    
    public static class a
    {
        @NotNull
        private final UUID an;
        @NotNull
        private final List<p> al;
        
        public a(@NotNull final UUID an, @NotNull final List<p> al) {
            this.an = an;
            this.al = al;
        }
        
        @NotNull
        public UUID ai() {
            return this.an;
        }
        
        @NotNull
        public List<p> af() {
            return this.al;
        }
    }
}
