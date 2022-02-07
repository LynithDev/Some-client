package net.digitalingot.feather;

import org.jetbrains.annotations.*;
import com.google.common.io.*;
import java.lang.reflect.*;
import com.google.gson.*;
import java.io.*;
import java.util.*;
import java.util.function.*;

public interface jr extends Closeable, AutoCloseable
{
    @NotNull
    InputStream th();
    
    default void a(@NotNull final ju ju) {
        Objects.requireNonNull(ju);
        this.b(ju::e);
    }
    
    @NotNull
    default jr ti() {
        return new jv(this);
    }
    
    default byte[] tj() {
        return this.a(inputStream -> {
            try {
                return ByteStreams.toByteArray(inputStream);
            }
            catch (IOException ex) {
                throw new js(ex);
            }
        });
    }
    
    default <T> T a(@NotNull final Type type) {
        return this.a(new Gson(), type);
    }
    
    default <T> T h(@NotNull final Class<T> clazz) {
        return this.a(new Gson(), clazz);
    }
    
    default <T> T a(@NotNull final Gson gson, @NotNull final Class<T> clazz) {
        return (T)gson.fromJson(this.tk(), (Class)clazz);
    }
    
    default <T> T a(@NotNull final Gson gson, @NotNull final Type type) {
        return (T)gson.fromJson(this.tk(), type);
    }
    
    @NotNull
    default String tk() {
        return String.join("\n", this.tl());
    }
    
    @NotNull
    default List<String> tl() {
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        ArrayList<String> list;
        final Object o;
        final String s;
        final ArrayList list2;
        return this.a(inputStream -> {
            try {
                inputStreamReader = new InputStreamReader(inputStream);
                try {
                    bufferedReader = new BufferedReader(inputStreamReader);
                    try {
                        list = new ArrayList<String>();
                        while (true) {
                            bufferedReader.readLine();
                            if (o != null) {
                                list.add(s);
                            }
                            else {
                                break;
                            }
                        }
                        bufferedReader.close();
                        inputStreamReader.close();
                        return list2;
                    }
                    catch (Throwable t) {
                        try {
                            bufferedReader.close();
                        }
                        catch (Throwable t2) {
                            t.addSuppressed(t2);
                        }
                        throw t;
                    }
                }
                catch (Throwable t3) {
                    try {
                        inputStreamReader.close();
                    }
                    catch (Throwable t4) {
                        t3.addSuppressed(t4);
                    }
                    throw t3;
                }
            }
            catch (IOException ex) {
                throw new js(ex);
            }
        });
    }
    
    default <T> T a(@NotNull final Function<InputStream, T> function) {
        try {
            return function.apply(this.th());
        }
        finally {
            jq.a(this);
        }
    }
    
    default void b(@NotNull final Consumer<InputStream> consumer) {
        try {
            consumer.accept(this.th());
        }
        finally {
            jq.a(this);
        }
    }
}
