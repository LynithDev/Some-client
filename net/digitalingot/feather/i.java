package net.digitalingot.feather;

import com.google.gson.*;
import org.jetbrains.annotations.*;
import java.util.*;
import net.minecraft.client.*;
import com.mojang.authlib.exceptions.*;
import com.mojang.authlib.minecraft.*;
import net.minecraft.util.*;
import javax.net.ssl.*;
import java.net.*;
import java.nio.charset.*;
import java.io.*;

public class i implements Closeable
{
    @NotNull
    public static final Gson GSON;
    @NotNull
    private final k C;
    @NotNull
    private final Map<UUID, String> D;
    @NotNull
    private final Map<String, UUID> E;
    
    public i() {
        this.D = new HashMap<UUID, String>();
        this.E = new TreeMap<String, UUID>(String.CASE_INSENSITIVE_ORDER);
        this.C = new k(this);
        this.F();
    }
    
    @Nullable
    public String a(@NotNull final UUID uuid) {
        return this.a(new UUID[] { uuid }).values().stream().findAny().orElse(null);
    }
    
    @NotNull
    public Map<UUID, String> a(@NotNull final UUID... array) {
        final ArrayList<UUID> list = new ArrayList<UUID>();
        final HashMap<UUID, String> hashMap = new HashMap<UUID, String>(array.length);
        for (final UUID uuid : array) {
            final String s = this.D.get(uuid);
            if (s != null) {
                hashMap.put(uuid, s);
            }
            else {
                list.add(uuid);
            }
        }
        if (!list.isEmpty()) {
            final m m = new m(null, list, null);
            n n;
            try {
                n = this.a(n.class, j.ACCOUNT_SEARCH, m, new String[0]);
            }
            catch (IOException ex) {
                kk.FT.error("Error while making an account search request", (Throwable)ex);
                return new HashMap<UUID, String>();
            }
            for (final n.a a : n.Q()) {
                this.a(a);
                hashMap.put(a.S(), a.T());
            }
        }
        return hashMap;
    }
    
    @Nullable
    public UUID h(@NotNull final String s) {
        return this.d(s).values().stream().findAny().orElse(null);
    }
    
    @NotNull
    public Map<String, UUID> d(@NotNull final String... array) {
        final ArrayList<String> list = new ArrayList<String>();
        final HashMap<String, UUID> hashMap = new HashMap<String, UUID>(array.length);
        for (final String s : array) {
            final UUID uuid = this.E.get(s);
            if (uuid != null) {
                hashMap.put(s, uuid);
            }
            else {
                list.add(s);
            }
        }
        if (!list.isEmpty()) {
            final m m = new m(null, null, list);
            n n;
            try {
                n = this.a(n.class, j.ACCOUNT_SEARCH, m, new String[0]);
            }
            catch (IOException ex) {
                kk.FT.error("Error while making an account search request", (Throwable)ex);
                return new HashMap<String, UUID>();
            }
            for (final n.a a : n.Q()) {
                this.a(a);
                hashMap.put(a.T(), a.S());
            }
        }
        return hashMap;
    }
    
    private void a(@NotNull final n.a a) {
        this.D.put(a.S(), a.T());
        this.E.put(a.T(), a.S());
    }
    
    void D() {
        this.a(o.class, j.UPDATE_TOKEN, new String[0]);
    }
    
    @NotNull
    String E() {
        return this.a(String.class, j.AUTH_TOKEN, new String[0]);
    }
    
    public void F() {
        final Minecraft minecraft = Minecraft.getMinecraft();
        final MinecraftSessionService sessionService = minecraft.getSessionService();
        if (sessionService == null) {
            throw new l("session service not available");
        }
        final Session session = minecraft.getSession();
        if (session == null) {
            throw new l("session not available");
        }
        boolean b = false;
        for (int i = 0; i < 2; ++i) {
            final String s = this.a(String.class, j.SERVER_ID, new String[0]);
            try {
                sessionService.joinServer(session.getProfile(), session.getToken(), s);
            }
            catch (AuthenticationException ex) {
                throw new l((Throwable)ex);
            }
            if (this.a(j.HAS_JOINED, new String[] { session.getUsername(), s }).contains("mcUsername")) {
                b = true;
                break;
            }
        }
        if (!b) {
            throw new l("Failed to authenticate with core backend");
        }
        if (a.b() != cA.a.IDE) {
            this.G();
        }
        kk.FT.info("Authenticated with core backend");
    }
    
