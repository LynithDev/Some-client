package net.digitalingot.feather;

import com.google.gson.*;
import org.apache.commons.io.*;
import org.apache.commons.codec.binary.*;
import java.nio.charset.*;
import java.net.*;
import java.io.*;
import java.util.*;

public class hm
{
    private static final String yK = "https://api.imgur.com/3/image";
    private static final Map<String, String> yL;
    
    public static String h(final File file) {
        final String s = hm.yL.get(file.getAbsolutePath());
        if (s != null) {
            return s;
        }
        final String replace = new JsonParser().parse(i(file)).getAsJsonObject().get("data").getAsJsonObject().get("link").getAsString().replace("i.imgur.com", "i.feathermc.com");
        hm.yL.put(file.getAbsolutePath(), replace);
        return replace;
    }
    
    private static String i(final File file) {
        HttpURLConnection ap = null;
        try {
            ap = ap("https://api.imgur.com/3/image");
            a(ap, "image=" + j(file));
            return a(ap);
        }
        catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        finally {
            if (ap != null) {
                ap.disconnect();
            }
        }
    }
    
    private static String j(final File file) {
        return URLEncoder.encode(new String(Base64.encodeBase64(FileUtils.readFileToByteArray(file)), StandardCharsets.US_ASCII), StandardCharsets.UTF_8.toString());
    }
    
    private static HttpURLConnection ap(final String s) {
        final HttpURLConnection httpURLConnection = (HttpURLConnection)new URL(s).openConnection();
        httpURLConnection.setDoInput(true);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty("Authorization", "Client-ID ecd202364b54dde");
        httpURLConnection.setReadTimeout(100000);
        httpURLConnection.connect();
        return httpURLConnection;
    }
    
    private static void a(final HttpURLConnection httpURLConnection, final String s) {
        final OutputStream outputStream = httpURLConnection.getOutputStream();
        try {
            final OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
            try {
                outputStreamWriter.write(s);
                outputStreamWriter.flush();
                outputStreamWriter.close();
            }
            catch (Throwable t) {
                try {
                    outputStreamWriter.close();
                }
                catch (Throwable t2) {
                    t.addSuppressed(t2);
                }
                throw t;
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }
        catch (Throwable t3) {
            if (outputStream != null) {
                try {
                    outputStream.close();
                }
                catch (Throwable t4) {
                    t3.addSuppressed(t4);
                }
            }
            throw t3;
        }
    }
    
    private static String a(final HttpURLConnection httpURLConnection) {
        return jt.d(httpURLConnection.getInputStream()).tk();
    }
    
    static {
        yL = new HashMap<String, String>();
    }
}
