package net.digitalingot.feather.mixin.client;

import java.nio.*;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import org.lwjgl.opengl.*;
import org.spongepowered.asm.mixin.injection.*;
import net.digitalingot.feather.*;
import net.digitalingot.fwebp.*;
import java.util.*;

@Mixin(targets = { "net.minecraftforge.fml.client.SplashProgress$3" }, remap = false)
public abstract class ar implements Runnable
{
    private ByteBuffer[] Ho;
    private int[] Hp;
    private WebPAnimInfo Hq;
    
    @Shadow
    protected abstract void setGL();
    
    @Shadow
    protected abstract void clearGL();
    
    @Inject(method = { "run()V" }, at = { @At("HEAD") }, remap = false, cancellable = true)
    private void c(final CallbackInfo callbackInfo) {
        callbackInfo.cancel();
        this.setGL();
        GL11.glClearColor(0.01176f, 0.06666f, 0.10196f, 1.0f);
        this.uq();
        final ByteBuffer[] ho = this.Ho;
        final int[] hp = this.Hp;
        final int frameCount = this.Hq.getFrameCount();
        final int canvasWidth = this.Hq.getCanvasWidth();
        final int canvasHeight = this.Hq.getCanvasHeight();
        this.Ho = null;
        this.Hp = null;
        this.Hq = null;
        int n = -1;
        long currentTimeMillis = 0L;
        int n2 = 0;
        int n3 = 84;
        int n4 = 212;
        GL11.glEnable(3553);
        final int s = this.s(canvasWidth, canvasHeight);
        GL11.glDisable(3553);
        while (true) {
            if (n2 != 0) {
                if (n == frameCount - 1) {
                    break;
                }
            }
            else if (ao.isDone()) {
                n3 = 212;
                n4 = frameCount;
                n = n3 - 1;
                n2 = 1;
            }
            GL11.glClear(16384);
            final int width = Display.getWidth();
            final int height = Display.getHeight();
            GL11.glViewport(0, 0, width, height);
            GL11.glMatrixMode(5889);
            GL11.glLoadIdentity();
            GL11.glOrtho(0.0, (double)width, (double)height, 0.0, -1.0, 1.0);
            GL11.glMatrixMode(5888);
            GL11.glLoadIdentity();
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            GL11.glEnable(3553);
            GL11.glBindTexture(3553, s);
            if (n == -1 || System.currentTimeMillis() - currentTimeMillis >= hp[n]) {
                if (++n >= n4) {
                    n = n3;
                }
                GL11.glTexSubImage2D(3553, 0, 0, 0, canvasWidth, canvasHeight, 6408, 5121, ho[n]);
                currentTimeMillis = System.currentTimeMillis();
            }
            GL11.glBegin(7);
            GL11.glTexCoord2f(0.0f, 0.0f);
            GL11.glVertex2f(0.0f, 0.0f);
            GL11.glTexCoord2f(1.0f, 0.0f);
            GL11.glVertex2f((float)width, 0.0f);
            GL11.glTexCoord2f(1.0f, 1.0f);
            GL11.glVertex2f((float)width, (float)height);
            GL11.glTexCoord2f(0.0f, 1.0f);
            GL11.glVertex2f(0.0f, (float)height);
            GL11.glEnd();
            GL11.glBindTexture(3553, 0);
            GL11.glDisable(3553);
            ao.getMutex().acquireUninterruptibly();
            Display.update();
            ao.getMutex().release();
            if (ao.isPaused()) {
                this.clearGL();
                this.setGL();
            }
            Display.sync(100);
        }
        GL11.glDeleteTextures(s);
        this.clearGL();
    }
    
    private void uq() {
        WebPAnimDecoder webPAnimDecoder;
        try {
            webPAnimDecoder = new WebPAnimDecoder(new WebPImage(jt.aO("assets/feather/textures/loading.webp").tj()));
        }
        catch (WebPException ex) {
            throw new AssertionError();
        }
        final int frameCount = webPAnimDecoder.getInfo().getFrameCount();
        final ByteBuffer[] ho = new ByteBuffer[frameCount];
        final int[] hp = new int[frameCount];
        int n = 0;
        for (final WebPAnimFrame webPAnimFrame : webPAnimDecoder) {
            final ByteBuffer pixels = webPAnimFrame.getPixels();
            final ByteBuffer allocateDirect = ByteBuffer.allocateDirect(pixels.capacity());
            allocateDirect.put(pixels);
            allocateDirect.rewind();
            ho[n] = allocateDirect;
            hp[n] = webPAnimFrame.getDuration();
            ++n;
        }
        this.Ho = ho;
        this.Hp = hp;
        this.Hq = webPAnimDecoder.getInfo();
    }
    
    private int s(final int n, final int n2) {
        final int glGenTextures = GL11.glGenTextures();
        GL11.glBindTexture(3553, glGenTextures);
        GL11.glTexParameteri(3553, 33085, 0);
        GL11.glTexParameteri(3553, 33082, 0);
        GL11.glTexParameteri(3553, 33083, 0);
        GL11.glTexParameterf(3553, 34049, 0.0f);
        GL11.glTexParameteri(3553, 10241, 9729);
        GL11.glTexParameteri(3553, 10240, 9729);
        GL11.glTexParameteri(3553, 10242, 33071);
        GL11.glTexParameteri(3553, 10243, 33071);
        GL11.glTexImage2D(3553, 0, 6408, n, n2, 0, 6408, 5121, (ByteBuffer)null);
        GL11.glBindTexture(3553, 0);
        return glGenTextures;
    }
}
