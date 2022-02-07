package net.digitalingot.feather;

import org.jetbrains.annotations.*;
import org.capnproto.*;
import io.netty.channel.*;
import io.netty.util.concurrent.*;

public abstract class it
{
    @NotNull
    protected final Channel iv;
    @NotNull
    protected final ir qC;
    
    protected it(@NotNull final Channel iv, @NotNull final ir qc) {
        this.iv = iv;
        this.qC = qc;
    }
    
    @NotNull
    protected iE.q.c.a c(final MessageBuilder messageBuilder) {
        return ((iE.q.a)messageBuilder.initRoot((FromPointerBuilder)iE.q.DK)).ro();
    }
    
    @NotNull
    public ir hY() {
        return this.qC;
    }
    
    protected void a(final MessageBuilder messageBuilder) {
        if (this.iv.eventLoop().inEventLoop()) {
            this.iv.writeAndFlush((Object)messageBuilder).addListener((GenericFutureListener)ChannelFutureListener.FIRE_EXCEPTION_ON_FAILURE);
        }
        else {
            this.iv.eventLoop().submit(() -> this.iv.writeAndFlush((Object)messageBuilder).addListener((GenericFutureListener)ChannelFutureListener.FIRE_EXCEPTION_ON_FAILURE));
        }
    }
}
