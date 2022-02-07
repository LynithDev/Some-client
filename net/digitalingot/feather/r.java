package net.digitalingot.feather;

import java.util.*;
import org.jetbrains.annotations.*;
import com.google.gson.*;
import net.minecraft.util.*;
import java.lang.reflect.*;

public class r
{
    private static final String ae;
    private static final Gson GSON;
    @NotNull
    private final Map<String, p> af;
    @NotNull
    private final Map<String, t> ag;
    @NotNull
    private final Map<String, p> ah;
    @NotNull
    private final Map<String, t> ai;
    @NotNull
    private final M aj;
    @NotNull
    private final v aa;
    @NotNull
    private final fV ak;
    
    private r(@NotNull final Map<String, p> af, @NotNull final Map<String, t> ag, final fV ak, @NotNull final v aa) {
        this.ah = new HashMap<String, p>();
        this.ai = new HashMap<String, t>();
        this.af = af;
        this.ag = ag;
        this.aj = new M();
        this.ak = ak;
        this.aa = aa;
    }
    
    public static r a(@NotNull final fV fv) {
        HashMap<String, p> hashMap;
        HashMap<String, t> hashMap2;
        try {
            final s s = jt.aM(r.ae).a(r.GSON, s.class);
            hashMap = new HashMap<String, p>(s.af().size());
            for (final p p : s.af()) {
                hashMap.put(p.getSlug(), p);
            }
            hashMap2 = new HashMap<String, t>(s.ag().size());
            for (final t t : s.ag()) {
                hashMap2.put(t.getSlug(), t);
            }
        }
        catch (Exception ex) {
            kk.FT.error("Error during cosmetics info fetch", (Throwable)ex);
            hashMap = new HashMap<String, p>();
            hashMap2 = new HashMap<String, t>();
        }
        return new r(hashMap, hashMap2, fv, new fW(fv));
    }
    
    public q Y() {
        return new q(this.aa, this);
    }
    
    public a j(final String s) {
        return this.af.containsKey(s) ? a.COSMETIC : (this.ag.containsKey(s) ? a.EMOTE : a.NONE);
    }
    
    @Nullable
    public p k(final String s) {
        return this.af.get(s);
    }
    
    @Nullable
    public t l(final String s) {
        return this.ag.get(s);
    }
    
    @NotNull
    public Map<String, p> Z() {
        return this.af;
    }
    
    @NotNull
    public Map<String, t> aa() {
        return this.ag;
    }
    
    @NotNull
    public Map<String, p> ab() {
        return this.ah;
    }
    
    @NotNull
    public Map<String, t> ac() {
        return this.ai;
    }
    
    @NotNull
    public M ad() {
        return this.aj;
    }
    
    public fV ae() {
        return this.ak;
    }
    
    static {
        ae = jQ.h("FEATHER_COSMETICS_JSON", "https://game-client.feathermc.com/cosmetics.json");
        GSON = new GsonBuilder().registerTypeAdapter((Type)ResourceLocation.class, (Object)new w()).create();
    }
    
    public enum a
    {
        COSMETIC, 
        EMOTE, 
        NONE;
        
        private static /* synthetic */ a[] $values() {
            return new a[] { a.COSMETIC, a.EMOTE, a.NONE };
        }
        
        static {
            $VALUES = $values();
        }
    }
}
