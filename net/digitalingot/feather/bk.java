package net.digitalingot.feather;

import org.jetbrains.annotations.*;
import java.util.function.*;

public class bk implements bW<cJ, ck, ci>
{
    @NotNull
    private final bg ck;
    
    public bk(@NotNull final bg ck) {
        this.ck = ck;
    }
    
    @Override
    public void a(final cJ cj, final Consumer<ck> consumer, final Consumer<ci> consumer2) {
        final cO de = cj.de();
        if (de != null) {
            final cO be = this.ck.bd().be();
            if (de.dj() != null) {
                be.a(de.dj());
            }
            if (de.dk() != null) {
                be.b(de.dk());
            }
            if (de.dn() != null) {
                be.c(de.dn());
            }
            if (de.do() != null) {
                be.u(de.do());
            }
        }
        final cK dd = cj.dd();
        if (dd != null) {
            final cK bf = this.ck.bd().bf();
            if (dd.di() != null) {
                bf.e(dd.di());
            }
            if (dd.dh() != null) {
                bf.d(dd.dh());
            }
        }
        this.ck.bb();
        consumer.accept(new ck("success"));
    }
}
