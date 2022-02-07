package net.digitalingot.feather;

import net.minecraft.util.*;
import net.minecraft.client.*;
import org.cache2k.*;
import javax.imageio.*;
import java.io.*;
import java.awt.*;
import java.awt.image.*;
import net.minecraft.client.renderer.texture.*;
import net.digitalingot.feather.mixin.client.*;
import net.minecraft.client.renderer.*;
import org.lwjgl.opengl.*;
import net.minecraft.client.renderer.vertex.*;
import java.util.*;
import com.google.common.collect.*;

public class ky
{
    private final String GB = "\u00c0\u00c1\u00c2\u00c8\u00ca\u00cb\u00cd\u00d3\u00d4\u00d5\u00da\u00df\u00e3\u00f5\u011f\u0130\u0131\u0152\u0153\u015e\u015f\u0174\u0175\u017e\u0207\u0000\u0000\u0000\u0000\u0000\u0000\u0000 !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~\u0000\u00c7\u00fc\u00e9\u00e2\u00e4\u00e0\u00e5\u00e7\u00ea\u00eb\u00e8\u00ef\u00ee\u00ec\u00c4\u00c5\u00c9\u00e6\u00c6\u00f4\u00f6\u00f2\u00fb\u00f9\u00ff\u00d6\u00dc\u00f8?\u00d8\u00d7\u0192\u00e1\u00ed\u00f3\u00fa\u00f1\u00d1???®¬???«»\u2591\u2592\u2593\u2502\u2524\u2561\u2562\u2556\u2555\u2563\u2551\u2557\u255d\u255c\u255b\u2510\u2514\u2534\u252c\u251c\u2500\u253c\u255e\u255f\u255a\u2554\u2569\u2566\u2560\u2550\u256c\u2567\u2568\u2564\u2565\u2559\u2558\u2552\u2553\u256b\u256a\u2518\u250c\u2588\u2584\u258c\u2590\u2580\u03b1\u03b2\u0393\u03c0\u03a3\u03c3\u03bc\u03c4\u03a6\u0398\u03a9\u03b4\u221e\u2205\u2208\u2229\u2261±\u2265\u2264\u2320\u2321\u00f7\u2248°\u2219·\u221a\u207f?\u25a0\u0000";
    private final Cache<kx.a, kx> GC;
    private final Cache<String, Integer> GD;
    private static final ResourceLocation[] GE;
    private int GF;
    private static final Minecraft nI;
    private int GG;
    private float GH;
    private float GI;
    private int GJ;
    
    public ky() {
        this.GC = (Cache<kx.a, kx>)Cache2kBuilder.of((Class)kx.a.class, (Class)kx.class).entryCapacity(2500L).build();
        this.GD = (Cache<String, Integer>)Cache2kBuilder.of((Class)String.class, (Class)Integer.class).entryCapacity(5000L).loader(this::az).build();
        this.GF = -1;
        this.GG = 256;
        this.GH = (float)(16 * this.GG + 128);
        this.GI = (float)(16 * this.GG);
        this.GJ = 128;
    }
    
