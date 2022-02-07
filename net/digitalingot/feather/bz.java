package net.digitalingot.feather;

import net.minecraft.client.gui.*;
import org.lwjgl.input.*;
import net.minecraft.client.*;
import org.jetbrains.annotations.*;

public class bz extends GuiScreen
{
    private final bB gI;
    private final bs gJ;
    private boolean gK;
    
    public bz() {
        this.gI = new bB();
        this.gJ = br.INSTANCE.getScreen();
    }
    
    public void initGui() {
        this.gI.e(this.width, this.height);
        this.gJ.initGui();
    }
    
    public void onGuiClosed() {
        this.gI.bB();
        this.gJ.onGuiClosed();
    }
    
    public void drawScreen(final int n, final int n2, final float n3) {
        this.gI.a(new im());
        this.gJ.drawScreen(n, n2, n3);
    }
    
    protected void keyTyped(final char c, final int n) {
        super.keyTyped(c, n);
        this.gI.a(c, n);
    }
    
    protected void mouseClicked(final int n, final int n2, final int n3) {
        if (this.gI.b(n, n2, n3)) {
            this.gK = true;
        }
    }
    
    protected void mouseReleased(final int n, final int n2, final int n3) {
        this.gI.c(n, n2, n3);
    }
    
    protected void mouseClickMove(final int n, final int n2, final int n3, final long n4) {
        this.gI.d(n, n2, n3);
    }
    
    public void handleMouseInput() {
        super.handleMouseInput();
        if (Mouse.getEventButton() == -1) {
            this.gI.a(Mouse.getEventX() * this.width / this.mc.displayWidth, (double)(this.height - Mouse.getEventY() * this.height / this.mc.displayHeight - 1));
        }
        if (this.gK) {
            this.gK = false;
            return;
        }
        this.gJ.handleMouseInput();
    }
    
    public void setWorldAndResolution(@NotNull final Minecraft minecraft, final int n, final int n2) {
        super.setWorldAndResolution(minecraft, n, n2);
        this.gJ.setWorldAndResolution(minecraft, n, n2);
    }
    
    public boolean doesGuiPauseGame() {
        return false;
    }
}
