package net.digitalingot.feather;

import net.minecraft.client.gui.*;
import org.cef.browser.*;
import org.cef.*;
import net.minecraft.client.renderer.*;
import java.io.*;
import org.lwjgl.input.*;
import java.util.*;
import java.awt.event.*;
import net.minecraft.client.*;
import org.jetbrains.annotations.*;
import java.awt.*;

public class bs extends GuiScreen
{
    private static final Component cv;
    private final CefApp cefApp;
    private final CefBrowser cefBrowser;
    private final ICefRenderer cw;
    private final bx cx;
    private final bv cy;
    private final Map<Integer, a> cz;
    private final Set<Integer> cA;
    private int cB;
    private boolean cC;
    private boolean cD;
    private boolean cE;
    @Nullable
    private ba.a cF;
    private long cG;
    
    public bs(final CefApp cefApp, final CefBrowser cefBrowser, final ICefRenderer cw) {
        this.cz = new HashMap<Integer, a>();
        this.cA = new HashSet<Integer>();
        this.cefApp = cefApp;
        this.cefBrowser = cefBrowser;
        this.cw = cw;
        this.cy = new bv(this);
        this.cx = new bx();
    }
    
    private static int v(int n) {
        if (isCtrlKeyDown()) {
            n |= 0x80;
        }
        if (isShiftKeyDown()) {
            n |= 0x40;
        }
        if (isAltKeyDown()) {
            n |= 0x200;
        }
        return n;
    }
    
    private static int w(final int n) {
        switch (n) {
            case 29:
            case 42:
            case 56:
            case 219: {
                return 2;
            }
            case 54:
            case 157:
            case 184:
            case 220: {
                return 3;
            }
            case 55:
            case 71:
            case 72:
            case 73:
            case 74:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
            case 80:
            case 81:
            case 82:
            case 83:
            case 141:
            case 156:
            case 179:
            case 181: {
                return 4;
            }
            default: {
                return 1;
            }
        }
    }
    
    private static int x(final int n) {
        if (n >= 0 && n <= 4) {
            return n + 1;
        }
        return 0;
    }
    
    private static int y(int n) {
        if (Mouse.isButtonDown(0)) {
            n |= 0x400;
        }
        if (Mouse.isButtonDown(1)) {
            n |= 0x800;
        }
        if (Mouse.isButtonDown(3)) {
            n |= 0x1000;
        }
        return n;
    }
    
    public void initGui() {
        this.cefBrowser.setFocus(true);
        GlStateManager.disableTexture2D();
        GlStateManager.enableTexture2D();
        this.cx.bw();
    }
    
    public void onGuiClosed() {
        this.cefBrowser.setFocus(false);
        this.a((ba.a)null);
        this.cz.clear();
    }
    
    public void drawScreen(final int n, final int n2, final float n3) {
        if (!this.cE && this.cD) {
            this.cx.bw();
            this.cE = true;
        }
        if (this.cC) {
            this.cy.a(n3);
        }
        final long currentTimeMillis = System.currentTimeMillis();
        if (this.a(currentTimeMillis) || currentTimeMillis - this.cG >= 20L) {
            this.cefApp.N_DoMessageLoopWork();
            this.cG = currentTimeMillis;
        }
        this.cw.render();
        dO.INSTANCE.onRenderModPreview(new im());
    }
    
    private boolean a(final long n) {
        if (!this.cD) {
            return false;
        }
        boolean b = false;
        if (Mouse.isCreated()) {
            while (Mouse.next()) {
                b = true;
                try {
                    this.mc.currentScreen.handleMouseInput();
                }
                catch (IOException ex) {}
            }
        }
        if (Keyboard.isCreated()) {
            while (Keyboard.next()) {
                b = true;
                try {
                    this.mc.currentScreen.handleKeyboardInput();
                }
                catch (IOException ex2) {}
            }
        }
        final Iterator<Map.Entry<Integer, a>> iterator = this.cz.entrySet().iterator();
        while (iterator.hasNext()) {
            final Map.Entry<Integer, a> entry = iterator.next();
            if (!Keyboard.isKeyDown((int)entry.getKey())) {
                iterator.remove();
            }
            else {
                entry.getValue().b(n);
            }
        }
        return b;
    }
    
    protected void keyTyped(final char c, final int n) {
    }
    
    protected void mouseClicked(final int n, final int n2, final int n3) {
    }
    
    protected void mouseReleased(final int n, final int n2, final int n3) {
    }
    
    protected void mouseClickMove(final int n, final int n2, final int n3, final long n4) {
    }
    
