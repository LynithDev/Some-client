package net.digitalingot.feather;

import io.netty.channel.nio.*;
import org.jetbrains.annotations.*;
import java.util.concurrent.*;
import io.netty.bootstrap.*;
import io.netty.util.*;
import io.netty.channel.*;
import java.net.*;
import java.io.*;
import io.netty.channel.socket.nio.*;
import java.util.*;
import io.netty.util.concurrent.*;
import java.util.function.*;
import java.util.stream.*;

public class hu implements Closeable
{
    @NotNull
    private final if qw;
    @NotNull
    private final hv zx;
    @NotNull
    private final hz zy;
    @NotNull
    private final hr zz;
    @NotNull
    private final NioEventLoopGroup iu;
    @NotNull
    private final Map<UUID, hF> zA;
    @NotNull
    private final List<hM> zB;
    @Nullable
    private hE zC;
    @Nullable
    private hC zD;
    @Nullable
    private hG zE;
    static final /* synthetic */ boolean ac;
    
    private hu(@NotNull final if qw, @NotNull final hv zx, @NotNull final hz zy) {
        this.zA = new HashMap<UUID, hF>();
        this.zB = new ArrayList<hM>();
        this.qw = qw;
        this.zx = zx;
        this.zy = zy;
        this.zz = new hs(this);
        this.iu = new NioEventLoopGroup(1);
    }
    
    public static hu a(@NotNull final k k, @NotNull final if if1, @NotNull final hv hv, @NotNull final hz hz) {
        kk.FT.info("Initializing voice...");
        final hu hu = new hu(if1, hv, hz);
        hu.c(k);
        final Iterator<hM> iterator;
        hu.ju().scheduleAtFixedRate(() -> {
            hu.jA().iterator();
            while (iterator.hasNext()) {
                iterator.next().kf();
            }
            return;
        }, 5L, 5L, TimeUnit.SECONDS);
        final hE he = new hE(hu);
        he.start();
        final hC hc = new hC(hu);
        hc.start();
        hu.a(he);
        hu.a(hc);
        return hu;
    }
    
    public void jq() {
        if (this.zE != null) {
            this.zE.ke().close();
        }
    }
    
    private void c(@NotNull final k k) {
        final Bootstrap bootstrap = new Bootstrap();
        bootstrap.group((EventLoopGroup)this.iu);
        bootstrap.channel((Class)NioSocketChannel.class);
        bootstrap.option(ChannelOption.SO_KEEPALIVE, (Object)true);
        bootstrap.remoteAddress(ht.zn, 5433);
        bootstrap.handler((ChannelHandler)new ChannelInitializer<Channel>() {
            protected void initChannel(final Channel channel) {
                final hI hi = new hI(channel, hu.this);
                channel.attr((AttributeKey)ht.zj).set((Object)hi);
                final ChannelPipeline pipeline = channel.pipeline();
                pipeline.addLast("packet-decoder", (ChannelHandler)new kT());
                pipeline.addLast("packet-encoder", (ChannelHandler)new kU());
                pipeline.addLast("controlPacketProcessor", (ChannelHandler)new hK());
                pipeline.addLast("unauthenticatedHandler", (ChannelHandler)new hL(hi));
                pipeline.addLast("inboundExceptionHandler", (ChannelHandler)new kW.a());
                pipeline.addLast("outboundExceptionHandler", (ChannelHandler)new kW.b());
            }
        });
        final ChannelFuture connect = bootstrap.connect();
        connect.addListener(future -> {
            if (!future.isSuccess()) {
                kk.FT.warn("Couldn't establish connection to voice control connection", future.cause());
                return;
            }
            final Channel channel = connect.channel();
            channel.config().setOption(ChannelOption.SO_RCVBUF, (Object)65536);
            channel.config().setOption(ChannelOption.SO_SNDBUF, (Object)65536);
            channel.config().setOption(ChannelOption.AUTO_READ, (Object)true);
            kk.FT.info("Established voice control connection to " + channel.remoteAddress());
            ((hI)channel.attr((AttributeKey)ht.zj).get()).au(k.K());
        });
        connect.channel().closeFuture().addListener(future -> {
            if (this.zE != null) {
                kk.FT.info("Control connection stopped.", future.cause());
                this.zE = null;
            }
            final Iterator<hM> iterator = hu.jA().iterator();
            while (iterator.hasNext()) {
                iterator.next().ke().close();
            }
            if (!this.iu.isShuttingDown()) {
                this.iu.schedule(() -> {
                    kk.FT.info("Reconnecting to voice control server...");
                    this.c(k);
                }, 5L, TimeUnit.SECONDS);
            }
        });
    }
    
