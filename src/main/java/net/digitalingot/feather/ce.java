package net.digitalingot.feather;

import com.google.gson.reflect.*;
import com.google.gson.*;

public class ce implements TypeAdapterFactory
{
    public <T> TypeAdapter<T> create(final Gson gson, final TypeToken<T> typeToken) {
        Class<? super Enum> clazz = (Class<? super Enum>)typeToken.getRawType();
        if (!Enum.class.isAssignableFrom(clazz) || clazz == Enum.class) {
            return null;
        }
        if (!clazz.isEnum()) {
            clazz = clazz.getSuperclass();
        }
        return new cd<T>((Class<T>)clazz);
    }
}
