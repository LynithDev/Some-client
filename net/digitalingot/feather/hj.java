package net.digitalingot.feather;

import java.util.*;
import java.io.*;
import org.jetbrains.annotations.*;
import java.util.concurrent.*;
import net.minecraft.client.*;
import net.minecraft.util.*;

@dP(eL = dW.SCREENSHOT, eM = @dV(fh = "Screenshot", fi = "https://assets.feathercdn.net/game/mods/screenshot.svg", fj = "", fk = {}))
public class hj extends dQ<a>
{
    @Override
    public void initialize() {
        final hk hk = new hk();
        final ao<ad> bk = ad.bk;
        final hk hk2 = hk;
        Objects.requireNonNull(hk2);
        bk.a(hk2::a);
        am.bv.a((canonicalFile, chatComponent) -> {
            if (!this.eS()) {
                return chatComponent;
            }
            else {
                try {
                    canonicalFile = canonicalFile.getCanonicalFile();
                }
                catch (IOException ex) {
                    throw new IllegalStateException(ex);
                }
                this.e(canonicalFile);
                return hl.a(canonicalFile, (a)this.jC);
            }
        });
    }
    
    private void e(@NotNull final File file) {
        switch (hj$1.yC[((a)this.jC).yE.ordinal()]) {
            case 1: {
                ForkJoinPool.commonPool().execute(() -> Minecraft.getMinecraft().addScheduledTask(() -> io.aC(hm.h(file))));
                break;
            }
            case 2: {
                Minecraft.getMinecraft().addScheduledTask(() -> hi.c(file));
                break;
            }
        }
    }
    
    @ef(fC = true)
    public static class a extends ea
    {
        @em(fS = 0)
        public eW yD;
        @er(fu = "autoCopyMode", fh = "Auto Copy Mode", fW = "dontCopy", fm = @em(fS = 1))
        public hj.a.a yE;
        @em(fS = 10)
        public eW yF;
        @er(fu = "openOption", fh = "Show Open Option", fW = "true", fm = @em(fS = 11))
        public boolean yG;
        @er(fu = "copyOption", fh = "Show Copy Option", fW = "true", fm = @em(fS = 12))
        public boolean yH;
        @er(fu = "uploadOption", fh = "Show Upload Option", fW = "true", fm = @em(fS = 13))
        public boolean yI;
        @er(fu = "tweetOption", fh = "Show Tweet Option", fW = "true", fm = @em(fS = 14))
        public boolean yJ;
        
        public a() {
            this.yD = new eW("Screenshot");
            this.yF = new eW("Screenshot Menu");
        }
        
        public enum a
        {
            @ei(fu = "dontCopy", fh = "Don't Copy")
            DONT_COPY, 
            @ei(fu = "copyFile", fh = "Copy File")
            COPY_FILE, 
            @ei(fu = "copyURL", fh = "Copy URL")
            COPY_URL;
            
            private static /* synthetic */ a[] $values() {
                return new a[] { a.DONT_COPY, a.COPY_FILE, a.COPY_URL };
            }
            
            static {
                $VALUES = $values();
            }
        }
    }
}
