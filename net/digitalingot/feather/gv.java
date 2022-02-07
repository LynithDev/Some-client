package net.digitalingot.feather;

import java.util.*;
import net.minecraft.client.*;
import net.minecraft.client.entity.*;
import net.minecraft.init.*;
import net.minecraft.item.*;

@dP(eL = dW.ARMOR_STATUS, eM = @dV(fh = "Armor Status", fi = "https://assets.feathercdn.net/game/mods/armorstatus.svg", fj = "Display your armor durability", fk = { df.a.PVP, df.a.HUD }))
public class gv extends dN<a>
{
    private static final ItemStack[] qT;
    private static final ItemStack qU;
    private final List<b> qV;
    
    public gv() {
        this.qV = new ArrayList<b>();
    }
    
    @Override
    public void a(final dN.a a, final im im) {
        this.o(a == dN.a.MOD_LAYOUT);
        this.d(im);
    }
    
    @Override
    public int eB() {
        switch (gv$1.qW[((a)this.jC).rb.ordinal()]) {
            case 1: {
                return ((a)this.jC).re ? 130 : 45;
            }
            case 2: {
                int n = 0;
                final Iterator<b> iterator = this.qV.iterator();
                while (iterator.hasNext()) {
                    n += iterator.next().rq;
                }
                return n + 5;
            }
            default: {
                throw new IllegalStateException();
            }
        }
    }
    
    @Override
    public int eC() {
        return ((((a)this.jC).rb == a.c.HORIZONTAL) ? 1 : (((a)this.jC).rh ? 5 : 4)) * (((a)this.jC).re ? 22 : 16);
    }
    
    @Override
    public int eD() {
        switch (gv$1.qW[((a)this.jC).rb.ordinal()]) {
            case 1: {
                return ((a)this.jC).re ? 130 : 45;
            }
            case 2: {
                return 196;
            }
            default: {
                throw new IllegalStateException();
            }
        }
    }
    
    private ItemStack a(final int n, final boolean b) {
        if (b) {
            if (n == -1 && ((a)this.jC).rh) {
                return gv.qU;
            }
            if (n != -1) {
                return gv.qT[n];
            }
        }
        else {
            final EntityPlayerSP thePlayer = Minecraft.getMinecraft().thePlayer;
            if (n == -1 && ((a)this.jC).rh) {
                return thePlayer.func_70694_bm();
            }
            if (n != -1) {
                return thePlayer.field_71071_by.armorInventory[n];
            }
        }
        return null;
    }
    
    private void o(final boolean b) {
        this.qV.clear();
        for (int i = 3; i >= -1; --i) {
            final ItemStack a = this.a(i, b);
            if (a != null && a != null) {
                this.qV.add(new b(a, 16, 16, i > -1, (a)this.jC));
            }
        }
    }
    
    private void d(final im im) {
        if (this.qV.isEmpty()) {
            return;
        }
        switch (gv$1.qW[((a)this.jC).rb.ordinal()]) {
            case 1: {
                int n = ((a)this.jC).re ? 5 : 0;
                final int n2 = ((a)this.jC).re ? 21 : 16;
                if (((a)this.jC).ra == a.b.LEFT) {
                    for (final b b : this.qV) {
                        b.b(im, b.rq + ((a)this.jC).rc, n);
                        n += n2;
                    }
                    return;
                }
                final int eb = this.eB();
                final Iterator<b> iterator2 = this.qV.iterator();
                while (iterator2.hasNext()) {
                    iterator2.next().b(im, eb, n);
                    n += n2;
                }
                break;
            }
            case 2: {
                int n3 = 3;
                for (final b b2 : this.qV) {
                    b2.b(im, n3 + b2.rq + ((a)this.jC).rc, 6);
                    n3 += b2.rq;
                }
                break;
            }
        }
    }
    
    static {
        qT = new ItemStack[] { new ItemStack((Item)Items.diamond_boots), new ItemStack((Item)Items.diamond_chestplate), new ItemStack((Item)Items.diamond_leggings), new ItemStack((Item)Items.diamond_helmet) };
        qU = new ItemStack(Items.diamond_sword);
    }
    
    class b
    {
        public final int rl;
        public final int rm;
        public final ItemStack rn;
        private final boolean ro;
        private final a rp;
        private int rq;
        private String rr;
        private int rs;
        private String rt;
        private int ru;
        
        public b(final ItemStack rn, final int rm, final int rl, final boolean ro, final a rp) {
            this.rr = "";
            this.rt = "";
            this.rn = rn;
            this.rm = rm;
            this.rl = rl;
            this.ro = ro;
            this.rp = rp;
            this.ic();
        }
        
        private void ic() {
            if (this.rn == null) {
                return;
            }
            if (((this.ro && this.rp.rf) || (!this.ro && this.rp.rj)) && this.rn.isItemStackDamageable()) {
                final int n = this.rn.getMaxDamage() + 1;
                final int n2 = n - this.rn.getItemDamage();
                switch (gv$1.qX[this.rp.qZ.ordinal()]) {
                    case 1: {
                        this.rr = n2 + (this.rp.rk ? ("/" + n) : "");
                        break;
                    }
                    case 2: {
                        this.rr = n2 * 100 / n + "%";
                        break;
                    }
                }
            }
            this.rs = gv.this.kw.V(jP.aS(this.rr));
            this.rq = ((a)gv.this.jC).rc + this.rm + ((a)gv.this.jC).rc + this.rs;
            if (this.rp.re) {
                this.rt = jP.aS(this.rn.getDisplayName());
                this.rt = this.rt.replace("Splash ", "").replace("Potion of ", "");
                this.rq = ((a)gv.this.jC).rc + this.rm + ((a)gv.this.jC).rc + Math.max(gv.this.kw.V(this.rt), this.rs);
            }
            this.ru = gv.this.kw.V(this.rt);
        }
        
