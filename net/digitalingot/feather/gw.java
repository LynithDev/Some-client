package net.digitalingot.feather;

import net.minecraft.client.gui.*;

@dP(eL = dW.BOSS_BAR, eM = @dV(fh = "Boss Bar", fi = "https://assets.feathercdn.net/game/mods/bossbar.svg", fj = "", fk = { df.a.HUD }))
public class gw extends dN<a>
{
    @Override
    public int eB() {
        return 182;
    }
    
    @Override
    public int eC() {
        return this.gP;
    }
    
    @Override
    public void a(final dN.a a, final im im) {
        if (a == dN.a.MOD_LAYOUT) {
            this.e(im);
        }
    }
    
    private void e(final im im) {
        final iJ ek = this.eK();
        final int eb = this.eB();
        final int n = (int)(0.8 * (float)(eb + 1));
        ii.a(0, GuiIngame.field_110324_m);
        ek.d(im, 0, 12, 0, 74, eb, 5);
        ek.d(im, 0, 12, 0, 74, eb, 5);
        if (n > 0) {
            ek.d(im, 0, 12, 0, 79, n, 5);
        }
        ek.a(im, "Feather", (float)((eb - ek.V("Feather")) / 2), 3.0f, ((a)this.jC).lg, ((a)this.jC).lh);
        this.gP = 19;
    }
    
    @ej(fJ = bG.TOP_CENTER, fH = -0.5, fI = 1.0)
    @ef(fC = true)
    public static class a extends dX
    {
        @er(fu = "textColor", fh = "Text Color", fW = "false/22/119/114/255", fm = @em(fS = 0))
        public eT lg;
        @er(fu = "textShadow", fh = "Text Shadow", fm = @em(fS = 1))
        public boolean lh;
    }
}
