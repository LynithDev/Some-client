package net.digitalingot.feather;

import java.util.function.*;
import java.util.*;

public class fa implements bW<dd, ck, ci>
{
    @Override
    public void a(final dd dd, final Consumer<ck> consumer, final Consumer<ci> consumer2) {
        final dU m = e.s().m();
        final Iterator<dW> iterator = dd.dx().iterator();
        while (iterator.hasNext()) {
            final dQ<?> a = m.a(iterator.next());
            if (!a.eR().eM().fl().fh().isEmpty()) {
                continue;
            }
            m.c(a);
        }
        ff.a(m);
        consumer.accept(new ck("success"));
    }
}
