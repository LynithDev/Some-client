package net.digitalingot.feather;

import org.jetbrains.annotations.*;
import java.io.*;

public class jq
{
    public static void a(@Nullable final Closeable... array) {
        for (final Closeable closeable : array) {
            try {
                if (closeable != null) {
                    closeable.close();
                }
            }
            catch (IOException ex) {
                kk.FT.error("Failed to close closeable", (Throwable)ex);
            }
        }
    }
}
