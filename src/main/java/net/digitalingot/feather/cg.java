package net.digitalingot.feather;

import com.google.gson.*;
import com.google.gson.stream.*;
import java.util.*;

public class cg extends TypeAdapter<bH>
{
    public void a(final JsonWriter jsonWriter, final bH bh) {
        if (bh == null) {
            jsonWriter.nullValue();
            return;
        }
        jsonWriter.beginObject();
        jsonWriter.name("keys");
        jsonWriter.beginArray();
        final int[] cl = bh.cl();
        for (int length = cl.length, i = 0; i < length; ++i) {
            jsonWriter.value((long)bN.J(cl[i]).cr());
        }
        jsonWriter.endArray();
        jsonWriter.name("display").value(bh.getName());
        jsonWriter.endObject();
    }
    
    public bH g(final JsonReader jsonReader) {
        jsonReader.beginObject();
        final ArrayList<Object> list = new ArrayList<Object>();
        while (jsonReader.hasNext()) {
            if (jsonReader.nextName().equals("keys")) {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    list.add(bN.K(jsonReader.nextInt()).cq());
                }
                jsonReader.endArray();
            }
            else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return new bH(list.stream().mapToInt(n -> n).toArray());
    }
}
