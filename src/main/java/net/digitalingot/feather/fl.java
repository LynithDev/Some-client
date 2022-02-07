package net.digitalingot.feather;

import java.util.function.*;
import java.util.*;

public class fl implements bW<dF, ck, ci>
{
    @Override
    public void a(final dF df, final Consumer<ck> consumer, final Consumer<ci> consumer2) {
        final dU m = e.s().m();
        final Iterator<dW> iterator = df.ep().iterator();
        while (iterator.hasNext()) {
            final dQ<?> a = m.a(iterator.next());
            if (a.eR().eM().fl().fh().isEmpty()) {
                continue;
            }
            m.c(a);
        }
        fk.a(m);
        consumer.accept(new ck("success"));
    }
}
