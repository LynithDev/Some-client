package net.digitalingot.feather;

import io.netty.handler.codec.http.*;
import org.jetbrains.annotations.*;
import java.net.*;

public enum j
{
    AUTH_TOKEN(HttpMethod.GET, "/game/auth-token"), 
    SERVER_ID(HttpMethod.GET, "/minecraft/server-id"), 
    HAS_JOINED(HttpMethod.GET, "/minecraft/has-joined/{}?token={}"), 
    UPDATE_TOKEN(HttpMethod.GET, "/service/update-token"), 
    ACCOUNT_SEARCH(HttpMethod.POST, "/minecraft/account-search");
    
    private static final String BASE;
    @NotNull
    private final HttpMethod method;
    @NotNull
    private final String endpoint;
    
    private j(final HttpMethod method, final String endpoint) {
        this.method = method;
        this.endpoint = endpoint;
    }
    
    public URL get(final String... array) {
        String s = this.endpoint;
        for (int length = array.length, i = 0; i < length; ++i) {
            s = s.replaceFirst("\\{}", array[i]);
        }
        if (s.contains("{}")) {
            throw new IllegalArgumentException("not all variables required were delivered");
        }
        return new URL(j.BASE + s);
    }
    
    @NotNull
    public HttpMethod getMethod() {
        return this.method;
    }
    
    private static /* synthetic */ j[] $values() {
        return new j[] { j.AUTH_TOKEN, j.SERVER_ID, j.HAS_JOINED, j.UPDATE_TOKEN, j.ACCOUNT_SEARCH };
    }
    
    static {
        $VALUES = $values();
        BASE = jQ.h("FEATHER_API_URL", "https://api.feathermc.com/v1");
    }
}
