package net.digitalingot.feather;

import java.util.*;
import java.nio.*;

public class kq
{
    public static byte[] r(final UUID uuid) {
        final ByteBuffer wrap = ByteBuffer.wrap(new byte[16]);
        wrap.putLong(uuid.getMostSignificantBits());
        wrap.putLong(uuid.getLeastSignificantBits());
        return wrap.array();
    }
    
    public static UUID o(final byte[] array) {
        long n = 0L;
        long n2 = 0L;
        for (int i = 0; i < 8; ++i) {
            n = (n << 8 | (long)(array[i] & 0xFF));
        }
        for (int j = 8; j < 16; ++j) {
            n2 = (n2 << 8 | (long)(array[j] & 0xFF));
        }
        return new UUID(n, n2);
    }
}
