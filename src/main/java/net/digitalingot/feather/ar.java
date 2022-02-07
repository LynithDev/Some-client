package net.digitalingot.feather;

import java.util.function.*;
import java.util.concurrent.locks.*;
import java.lang.reflect.*;
import java.util.*;

class ar<T> extends ao<T>
{
    private final Function<T[], T> bK;
    private final Lock bL;
    private T[] bM;
    
    ar(final Class<? super T> clazz, final Function<T[], T> bk) {
        this.bL = new ReentrantLock();
        this.bK = bk;
        this.bM = (T[])Array.newInstance(clazz, 0);
        this.aK();
    }
    
    void aK() {
        this.bI = this.bK.apply(this.bM);
    }
    
    @Override
    public void a(final T t) {
        Objects.requireNonNull(t, "Tried to register a null listener!");
        this.bL.lock();
        try {
            (this.bM = Arrays.copyOf(this.bM, this.bM.length + 1))[this.bM.length - 1] = t;
            this.aK();
        }
        finally {
            this.bL.unlock();
        }
    }
}
