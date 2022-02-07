package net.digitalingot.feather;

import com.google.gson.*;
import java.awt.*;
import com.google.gson.stream.*;
import org.jetbrains.annotations.*;

public class cc extends TypeAdapter<Color>
{
    public void a(final JsonWriter jsonWriter, final Color color) {
        if (color == null) {
            jsonWriter.nullValue();
            return;
        }
        jsonWriter.beginObject();
        String s;
        if (color.getAlpha() == 0) {
            s = String.format("#%02x%02x%02x", color.getRed(), color.getGreen(), color.getBlue());
        }
        else {
            s = String.format("#%02x%02x%02x%02x", color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha());
        }
        jsonWriter.name("color").value(s);
        jsonWriter.name("chroma").value(false);
        jsonWriter.endObject();
    }
    
    public Color d(final JsonReader jsonReader) {
        jsonReader.beginObject();
        Color t = null;
        while (jsonReader.hasNext()) {
            final String nextName = jsonReader.nextName();
            if (nextName.equals("color")) {
                t = t(jsonReader.nextString());
            }
            else {
                if (!nextName.equals("chroma")) {
                    continue;
                }
                jsonReader.nextBoolean();
            }
        }
        jsonReader.endObject();
        return t;
    }
    
    private static Color t(@NotNull final String s) {
        final int intValue = Integer.valueOf(s.substring(1, 3), 16);
        final int intValue2 = Integer.valueOf(s.substring(3, 5), 16);
        final int intValue3 = Integer.valueOf(s.substring(5, 7), 16);
        if (s.length() > 7) {
            return new Color(intValue, intValue2, intValue3, Integer.valueOf(s.substring(7, 9), 16));
        }
        return new Color(intValue, intValue2, intValue3);
    }
}
