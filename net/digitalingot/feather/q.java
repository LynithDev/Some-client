package net.digitalingot.feather;

import org.jetbrains.annotations.*;
import java.util.*;

public class q implements iw
{
    @NotNull
    private final v aa;
    @NotNull
    private final r ab;
    static final /* synthetic */ boolean ac;
    
    q(@NotNull final v aa, @NotNull final r ab) {
        this.aa = aa;
        this.ab = ab;
    }
    
    @Override
    public void a(final UUID uuid, final String s) {
        final t l = this.ab.l(s);
        if (l == null) {
            kk.FT.info("received an unknown slug as an incoming emote: {}", new Object[] { s });
            return;
        }
        this.aa.a(uuid, l);
    }
    
    @Override
    public void b(final List<iv> list) {
        final ArrayList<v.a> list2 = new ArrayList<v.a>(list.size());
        for (final iv iv : list) {
            final ArrayList list3 = new ArrayList<p>(iv.mE().size());
            for (final String s : iv.mE()) {
                final p k = this.ab.k(s);
                if (k == null) {
                    kk.FT.info("received an unknown slug as an incoming cosmetic: {}", new Object[] { s });
                }
                else {
                    list3.add(k);
                }
            }
            list2.add(new v.a(iv.ai(), (List<p>)list3));
        }
        this.aa.b(list2);
    }
    
    @Override
    public void c(final List<String> list) {
        this.ab.ab().clear();
        this.ab.ac().clear();
        for (final String s : list) {
            switch (q$1.ad[this.ab.j(s).ordinal()]) {
                case 1: {
                    final p k = this.ab.k(s);
                    if (!q.ac && k == null) {
                        throw new AssertionError();
                    }
                    this.ab.ab().put(s, k);
                    continue;
                }
                case 2: {
                    final t l = this.ab.l(s);
                    if (!q.ac && l == null) {
                        throw new AssertionError();
                    }
                    this.ab.ac().put(s, l);
                    continue;
                }
                case 3: {
                    kk.FT.info("received an unknown slug as an owned cosmetic: {}", new Object[] { s });
                    continue;
                }
            }
        }
        H.b(this.ab.ae());
    }
    
    static {
        ac = !q.class.desiredAssertionStatus();
    }
}
