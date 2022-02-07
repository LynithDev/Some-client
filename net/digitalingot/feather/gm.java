package net.digitalingot.feather;

import net.minecraft.client.*;
import net.minecraft.client.network.*;
import java.util.*;
import org.jetbrains.annotations.*;
import net.minecraft.entity.player.*;

public class gm
{
    @NotNull
    private final ir qC;
    @NotNull
    private final fV qv;
    @NotNull
    private final fX qy;
    private int qF;
    
    private gm(@NotNull final ir qc, @NotNull final fV qv, @NotNull final fX qy) {
        this.qC = qc;
        this.qv = qv;
        this.qy = qy;
    }
    
    @Nullable
    public static gm a(@NotNull final i i) {
        final gk gk = new gk();
        final fV fv = new fV();
        final fX fx = new fX(i);
        final ib lm = ib.lm();
        final ia ia = new ia(lm);
        final k h = i.H();
        if (h.K() == null) {
            return null;
        }
        final ir a = ir.a(gk, fv.hQ().Y(), fx.hS().lt(), ia, h);
        lm.a(a);
        final gm gm = new gm(a, fv, fx);
        fv.a(gm);
        new gl(a).init();
        final fZ fz = new fZ(fx.hL(), a, fx);
        final ao<ad> bk = ad.bk;
        final fZ fz2 = fz;
        Objects.requireNonNull(fz2);
        bk.a(fz2::a);
        ab.br.a((entityPlayer, p2) -> a.mu().keySet().removeIf(uuid -> !uuid.equals(entityPlayer.func_110124_au())));
        final gm gm2;
        final NetHandlerPlayClient netHandlerPlayClient;
        final Collection<NetworkPlayerInfo> collection;
        HashSet<UUID> set;
        final Iterator<NetworkPlayerInfo> iterator;
        final ir ir;
        final is is;
        an.bE.a(c -> {
            if (c != an.c.START) {
                return;
            }
            else if (++gm2.qF != 20) {
                return;
            }
            else {
                gm2.qF = 0;
                Minecraft.getMinecraft().getNetHandler();
                if (netHandlerPlayClient == null) {
                    return;
                }
                else {
                    netHandlerPlayClient.getPlayerInfoMap();
                    set = new HashSet<UUID>(collection.size());
                    collection.iterator();
                    while (iterator.hasNext()) {
                        set.add(iterator.next().getGameProfile().getId());
                    }
                    ir.hP();
                    if (is != null) {
                        is.b(set);
                    }
                    return;
                }
            }
        });
        return gm;
    }
    
    @NotNull
    public ir hY() {
        return this.qC;
    }
    
    @NotNull
    public fV hZ() {
        return this.qv;
    }
    
    @NotNull
    public fX ia() {
        return this.qy;
    }
}
