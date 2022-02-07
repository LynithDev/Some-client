package net.digitalingot.feather;

import org.objectweb.asm.*;

public abstract class kv extends ClassVisitor
{
    public kv() {
        super(ku.Gt);
    }
    
    public kv(final ClassVisitor classVisitor) {
        super(ku.Gt, classVisitor);
    }
}
