package net.digitalingot.feather;

import com.google.gson.*;
import java.util.*;
import com.google.gson.stream.*;
import com.google.gson.annotations.*;
import java.lang.reflect.*;

public final class cd<T extends Enum<T>> extends TypeAdapter<T>
{
    private final Map<String, T> ix;
    private final Map<T, String> iy;
    
    public cd(final Class<T> clazz) {
        this.ix = new HashMap<String, T>();
        this.iy = new HashMap<T, String>();
        for (final Enum<T> enum1 : clazz.getEnumConstants()) {
            final String a = a(clazz, (T)enum1);
            this.ix.put(a, (T)enum1);
            this.iy.put((T)enum1, a);
        }
    }
    
    public T e(final JsonReader jsonReader) {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        return this.ix.get(jsonReader.nextString());
    }
    
    public void a(final JsonWriter jsonWriter, final T t) {
        jsonWriter.value((t == null) ? null : this.iy.get(t));
    }
    
    private static <T> String a(final Class<T> clazz, final T t) {
        Field declaredField;
        try {
            declaredField = clazz.getDeclaredField(t.toString());
        }
        catch (NoSuchFieldException ex) {
            throw new IllegalStateException(ex);
        }
        final ei ei = declaredField.getDeclaredAnnotation(ei.class);
        if (ei != null) {
            return ei.fu();
        }
        final SerializedName serializedName = declaredField.getDeclaredAnnotation(SerializedName.class);
        if (serializedName != null) {
            return serializedName.value();
        }
        return t.toString();
    }
}