    private void tV() {
        int width = 256;
        int i = 0;
        while (i < 256) {
            try {
                final InputStream inputStream = ky.nI.getResourceManager().getResource(new ResourceLocation(String.format("textures/font/unicode_page_%02x.png", i))).getInputStream();
                try {
                    width = ImageIO.read(inputStream).getWidth();
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
            catch (Exception ex2) {
                ++i;
                continue;
            }
            break;
        }
        this.GG = width;
        int width2 = 128;
        try {
            final InputStream inputStream2 = ky.nI.getResourceManager().getResource(this.tX().getLocationFontTexture()).getInputStream();
            try {
                width2 = ImageIO.read(inputStream2).getWidth();
                if (inputStream2 != null) {
                    inputStream2.close();
                }
            }
            catch (Throwable t3) {
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    }
                    catch (Throwable t4) {
                        t3.addSuppressed(t4);
                    }
                }
                throw t3;
            }
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        this.GJ = width2;
        this.GH = (float)(16 * this.GG + width2);
        this.GI = (float)(16 * this.GG);
    }
    
    private void tW() {
        final bY tx = this.tX();
        final BufferedImage bufferedImage = new BufferedImage((int)this.GI, (int)this.GH, 2);
        for (int i = 0; i < 256; ++i) {
            try {
                final InputStream inputStream = Minecraft.getMinecraft().getResourceManager().getResource(new ResourceLocation(String.format("textures/font/unicode_page_%02x.png", i))).getInputStream();
                try {
                    bufferedImage.getGraphics().drawImage(ImageIO.read(inputStream), i / 16 * this.GG, i % 16 * this.GG, null);
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
            catch (Exception ex2) {}
        }
        try {
            final InputStream inputStream2 = Minecraft.getMinecraft().getResourceManager().getResource(tx.getLocationFontTexture()).getInputStream();
            try {
                bufferedImage.getGraphics().drawImage(ImageIO.read(inputStream2), 0, 16 * this.GG, null);
                if (inputStream2 != null) {
                    inputStream2.close();
                }
            }
            catch (Throwable t3) {
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    }
                    catch (Throwable t4) {
                        t3.addSuppressed(t4);
                    }
                }
                throw t3;
            }
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        this.GF = new DynamicTexture(bufferedImage).func_110552_b();
    }
    
    public void a(final String s, final int n, final boolean b) {
        if (this.GF == -1) {
            this.tV();
            this.tW();
        }
        final bY tx = this.tX();
        tx.setRandomStyle(false);
        tx.setBoldStyle(false);
        tx.setItalicStyle(false);
        tx.setUnderlineStyle(false);
        tx.setStrikethroughStyle(false);
        final float posX = tx.getPosX();
        final float posY = tx.getPosY();
        tx.setPosX(0.0f);
        tx.setPosY(0.0f);
        GlStateManager.bindTexture(this.GF);
        GlStateManager.translate(posX, posY, 0.0f);
        final kx.a a = new kx.a(s, tx.getRed(), tx.getGreen(), tx.getBlue(), tx.getAlpha(), b);
        if (this.GC.containsKey((Object)a)) {
            final kx kx = (kx)this.GC.get((Object)a);
            GlStateManager.callList(kx.tT());
            GlStateManager.translate(-posX, -posY, 0.0f);
            tx.setPosX(posX + kx.tR());
            tx.setPosY(posY + kx.tS());
            GlStateManager.resetColor();
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        }
        else {
            final int generateDisplayLists = GLAllocation.generateDisplayLists(1);
            GL11.glNewList(generateDisplayLists, 4865);
            final kx kx2 = new kx(s, tx.getPosX() - posX, tx.getPosY() - posY, tx.getRed(), tx.getGreen(), tx.getBlue(), tx.getAlpha(), generateDisplayLists);
            this.a(tx, s, n, b);
            GL11.glEndList();
            this.GC.put((Object)a, (Object)kx2);
            kx2.p(tx.getPosX());
            tx.setPosX(posX + kx2.tR());
            tx.setPosY(posY + kx2.tS());
            GlStateManager.translate(-posX, -posY, 0.0f);
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        }
    }
    
    private void a(final bY by, final String s, int n, final boolean b) {
        iO.a(7, DefaultVertexFormats.POSITION_TEX_COLOR);
        final jk jk = iO.sS().createSink(ja.EH);
        List<kz> list = null;
        for (int i = 0; i < s.length(); ++i) {
            char char1 = s.charAt(i);
            if (char1 == '§' && i + 1 < s.length()) {
                int index = "0123456789abcdefklmnor".indexOf(s.toLowerCase(Locale.ENGLISH).charAt(i + 1));
                if (index < 16) {
                    by.setRandomStyle(false);
                    by.setBoldStyle(false);
                    by.setStrikethroughStyle(false);
                    by.setUnderlineStyle(false);
                    by.setItalicStyle(false);
                    if (index < 0) {
                        index = 15;
                    }
                    if (b) {
                        index += 16;
                    }
                    final int n2 = by.getColorCode()[index];
                    n = iL.d((n2 >> 16) / 255.0f, (n2 >> 8 & 0xFF) / 255.0f, (n2 & 0xFF) / 255.0f, by.getAlpha());
                }
                else if (index == 16) {
                    by.setRandomStyle(true);
                }
                else if (index == 17) {
                    by.setBoldStyle(true);
                }
                else if (index == 18) {
                    by.setStrikethroughStyle(true);
                    list = this.m(list);
                }
                else if (index == 19) {
                    by.setUnderlineStyle(true);
                    list = this.m(list);
                }
                else if (index == 20) {
                    by.setItalicStyle(true);
                }
                else {
                    by.setRandomStyle(false);
                    by.setBoldStyle(false);
                    by.setStrikethroughStyle(false);
                    by.setUnderlineStyle(false);
                    by.setItalicStyle(false);
                    n = iL.d(by.getRed(), by.getBlue(), by.getGreen(), by.getAlpha());
                }
                ++i;
            }
            else {
                int index2;
                if (b || by.isRandomStyle()) {
                    Objects.requireNonNull(this);
                    index2 = "\u00c0\u00c1\u00c2\u00c8\u00ca\u00cb\u00cd\u00d3\u00d4\u00d5\u00da\u00df\u00e3\u00f5\u011f\u0130\u0131\u0152\u0153\u015e\u015f\u0174\u0175\u017e\u0207\u0000\u0000\u0000\u0000\u0000\u0000\u0000 !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~\u0000\u00c7\u00fc\u00e9\u00e2\u00e4\u00e0\u00e5\u00e7\u00ea\u00eb\u00e8\u00ef\u00ee\u00ec\u00c4\u00c5\u00c9\u00e6\u00c6\u00f4\u00f6\u00f2\u00fb\u00f9\u00ff\u00d6\u00dc\u00f8?\u00d8\u00d7\u0192\u00e1\u00ed\u00f3\u00fa\u00f1\u00d1???®¬???«»\u2591\u2592\u2593\u2502\u2524\u2561\u2562\u2556\u2555\u2563\u2551\u2557\u255d\u255c\u255b\u2510\u2514\u2534\u252c\u251c\u2500\u253c\u255e\u255f\u255a\u2554\u2569\u2566\u2560\u2550\u256c\u2567\u2568\u2564\u2565\u2559\u2558\u2552\u2553\u256b\u256a\u2518\u250c\u2588\u2584\u258c\u2590\u2580\u03b1\u03b2\u0393\u03c0\u03a3\u03c3\u03bc\u03c4\u03a6\u0398\u03a9\u03b4\u221e\u2205\u2208\u2229\u2261±\u2265\u2264\u2320\u2321\u00f7\u2248°\u2219·\u221a\u207f?\u25a0\u0000".indexOf(char1);
                }
                else {
                    index2 = 0;
                }
                int nextInt = index2;
                if (by.isRandomStyle() && nextInt != -1) {
                    char char2;
                    do {
                        final Random fontRandom = by.getFontRandom();
                        Objects.requireNonNull(this);
                        nextInt = fontRandom.nextInt("\u00c0\u00c1\u00c2\u00c8\u00ca\u00cb\u00cd\u00d3\u00d4\u00d5\u00da\u00df\u00e3\u00f5\u011f\u0130\u0131\u0152\u0153\u015e\u015f\u0174\u0175\u017e\u0207\u0000\u0000\u0000\u0000\u0000\u0000\u0000 !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~\u0000\u00c7\u00fc\u00e9\u00e2\u00e4\u00e0\u00e5\u00e7\u00ea\u00eb\u00e8\u00ef\u00ee\u00ec\u00c4\u00c5\u00c9\u00e6\u00c6\u00f4\u00f6\u00f2\u00fb\u00f9\u00ff\u00d6\u00dc\u00f8?\u00d8\u00d7\u0192\u00e1\u00ed\u00f3\u00fa\u00f1\u00d1???®¬???«»\u2591\u2592\u2593\u2502\u2524\u2561\u2562\u2556\u2555\u2563\u2551\u2557\u255d\u255c\u255b\u2510\u2514\u2534\u252c\u251c\u2500\u253c\u255e\u255f\u255a\u2554\u2569\u2566\u2560\u2550\u256c\u2567\u2568\u2564\u2565\u2559\u2558\u2552\u2553\u256b\u256a\u2518\u250c\u2588\u2584\u258c\u2590\u2580\u03b1\u03b2\u0393\u03c0\u03a3\u03c3\u03bc\u03c4\u03a6\u0398\u03a9\u03b4\u221e\u2205\u2208\u2229\u2261±\u2265\u2264\u2320\u2321\u00f7\u2248°\u2219·\u221a\u207f?\u25a0\u0000".length());
                        Objects.requireNonNull(this);
                        char2 = "\u00c0\u00c1\u00c2\u00c8\u00ca\u00cb\u00cd\u00d3\u00d4\u00d5\u00da\u00df\u00e3\u00f5\u011f\u0130\u0131\u0152\u0153\u015e\u015f\u0174\u0175\u017e\u0207\u0000\u0000\u0000\u0000\u0000\u0000\u0000 !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~\u0000\u00c7\u00fc\u00e9\u00e2\u00e4\u00e0\u00e5\u00e7\u00ea\u00eb\u00e8\u00ef\u00ee\u00ec\u00c4\u00c5\u00c9\u00e6\u00c6\u00f4\u00f6\u00f2\u00fb\u00f9\u00ff\u00d6\u00dc\u00f8?\u00d8\u00d7\u0192\u00e1\u00ed\u00f3\u00fa\u00f1\u00d1???®¬???«»\u2591\u2592\u2593\u2502\u2524\u2561\u2562\u2556\u2555\u2563\u2551\u2557\u255d\u255c\u255b\u2510\u2514\u2534\u252c\u251c\u2500\u253c\u255e\u255f\u255a\u2554\u2569\u2566\u2560\u2550\u256c\u2567\u2568\u2564\u2565\u2559\u2558\u2552\u2553\u256b\u256a\u2518\u250c\u2588\u2584\u258c\u2590\u2580\u03b1\u03b2\u0393\u03c0\u03a3\u03c3\u03bc\u03c4\u03a6\u0398\u03a9\u03b4\u221e\u2205\u2208\u2229\u2261±\u2265\u2264\u2320\u2321\u00f7\u2248°\u2219·\u221a\u207f?\u25a0\u0000".charAt(nextInt);
                    } while (ky.nI.fontRendererObj.getCharWidth(char1) != ky.nI.fontRendererObj.getCharWidth(char2));
                    char1 = char2;
                }
                final float n3 = (nextInt == -1 || by.isUnicodeFlag()) ? 0.5f : 1.0f;
                final boolean b2 = (char1 == '\0' || nextInt == -1 || by.isUnicodeFlag()) && b;
                if (b2) {
                    by.setPosX(by.getPosX() - n3);
                    by.setPosY(by.getPosY() - n3);
                }
                float a = this.a(jk, char1, n, by.isItalicStyle(), i == 0);
                if (b2) {
                    by.setPosX(by.getPosX() + n3);
                    by.setPosY(by.getPosY() + n3);
                }
                if (by.isBoldStyle()) {
                    by.setPosX(by.getPosX() + n3);
                    if (b2) {
                        by.setPosX(by.getPosX() - n3);
                        by.setPosY(by.getPosY() - n3);
                    }
                    this.a(jk, char1, n, by.isItalicStyle(), false);
                    by.setPosX(by.getPosX() - n3);
                    if (b2) {
                        by.setPosX(by.getPosX() + n3);
                        by.setPosY(by.getPosY() + n3);
                    }
                    ++a;
                }
                final int n4 = (list == null) ? 0 : (list.size() - 1);
                if (by.isStrikethroughStyle()) {
                    if (n4 >= 0 && list.get(n4).tY() == by.getPosX()) {
                        list.get(n4).q(by.getPosX() + a);
                    }
                    else {
                        list.add(new kz(by.getPosX(), by.getPosY() + by.getFontHeight() / 2, by.getPosX() + a, n));
                    }
                }
                if (by.isUnderlineStyle()) {
                    if (n4 >= 0 && list.get(n4).tY() == by.getPosX() - 1.0f) {
                        list.get(n4).q(by.getPosX() + a);
                    }
                    else {
                        list.add(new kz(by.getPosX() - 1.0f, by.getPosY() + by.getFontHeight(), by.getPosX() + a, n));
                    }
                }
                by.setPosX(by.getPosX() + (int)a);
            }
        }
        jk.tc();
        iO.lS();
        if (list != null && list.size() > 0) {
            GlStateManager.disableTexture2D();
            iO.a(7, DefaultVertexFormats.POSITION_COLOR);
            final ji ji = iO.sS().createSink(ja.EF);
            for (final kz kz : list) {
                ji.b(kz.tY(), kz.tZ(), kz.iu());
                ji.b(kz.ua(), kz.tZ(), kz.iu());
                ji.b(kz.ua(), kz.tZ() - 1.0f, kz.iu());
                ji.b(kz.tY(), kz.tZ() - 1.0f, kz.iu());
            }
            ji.tc();
            iO.lS();
            GlStateManager.enableTexture2D();
        }
    }
    
    private float a(final jk jk, final char c, final int n, final boolean b, final boolean b2) {
        final bY tx = this.tX();
        if (c == ' ' || c == ' ') {
            return tx.isUnicodeFlag() ? 4.0f : ((float)Minecraft.getMinecraft().fontRendererObj.getCharWidth(c));
        }
        Objects.requireNonNull(this);
        final int index = "\u00c0\u00c1\u00c2\u00c8\u00ca\u00cb\u00cd\u00d3\u00d4\u00d5\u00da\u00df\u00e3\u00f5\u011f\u0130\u0131\u0152\u0153\u015e\u015f\u0174\u0175\u017e\u0207\u0000\u0000\u0000\u0000\u0000\u0000\u0000 !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~\u0000\u00c7\u00fc\u00e9\u00e2\u00e4\u00e0\u00e5\u00e7\u00ea\u00eb\u00e8\u00ef\u00ee\u00ec\u00c4\u00c5\u00c9\u00e6\u00c6\u00f4\u00f6\u00f2\u00fb\u00f9\u00ff\u00d6\u00dc\u00f8?\u00d8\u00d7\u0192\u00e1\u00ed\u00f3\u00fa\u00f1\u00d1???®¬???«»\u2591\u2592\u2593\u2502\u2524\u2561\u2562\u2556\u2555\u2563\u2551\u2557\u255d\u255c\u255b\u2510\u2514\u2534\u252c\u251c\u2500\u253c\u255e\u255f\u255a\u2554\u2569\u2566\u2560\u2550\u256c\u2567\u2568\u2564\u2565\u2559\u2558\u2552\u2553\u256b\u256a\u2518\u250c\u2588\u2584\u258c\u2590\u2580\u03b1\u03b2\u0393\u03c0\u03a3\u03c3\u03bc\u03c4\u03a6\u0398\u03a9\u03b4\u221e\u2205\u2208\u2229\u2261±\u2265\u2264\u2320\u2321\u00f7\u2248°\u2219·\u221a\u207f?\u25a0\u0000".indexOf(c);
        return (index != -1 && !tx.isUnicodeFlag()) ? this.a(jk, c, index, n, b, b2) : this.a(jk, c, n, b);
    }
    
    protected float a(final jk jk, final char c, final int n, final int n2, final boolean b, final boolean b2) {
        final float n3 = (n % 16 * 8 * this.GJ >> 7) + 0.01f;
        final float n4 = ((n >> 4) * 8 * this.GJ >> 7) + 16 * this.GG + 0.01f;
        final boolean b3 = b;
        final bY tx = this.tX();
        final float n5 = (float)ky.nI.fontRendererObj.getCharWidth(c);
        final float n6 = n5 - 0.01f;
        final float n7 = 7.99f * this.GJ / 128.0f;
        final float n8 = n6 * this.GJ / 128.0f;
        final float n9 = n4 / this.GH;
        final float n10 = (n4 + n7) / this.GH;
        jk.a(tx.getPosX() + (float)(b3 ? 1 : 0), tx.getPosY(), n3 / this.GI, n9, n2);
        jk.a(tx.getPosX() - (float)(b3 ? 1 : 0), tx.getPosY() + 7.99f, n3 / this.GI, n10, n2);
        final int n11 = this.GJ / 127;
        jk.a(tx.getPosX() + n6 - 1.0f - (float)(b3 ? 1 : 0), tx.getPosY() + 7.99f, (n3 + n8 - n11) / this.GI, n10, n2);
        jk.a(tx.getPosX() + n6 - 1.0f + (float)(b3 ? 1 : 0), tx.getPosY(), (n3 + n8 - n11) / this.GI, n9, n2);
        return n5;
    }
    
    private float a(final int n, final float n2, final float n3, final char c) {
        return ((n >> 4) * this.GG + ((c % '\u0010' << 4) + n2 + n3)) / this.GI;
    }
    
    private float a(final int n, final float n2, final char c) {
        return (n % 16 * this.GG + (((c & '\u00ff') >> 4) * 16 + n2)) / this.GH;
    }
    
    protected float a(final jk jk, final char c, final int n, final boolean b) {
        final bY tx = this.tX();
        if (tx.getGlyphWidth()[c] == 0) {
            return 0.0f;
        }
        final int n2 = tx.getGlyphWidth()[c] >>> 4;
        final int n3 = tx.getGlyphWidth()[c] & 0xF;
        final int n4 = c / '\u0100';
        final float n5 = 0.05f * n4 / 39.0f;
        final float a = this.a(n4, (float)n2, n5, c);
        final float a2 = this.a(n4, n5, c);
        final float n6 = (float)(n3 + 1);
        final float n7 = n6 - n2 - 0.02f;
        final float n8 = b ? 1.0f : 0.0f;
        final float n9 = 15.98f * this.GG / 256.0f;
        jk.a(tx.getPosX() + n8, tx.getPosY(), a, a2, n);
        jk.a(tx.getPosX() - n8, tx.getPosY() + 7.99f, a, a2 + n9 / this.GH, n);
        final float n10 = n7 + 0.5f;
        jk.a(tx.getPosX() + n7 / 2.0f - n8, tx.getPosY() + 7.99f, a + n10 / this.GH, a2 + n9 / this.GH, n);
        jk.a(tx.getPosX() + n7 / 2.0f + n8, tx.getPosY(), a + n10 / this.GH, a2, n);
        return (n6 - n2) / 2.0f + 1.0f;
    }
    
    public int aW(final String s) {
        return (int)this.GD.get((Object)s);
    }
    
    private int az(final String s) {
        if (s == null) {
            return 0;
        }
        int n = 0;
        boolean b = false;
        for (int i = 0; i < s.length(); ++i) {
            int e = this.e(s.charAt(i));
            if (e < 0 && i < s.length() - 1) {
                ++i;
                final char char1 = s.charAt(i);
                if (char1 != 'l' && char1 != 'L') {
                    if (char1 == 'r' || char1 == 'R') {
                        b = false;
                    }
                }
                else {
                    b = true;
                }
                e = 0;
            }
            n += e;
            if (b && e > 0) {
                ++n;
            }
        }
        return n;
    }
    
    public int e(final char c) {
        if (c == '§') {
            return -1;
        }
        if (c == ' ') {
            return 4;
        }
        Objects.requireNonNull(this);
        final int index = "\u00c0\u00c1\u00c2\u00c8\u00ca\u00cb\u00cd\u00d3\u00d4\u00d5\u00da\u00df\u00e3\u00f5\u011f\u0130\u0131\u0152\u0153\u015e\u015f\u0174\u0175\u017e\u0207\u0000\u0000\u0000\u0000\u0000\u0000\u0000 !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~\u0000\u00c7\u00fc\u00e9\u00e2\u00e4\u00e0\u00e5\u00e7\u00ea\u00eb\u00e8\u00ef\u00ee\u00ec\u00c4\u00c5\u00c9\u00e6\u00c6\u00f4\u00f6\u00f2\u00fb\u00f9\u00ff\u00d6\u00dc\u00f8?\u00d8\u00d7\u0192\u00e1\u00ed\u00f3\u00fa\u00f1\u00d1???®¬???«»\u2591\u2592\u2593\u2502\u2524\u2561\u2562\u2556\u2555\u2563\u2551\u2557\u255d\u255c\u255b\u2510\u2514\u2534\u252c\u251c\u2500\u253c\u255e\u255f\u255a\u2554\u2569\u2566\u2560\u2550\u256c\u2567\u2568\u2564\u2565\u2559\u2558\u2552\u2553\u256b\u256a\u2518\u250c\u2588\u2584\u258c\u2590\u2580\u03b1\u03b2\u0393\u03c0\u03a3\u03c3\u03bc\u03c4\u03a6\u0398\u03a9\u03b4\u221e\u2205\u2208\u2229\u2261±\u2265\u2264\u2320\u2321\u00f7\u2248°\u2219·\u221a\u207f?\u25a0\u0000".indexOf(c);
        final bY tx = this.tX();
        if (c > '\0' && index != -1 && !tx.isUnicodeFlag()) {
            return tx.getCharWidth()[index];
        }
        if (tx.getGlyphWidth()[c] != 0) {
            final int n = tx.getGlyphWidth()[c] >>> 4;
            int n2 = tx.getGlyphWidth()[c] & 0xF;
            return (++n2 - n) / 2 + 1;
        }
        return 0;
    }
    
    private List<kz> m(final List<kz> list) {
        if (list == null) {
            return (List<kz>)Lists.newArrayList();
        }
        return list;
    }
    
    private bY tX() {
        return (bY)Minecraft.getMinecraft().fontRendererObj;
    }
    
    static {
        GE = new ResourceLocation[256];
        nI = Minecraft.getMinecraft();
    }
}
