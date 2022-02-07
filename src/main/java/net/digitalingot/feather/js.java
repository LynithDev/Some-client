package net.digitalingot.feather;

public class js extends RuntimeException
{
    public js(final String s, final Throwable t) {
        super(s, t);
    }
    
    public js(final Throwable t) {
        super(t);
    }
}
