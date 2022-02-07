package net.digitalingot.feather;

import com.google.gson.annotations.*;
import org.jetbrains.annotations.*;
import java.net.*;

public class dz implements bT
{
    @SerializedName("id")
    private final int id;
    @SerializedName("server_port")
    @Nullable
    private final Integer jY;
    @SerializedName("peer")
    @NotNull
    private final InetSocketAddress jZ;
    @SerializedName("peer_enc_pk")
    private final byte[] ka;
    
    public dz(final int id, @Nullable final Integer jy, @NotNull final InetSocketAddress jz, final byte[] ka) {
        this.id = id;
        this.jY = jy;
        this.jZ = jz;
        this.ka = ka;
    }
    
    public int ee() {
        return this.id;
    }
    
    @Nullable
    public Integer ef() {
        return this.jY;
    }
    
    @NotNull
    public SocketAddress eg() {
        return this.jZ;
    }
    
    public byte[] eh() {
        return this.ka;
    }
    
    @NotNull
    @Override
    public bQ cv() {
        return bQ.PUNCH_HOLE;
    }
}
