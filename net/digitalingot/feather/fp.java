package net.digitalingot.feather;

import org.jetbrains.annotations.*;
import java.util.function.*;
import java.util.*;

public class fp
{
    @NotNull
    private final dU t;
    
    public fp(@NotNull final dU t) {
        this.t = t;
    }
    
    public void gU() {
        this.m(true);
        this.l(true);
    }
    
    public void gV() {
        this.l(false);
    }
    
    private void l(final boolean b) {
        while (this.t.fe().iterator().hasNext()) {
            final Iterator<Class<? extends dQ<?>>> iterator;
            final Map.Entry<dW, dQ<?>> entry2 = this.t.dL().entrySet().stream().filter(entry -> entry.getValue().getClass() == iterator.next()).findFirst().orElseThrow((Supplier<? extends Throwable>)IllegalStateException::new);
            final dW dw = entry2.getKey();
            final dQ<ea> dq = entry2.getValue();
            if (b && dw.isCore()) {
                continue;
            }
            if (!dq.dI().dG() || this.t.fg().contains(dq.eR().eL())) {
                continue;
            }
            this.i(dq);
        }
    }
    
    public void gW() {
        this.m(false);
    }
    
    private void m(final boolean b) {
        for (int i = this.t.fe().size() - 1; i >= 0; --i) {
            final List<Class<? extends dQ<?>>> list;
            final Map.Entry<dW, dQ<?>> entry2 = this.t.dL().entrySet().stream().filter(entry -> entry.getValue().getClass() == list.get(i)).findFirst().orElseThrow((Supplier<? extends Throwable>)IllegalStateException::new);
            final dW dw = entry2.getKey();
            final dQ<?> dq = entry2.getValue();
            if (!b || !dw.isCore()) {
                if (dq.eS()) {
                    this.j(dq);
                }
            }
        }
    }
    
    public void i(@NotNull final dQ<?> dq) {
        dq.h(true);
        if (!dq.q()) {
            dq.initialize();
            dq.i(true);
        }
        dq.eN();
        dq.eP();
        Z.bk.aH().loadedStateChange(dq, true);
    }
    
    public void j(@NotNull final dQ<?> dq) {
        if (!dq.eS()) {
            return;
        }
        dq.h(false);
        dq.eO();
        Z.bk.aH().loadedStateChange(dq, false);
    }
}
