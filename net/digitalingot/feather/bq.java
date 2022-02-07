package net.digitalingot.feather;

import org.lwjgl.opengl.*;
import java.awt.*;
import java.nio.*;
import org.lwjgl.*;

public class bq extends bo
{
    private static final FloatBuffer cs;
    
    @Override
    protected boolean bl() {
        return GL11.glIsEnabled(3553);
    }
    
    public void render() {
        if (!this.bo()) {
            return;
        }
        final int glGetInteger = GL11.glGetInteger(32873);
        final int glGetTexEnvi = GL11.glGetTexEnvi(8960, 8704);
        final int glGetInteger2 = GL11.glGetInteger(3317);
        GL11.glPushAttrib(61440);
        GL11.glPushClientAttrib(2);
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glDisable(2912);
        GL11.glDisable(2896);
        GL11.glDisable(2884);
        GL11.glDisable(2929);
        GL11.glDisable(2960);
        GL11.glDisable(2903);
        GL11.glEnable(3553);
        GL11.glTexEnvi(8960, 8704, 8448);
        GL11.glHint(3155, 4354);
        GL11.glClear(256);
        GL11.glMatrixMode(5889);
        GL11.glPushMatrix();
        GL11.glLoadIdentity();
        GL11.glMatrixMode(5888);
        GL11.glPushMatrix();
        GL11.glLoadIdentity();
        GL11.glPixelStorei(3317, 1);
        GL11.glBindTexture(3553, this.cq);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glInterleavedArrays(10791, 0, bq.cs);
        GL11.glDrawArrays(7, 0, 4);
        GL11.glPixelStorei(3317, glGetInteger2);
        GL11.glBindTexture(3553, glGetInteger);
        GL11.glMatrixMode(5888);
        GL11.glPopMatrix();
        GL11.glMatrixMode(5889);
        GL11.glPopMatrix();
        GL11.glPopAttrib();
        GL11.glPopClientAttrib();
        GL11.glTexEnvi(8960, 8704, glGetTexEnvi);
    }
    
    static {
        final float[] array = { 0.0f, 1.0f, -1.0f, -1.0f, 0.0f, 1.0f, 1.0f, 1.0f, -1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, -1.0f, 1.0f, 0.0f };
        (cs = BufferUtils.createFloatBuffer(array.length)).put(array, 0, array.length);
        bq.cs.rewind();
    }
}