    void G() {
        try {
            final HttpsURLConnection httpsURLConnection = (HttpsURLConnection)new URL("https://wl.feathermc.com/whitelist_status").openConnection();
            httpsURLConnection.setRequestMethod("GET");
            httpsURLConnection.setRequestProperty("User-Agent", "Feather Client");
            httpsURLConnection.setRequestProperty("Authorization", this.C.K());
            httpsURLConnection.connect();
            final InputStreamReader inputStreamReader = new InputStreamReader(httpsURLConnection.getInputStream());
            try {
                final BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                try {
                    if (!Boolean.parseBoolean(bufferedReader.readLine())) {
                        Minecraft.getMinecraft().shutdown();
                    }
                    bufferedReader.close();
                }
                catch (Throwable t) {
                    try {
                        bufferedReader.close();
                    }
                    catch (Throwable t2) {
                        t.addSuppressed(t2);
                    }
                    throw t;
                }
                inputStreamReader.close();
            }
            catch (Throwable t3) {
                try {
                    inputStreamReader.close();
                }
                catch (Throwable t4) {
                    t3.addSuppressed(t4);
                }
                throw t3;
            }
        }
        catch (Exception ex) {
            Minecraft.getMinecraft().shutdown();
        }
    }
    
    @NotNull
    private <T> T a(@NotNull final Class<T> clazz, @NotNull final j j, @NotNull final String... array) {
        return this.a(clazz, j, (Object)null, array);
    }
    
    @NotNull
    private <T> T a(@NotNull final Class<T> clazz, @NotNull final j j, @Nullable final Object o, @NotNull final String... array) {
        return (T)i.GSON.fromJson(this.a(j, o, array), (Class)clazz);
    }
    
    @NotNull
    private String a(@NotNull final j j, @NotNull final String... array) {
        return this.a(j, (Object)null, array);
    }
    
    @NotNull
    private String a(@NotNull final j j, @Nullable final Object o, @NotNull final String... array) {
        final HttpsURLConnection httpsURLConnection = (HttpsURLConnection)j.get(array).openConnection();
        httpsURLConnection.setRequestMethod(j.getMethod().name());
        httpsURLConnection.setRequestProperty("User-Agent", "Feather Client");
        if (j != j.SERVER_ID && j != j.HAS_JOINED) {
            final String i = this.C.J();
            if (i != null) {
                httpsURLConnection.setRequestProperty("Authorization", i);
            }
        }
        httpsURLConnection.connect();
        if (o != null) {
            final String json = i.GSON.toJson(o);
            httpsURLConnection.setDoOutput(true);
            httpsURLConnection.setRequestProperty("Content-Type", "application/json");
            final OutputStream outputStream = httpsURLConnection.getOutputStream();
            try {
                outputStream.write(json.getBytes(StandardCharsets.UTF_8));
                outputStream.flush();
                if (outputStream != null) {
                    outputStream.close();
                }
            }
            catch (Throwable t) {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    }
                    catch (Throwable t2) {
                        t.addSuppressed(t2);
                    }
                }
                throw t;
            }
        }
        final String headerField = httpsURLConnection.getHeaderField("Authorization");
        if (headerField != null) {
            this.C.i(headerField);
        }
        return jt.d(httpsURLConnection.getInputStream()).tk();
    }
    
    @Override
    public void close() {
        this.C.close();
    }
    
    @NotNull
    public k H() {
        return this.C;
    }
    
    static {
        GSON = new Gson();
    }
}
