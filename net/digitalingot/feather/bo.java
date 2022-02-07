package net.digitalingot.feather;

import org.cef.*;
import java.awt.*;
import java.nio.*;
import org.lwjgl.opengl.*;

abstract class bo implements ICefRenderer
{
    private boolean cl;
    protected int cm;
    protected int cn;
    protected Rectangle co;
    protected Rectangle cp;
    protected int cq;
    
    bo() {
        this.cl = false;
        this.cm = 0;
        this.cn = 0;
        this.co = new Rectangle(0, 0, 0, 0);
        this.cp = new Rectangle(0, 0, 0, 0);
        this.cq = 0;
    }
    
    protected void initialize() {
        this.bm();
    }
    
    public void bk() {
        this.bn();
    }
    
    protected abstract boolean bl();
    
    public void onPaint(final boolean b, final Rectangle[] array, final ByteBuffer byteBuffer, final int cm, final int cn) {
        final boolean b2 = !b;
        final boolean b3 = b && this.co.width > 0 && this.co.height > 0;
        if (!b2 && !b3) {
            return;
        }
        final int glGetInteger = GL11.glGetInteger(32873);
        final boolean glIsEnabled = GL11.glIsEnabled(3042);
        final boolean bl = this.bl();
        if (!glIsEnabled) {
            GL11.glEnable(3042);
        }
        if (!bl) {
            GL11.glEnable(3553);
        }
        if (!this.cl) {
            this.initialize();
            this.cl = true;
        }
        else {
            GL11.glBindTexture(3553, this.cq);
        }
        final int glGetInteger2 = GL11.glGetInteger(3317);
        final int glGetInteger3 = GL11.glGetInteger(3314);
        final int glGetInteger4 = GL11.glGetInteger(3316);
        final int glGetInteger5 = GL11.glGetInteger(3315);
        GL11.glPixelStorei(3317, 1);
        if (b2) {
            final int cm2 = this.cm;
            final int cn2 = this.cn;
            this.cm = cm;
            this.cn = cn;
            GL11.glPixelStorei(3314, this.cm);
            if (cm2 != this.cm || cn2 != this.cn) {
                GL11.glPixelStorei(3316, 0);
                GL11.glPixelStorei(3315, 0);
                GL11.glTexImage2D(3553, 0, 6408, this.cm, this.cn, 0, 32993, 33639, byteBuffer);
            }
            else {
                for (final Rectangle rectangle : array) {
                    GL11.glPixelStorei(3316, rectangle.x);
                    GL11.glPixelStorei(3315, rectangle.y);
                    GL11.glTexSubImage2D(3553, 0, rectangle.x, rectangle.y, rectangle.width, rectangle.height, 32993, 33639, byteBuffer);
                }
            }
        }
        else {
            int n = 0;
            int n2 = 0;
            int x = this.co.x;
            int y = this.co.y;
            int n3 = cm;
            int n4 = cn;
            if (x < 0) {
                n = -x;
                x = 0;
            }
            if (y < 0) {
                n2 = -y;
                y = 0;
            }
            if (x + n3 > this.cm) {
                n3 -= x + n3 - this.cm;
            }
            if (y + n4 > this.cn) {
                n4 -= y + n4 - this.cn;
            }
            GL11.glPixelStorei(3314, cm);
            GL11.glPixelStorei(3316, n);
            GL11.glPixelStorei(3315, n2);
            GL11.glTexSubImage2D(3553, 0, x, y, n3, n4, 32993, 33639, byteBuffer);
        }
        GL11.glPixelStorei(3317, glGetInteger2);
        GL11.glPixelStorei(3314, glGetInteger3);
        GL11.glPixelStorei(3316, glGetInteger4);
        GL11.glPixelStorei(3315, glGetInteger5);
        GL11.glBindTexture(3553, glGetInteger);
        if (!glIsEnabled) {
            GL11.glDisable(3042);
        }
        if (!bl) {
            GL11.glDisable(3553);
        }
    }
    
    public void onPopupSize(final Rectangle cp) {
        if (cp.width <= 0 || cp.height <= 0) {
            return;
        }
        this.cp = cp;
        this.co = this.a(this.cp);
    }
    
    public void onPopupClosed() {
        this.co.setBounds(0, 0, 0, 0);
        this.cp.setBounds(0, 0, 0, 0);
    }
    
    protected Rectangle a(final Rectangle rectangle) {
        if (rectangle.x < 0) {
            rectangle.x = 0;
        }
        if (rectangle.y < 0) {
            rectangle.y = 0;
        }
        if (rectangle.x + rectangle.width > this.cm) {
            rectangle.x = this.cm - rectangle.width;
        }
        if (rectangle.y + rectangle.height > this.cn) {
            rectangle.y = this.cn - rectangle.height;
        }
        if (rectangle.x < 0) {
            rectangle.x = 0;
        }
        if (rectangle.y < 0) {
            rectangle.y = 0;
        }
        return rectangle;
    }
    
    private void bm() {
        GL11.glBindTexture(3553, this.cq = GL11.glGenTextures());
        GL11.glTexParameteri(3553, 10241, 9728);
        GL11.glTexParameteri(3553, 10240, 9728);
    }
    
    private void bn() {
        if (this.cq != 0) {
            GL11.glDeleteTextures(this.cq);
            this.cq = 0;
        }
    }
    
    protected final boolean bo() {
        return this.cl && this.cm != 0 && this.cn != 0;
    }
}
