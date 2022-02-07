package net.digitalingot.feather;

public enum bw
{
    @ei(fu = "ultra", fh = "Ultra")
    ULTRA(1.0f), 
    @ei(fu = "high", fh = "High")
    HIGH(0.85f), 
    @ei(fu = "medium", fh = "Medium")
    MEDIUM(0.75f), 
    @ei(fu = "low", fh = "Low")
    LOW(0.6f);
    
    private final float scale;
    
    private bw(final float scale) {
        this.scale = scale;
    }
    
    public float getScale() {
        return this.scale;
    }
    
    private static /* synthetic */ bw[] $values() {
        return new bw[] { bw.ULTRA, bw.HIGH, bw.MEDIUM, bw.LOW };
    }
    
    static {
        $VALUES = $values();
    }
}
