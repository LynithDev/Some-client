package net.digitalingot.feather;

import net.minecraft.client.*;
import java.util.function.*;
import org.jetbrains.annotations.*;

public class a
{
    @Nullable
    private static cA.a a;
    
    public static void a() {
        new Thread(null, null, "Feather-DRM") {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000L);
                }
                catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                if (net.digitalingot.feather.a.a == null || net.digitalingot.feather.a.a.getPriority() < net.digitalingot.feather.a.b().getPriority()) {
                    kk.FT.debug("DRM check failed.");
                    Minecraft.getMinecraft().shutdown();
                }
                else {
                    kk.FT.debug("Passed DRM check");
                }
            }
        }.start();
        e.s().l().b(new cz(), (Consumer<bT>)new Consumer<cA>() {
            public void a(final cA ca) {
                net.digitalingot.feather.a.a = ca.b();
            }
        }, (Consumer<bT>)null);
    }
    
    @NotNull
    public static cA.a b() {
        return cA.a.RELEASE;
    }
}