        public void b(final im im, final int n, final int n2) {
            switch (gv$1.qY[this.rp.ra.ordinal()]) {
                case 1: {
                    final int max = Math.max(this.rs, this.rp.re ? this.ru : 0);
                    gv.this.kw.a(im, this.rn, n - (2 * ((a)gv.this.jC).rc + this.rm + max), n2, this.rp.rg, this.rp.ri);
                    if (this.rp.re) {
                        gv.this.kw.a(im, this.rt + "§r", (float)(n - (max + ((a)gv.this.jC).rc)), (float)(n2 - 3), ((a)gv.this.jC).lg, true);
                    }
                    gv.this.kw.a(im, this.rr + "§r", (float)(n - (max + ((a)gv.this.jC).rc)), (float)(n2 + (this.rp.re ? 8 : 2)), ((a)gv.this.jC).lg, true);
                    break;
                }
                case 2: {
                    gv.this.kw.a(im, this.rn, n - (this.rm + ((a)gv.this.jC).rc), n2, this.rp.rg, this.rp.ri);
                    if (this.rp.re) {
                        gv.this.kw.a(im, this.rt + "§r", (float)(n - (((a)gv.this.jC).rc + this.rm + ((a)gv.this.jC).rc) - this.ru), (float)(n2 - 3), ((a)gv.this.jC).lg, true);
                    }
                    gv.this.kw.a(im, this.rr + "§r", (float)(n - (((a)gv.this.jC).rc + this.rm + ((a)gv.this.jC).rc) - this.rs), (float)(n2 + (this.rp.re ? 8 : 2)), ((a)gv.this.jC).lg, true);
                    break;
                }
            }
            ii.a(1.0f, 1.0f, 1.0f, 1.0f);
        }
    }
    
    @ej(fJ = bG.BOTTOM_RIGHT, fH = 0.0, fI = -1.0)
    @ef(fC = true)
    public static class a extends dX
    {
        @er(fu = "color", fh = "Text Color", fm = @em(fS = 0))
        public eT lg;
        @er(fu = "damageDisplayType", fh = "Damage Display Type", fW = "value", fm = @em(fS = 1))
        public gv.a.a qZ;
        @er(fu = "iconLocation", fh = "Icon Location", fW = "right", fm = @em(fS = 2))
        public b ra;
        @er(fu = "listMode", fh = "List Mode", fW = "vertical", fm = @em(fS = 3))
        public c rb;
        @er(fu = "padding", fh = "Padding", fW = "2", fm = @em(fS = 4))
        @el(fP = 5)
        public int rc;
        @em(fS = 10)
        public eW rd;
        @er(fu = "enableItemName", fh = "Enable Item Name", fW = "false", fm = @em(fS = 11))
        public boolean re;
        @er(fu = "showArmorDamage", fh = "Show Armor Damage", fW = "true", fm = @em(fS = 12))
        public boolean rf;
        @er(fu = "showDamageOverlay", fh = "Show Damage Overlay", fW = "true", fm = @em(fS = 13))
        public boolean rg;
        @er(fu = "showEquippedItem", fh = "Show Equipped Item", fW = "true", fm = @em(fS = 14))
        public boolean rh;
        @er(fu = "showItemCount", fh = "Show Item Count", fW = "true", fm = @em(fS = 15))
        public boolean ri;
        @er(fu = "showItemDamage", fh = "Show Item Damage", fW = "true", fm = @em(fS = 16))
        public boolean rj;
        @er(fu = "showMaxDamage", fh = "Show Max Damage", fW = "false", fm = @em(fS = 17))
        public boolean rk;
        
        public a() {
            this.rd = new eW("Show");
        }
        
        public enum a
        {
            @ei(fu = "value", fh = "Value")
            VALUE, 
            @ei(fu = "percent", fh = "Percent")
            PERCENT;
            
            private static /* synthetic */ a[] $values() {
                return new a[] { a.VALUE, a.PERCENT };
            }
            
            static {
                $VALUES = $values();
            }
        }
        
        public enum b
        {
            @ei(fu = "left", fh = "Left")
            LEFT, 
            @ei(fu = "right", fh = "Right")
            RIGHT;
            
            private static /* synthetic */ b[] $values() {
                return new b[] { b.LEFT, b.RIGHT };
            }
            
            static {
                $VALUES = $values();
            }
        }
        
        public enum c
        {
            @ei(fu = "horizontal", fh = "Horizontal")
            HORIZONTAL, 
            @ei(fu = "vertical", fh = "Vertical")
            VERTICAL;
            
            private static /* synthetic */ c[] $values() {
                return new c[] { c.HORIZONTAL, c.VERTICAL };
            }
            
            static {
                $VALUES = $values();
            }
        }
    }
}
