package net.digitalingot.feather;

import net.minecraft.client.resources.*;
import net.minecraft.util.*;
import java.io.*;
import java.util.*;
import java.nio.charset.*;
import org.apache.commons.io.*;
import net.minecraft.client.resources.data.*;
import org.jetbrains.annotations.*;

public class he implements IResource
{
    private static final String yd = "{\"targets\":[\"swap\",\"previous\"],\"passes\":[{\"name\":\"phosphor\",\"intarget\":\"minecraft:main\",\"outtarget\":\"swap\",\"auxtargets\":[{\"name\":\"PrevSampler\",\"id\":\"previous\"}],\"uniforms\":[{\"name\":\"Phosphor\",\"values\":[%.2f, %.2f, %.2f]}]},{\"name\":\"blit\",\"intarget\":\"swap\",\"outtarget\":\"previous\"},{\"name\":\"blit\",\"intarget\":\"swap\",\"outtarget\":\"minecraft:main\"}]}";
    private final hd ye;
    
    public he(final hd ye) {
        this.ye = ye;
    }
    
    public ResourceLocation getResourceLocation() {
        return null;
    }
    
    @NotNull
    public InputStream getInputStream() {
        final double n = 0.6 + this.ye.dI().yc / 251.0;
        return IOUtils.toInputStream(String.format(Locale.ENGLISH, "{\"targets\":[\"swap\",\"previous\"],\"passes\":[{\"name\":\"phosphor\",\"intarget\":\"minecraft:main\",\"outtarget\":\"swap\",\"auxtargets\":[{\"name\":\"PrevSampler\",\"id\":\"previous\"}],\"uniforms\":[{\"name\":\"Phosphor\",\"values\":[%.2f, %.2f, %.2f]}]},{\"name\":\"blit\",\"intarget\":\"swap\",\"outtarget\":\"previous\"},{\"name\":\"blit\",\"intarget\":\"swap\",\"outtarget\":\"minecraft:main\"}]}", n, n, n), StandardCharsets.UTF_8);
    }
    
    public boolean hasMetadata() {
        return false;
    }
    
    @Nullable
    public <T extends IMetadataSection> T getMetadata(final String s) {
        return null;
    }
    
    public String getResourcePackName() {
        return null;
    }
}
