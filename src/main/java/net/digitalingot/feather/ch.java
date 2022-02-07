package net.digitalingot.feather;

import com.google.gson.*;
import com.google.gson.stream.*;

public class ch
{
    public static class a extends TypeAdapter<cL>
    {
        public void a(final JsonWriter jsonWriter, final cL cl) {
            jsonWriter.beginObject();
            jsonWriter.name("name").value(cl.getName());
            jsonWriter.name("slug").value(cl.getSlug());
            jsonWriter.name("icon").value(cl.getIcon());
            jsonWriter.endObject();
        }
        
        public cL h(final JsonReader jsonReader) {
            throw new UnsupportedOperationException("not implemented");
        }
    }
    
    public static class b extends TypeAdapter<cM>
    {
        public void a(final JsonWriter jsonWriter, final cM cm) {
            jsonWriter.beginObject();
            jsonWriter.name("name").value(cm.getName());
            jsonWriter.name("slug").value(cm.getSlug());
            jsonWriter.endObject();
        }
        
        public cM i(final JsonReader jsonReader) {
            throw new UnsupportedOperationException("not implemented");
        }
    }
    
    public static class c extends TypeAdapter<cN>
    {
        public void a(final JsonWriter jsonWriter, final cN cn) {
            jsonWriter.beginObject();
            jsonWriter.name("slug").value(cn.getSlug());
            jsonWriter.endObject();
        }
        
        public cN j(final JsonReader jsonReader) {
            return null;
        }
    }
}
