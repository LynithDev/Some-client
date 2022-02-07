package net.digitalingot.feather;

import net.minecraft.client.*;
import net.minecraft.util.*;
import com.google.common.cache.*;
import org.jetbrains.annotations.*;
import net.minecraft.client.entity.*;
import net.minecraft.client.network.*;
import com.mojang.authlib.*;
import java.util.regex.*;
import net.minecraft.client.resources.*;
import com.google.common.collect.*;
import java.util.*;
import com.mojang.authlib.minecraft.*;

@dP(eL = dW.NICK_HIDER, eM = @dV(fh = "Nick Hider", fi = "https://assets.feathercdn.net/game/mods/nickhider.svg", fj = "Hide your nick and skin", fk = {}))
public class fz extends dQ<b>
{
    private static final int nL = 5000;
    private static final int nM = 1000000000;
    private static final String kE = "Player-";
    private static final String nN = " ";
    private static final String nO = "You";
    private Minecraft minecraft;
    private ResourceLocation nP;
    private String nQ;
    private ResourceLocation nR;
    private boolean nS;
    private final List<a> nT;
    private final Cache<String, Boolean> nU;
    private final LoadingCache<String, String> nV;
    
    public fz() {
        this.nT = (List<a>)Lists.newArrayList();
        this.nU = (Cache<String, Boolean>)CacheBuilder.newBuilder().maximumSize(5000L).build();
        this.nV = (LoadingCache<String, String>)CacheBuilder.newBuilder().maximumSize(5000L).build((CacheLoader)new CacheLoader<String, String>() {
            @NotNull
            public String N(@NotNull final String s) {
                String replaceAll = s;
                for (final a a : fz.this.nT) {
                    replaceAll = a.nY.matcher(replaceAll).replaceAll(a.jE);
                }
                return replaceAll;
            }
        });
    }
    
    @Override
    public void initialize() {
        this.minecraft = Minecraft.getMinecraft();
        an.bE.a(c -> {
            if (c == an.c.START && this.eS()) {
                this.onClientTick();
            }
            return;
        });
        an.bH.a((c2, p1) -> {
            if (c2 == an.c.START && this.eS()) {
                this.hj();
            }
            return;
        });
        P.bk.a(s -> this.eS() ? this.J(s) : s);
    }
    
    private void hi() {
    }
    
    private void onClientTick() {
    }
    
    private String H(final String s) {
        return null;
    }
    
    private void hj() {
        if (!((b)this.jC).oc && !((b)this.jC).oh) {
            return;
        }
        final EntityPlayerSP thePlayer = this.minecraft.thePlayer;
        if (thePlayer == null) {
            return;
        }
        final NetHandlerPlayClient sendQueue = thePlayer.sendQueue;
        if (sendQueue == null) {
            return;
        }
        final UUID id = this.ho().getId();
        boolean b = false;
        final Iterator iterator = sendQueue.getPlayerInfoMap().iterator();
        while (iterator.hasNext()) {
            final GameProfile gameProfile = iterator.next().getGameProfile();
            final String name = gameProfile.getName();
            if (id.equals(gameProfile.getId())) {
                if (!((b)this.jC).oc) {
                    continue;
                }
                b |= this.d(name, "You");
            }
            else {
                if (!((b)this.jC).od) {
                    continue;
                }
                b |= this.d(name, this.I(name));
            }
        }
        if (b) {
            this.nV.invalidateAll();
        }
    }
    
    private String I(final String s) {
        return "Player-" + Math.abs(s.hashCode()) % 1000000000;
    }
    
    private boolean d(String lowerCase, final String s) {
        if (lowerCase.isEmpty() || lowerCase.contains(" ")) {
            return false;
        }
        lowerCase = lowerCase.toLowerCase(Locale.ROOT);
        if (this.nU.getIfPresent((Object)lowerCase) != null) {
            return false;
        }
        this.nU.put((Object)lowerCase, (Object)true);
        this.nT.add(new a(Pattern.compile(Pattern.quote(lowerCase), 2), lowerCase, (lowerCase.length() > 2) ? s : lowerCase));
        this.nT.sort(Comparator.comparingInt(a -> a.nZ.length()).reversed());
        return true;
    }
    
