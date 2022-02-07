package net.digitalingot.feather;

import org.jetbrains.annotations.*;
import java.net.*;
import net.minecraft.network.*;
import net.minecraft.entity.player.*;
import net.minecraft.client.network.*;

public class gl
{
    @NotNull
    private final ir qC;
    private boolean qE;
    
    public gl(@NotNull final ir qc) {
        this.qC = qc;
    }
    
    public void init() {
        final is is;
        final NetworkManager networkManager;
        InetSocketAddress inetSocketAddress;
        final String s;
        ab.bq.a((p0, netHandlerPlayClient) -> {
            this.qC.hP();
            if (is == null) {
                return;
            }
            else {
                netHandlerPlayClient.getNetworkManager();
                this.qE = (networkManager.isLocalChannel() || !(networkManager.getRemoteAddress() instanceof InetSocketAddress));
                if (this.qE) {
                    return;
                }
                else {
                    inetSocketAddress = (InetSocketAddress)networkManager.getRemoteAddress();
                    inetSocketAddress.getHostName();
                    is.a(s.endsWith(".") ? s.substring(0, s.length() - 1) : s, (short)inetSocketAddress.getPort());
                    return;
                }
            }
        });
        final is is2;
        ab.br.a((p0, p1) -> {
            this.qC.hP();
            if (is2 != null) {
                if (!this.qE) {
                    is2.mz();
                }
            }
        });
    }
}
