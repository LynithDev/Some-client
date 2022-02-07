package net.digitalingot.feather;

import java.util.*;
import net.minecraftforge.fml.common.*;
import java.util.function.*;
import java.util.stream.*;

public class ko
{
    public static List<String> tQ() {
        return Loader.instance().getIndexedModList().values().stream().map((Function<? super Object, ?>)ModContainer::getModId).collect((Collector<? super Object, ?, List<String>>)Collectors.toList());
    }
}
