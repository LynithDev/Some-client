package net.digitalingot.feather;

public interface ad
{
    public static final ao<ad> bk = ap.a((Class<? super ad>)ad.class, array -> void1 -> {
        for (length = array.length; i < length; ++i) {
            array[i].registerCommands(void1);
        }
    });
    
    void registerCommands(final Void p0);
    
    default static {
        int length;
        int i = 0;
    }
}
