package net.digitalingot.feather;

import org.jetbrains.annotations.*;
import com.google.gson.*;
import java.io.*;
import java.util.function.*;

public interface ju extends Closeable, AutoCloseable
{
    @NotNull
    OutputStream tm();
    
    @NotNull
    default jw tn() {
        return new jw(this);
    }
    
    default void i(@NotNull final Object o) {
        this.a(new Gson(), o);
    }
    
    default void a(@NotNull final Gson gson, @NotNull final Object o) {
        this.aP(gson.toJson(o));
    }
    
    default void aP(@NotNull final String s) {
        this.l(s.getBytes());
    }
    
    default void l(final byte[] array) {
        this.c(outputStream -> {
            try {
                outputStream.write(array);
            }
            catch (IOException ex) {
                throw new js(ex);
            }
        });
    }
    
    default void e(@NotNull final InputStream inputStream) {
        try {
            try {
                this.c(outputStream -> {
                    try {
                        inputStream.transferTo(outputStream);
                    }
                    catch (IOException ex) {
                        throw new js(ex);
                    }
                    return;
                });
                if (inputStream != null) {
                    inputStream.close();
                }
            }
            catch (Throwable t) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    }
                    catch (Throwable t2) {
                        t.addSuppressed(t2);
                    }
                }
                throw t;
            }
        }
        catch (IOException ex2) {
            throw new js(ex2);
        }
    }
    
    default <T> T b(@NotNull final Function<OutputStream, T> function) {
        try {
            return function.apply(this.tm());
        }
        finally {
            jq.a(this);
        }
    }
    
    default void c(@NotNull final Consumer<OutputStream> consumer) {
        try {
            consumer.accept(this.tm());
        }
        finally {
            jq.a(this);
        }
    }
}
