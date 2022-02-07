package net.digitalingot.feather;

import java.util.function.*;

public class fh implements bW<dm, ck, ci>
{
    @Override
    public void a(final dm dm, final Consumer<ck> consumer, final Consumer<ci> consumer2) {
        final eS gi = e.s().m().ff().gI();
        new eR(gi, dm.dJ()).gG().renameTo(new eR(gi, dm.dK()).gG());
        if (gi.gL().getName().equals(dm.dJ())) {
            gi.C(dm.dK());
        }
        consumer.accept(new ck("success"));
    }
}
