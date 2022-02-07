package net.digitalingot.feather;

import com.google.gson.*;
import java.util.*;
import com.google.gson.stream.*;

public class ca extends TypeAdapter<byte[]>
{
    public void a(final JsonWriter jsonWriter, final byte[] array) {
        if (array == null) {
            jsonWriter.nullValue();
            return;
        }
        jsonWriter.beginArray();
        for (int length = array.length, i = 0; i < length; ++i) {
            jsonWriter.value((long)(array[i] & 0xFF));
        }
        jsonWriter.endArray();
    }
    
    public byte[] b(final JsonReader jsonReader) {
        jsonReader.beginArray();
        final ArrayList<Byte> list = new ArrayList<Byte>();
        while (jsonReader.peek() == JsonToken.NUMBER) {
            list.add((byte)jsonReader.nextInt());
        }
        jsonReader.endArray();
        final byte[] array = new byte[list.size()];
        for (int i = 0; i < list.size(); ++i) {
            array[i] = (byte)list.get(i);
        }
        return array;
    }
}