    public ResourceLocation hk() {
        this.hl();
        return this.nP;
    }
    
    private void hl() {
        if (this.nQ != null || this.nS) {
            return;
        }
        this.a(this.ho(), (type, resourceLocation, minecraftProfileTexture) -> {
            switch (fz$2.nX[type.ordinal()]) {
                case 1: {
                    this.nP = resourceLocation;
                    this.nQ = minecraftProfileTexture.getMetadata("model");
                    if (this.nQ == null) {
                        this.nQ = "default";
                        break;
                    }
                    break;
                }
                case 2: {
                    this.nR = resourceLocation;
                    break;
                }
            }
            this.nS = false;
        }, false);
    }
    
    private void a(final GameProfile gameProfile, final SkinManager.SkinAvailableCallback skinAvailableCallback, final boolean b) {
        this.minecraft.getSkinManager().loadProfileTextures(gameProfile, skinAvailableCallback, b);
    }
    
    public String hm() {
        return this.nQ;
    }
    
    public ResourceLocation hn() {
        return this.nR;
    }
    
    private String J(String replaceAll) {
        if (this.hp()) {
            for (final a a : this.nT) {
                if (a.jE.equals("You")) {
                    continue;
                }
                replaceAll = Pattern.compile(a.jE, 2).matcher(replaceAll).replaceAll(a.nZ);
            }
        }
        return replaceAll;
    }
    
    public String K(final String s) {
        return s;
    }
    
    public String L(final String s) {
        return (String)(this.hp() ? this.nV.getUnchecked((Object)s) : s);
    }
    
    public String[] a(final String[] array, final String s) {
        if (!this.hp()) {
            return array;
        }
        for (int i = 0; i < array.length; ++i) {
            array[i] = this.L(array[i]);
        }
        final String[] split = s.split(" ");
        final String lowerCase = split[split.length - 1].toLowerCase(Locale.ROOT);
        final ArrayList<String> list = new ArrayList<String>();
        for (final a a : this.nT) {
            if (a.oa.startsWith(lowerCase)) {
                list.add(a.jE);
            }
        }
        final HashSet hashSet = Sets.newHashSet((Object[])array);
        hashSet.addAll(list);
        return (String[])hashSet.toArray(new String[0]);
    }
    
    private GameProfile ho() {
        return this.minecraft.getSession().getProfile();
    }
    
    private boolean hp() {
        return (((b)this.jC).oc || ((b)this.jC).od) && !this.nT.isEmpty();
    }
    
    static class a
    {
        public Pattern nY;
        public String nZ;
        public String jE;
        public String oa;
        
        public a(final Pattern ny, final String nz, final String je) {
            this.nY = ny;
            this.nZ = nz;
            this.jE = je;
            this.oa = je.toLowerCase(Locale.ROOT);
        }
    }
    
    public static class b extends ea
    {
        @em(fS = 0)
        public eW ob;
        @er(fu = "hideOwnName", fh = "Hide Your Own Name", fW = "false", fm = @em(fS = 1))
        public boolean oc;
        @er(fu = "hideOtherNames", fh = "Hide Other Names", fW = "false", fm = @em(fS = 2))
        public boolean od;
        @em(fS = 10)
        public eW oe;
        @er(fu = "hideSkin", fh = "Hide Your Skin", fW = "false", fm = @em(fS = 11))
        public boolean of;
        @er(fu = "showRealSkin", fh = "Show Real Skin", fW = "false", fm = @em(fS = 12))
        public boolean og;
        @er(fu = "hideOtherSkins", fh = "Hide Other Skins", fW = "false", fm = @em(fS = 13))
        public boolean oh;
        
        public b() {
            this.ob = new eW("Name Options");
            this.oe = new eW("Skin Options");
        }
    }
}
