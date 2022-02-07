package net.digitalingot.feather;

import org.jetbrains.annotations.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import net.minecraft.client.*;
import net.minecraft.util.*;
import net.minecraft.client.multiplayer.*;
import net.minecraft.client.gui.*;
import net.minecraft.client.network.*;

public class ia implements iy
{
    @NotNull
    private final ib AP;
    
    public ia(@NotNull final ib ap) {
        this.AP = ap;
    }
    
    @Override
    public void a(@NotNull final UUID uuid, @NotNull final dB.a a) {
        final ib.a a2 = this.AP.lp().remove(uuid);
        if (a2 == null || a2.jk() - TimeUnit.MINUTES.toMillis(10L) > System.currentTimeMillis()) {
            kk.FT.error("Received P2P Join Request from {} while it was never accepted or the request has timed out", new Object[] { uuid });
            return;
        }
        final bV l = e.s().l();
        l.b(new dy(), (Consumer<bT>)new Consumer<dB>() {
            public void a(final dB db) {
                final ir hy = ia.this.AP.hY();
                if (hy == null) {
                    return;
                }
                final is hp = hy.hP();
                if (hp == null) {
                    return;
                }
                final int ee = db.ee();
                hp.d(uuid, db.ej());
                l.b(new dz(ee, a2.ed(), a.ek(), a.eh()), (Consumer<bT>)new Consumer<dC>() {
                    public void a(final dC dc) {
                        ia.this.AP.ln().add(ee);
                    }
                }, (Consumer<bT>)null);
            }
        }, (Consumer<bT>)null);
    }
    
    @Override
    public void b(@NotNull final UUID uuid, @NotNull final dB.a a) {
        final ib.b b = this.AP.lo().remove(uuid);
        if (b == null || b.jk() - TimeUnit.MINUTES.toMillis(10L) > System.currentTimeMillis()) {
            kk.FT.error("Received P2P Join Accepted from {} while it was never requested or the request has timed out", new Object[] { uuid });
            return;
        }
        e.s().l().b(new dz(b.ee(), null, a.ek(), a.eh()), (Consumer<bT>)new Consumer<dC>() {
            public void a(final dC dc) {
                final Integer el = dc.el();
                if (el == null) {
                    throw new NullPointerException("Client port not expected to be null when accepting P2P Join without providing server port");
                }
                ia.this.AP.ln().add(b.ee());
                kk.FT.info("Created local P2P tunnel - port to connect to: {}", new Object[] { el });
                final Minecraft minecraft = Minecraft.getMinecraft();
                final NetHandlerPlayClient netHandler = minecraft.getNetHandler();
                if (netHandler != null) {
                    netHandler.getNetworkManager().closeChannel((IChatComponent)new ChatComponentText(""));
                }
                minecraft.displayGuiScreen((GuiScreen)new GuiConnecting((GuiScreen)new GuiMainMenu(), minecraft, "127.0.0.1", (int)el));
            }
        }, (Consumer<bT>)null);
    }
}
