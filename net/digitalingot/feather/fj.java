package net.digitalingot.feather;

import org.jetbrains.annotations.*;
import java.util.*;

public class fj
{
    public static void a(@NotNull final dU du) {
        final Set<Map.Entry<dW, dQ<?>>> entrySet = du.dL().entrySet();
        final TreeMap<Integer, Object> treeMap = new TreeMap<Integer, Object>();
        for (final Map.Entry<dW, dQ<?>> entry : entrySet) {
            final dW dw = entry.getKey();
            final dQ<?> dq = entry.getValue();
            final dV em = dq.eR().eM();
            if (em.fl().fh().isEmpty()) {
                continue;
            }
            treeMap.put(em.fl().fm().fS(), new dD.a(em.fh(), dw, em.fl().fh(), em.fi(), em.fj(), eV.g(dq.dI())));
        }
        e.s().l().b(new dD(new ArrayList<dD.a>(treeMap.values())));
    }
}