    public void handleKeyboardInput() {
        if (!this.cD) {
            return;
        }
        final boolean eventKeyState = Keyboard.getEventKeyState();
        final char eventCharacter = Keyboard.getEventCharacter();
        final int eventKey = Keyboard.getEventKey();
        final long n2 = Keyboard.getEventNanoseconds() / 1000000L;
        final int v = v(0);
        final int cr = bN.J(eventKey).cr();
        final int w = w(eventKey);
        if (eventKeyState) {
            if (this.cF != null) {
                if (eventKey != 1) {
                    this.cA.add(eventKey);
                }
                else {
                    this.cF.respond(new int[] { eventKey });
                    this.a((ba.a)null);
                }
                return;
            }
            final char c = (eventCharacter == '\0' || !Character.isDefined(eventCharacter)) ? '\uffff' : eventCharacter;
            KeyEvent keyEvent = new KeyEvent(bs.cv, 401, n2, v, cr, c, w);
            bu.b(keyEvent, eventKey);
            this.cefBrowser.sendKeyEvent(keyEvent);
            if (c != '\uffff') {
                final KeyEvent keyEvent2 = new KeyEvent(bs.cv, 400, n2, v, 0, c);
                if (!Character.isIdentifierIgnorable(c)) {
                    keyEvent = keyEvent2;
                }
                this.cefBrowser.sendKeyEvent(keyEvent2);
            }
            this.cz.put(eventKey, new a((c != '\uffff') ? Character.valueOf(eventCharacter) : null, keyEvent, System.currentTimeMillis()));
        }
        else {
            if (this.cF != null) {
                this.cF.respond(this.cA.stream().mapToInt(n -> n).toArray());
                this.a((ba.a)null);
                return;
            }
            final a a = this.cz.remove(eventKey);
            final KeyEvent keyEvent3 = new KeyEvent(bs.cv, 402, n2, v, cr, (a != null) ? ((a.bs() != null) ? a.bs() : '\uffff') : '\uffff', w);
            bu.b(keyEvent3, eventKey);
            this.cefBrowser.sendKeyEvent(keyEvent3);
        }
        super.handleKeyboardInput();
    }
    
    public void handleMouseInput() {
        if (!this.cD && this.cF != null) {
            return;
        }
        final int min = Math.min(br.INSTANCE.getPreferredWidth(), this.mc.displayWidth);
        final int min2 = Math.min(br.INSTANCE.getPreferredHeight(), this.mc.displayHeight);
        final int n2 = Mouse.getEventX() * min / this.mc.displayWidth;
        final int n3 = min2 - Mouse.getEventY() * min2 / this.mc.displayHeight - 1;
        final long n4 = Mouse.getEventNanoseconds() / 1000000L;
        final int eventButton = Mouse.getEventButton();
        final int v = v(y(0));
        if (eventButton == -1) {
            final int eventDWheel = Mouse.getEventDWheel();
            if (eventDWheel != 0) {
                this.cefBrowser.sendMouseWheelEvent(new MouseWheelEvent(bs.cv, 507, n4, v, n2, n3, 0, false, 0, 1, eventDWheel));
            }
            else {
                this.cefBrowser.sendMouseEvent(new MouseEvent(bs.cv, (this.cB != -1) ? 506 : 503, n4, v, n2, n3, 0, false, 0));
            }
        }
        else {
            final int x = x(eventButton);
            if (x != 0) {
                if (Mouse.getEventButtonState()) {
                    this.cB = eventButton;
                    if (this.cF != null) {
                        this.cA.add(eventButton + 100001);
                        return;
                    }
                    this.cefBrowser.sendMouseEvent(new MouseEvent(bs.cv, 501, n4, v, n2, n3, 1, false, x));
                }
                else {
                    this.cB = -1;
                    if (this.cF != null) {
                        this.cF.respond(this.cA.stream().mapToInt(n -> n).toArray());
                        this.a((ba.a)null);
                        return;
                    }
                    this.cefBrowser.sendMouseEvent(new MouseEvent(bs.cv, 502, n4, v, n2, n3, 1, false, x));
                    this.cefBrowser.sendMouseEvent(new MouseEvent(bs.cv, 500, n4, v, n2, n3, 1, false, x));
                }
            }
        }
    }
    
    public void setWorldAndResolution(@NotNull final Minecraft minecraft, final int n, final int n2) {
        super.setWorldAndResolution(minecraft, n, n2);
        this.bq();
    }
    
    public void e(final boolean cc) {
        this.cC = cc;
    }
    
    public boolean bp() {
        return this.cC;
    }
    
    public void f(final boolean cd) {
        this.cD = cd;
    }
    
    public void a(@Nullable final ba.a cf) {
        this.cA.clear();
        this.cF = cf;
    }
    
    public void bq() {
        if (this.mc == null) {
            return;
        }
        final int min = Math.min(br.INSTANCE.getPreferredWidth(), this.mc.displayWidth);
        final int min2 = Math.min(br.INSTANCE.getPreferredHeight(), this.mc.displayHeight);
        final Rectangle viewRect = this.cefBrowser.getRenderHandler().getViewRect(this.cefBrowser);
        if (viewRect.width != min || viewRect.height != min2) {
            this.cx.bw();
            this.cefBrowser.wasResized(min, min2);
        }
    }
    
    public float br() {
        return this.field_73735_i;
    }
    
    static {
        cv = new Component() {};
    }
    
    class a
    {
        @Nullable
        private final Character cH;
        @NotNull
        private final KeyEvent cI;
        private int cJ;
        private long cK;
        
        private a(@NotNull final Character ch, final KeyEvent ci, final long ck) {
            this.cH = ch;
            this.cI = ci;
            this.cK = ck;
        }
        
        public void b(final long ck) {
            if (ck - this.cK < ((this.cJ == 0) ? 500L : 30L)) {
                return;
            }
            bs.this.cefBrowser.sendKeyEvent(this.cI);
            this.cK = ck;
            ++this.cJ;
        }
        
        public Character bs() {
            return this.cH;
        }
        
        @NotNull
        public KeyEvent bt() {
            return this.cI;
        }
    }
}
