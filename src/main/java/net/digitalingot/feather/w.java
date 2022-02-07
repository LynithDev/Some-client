package net.digitalingot.feather;

import com.google.gson.*;
import net.minecraft.util.*;
import java.io.*;
import com.google.gson.stream.*;

public class w extends TypeAdapter<ResourceLocation>
{
    public void a(final JsonWriter jsonWriter, final ResourceLocation resourceLocation) {
        throw new IOException("operation unsupported");
    }
    
    public ResourceLocation a(final JsonReader jsonReader) {
        return new ResourceLocation(jsonReader.nextString());
    }
}
