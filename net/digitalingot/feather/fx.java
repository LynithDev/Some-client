package net.digitalingot.feather;

import net.minecraft.util.*;
import net.minecraft.client.renderer.*;
import java.awt.*;
import net.minecraft.entity.*;
import net.minecraft.entity.item.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.player.*;

@dP(eL = dW.HITBOX, eM = @dV(fh = "Hitbox", fi = "https://assets.feathercdn.net/game/mods/hitbox.svg", fj = "Adds hitboxes around entities", fk = {}))
public class fx extends dQ<a>
{
    @Override
    public void initialize() {
        final Color color;
        final AxisAlignedBB axisAlignedBB;
        ae.bv.a((entity, n, n2, n3, p4) -> {
            if (!(!this.eS())) {
                if (!entity.isInvisible()) {
                    this.e(entity);
                    if (color != null) {
                        ii.r(false);
                        ii.lK();
                        ii.lB();
                        ii.lI();
                        ii.lH();
                        entity.getEntityBoundingBox();
                        RenderGlobal.drawOutlinedBoundingBox(new AxisAlignedBB(axisAlignedBB.minX - entity.posX + n, axisAlignedBB.minY - entity.posY + n2, axisAlignedBB.minZ - entity.posZ + n3, axisAlignedBB.maxX - entity.posX + n, axisAlignedBB.maxY - entity.posY + n2, axisAlignedBB.maxZ - entity.posZ + n3), color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha());
                        ii.lL();
                        ii.lA();
                        ii.lJ();
                        ii.lH();
                        ii.r(true);
                    }
                }
            }
        });
    }
    
    private Color e(final Entity entity) {
        Color color = null;
        if (entity instanceof IProjectile) {
            color = (((a)this.jC).nC ? ((a)this.jC).nD : null);
        }
        else if (entity instanceof EntityItem) {
            color = (((a)this.jC).nF ? ((a)this.jC).nG : null);
        }
        else if (entity instanceof EntityAnimal) {
            color = (((a)this.jC).nz ? ((a)this.jC).nA : null);
        }
        else if (entity instanceof EntityMob) {
            color = (((a)this.jC).nw ? ((a)this.jC).nx : null);
        }
        else if (entity instanceof EntityPlayer) {
            color = (((a)this.jC).nt ? ((a)this.jC).nu : null);
        }
        if (color == null) {
            return null;
        }
        final eT nr = ((a)this.jC).nr;
        Color gs;
        if (nr.gR()) {
            gs = new Color(iG.sL().sN());
        }
        else {
            gs = nr.gS();
        }
        return gs;
    }
    
    public static class a extends ea
    {
        @em(fS = 0)
        public eW mm;
        @er(fu = "mainColor", fh = "Main Color", fW = "", fm = @em(fS = 1))
        public eT nr;
        @em(fS = 10)
        public eW ns;
        @er(fu = "playerHitboxes", fh = "Player Hitboxes", fW = "true", fm = @em(fS = 11))
        public boolean nt;
        @er(fu = "playerHitboxColor", fh = "Color", fZ = @en(fu = "playerHitboxes"), fm = @em(fS = 12))
        public Color nu;
        @em(fS = 20)
        public eW nv;
        @er(fu = "monsterHitboxes", fh = "Monster Hitboxes", fW = "true", fm = @em(fS = 21))
        public boolean nw;
        @er(fu = "monsterHitboxColor", fh = "Color", fZ = @en(fu = "monsterHitboxes"), fm = @em(fS = 22))
        public Color nx;
        @em(fS = 30)
        public eW ny;
        @er(fu = "animalHitboxes", fh = "Animal Hitboxes", fW = "true", fm = @em(fS = 31))
        public boolean nz;
        @er(fu = "animalHitboxColor", fh = "Color", fZ = @en(fu = "animalHitboxes"), fm = @em(fS = 32))
        public Color nA;
        @em(fS = 40)
        public eW nB;
        @er(fu = "projectileHitboxes", fh = "Projectile Hitboxes", fW = "true", fm = @em(fS = 41))
        public boolean nC;
        @er(fu = "projectileHitboxColor", fh = "Color", fZ = @en(fu = "projectileHitboxes"), fm = @em(fS = 42))
        public Color nD;
        @em(fS = 50)
        public eW nE;
        @er(fu = "itemDropHitboxes", fh = "Item Drop Hitboxes", fW = "true", fm = @em(fS = 51))
        public boolean nF;
        @er(fu = "itemDropHitboxColor", fh = "Color", fZ = @en(fu = "itemDropHitboxes"), fm = @em(fS = 52))
        public Color nG;
        
        public a() {
            this.mm = new eW("General");
            this.ns = new eW("Player Hitboxes");
            this.nv = new eW("Monster Hitboxes");
            this.ny = new eW("Animal Hitboxes");
            this.nB = new eW("Projectile Hitboxes");
            this.nE = new eW("Item Drop Hitboxes");
        }
    }
}
