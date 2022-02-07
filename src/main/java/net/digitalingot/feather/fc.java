package net.digitalingot.feather;

import java.util.function.*;
import java.nio.file.*;

public class fc implements bW<dh, ck, ci>
{
    @Override
    public void a(final dh dh, final Consumer<ck> consumer, final Consumer<ci> consumer2) {
        final eS gi = e.s().m().ff().gI();
        final eR er = new eR(gi, dh.dJ());
        final eR er2 = new eR(gi, dh.dK());
        if (er2.gG().exists()) {
            throw new IllegalArgumentException("Profile already exists");
        }
        Files.copy(er.gG().toPath(), er2.gG().toPath(), new CopyOption[0]);
        consumer.accept(new ck("success"));
    }
}
