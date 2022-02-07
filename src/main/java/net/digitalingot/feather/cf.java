package net.digitalingot.feather;

import com.google.gson.*;
import java.net.*;
import com.google.gson.stream.*;

public class cf extends TypeAdapter<InetSocketAddress>
{
    public void a(final JsonWriter jsonWriter, final InetSocketAddress inetSocketAddress) {
        if (inetSocketAddress == null) {
            jsonWriter.nullValue();
            return;
        }
        jsonWriter.value(inetSocketAddress.getAddress().getHostAddress() + ":" + inetSocketAddress.getPort());
    }
    
    public InetSocketAddress f(final JsonReader jsonReader) {
        final String[] split = jsonReader.nextString().split(":", 2);
        return new InetSocketAddress(split[0], Integer.parseInt(split[1]));
    }
}
