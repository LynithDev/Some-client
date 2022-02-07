package net.digitalingot.feather;

import java.net.*;
import com.google.gson.*;
import java.nio.charset.*;
import java.io.*;

public class hc
{
    public static int b(final String s, final String s2, final String s3) {
        try {
            final HttpURLConnection httpURLConnection = (HttpURLConnection)new URL("https://sessionserver.mojang.com/session/minecraft/join").openConnection();
            try {
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                final JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("accessToken", s);
                jsonObject.addProperty("selectedProfile", s2);
                jsonObject.addProperty("serverId", s3);
                final byte[] bytes = jsonObject.toString().getBytes(StandardCharsets.UTF_8);
                httpURLConnection.setFixedLengthStreamingMode(bytes.length);
                httpURLConnection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
                httpURLConnection.connect();
                final OutputStream outputStream = httpURLConnection.getOutputStream();
                try {
                    outputStream.write(bytes);
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
                return httpURLConnection.getResponseCode();
            }
            finally {
                httpURLConnection.disconnect();
            }
        }
        catch (IOException ex) {
            return -1;
        }
    }
}
