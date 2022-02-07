package net.digitalingot.feather;

import java.util.*;
import com.google.gson.*;

public class hb
{
    private final JsonObject yb;
    
    public hb(final JsonObject yb) {
        this.yb = yb;
    }
    
    public hb(final String s) {
        this(new JsonParser().parse(s).getAsJsonObject());
    }
    
    public hb() {
        this(new JsonObject());
    }
    
    public Object ab(final String s) {
        return this.yb.get(s);
    }
    
    public int ac(final String s) {
        return this.ah(s);
    }
    
    public long ad(final String s) {
        return this.ai(s);
    }
    
    public JsonObject jd() {
        return this.yb;
    }
    
    public String ae(final String s) {
        return this.aj(s);
    }
    
    public UUID h(final String s) {
        return this.ak(s);
    }
    
    public boolean af(final String s) {
        return this.yb.has(s);
    }
    
    public boolean c(final String s, final boolean b) {
        try {
            return this.yb.get(s).getAsBoolean();
        }
        catch (Exception ex) {
            return b;
        }
    }
    
    public boolean ag(final String s) {
        return this.c(s, false);
    }
    
    public int a(final String s, final int n) {
        try {
            return this.yb.get(s).getAsInt();
        }
        catch (Exception ex) {
            return n;
        }
    }
    
    public int ah(final String s) {
        return this.a(s, 0);
    }
    
    public long a(final String s, final long n) {
        try {
            return this.yb.get(s).getAsLong();
        }
        catch (Exception ex) {
            return n;
        }
    }
    
    public long ai(final String s) {
        return this.a(s, 0L);
    }
    
    public String e(final String s, final String s2) {
        try {
            return this.yb.get(s).getAsString();
        }
        catch (Exception ex) {
            return s2;
        }
    }
    
    public String aj(final String s) {
        return this.e(s, "");
    }
    
    private UUID ak(final String s) {
        return UUID.fromString(this.aj(s));
    }
    
    public hb d(final String s, final boolean b) {
        this.yb.addProperty(s, Boolean.valueOf(b));
        return this;
    }
    
    public hb f(final String s, final String s2) {
        this.yb.addProperty(s, s2);
        return this;
    }
    
    public hb b(final String s, final int n) {
        this.yb.addProperty(s, (Number)n);
        return this;
    }
    
    public hb a(final String s, final double n) {
        this.yb.addProperty(s, (Number)n);
        return this;
    }
    
    public hb b(final String s, final long n) {
        this.yb.addProperty(s, (Number)n);
        return this;
    }
    
    public hb a(final String s, final hb hb) {
        this.a(s, hb.yb);
        return this;
    }
    
    public void a(final String s, final JsonObject jsonObject) {
        this.yb.add(s, (JsonElement)jsonObject);
    }
    
    public void a(final String s, final JsonArray jsonArray) {
        this.yb.add(s, (JsonElement)jsonArray);
    }
    
    public hb a(final String s, final JsonElement jsonElement) {
        this.yb.add(s, jsonElement);
        return this;
    }
    
    public hb a(final String s, final Object o) {
        return this.f(s, o.toString());
    }
    
    public hb a(final String s, final Number n) {
        this.yb.add(s, (JsonElement)new JsonPrimitive(n));
        return this;
    }
    
    public void al(final String s) {
        this.yb.remove(s);
    }
    
    @Override
    public String toString() {
        return this.yb.toString();
    }
}
