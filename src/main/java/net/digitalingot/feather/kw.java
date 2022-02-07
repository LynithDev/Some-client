package net.digitalingot.feather;

import org.objectweb.asm.*;

public abstract class kw extends MethodVisitor
{
    public kw() {
        super(ku.Gt);
    }
    
    public kw(final MethodVisitor methodVisitor) {
        super(ku.Gt, methodVisitor);
    }
}
