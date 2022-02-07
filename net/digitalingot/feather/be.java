package net.digitalingot.feather;

import com.google.common.collect.*;
import org.jetbrains.annotations.*;
import java.util.*;

public class be
{
    @NotNull
    private static final ImmutableMap<Integer, Integer> cd;
    
    public static void a(@NotNull final dU du) {
        e.s().l().b(new cY(b(du)));
    }
    
    @NotNull
    private static Map<Integer, cY.a> b(@NotNull final dU du) {
        final TreeMap<Integer, cY.a> treeMap = new TreeMap<Integer, cY.a>();
        for (final dQ<ea> dq : du.dL().values()) {
            final ea di = dq.dI();
            final ef ef = di.getClass().getDeclaredAnnotation(ef.class);
            if (ef == null) {
                continue;
            }
            final ek fd = ef.fD();
            if (fd.fN().isEmpty()) {
                continue;
            }
            if (!di.enabled || !di.kX) {
                continue;
            }
            if (du.fg().contains(dq.eR().eL())) {
                continue;
            }
            treeMap.put(fd.fO(), new cY.a(fd.fN(), fd.fh(), fd.fi()));
        }
        final HashMap hashMap = new HashMap<Integer, cY.a>(treeMap.size());
        hashMap.put((Integer)be.cd.get((Object)0), new cY.a("cosmetics", "Cosmetics", "https://assets.feathercdn.net/game/hudselection/cosmetics.svg"));
        int n = 1;
        final Iterator<cY.a> iterator2 = treeMap.values().iterator();
        while (iterator2.hasNext()) {
            hashMap.put((Integer)be.cd.get((Object)(n++)), (cY.a)iterator2.next());
        }
        return (Map<Integer, cY.a>)hashMap;
    }
    
    static {
        cd = ImmutableMap.builder().put((Object)0, (Object)6).put((Object)1, (Object)2).put((Object)2, (Object)4).put((Object)3, (Object)0).put((Object)4, (Object)1).put((Object)5, (Object)3).put((Object)6, (Object)5).put((Object)7, (Object)7).build();
    }
}
