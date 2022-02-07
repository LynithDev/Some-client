package net.digitalingot.feather;

import java.awt.*;

public class eb extends dX implements dZ
{
    @eo
    @em(fS = 0)
    public eW kY;
    @eo
    @er(fu = "displayMode", fh = "Display Mode", fW = "background", fm = @em(fS = 1))
    public a kZ;
    @eo
    @er(fu = "backgroundColor", fh = "Background", fW = "7/7/7/146", fZ = @en(fu = "displayMode", fT = { "background" }), fm = @em(fS = 2))
    public Color la;
    @eo
    @er(fu = "backgroundWidth", fh = "Background Width", fW = "60", fZ = @en(fu = "displayMode", fT = { "background" }), fm = @em(fS = 3))
    @el(fQ = 40, fP = 70)
    public int lb;
    @eo
    @er(fu = "backgroundHeight", fh = "Background Height", fW = "20", fZ = @en(fu = "displayMode", fT = { "background" }), fm = @em(fS = 4))
    @el(fQ = 10, fP = 25)
    public int lc;
    @eo
    @er(fu = "border", fh = "Border", fW = "false", fm = @em(fS = 7), fZ = @en(fu = "displayMode", fT = { "background" }))
    public boolean ld;
    @eo
    @er(fu = "borderColor", fh = "Border Color", fW = "75/75/75/255", fZ = @en(fu = "border"), fm = @em(fS = 8))
    public Color le;
    @eo
    @er(fu = "borderThickness", fh = "Border Thickness", fW = "25", fZ = @en(fu = "border"), fm = @em(fS = 9))
    @el(fQ = 1)
    public int lf;
    @eo
    @er(fu = "textColor", fh = "Text", fW = "false/255/255/255", fm = @em(fS = 10))
    public eT lg;
    @eo
    @er(fu = "textShadow", fh = "Text Shadow", fW = "false", fm = @em(fS = 11))
    public boolean lh;
    
    public eb() {
        this.kY = new eW("Style");
    }
    
    @Override
    public int fs() {
        return 10;
    }
    
    @Override
    public int ft() {
        return 12;
    }
}
