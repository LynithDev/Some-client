package net.digitalingot.feather;

import java.lang.reflect.*;
import java.awt.event.*;

final class bp
{
    private static final Field cr;
    
    private bp() {
        throw new AssertionError();
    }
    
    public static void a(final KeyEvent keyEvent, final int n) {
        try {
            bp.cr.set(keyEvent, n);
        }
        catch (Throwable t) {}
    }
    
    static {
        try {
            (cr = KeyEvent.class.getDeclaredField("scancode")).setAccessible(true);
        }
        catch (Throwable t) {
            throw new IllegalStateException(t);
        }
    }
}
