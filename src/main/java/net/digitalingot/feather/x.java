package net.digitalingot.feather;

import net.minecraft.util.*;
import java.nio.file.*;
import net.minecraft.client.resources.*;
import org.jetbrains.annotations.*;
import net.digitalingot.fwebp.*;
import java.io.*;
import java.util.*;
import net.minecraft.client.*;
import java.util.concurrent.*;

public class x
{
    private static final dT<fR> ao;
    private static final z ap;
    private static final ResourceLocation aq;
    private static final IResourceManager ar;
    private static final Executor as;
    private boolean at;
    private D au;
    private long av;
    private final Path aw;
    private final Map<String, F> ax;
    private final A ay;
    public static final x az;
    
    public x() {
        this.aw = e.s().o().toPath().resolve("assets/game/cosmetics/cloaks");
        this.ax = new HashMap<String, F>();
        this.ay = new A();
        an.bH.a((c, p1) -> {
            if (c == an.c.END) {
                this.al();
            }
        });
    }
    
    private void aj() {
        if (this.at) {
            return;
        }
        this.at = true;
        final IResource resource;
        final InputStream inputStream;
        final y y;
        x.as.execute(() -> {
            try {
                x.ar.getResource(x.aq);
                if (resource != null) {
                    resource.getInputStream();
                    try {
                        net.digitalingot.feather.y.a(inputStream, x.ap);
                        if (inputStream != null) {
                            inputStream.close();
                        }
                    }
                    catch (Throwable t) {
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            }
                            catch (Throwable t2) {
                                t.addSuppressed(t2);
                            }
                        }
                        throw t;
                    }
                    this.au = c.i().a(() -> D.b(y)).get();
                }
            }
            catch (Exception ex) {
                kk.FT.error("Error while loading cloak model", (Throwable)ex);
            }
            finally {
                this.at = false;
            }
        });
    }
    
    public D ak() {
        if (this.au == null) {
            this.aj();
            return null;
        }
        return this.au;
    }
    
    private void m(@NotNull final String s) {
        if (this.at) {
            return;
        }
        this.at = true;
        final File file;
        final F f;
        x.as.execute(() -> {
            try {
                this.aw.resolve(s + ".webp").toFile();
                if (!(!file.exists())) {
                    new G(x.ap).a(new WebPImage(jt.m(file).ti().tj())).aB();
                    if (f == null) {
                        kk.FT.error("[Cloak] Failed to load animation for " + s);
                    }
                    else {
                        this.ax.put(s, f);
                    }
                }
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
            finally {
                this.at = false;
            }
        });
    }
    
    public F n(@NotNull final String s) {
        final F f = this.ax.get(s);
        if (f == null) {
            this.m(s);
        }
        return f;
    }
    
    private void al() {
        if (this.au == null) {
            return;
        }
        final int n = (int)(System.currentTimeMillis() - this.av);
        for (final F f : this.ax.values()) {
            final int an = f.an();
            int i = f.ay() + n;
            int ax = f.ax();
            for (int n2 = f.g(ax); i >= n2; n2 = f.g(ax)) {
                i -= n2;
                if (++ax == an) {
                    ax = 0;
                }
            }
            f.e(i);
            f.d(ax);
        }
        this.av = System.currentTimeMillis();
    }
    
    public boolean b(final UUID uuid) {
        return this.d(uuid) != null;
    }
    
    public void c(final UUID uuid) {
        final p d = this.d(uuid);
        if (d == null) {
            return;
        }
        final D ak = this.ak();
        if (ak == null) {
            return;
        }
        final F n = this.n(d.getSlug());
        if (n == null) {
            return;
        }
        this.ay.a(ak, n);
    }
    
    private p d(final UUID uuid) {
        final gm hk = x.ao.eZ().hK();
        if (hk == null) {
            return null;
        }
        final List<p> list = hk.hZ().hR().get(uuid);
        if (list == null) {
            return null;
        }
        for (final p p : list) {
            if (p.W() == p.a.CAPE) {
                return p;
            }
        }
        return null;
    }
    
    static {
        ao = dU.a(fR.class);
        ap = z.a(704, 544, 2000);
        aq = new ResourceLocation("feather", "cosmetics/cloak/cloak.obj");
        ar = Minecraft.getMinecraft().getResourceManager();
        as = Executors.newSingleThreadExecutor();
        az = new x();
    }
}
