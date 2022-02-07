package net.digitalingot.feather;

import java.awt.image.*;
import java.nio.*;

public class ki
{
    public static ByteBuffer a(final BufferedImage bufferedImage) {
        final byte[] array = new byte[bufferedImage.getWidth() * bufferedImage.getHeight() * 4];
        int n = 0;
        for (int i = 0; i < bufferedImage.getHeight(); ++i) {
            for (int j = 0; j < bufferedImage.getWidth(); ++j) {
                final int rgb = bufferedImage.getRGB(j, i);
                array[n] = (byte)(rgb << 8 >> 24);
                array[n + 1] = (byte)(rgb << 16 >> 24);
                array[n + 2] = (byte)(rgb << 24 >> 24);
                array[n + 3] = (byte)(rgb >> 24);
                n += 4;
            }
        }
        return ByteBuffer.wrap(array);
    }
}
