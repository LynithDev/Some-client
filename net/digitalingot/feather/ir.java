package net.digitalingot.feather;

import io.netty.util.*;
import io.netty.channel.nio.*;
import org.jetbrains.annotations.*;
import java.util.*;
import io.netty.bootstrap.*;
import io.netty.channel.socket.nio.*;
import io.netty.channel.*;
import io.netty.util.concurrent.*;
import java.util.concurrent.*;

public class ir
{
    public static final AttributeKey<iu> BO;
    @NotNull
    private static final String BP;
    private static final int BQ = 1668;
    @NotNull
    private final ix BR;
    @NotNull
    private final iw BS;
    @NotNull
    private final iz BT;
    @NotNull
    private final iy BU;
    @NotNull
    private final NioEventLoopGroup iu;
    @Nullable
    private Channel iv;
    @NotNull
    private final Map<UUID, iD.a.c.b.c> BV;
    @Nullable
    private is BW;
    
    private ir(@NotNull final ix br, @NotNull final iw bs, @NotNull final iz bt, @NotNull final iy bu) {
        this.BV = new HashMap<UUID, iD.a.c.b.c>();
        this.BR = br;
        this.BS = bs;
        this.BT = bt;
        this.BU = bu;
        this.iu = new NioEventLoopGroup(1);
    }
    
    public static ir a(@NotNull final ix ix, @NotNull final iw iw, @NotNull final iz iz, @NotNull final iy iy, @NotNull final k k) {
        kk.FT.info("Initializing Redstone...");
        final ir ir = new ir(ix, iw, iz, iy);
        ir.e(k);
        return ir;
    }
    
    public void jq() {
        if (this.iv != null) {
            this.iv.close();
        }
    }
    
    private void e(@NotNull final k k) {
        final Bootstrap bootstrap = new Bootstrap();
        bootstrap.group((EventLoopGroup)this.iu);
        bootstrap.channel((Class)NioSocketChannel.class);
        bootstrap.option(ChannelOption.SO_KEEPALIVE, (Object)true);
        bootstrap.remoteAddress(ir.BP, 1668);
        bootstrap.handler((ChannelHandler)new ChannelInitializer<Channel>() {
            protected void initChannel(final Channel channel) {
                final iu iu = new iu(channel, ir.this);
                channel.attr((AttributeKey)ir.BO).set((Object)iu);
                final ChannelPipeline pipeline = channel.pipeline();
                pipeline.addLast("frame-decoder", (ChannelHandler)new kX());
                pipeline.addLast("frame-encoder", (ChannelHandler)new kY());
                pipeline.addLast("packet-decoder", (ChannelHandler)new kT());
                pipeline.addLast("packet-encoder", (ChannelHandler)new kU());
                pipeline.addLast("redstone-decoder", (ChannelHandler)new iB());
                pipeline.addLast("unauthenticatedHandler", (ChannelHandler)new iC(iu));
                pipeline.addLast("inboundExceptionHandler", (ChannelHandler)new kW.a());
                pipeline.addLast("outboundExceptionHandler", (ChannelHandler)new kW.b());
            }
        });
        final ChannelFuture connect = bootstrap.connect();
        connect.addListener(future -> {
            if (!future.isSuccess()) {
                kk.FT.warn("Couldn't establish connection to Redstone", future.cause());
                return;
            }
            if (k.K() == null) {
                throw new IllegalArgumentException("Game token couldn't be fetched");
            }
            this.iv = connect.channel();
            this.iv.config().setOption(ChannelOption.SO_RCVBUF, (Object)65536);
            this.iv.config().setOption(ChannelOption.SO_SNDBUF, (Object)65536);
            this.iv.config().setOption(ChannelOption.AUTO_READ, (Object)true);
            kk.FT.info("Established Redstone connection to " + this.iv.remoteAddress());
            ((iu)this.iv.attr((AttributeKey)ir.BO).get()).au(k.K());
        });
        connect.channel().closeFuture().addListener(future -> {
            kk.FT.info("Redstone connection stopped.", future.cause());
            this.iv = null;
            if (this.BW != null) {
                this.BW = null;
            }
            if (!this.iu.isShuttingDown()) {
                this.iu.schedule(() -> {
                    kk.FT.info("Reconnecting to Redstone...");
                    this.e(k);
                }, 5L, TimeUnit.SECONDS);
            }
        });
    }
    
    @NotNull
    public Map<UUID, iD.a.c.b.c> mu() {
        return this.BV;
    }
    
    @Nullable
    public is hP() {
        return this.BW;
    }
    
    public void c(@NotNull final is bw) {
        this.BW = bw;
    }
    
    @NotNull
    public ix mv() {
        return this.BR;
    }
    
    @NotNull
    public iw mw() {
        return this.BS;
    }
    
    @NotNull
    public iz mx() {
        return this.BT;
    }
    
    @NotNull
    public iy my() {
        return this.BU;
    }
    
    static {
        BO = AttributeKey.valueOf("unauthenticated-redstone-connection");
        BP = jQ.h("FEATHER_REDSTONE", "redstone.lb.feathermc.com");
    }
}
