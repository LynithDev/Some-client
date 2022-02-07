package net.digitalingot.feather;

import org.objectweb.asm.*;
import org.objectweb.asm.tree.*;
import java.lang.reflect.*;

public final class ku
{
    public static final int Gt;
    
    private ku() {
        throw new AssertionError();
    }
    
    static {
        try {
            final Field declaredField = ClassVisitor.class.getDeclaredField("api");
            declaredField.setAccessible(true);
            Gt = (int)declaredField.get(new ClassNode());
        }
        catch (NoSuchFieldException | IllegalAccessException ex) {
            throw new RuntimeException("Unable to find ASM API version");
        }
    }
}
