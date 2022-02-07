package net.digitalingot.feather;

import net.minecraft.client.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;

@dP(eL = dW.COMBO_DISPLAY, eM = @dV(fh = "Combo Display", fi = "https://assets.feathercdn.net/game/mods/combodisplay.svg", fj = "Display number of consecutive hits", fk = { df.a.PVP, df.a.HUD }))
public class gx extends dR<a>
{
    private static final long rw = 2000L;
    private static final long rx = 500L;
    private static final Minecraft minecraft;
    private long ry;
    private int rz;
    private int rA;
    
    public gx() {
        this.rz = 0;
    }
    
    @Override
    public void initialize() {
        N.bk.a((p0, entity) -> {
            if (!this.eS() || !(entity instanceof EntityPlayer)) {
                return;
            }
            else if (gx.minecraft.objectMouseOver == null) {
                return;
            }
            else if (gx.minecraft.objectMouseOver.typeOfHit != MovingObjectPosition.MovingObjectType.ENTITY) {
                return;
            }
            else if (gx.minecraft.objectMouseOver.entityHit == null || gx.minecraft.objectMouseOver.entityHit.getEntityId() != entity.getEntityId()) {
                return;
            }
            else {
                if (this.rA != entity.getEntityId()) {
                    this.rz = 0;
                }
                this.rA = entity.getEntityId();
                this.ry = System.currentTimeMillis();
                return;
            }
        });
        final int n;
        Y.bk.a(entityLivingBase -> {
            if (!this.eS() || gx.minecraft.thePlayer == null) {
                return;
            }
            else {
                entityLivingBase.func_145782_y();
                if (n == gx.minecraft.thePlayer.func_145782_y()) {
                    this.rz = 0;
                }
                else if (this.rA == n && System.currentTimeMillis() - this.ry < 500L) {
                    ++this.rz;
                }
                return;
            }
        });
        an.bE.a(c -> {
            if (c == an.c.END && gx.minecraft.thePlayer != null && this.eS()) {
                if (System.currentTimeMillis() > this.ry + 2000L) {
                    this.rz = 0;
                }
            }
        });
    }
    
    @Override
    public Object eT() {
        if (this.rz == 0) {
            return "No Combo";
        }
        return ((a)this.jC).rB ? ("Combo: " + this.rz) : (this.rz + " Combo");
    }
    
    @Override
    public boolean eV() {
        return ((a)this.jC).rB;
    }
    
    static {
        minecraft = Minecraft.getMinecraft();
    }
    
    @ej(fH = 33.0, fI = 8.0)
    public static class a extends eb
    {
        @er(fu = "reversed", fh = "Reversed", fm = @em(fS = 0))
        public boolean rB;
    }
}
