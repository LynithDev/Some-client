package net.digitalingot.feather;

import javax.imageio.*;
import java.io.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.datatransfer.*;

public class hi
{
    public static void c(final File file) {
        System.out.println("Copying image to clipboard...");
        d(file);
    }
    
    private static void d(final File file) {
        BufferedImage read;
        try {
            read = ImageIO.read(file);
        }
        catch (IOException ex) {
            kk.FT.error("Could not read image from file: " + file.getAbsolutePath());
            return;
        }
        final hn hn = new hn(read);
        final Clipboard systemClipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        try {
            systemClipboard.setContents(hn, null);
        }
        catch (Exception ex2) {}
    }
}
