package net.digitalingot.feather;

import org.jetbrains.annotations.*;
import java.util.*;

public class fk
{
    public static void a(@NotNull final dU du) {
        final HashMap<dW, dH> hashMap = new HashMap<dW, dH>();
        for (final Map.Entry<dW, dQ<?>> entry : du.dL().entrySet()) {
            final dW dw = entry.getKey();
            final dQ<?> dq = entry.getValue();
            if (dq.eR().eM().fl().fh().isEmpty()) {
                continue;
            }
            hashMap.put(dw, new dH((ea)dq.dI()));
        }
        e.s().l().b(new dE(hashMap));
    }
}
