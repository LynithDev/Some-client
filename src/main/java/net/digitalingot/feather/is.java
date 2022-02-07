package net.digitalingot.feather;

import org.jetbrains.annotations.*;
import io.netty.channel.*;
import java.util.function.*;
import java.util.*;
import org.capnproto.*;
import java.net.*;

public class is extends it
{
    @NotNull
    private List<UUID> BZ;
    
    is(@NotNull final Channel channel, @NotNull final ir ir) {
        super(channel, ir);
        this.BZ = new ArrayList<UUID>();
    }
    
    public void a(final Consumer<iE.f.e.a> consumer) {
        final MessageBuilder messageBuilder = new MessageBuilder();
        consumer.accept(this.c(messageBuilder).rv().pp().qd());
        this.a(messageBuilder);
    }
    
    public void a(@NotNull final String s, final short n) {
        final MessageBuilder messageBuilder = new MessageBuilder();
        final iE.f.d.a qg = this.c(messageBuilder).rv().pp().qg();
        qg.aG(s);
        qg.b(n);
        this.a(messageBuilder);
    }
    
    public void mz() {
        final MessageBuilder messageBuilder = new MessageBuilder();
        this.c(messageBuilder).rv().pp().d(Void.VOID);
        this.a(messageBuilder);
    }
    
    public void mA() {
        final MessageBuilder messageBuilder = new MessageBuilder();
        this.c(messageBuilder).ry().qU().g(Void.VOID);
        this.BZ.clear();
        this.a(messageBuilder);
    }
    
    public void a(@NotNull final List<UUID> bz, @NotNull final Set<UUID> set) {
        final ArrayList<UUID> list = new ArrayList<UUID>(bz);
        list.removeAll(this.BZ);
        final ArrayList<Object> list2 = new ArrayList<Object>(this.BZ);
        list2.removeAll(bz);
        if (list2.isEmpty() && list.isEmpty()) {
            return;
        }
        if (!list.isEmpty()) {
            final ArrayList list3 = new ArrayList<UUID>(list);
            list3.removeAll(set);
            if (!set.isEmpty()) {
                this.l((List<UUID>)list3);
            }
        }
        final MessageBuilder messageBuilder = new MessageBuilder();
        final iE.p.c.a rh = this.c(messageBuilder).ry().qU().rh();
        final DataList.Builder ab = rh.aB(list.size());
        for (int i = 0; i < list.size(); ++i) {
            ab.set(i, new Data.Reader(kq.r((UUID)list.get(i))));
        }
        final DataList.Builder ac = rh.aC(list2.size());
        for (int j = 0; j < list2.size(); ++j) {
            ac.set(j, new Data.Reader(kq.r(list2.get(j))));
        }
        this.BZ = bz;
        this.a(messageBuilder);
    }
    
    public void b(@NotNull final Set<UUID> set) {
        this.qC.mu().keySet().removeIf(uuid -> !set.contains(uuid));
        set.removeAll(this.qC.mu().keySet());
        if (set.isEmpty()) {
            return;
        }
        final MessageBuilder messageBuilder = new MessageBuilder();
        final DataList.Builder ap = this.c(messageBuilder).rB().ap(set.size());
        int n = 0;
        final Iterator<UUID> iterator = set.iterator();
        while (iterator.hasNext()) {
            ap.set(n, new Data.Reader(kq.r(iterator.next())));
            ++n;
        }
        this.a(messageBuilder);
    }
    
    public void k(@NotNull final List<p> list) {
        final MessageBuilder messageBuilder = new MessageBuilder();
        final TextList.Builder ag = this.c(messageBuilder).rG().ag(list.size());
        for (int i = 0; i < list.size(); ++i) {
            ag.set(i, new Text.Reader(list.get(i).getSlug()));
        }
        this.a(messageBuilder);
    }
    
    public void l(@NotNull final List<UUID> list) {
        final MessageBuilder messageBuilder = new MessageBuilder();
        final DataList.Builder ap = this.c(messageBuilder).rE().ap(list.size());
        for (int i = 0; i < list.size(); ++i) {
            ap.set(i, new Data.Reader(kq.r(list.get(i))));
        }
        this.a(messageBuilder);
    }
    
    public void a(@NotNull final t t) {
        final MessageBuilder messageBuilder = new MessageBuilder();
        this.c(messageBuilder).rJ().aE(t.getSlug());
        this.a(messageBuilder);
    }
    
    public void mB() {
        final MessageBuilder messageBuilder = new MessageBuilder();
        this.c(messageBuilder).rM();
        this.a(messageBuilder);
    }
    
    public void o(@NotNull final UUID uuid) {
        final MessageBuilder messageBuilder = new MessageBuilder();
        this.c(messageBuilder).rP().j(kq.r(uuid));
        this.a(messageBuilder);
    }
    
    public void p(@NotNull final UUID uuid) {
        final MessageBuilder messageBuilder = new MessageBuilder();
        this.c(messageBuilder).rR().j(kq.r(uuid));
        this.a(messageBuilder);
    }
    
    public void b(final int n, final boolean b) {
        final MessageBuilder messageBuilder = new MessageBuilder();
        final iE.k.a ru = this.c(messageBuilder).rU();
        ru.am(n);
        ru.u(b);
        this.a(messageBuilder);
    }
    
    public void mC() {
        final MessageBuilder messageBuilder = new MessageBuilder();
        this.c(messageBuilder).rW().qB().e(Void.VOID);
        this.a(messageBuilder);
    }
    
    public void q(@NotNull final UUID uuid) {
        final MessageBuilder messageBuilder = new MessageBuilder();
        this.c(messageBuilder).rW().qB().j(kq.r(uuid));
        this.a(messageBuilder);
    }
    
    public void a(@NotNull final iF.b b) {
        final MessageBuilder messageBuilder = new MessageBuilder();
        this.c(messageBuilder).rZ().qL().a(b);
        this.a(messageBuilder);
    }
    
    public void c(@NotNull final UUID uuid, @NotNull final dB.a a) {
        final MessageBuilder messageBuilder = new MessageBuilder();
        final iE.h.a sb = this.c(messageBuilder).sb();
        this.a(sb.nt(), a);
        sb.j(kq.r(uuid));
        this.a(messageBuilder);
    }
    
    public void d(@NotNull final UUID uuid, @NotNull final dB.a a) {
        final MessageBuilder messageBuilder = new MessageBuilder();
        final iE.g.a sd = this.c(messageBuilder).sd();
        this.a(sd.nt(), a);
        sd.i(kq.r(uuid));
        this.a(messageBuilder);
    }
    
    private void a(@NotNull final iF.a.a a, @NotNull final dB.a a2) {
        final InetSocketAddress ek = a2.ek();
        a.aL(ek.getAddress().getHostAddress() + ":" + ek.getPort());
        a.k(a2.eh());
    }
}
