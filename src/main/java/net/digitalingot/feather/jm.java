package net.digitalingot.feather;

public interface jm<T extends iZ> extends jn<T>
{
    T g(final jc p0, final boolean p1);
    
    default T a(final jc jc) {
        return this.g(jc, e.s().m().b(fC.class).dI().ov);
    }
}
