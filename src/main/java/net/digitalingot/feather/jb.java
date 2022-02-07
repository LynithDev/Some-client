package net.digitalingot.feather;

import net.minecraft.client.renderer.vertex.*;

public interface jb
{
    default jb b(final VertexFormat vertexFormat) {
        return (jb)vertexFormat;
    }
    
    int getStride();
}
