package net.digitalingot.feather;

import java.nio.*;

public interface jc
{
    boolean ensureBufferCapacity(final int p0);
    
    ByteBuffer getDirectBuffer();
    
    int getWriterPosition();
    
    void flush(final int p0, final jb p1);
    
    jb getVertexFormat();
}
