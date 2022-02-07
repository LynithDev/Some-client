package net.digitalingot.feather;

import org.jetbrains.annotations.*;
import java.net.*;
import java.io.*;

public class jt
{
    @NotNull
    public static jz d(@NotNull final InputStream inputStream) {
        return new jz(inputStream);
    }
    
    @NotNull
    public static jA a(@NotNull final URL url) {
        return new jA(url);
    }
    
    @NotNull
    public static jA aM(@NotNull final String s) {
        try {
            return a(new URL(s));
        }
        catch (MalformedURLException ex) {
            throw new IllegalArgumentException("Illegal URL", ex);
        }
    }
    
    @NotNull
    public static jy m(@NotNull final File file) {
        return new jy(file);
    }
    
    @NotNull
    public static jy aN(@NotNull final String s) {
        return new jy(new File(s));
    }
    
    @NotNull
    public static jx aO(@NotNull final String s) {
        return new jx(s);
    }
}
