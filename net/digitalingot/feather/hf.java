package net.digitalingot.feather;

import net.minecraft.client.resources.data.*;
import org.jetbrains.annotations.*;
import net.minecraft.util.*;
import net.minecraft.client.resources.*;
import java.util.*;

public class hf extends FallbackResourceManager
{
    private final hd ye;
    
    public hf(final hd ye) {
        super((IMetadataSerializer)null);
        this.ye = ye;
    }
    
    @NotNull
    public Set<String> getResourceDomains() {
        return Collections.emptySet();
    }
    
    @NotNull
    public IResource getResource(@NotNull final ResourceLocation resourceLocation) {
        return (IResource)new he(this.ye);
    }
    
    @NotNull
    public List<IResource> getAllResources(final ResourceLocation resourceLocation) {
        return Collections.emptyList();
    }
}
