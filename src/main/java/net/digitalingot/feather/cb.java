package net.digitalingot.feather;

import com.google.gson.*;
import java.awt.*;
import com.google.gson.stream.*;
import org.jetbrains.annotations.*;

public class cb extends TypeAdapter<eT>
{
    public void a(final JsonWriter jsonWriter, final eT et) {
        if (et == null) {
            jsonWriter.nullValue();
            return;
        }
        final Color gs = et.gS();
        String s;
        if (gs.getAlpha() == 0) {
            s = String.format("#%02x%02x%02x", gs.getRed(), gs.getGreen(), gs.getBlue());
        }
        else {
            s = String.format("#%02x%02x%02x%02x", gs.getRed(), gs.getGreen(), gs.getBlue(), gs.getAlpha());
        }
        jsonWriter.beginObject();
        jsonWriter.name("chroma").value(et.gR());
        jsonWriter.name("color").value(s);
        jsonWriter.endObject();
    }
    
    public eT c(final JsonReader jsonReader) {
        jsonReader.beginObject();
        boolean nextBoolean = false;
        Color t = null;
        while (jsonReader.hasNext()) {
            final String nextName = jsonReader.nextName();
            switch (nextName) {
                case "chroma": {
                    nextBoolean = jsonReader.nextBoolean();
                    continue;
                }
                case "color": {
                    t = t(jsonReader.nextString());
                    continue;
                }
            }
        }
        jsonReader.endObject();
        return new eT(nextBoolean, t);
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
