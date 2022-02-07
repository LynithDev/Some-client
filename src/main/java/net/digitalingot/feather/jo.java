package net.digitalingot.feather;

import net.minecraft.client.renderer.vertex.*;
import java.util.function.*;

public class jo<T extends iZ> implements jm<T>, jn<T>
{
    private final VertexFormat Bs;
    private final Function<iX, T> ES;
    private final a<T> ET;
    
    public jo(final VertexFormat bs, final Function<iX, T> es, final a<T> et) {
        this.Bs = bs;
        this.ES = es;
        this.ET = et;
    }
    
    @Override
    public T b(final iX ix) {
        return this.ES.apply(ix);
    }
    
    @Override
    public T g(final jc jc, final boolean b) {
        return this.ET.apply(jc, b);
    }
    
    @Override
    public jm<T> tg() {
        return this;
    }
    
    @Override
    public jb tf() {
        return jb.b(this.Bs);
    }
    
    public interface a<T>
    {
        T apply(final jc p0, final boolean p1);
    }
}
