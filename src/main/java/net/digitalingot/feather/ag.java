package net.digitalingot.feather;

import org.jetbrains.annotations.*;

public interface ag
{
    public static final ao<ag> bx = ap.a((Class<? super ag>)ag.class, array -> im -> {
        for (length = array.length; i < length; ++i) {
            array[i].render(im);
        }
    });
    
    void render(@NotNull final im p0);
    
    default static {
        int length;
        int i = 0;
    }
    
    public interface a
    {
    }
    
    public interface b
    {
    }
}
