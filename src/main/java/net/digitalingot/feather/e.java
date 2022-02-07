package net.digitalingot.feather;

public class e
{
    private static e y;
    private f z;
    
    public static boolean q() {
        return e.y != null;
    }
    
    public static e r() {
        if (e.y == null) {
            return null;
        }
        return e.y;
    }
    
    public static f s() {
        if (e.y == null) {
            return null;
        }
        return r().z;
    }
    
    public static void a(final e y) {
        e.y = y;
    }
    
    public void a(final f z) {
        this.z = z;
    }
    
    public f t() {
        return this.z;
    }
}
