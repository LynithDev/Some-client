package net.digitalingot.feather;

import java.util.*;
import net.minecraft.client.*;
import org.jetbrains.annotations.*;
import net.minecraft.client.entity.*;
import net.minecraft.entity.player.*;

public class hw implements hv
{
    @NotNull
    private final hq zL;
    
    public hw(@NotNull final hq zl) {
        this.zL = zl;
    }
    
    @Override
    public float jD() {
        return (float)this.zL.dI().ze;
    }
    
    @Override
    public float jE() {
        return (float)this.zL.dI().zh;
    }
    
    @Override
    public float jF() {
        return (float)this.zL.dI().zi;
    }
    
    @NotNull
    @Override
    public hT.a jG() {
        return this.zL.dI().yY.toCapnProto();
    }
    
    @NotNull
    @Override
    public List<UUID> jH() {
        return Collections.emptyList();
    }
    
    @Nullable
    @Override
    public hT.c[] jI() {
        if (!Minecraft.getMinecraft().inGameHasFocus) {
            return null;
        }
        final boolean ck = this.zL.dI().za.ck();
        final boolean ck2 = this.zL.dI().zb.ck();
        hT.c[] array;
        if (ck2 && ck) {
            array = new hT.c[] { hT.c.PROXIMITY, hT.c.PARTY };
        }
        else if (ck) {
            array = new hT.c[] { hT.c.PROXIMITY };
        }
        else if (ck2) {
            array = new hT.c[] { hT.c.PARTY };
        }
        else {
            array = null;
        }
        return array;
    }
    
    @Nullable
    @Override
    public a jJ() {
        final Minecraft minecraft = Minecraft.getMinecraft();
        final EntityPlayerSP thePlayer = minecraft.thePlayer;
        if (thePlayer == null) {
            return null;
        }
        return new a(new kN((float)thePlayer.field_70169_q, (float)thePlayer.field_70167_r, (float)thePlayer.field_70166_s), minecraft.gameSettings.thirdPersonView != 0, minecraft.thePlayer.field_71109_bG, minecraft.thePlayer.field_70726_aT);
    }
    
    @Nullable
    @Override
    public kN n(final UUID uuid) {
        final Minecraft minecraft = Minecraft.getMinecraft();
        if (minecraft.thePlayer == null) {
            return null;
        }
        final EntityPlayer func_152378_a = minecraft.theWorld.func_152378_a(uuid);
        if (func_152378_a == null) {
            return null;
        }
        return new kN((float)func_152378_a.field_70169_q, (float)func_152378_a.field_70167_r, (float)func_152378_a.field_70166_s);
    }
}
