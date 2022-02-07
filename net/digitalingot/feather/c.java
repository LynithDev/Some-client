package net.digitalingot.feather;

import java.nio.file.*;
import org.jetbrains.annotations.*;
import net.minecraft.client.*;
import java.util.*;

public class c
{
    private static final boolean FEATHER_TEST;
    private static c p;
    @NotNull
    private final Path q;
    private final jE r;
    
    public c(@NotNull final Minecraft minecraft) {
        c.p = this;
        this.q = minecraft.mcDataDir.toPath().resolve("feather");
        this.r = new jE();
        new jF(this.r);
    }
    
    public void a(@NotNull final List<Class<? extends dQ<?>>> list) {
        final bg bg = new bg(this.q.toFile());
        final eO f = this.f();
        final dU a = this.a(list, f, bg);
        final d d = new d(new bV(), a, bg, this.q.toFile(), this.q.resolve("misc").toFile(), this.g());
        final e e = new e();
        e.a(d);
        net.digitalingot.feather.e.a(e);
        br.INSTANCE.initialize();
        a.fa();
        f.b(a.dL());
        au.aM();
        dO.INSTANCE.init();
        this.e();
        kk.FT.info("Started Feather (" + d.g() + ")");
    }
    
    private void e() {
        final dU m = e.s().m();
        final bV l = e.s().l();
        final bg n = e.s().n();
        l.a(bQ.READY_FOR_MESSAGES, (bW<bT, bT, bT>)new aZ());
        l.a(bQ.RECORD_KEYS, (bW<bT, bT, bT>)new ba());
        l.a(bQ.PAGE_UPDATE, (bW<bT, bT, bT>)new aX());
        l.a(bQ.PRESS_BUTTON, (bW<bT, bT, bT>)new aY());
        l.a(bQ.UPDATE_CLIENT_PREFERENCES, (bW<bT, bT, bT>)new bk(n));
        l.a(bQ.CREATE_MOD_PROFILE, (bW<bT, bT, bT>)new fd());
        l.a(bQ.DELETE_MOD_PROFILE, (bW<bT, bT, bT>)new fe());
        l.a(bQ.RENAME_MOD_PROFILE, (bW<bT, bT, bT>)new fh());
        l.a(bQ.CLONE_MOD_PROFILE, (bW<bT, bT, bT>)new fc());
        l.a(bQ.SELECT_MOD_PROFILE, (bW<bT, bT, bT>)new fi());
        l.a(bQ.RESET_MOD_POSITIONS, (bW<bT, bT, bT>)new eZ());
        l.a(bQ.RESET_MOD_SETTINGS, (bW<bT, bT, bT>)new fa());
        l.a(bQ.UPDATE_MOD_SETTINGS, (bW<bT, bT, bT>)new fb(n));
        l.a(bQ.RENDER_MOD, (bW<bT, bT, bT>)new bc());
        l.a(bQ.REMOVE_RENDER_MOD, (bW<bT, bT, bT>)new bb());
        l.a(bQ.RESET_SIDEBAR_SETTINGS, (bW<bT, bT, bT>)new fl());
        l.a(bQ.UPDATE_SIDEBAR_SETTINGS, (bW<bT, bT, bT>)new fm());
        l.a(bQ.DO_HUD_SELECTION, (bW<bT, bT, bT>)new aT());
        V.bk.a(s -> {
            if (s.equals("featherMods")) {
                br.INSTANCE.show();
                aW.d(true);
            }
            return;
        });
        aV.ah();
        bh.a(n);
        fj.a(m);
        fk.a(m);
        eX.a(m);
        fg.a(m);
        ff.a(m);
        be.a(m);
    }
    
    @NotNull
    private dU a(@NotNull final List<Class<? extends dQ<?>>> list, @NotNull final eO eo, final bg bg) {
        final dU du = new dU(list, eo, bg);
        du.initialize();
        return du;
    }
    
    @NotNull
    private eO f() {
        final eO eo = new eO(this.q);
        eo.gE();
        return eo;
    }
    
    @NotNull
    private String g() {
        return jt.aO("git.hash").tk();
    }
    
    public static c h() {
        return c.p;
    }
    
    public static jE i() {
        return c.p.r;
    }
    
    public static boolean isCallingFromMinecraftThread() {
        return Minecraft.getMinecraft().isCallingFromMinecraftThread();
    }
    
    public static boolean isFeatherTest() {
        return c.FEATHER_TEST;
    }
    
    static {
        FEATHER_TEST = (System.getenv("FEATHER_TEST") != null);
    }
}
