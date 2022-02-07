package net.digitalingot.feather;

import java.nio.*;
import java.util.function.*;
import java.util.*;
import org.lwjgl.opengl.*;
import org.lwjgl.util.vector.*;
import org.lwjgl.*;

public final class im
{
    private static final FloatBuffer Bt;
    private final Deque<a> Bu;
    
    private im(final Consumer<Deque<a>> consumer) {
        consumer.accept(this.Bu = new ArrayDeque<a>());
    }
    
    public im() {
        final Matrix4f matrix4f;
        final Matrix3f matrix3f;
        this(deque -> {
            matrix4f = new Matrix4f();
            matrix4f.setIdentity();
            matrix3f = new Matrix3f();
            matrix3f.setIdentity();
            deque.add(new a(matrix4f, matrix3f));
        });
    }
    
    public im(final boolean b) {
        final Matrix4f matrix4f;
        final Matrix3f matrix3f;
        this(deque -> {
            im.Bt.rewind();
            GL11.glGetFloat(2982, im.Bt);
            matrix4f = new Matrix4f();
            matrix4f.load(im.Bt);
            matrix3f = new Matrix3f();
            matrix3f.setIdentity();
            deque.add(new a(matrix4f, matrix3f));
        });
    }
    
    public void a(final double n, final double n2, final double n3) {
        this.b((float)n, (float)n2, (float)n3);
    }
    
    public void b(final float n, final float n2, final float n3) {
        if (n != 0.0f || n2 != 0.0f || n3 != 0.0f) {
            final Matrix4f a = this.Bu.getLast().Bv;
            Matrix4f.translate(new Vector3f(n, n2, n3), a, a);
        }
    }
    
    public void b(final double n, final double n2, final double n3) {
        this.c((float)n, (float)n2, (float)n3);
    }
    
    public void c(final float n, final float n2, final float n3) {
        if (n != 1.0f || n2 != 1.0f || n3 != 1.0f) {
            final a a = this.Bu.getLast();
            final Matrix4f a2 = a.Bv;
            final Matrix3f b = a.Bw;
            Matrix4f.scale(new Vector3f(n, n2, n3), a2, a2);
            if (n == n2 && n2 == n3) {
                if (n < 0.0f) {
                    Matrix3f.negate(b, b);
                }
            }
            else {
                final float n4 = 1.0f / n;
                final float n5 = 1.0f / n2;
                final float n6 = 1.0f / n3;
                final float k = il.k(n4 * n5 * n6);
                final Matrix3f matrix3f = new Matrix3f();
                matrix3f.m00 = k * n4;
                matrix3f.m11 = k * n5;
                matrix3f.m22 = k * n6;
                Matrix3f.mul(b, matrix3f, b);
            }
        }
    }
    
    public void lW() {
        this.Bu.addLast(this.Bu.getLast().me());
    }
    
    public void lX() {
        this.Bu.removeLast();
    }
    
    public a lY() {
        return this.Bu.getLast();
    }
    
    public boolean lZ() {
        return this.Bu.size() == 1;
    }
    
    public void ma() {
        im.Bt.rewind();
        this.Bu.getLast().Bv.store(im.Bt);
        im.Bt.rewind();
        GL11.glMultMatrix(im.Bt);
    }
    
    private void mb() {
        GL11.glLoadIdentity();
        this.ma();
    }
    
    public void a(final Runnable runnable) {
        ik.lU();
        this.ma();
        runnable.run();
        ik.lV();
    }
    
    static {
        Bt = BufferUtils.createFloatBuffer(16);
    }
    
    public static final class a
    {
        private final Matrix4f Bv;
        private final Matrix3f Bw;
        
        private a(final Matrix4f bv, final Matrix3f bw) {
            this.Bv = bv;
            this.Bw = bw;
        }
        
        public Matrix4f mc() {
            return this.Bv;
        }
        
        public Matrix3f md() {
            return this.Bw;
        }
        
        public a me() {
            return new a(Matrix4f.load(this.Bv, (Matrix4f)null), Matrix3f.load(this.Bw, (Matrix3f)null));
        }
    }
}