    public void jr() {
        if (!hu.ac && this.zE == null) {
            throw new AssertionError();
        }
        String[] js;
        try {
            js = this.js();
        }
        catch (IOException ex) {
            kk.FT.error("Error while fetching voice IPs", (Throwable)ex);
            js = new String[] { ((InetSocketAddress)this.zE.ke().remoteAddress()).getAddress().getHostAddress() };
        }
        for (final String s : js) {
            final Bootstrap bootstrap = new Bootstrap();
            bootstrap.group((EventLoopGroup)this.iu);
            bootstrap.channel((Class)NioDatagramChannel.class);
            bootstrap.remoteAddress(s, 5432);
            bootstrap.handler((ChannelHandler)new ChannelInitializer<Channel>() {
                protected void initChannel(final Channel channel) {
                    final ChannelPipeline pipeline = channel.pipeline();
                    pipeline.addLast("packet-decoder", (ChannelHandler)new kT());
                    pipeline.addLast("packet-encoder", (ChannelHandler)new kU());
                    pipeline.addLast("voicePacketProcessor", (ChannelHandler)new hO());
                    pipeline.addLast("voiceConnectionHandler", (ChannelHandler)new hN(hu.this));
                    pipeline.addLast("inboundExceptionHandler", (ChannelHandler)new kW.a());
                    pipeline.addLast("outboundExceptionHandler", (ChannelHandler)new kW.b());
                }
            });
            final ChannelFuture connect = bootstrap.connect();
            final Channel channel = connect.channel();
            connect.addListener(future -> {
                final InetSocketAddress inetSocketAddress = (InetSocketAddress)channel.remoteAddress();
                final hM hm = new hM(hu, channel, inetSocketAddress.getAddress().equals(((InetSocketAddress)this.zE.ke().remoteAddress()).getAddress()));
                synchronized (this) {
                    hu.jA().add(hm);
                }
                channel.attr((AttributeKey)ht.zk).set((Object)hm);
                channel.config().setOption(ChannelOption.SO_RCVBUF, (Object)65536);
                channel.config().setOption(ChannelOption.SO_SNDBUF, (Object)65536);
                channel.config().setOption(ChannelOption.AUTO_READ, (Object)true);
                kk.FT.info("Established voice connection to " + inetSocketAddress + " - connected: " + hu.jA().stream().map((Function<? super Object, ?>)hM::ke).map((Function<? super Object, ?>)Channel::remoteAddress).collect((Collector<? super Object, ?, List<? super Object>>)Collectors.toList()));
                hm.kf();
            });
            channel.closeFuture().addListener(future -> {
                final hM hm = (hM)channel.attr((AttributeKey)ht.zk).get();
                if (hm != null) {
                    kk.FT.info("Voice connection to " + hm.ke().remoteAddress() + " closed");
                    synchronized (this) {
                        hu.jA().remove(hm);
                    }
                    if (hm.kg()) {
                        hu.jq();
                    }
                }
            });
        }
    }
    
    private String[] js() {
        return jt.aM(ht.zl).tk().split("\n");
    }
    
    @NotNull
    public if hS() {
        return this.qw;
    }
    
    @NotNull
    Map<UUID, hF> jt() {
        return this.zA;
    }
    
    @NotNull
    public NioEventLoopGroup ju() {
        return this.iu;
    }
    
    @NotNull
    public hv jv() {
        return this.zx;
    }
    
    @NotNull
    public hz jw() {
        return this.zy;
    }
    
    @NotNull
    public Set<UUID> jx() {
        final Iterator<hF> iterator = this.zA.values().iterator();
        while (iterator.hasNext()) {
            final hF hf = iterator.next();
            if (hf.ka() + 500L < System.currentTimeMillis()) {
                iterator.remove();
                hf.close();
            }
        }
        return this.zA.keySet();
    }
    
    @NotNull
    public hr jy() {
        return this.zz;
    }
    
    @Nullable
    public hM jz() {
        for (final hM hm : this.zB) {
            if (hm.kg()) {
                return hm;
            }
        }
        return null;
    }
    
    @NotNull
    public List<hM> jA() {
        return this.zB;
    }
    
    @Nullable
    public hG jB() {
        return this.zE;
    }
    
    public void a(@Nullable final hG ze) {
        this.zE = ze;
    }
    
    private void a(@NotNull final hE zc) {
        this.zC = zc;
    }
    
    public void a(@NotNull final hC zd) {
        this.zD = zd;
    }
    
    @Nullable
    hC jC() {
        return this.zD;
    }
    
    @Override
    public void close() {
        this.iu.shutdownGracefully();
        if (this.zC != null) {
            this.zC.close();
        }
        this.zy.close();
    }
    
    static {
        ac = !hu.class.desiredAssertionStatus();
    }
}
