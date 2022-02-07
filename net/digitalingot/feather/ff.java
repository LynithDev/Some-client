package net.digitalingot.feather;

import org.jetbrains.annotations.*;
import java.util.*;

public class ff
{
    public static void a(@NotNull final dU du) {
        final HashMap<dW, dg> hashMap = new HashMap<dW, dg>(du.dL().size());
        for (final Map.Entry<dW, dQ<?>> entry : du.dL().entrySet()) {
            final dW dw = entry.getKey();
            final dQ<?> dq = entry.getValue();
            if (!dq.eR().eM().fl().fh().isEmpty()) {
                continue;
            }
            hashMap.put(dw, new dg((ea)dq.dI()));
        }
        e.s().l().b(new dk(hashMap));
    }
}
