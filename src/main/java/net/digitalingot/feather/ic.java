package net.digitalingot.feather;

import org.jetbrains.annotations.*;
import java.util.function.*;

public class ic
{
    public static class b implements bW<dA, cj, ci>
    {
        @NotNull
        private final ib AP;
        
        public b(@NotNull final ib ap) {
            this.AP = ap;
        }
        
        @Override
        public void a(final dA da, final Consumer<cj> consumer, final Consumer<ci> consumer2) {
            this.AP.lo().put(da.ei(), new ib.b(da.ee(), System.currentTimeMillis()));
            final ir hy = this.AP.hY();
            final is is = (hy != null) ? hy.hP() : null;
            if (is == null) {
                consumer2.accept(new ci("redstone connection not established"));
                return;
            }
            e.s().l().b(new dy(), (Consumer<bT>)new Consumer<dB>() {
                public void a(final dB db) {
                    is.c(da.ei(), db.ej());
                }
            }, (Consumer<bT>)consumer2);
        }
    }
    
    public static class a implements bW<dw, cj, ci>
    {
        @NotNull
        private final ib AP;
        
        public a(@NotNull final ib ap) {
            this.AP = ap;
        }
        
        @Override
        public void a(final dw dw, final Consumer<cj> consumer, final Consumer<ci> consumer2) {
            this.AP.lp().put(dw.ec(), new ib.a(System.currentTimeMillis(), dw.ed()));
        }
    }
}
