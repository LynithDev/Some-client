package net.digitalingot.feather;

import net.minecraft.client.resources.*;
import net.minecraft.util.*;
import net.minecraft.client.*;
import java.util.*;
import net.minecraft.client.renderer.*;

public class kp implements ke<ResourcePackRepository.Entry>
{
    private final ResourceLocation Go;
    
    public kp() {
        this.Go = new ResourceLocation("textures/misc/unknown_pack.png");
    }
    
    @Override
    public void a(final iG ig, final im im, final ResourcePackRepository.Entry entry, final float n, final float n2, final eT et, final boolean b) {
        ig.a(im, entry.getResourcePackName(), n, n2, et, b);
    }
    
    @Override
    public void a(final iG ig, final im im, final ResourcePackRepository.Entry entry, final float n, final float n2, final int n3, final boolean b) {
        final List listFormattedStringToWidth = Minecraft.getMinecraft().fontRendererObj.listFormattedStringToWidth(entry.getTexturePackDescription(), 157);
        int n4 = 0;
        final Iterator<String> iterator = listFormattedStringToWidth.iterator();
        while (iterator.hasNext()) {
            ig.a(im, iterator.next(), n, n2 + n4, n3, b, false);
            n4 += 12;
        }
    }
    
    public void a(final ResourcePackRepository.Entry entry) {
        entry.bindTexturePackIcon(Minecraft.getMinecraft().getTextureManager());
    }
    
    @Override
    public void tL() {
        Minecraft.getMinecraft().getTextureManager().bindTexture(this.Go);
    }
    
    @Override
    public void a(final iG ig, final im im, final int n, final int n2, final int n3) {
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(770, 771);
        GlStateManager.disableTexture2D();
        ig.a(im, n, n2, 0.0f, 0.0f, n3, n3, n3, n3, (float)n3, (float)n3);
        GlStateManager.enableTexture2D();
    }
}
