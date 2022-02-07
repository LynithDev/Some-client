package net.digitalingot.feather;

import org.jetbrains.annotations.*;
import org.capnproto.*;
import io.netty.channel.*;

public class iu extends it
{
    public iu(@NotNull final Channel channel, @NotNull final ir ir) {
        super(channel, ir);
    }
    
    public void au(@NotNull final String s) {
        kk.FT.info("Authenticating with Redstone...");
        final MessageBuilder messageBuilder = new MessageBuilder();
        this.c(messageBuilder).rs().av(s);
        this.a(messageBuilder);
    }
    
    public void mD() {
        kk.FT.info("Authenticated with Redstone");
        final is is = new is(this.iv, this.qC);
        this.qC.c(is);
        this.iv.pipeline().replace("unauthenticatedHandler", "authenticatedHandler", (ChannelHandler)new iA(is));
        iq.a(is);
    }
}
