package net.digitalingot.feather;

import org.jetbrains.annotations.*;
import java.util.function.*;
import java.util.*;
import com.google.gson.*;

public class fb implements bW<de, ck, ci>
{
    @NotNull
    private final bg u;
    
    public fb(@NotNull final bg u) {
        this.u = u;
    }
    
    @Override
    public void a(final de de, final Consumer<ck> consumer, final Consumer<ci> consumer2) {
        final dW dz = de.dz();
        final dU m = e.s().m();
        final dQ<?> a = m.a(dz);
        final Object di = a.dI();
        if (de.dA() != null) {
            ((ea)di).enabled = de.dA();
        }
        if (de.dB() != null) {
            ((ea)di).jB = de.dB();
            final cO be = this.u.bd().be();
            if (de.dB()) {
                be.dl().add(de.dz());
            }
            else {
                be.dl().remove(de.dz());
            }
            this.u.bb();
        }
        if (de.dC() != null) {
            this.u.bb();
        }
        final Map<String, JsonElement> dd = de.dD();
        if (dd != null) {
            m.a(a, dd);
        }
        m.f(a);
        consumer.accept(new ck("success"));
    }
}
