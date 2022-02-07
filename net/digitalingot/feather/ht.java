package net.digitalingot.feather;

import io.netty.util.*;

public class ht
{
    public static final AttributeKey<hI> zj;
    public static final AttributeKey<hM> zk;
    public static final String zl;
    public static final int zm = 5432;
    public static final String zn;
    public static final int zo = 5433;
    public static final int zp = 3;
    public static final int zq = 1;
    public static final int zr = 24000;
    public static final int zs = 20;
    public static final int zt = 480;
    public static final int zu = 960;
    public static final double zv = 32.0;
    public static final double zw = 16.0;
    
    static {
        zj = AttributeKey.valueOf("control-connection");
        zk = AttributeKey.valueOf("voice-connection");
        zl = jQ.h("FEATHER_VOICE_IPS", "https://game-client.feathermc.com/voice-list");
        zn = jQ.h("FEATHER_CONTROL_SERVER", "voice.lb.feathermc.com");
    }
}
