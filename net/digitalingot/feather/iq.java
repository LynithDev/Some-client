package net.digitalingot.feather;

import net.minecraft.client.*;
import java.util.function.*;
import net.minecraft.client.renderer.*;
import org.lwjgl.opengl.*;
import org.capnproto.*;
import net.minecraft.client.resources.*;
import java.util.*;

public class iq
{
    public static void a(final is is) {
        Minecraft.getMinecraft().addScheduledTask(() -> is.a(mt()));
    }
    
    private static Consumer<iE.f.e.a> mt() {
        return a -> {
            a(a);
            a.aH(Minecraft.getMinecraft().getVersion());
            b(a);
            c(a);
            d(a);
        };
    }
    
    private static void a(final iE.f.e.a a) {
        final Runtime runtime = Runtime.getRuntime();
        final String property = System.getProperty("os.name");
        final short n = (short)runtime.availableProcessors();
        final int j = j(runtime.maxMemory());
        final String cpu = OpenGlHelper.getCpu();
        final String string = GL11.glGetString(7936) + " " + GL11.glGetString(7937);
        final iE.f.e.c.a py = a.py();
        py.aI(property);
        py.c(n);
        py.aw(j);
        py.aJ(cpu);
        py.aK(string);
    }
    
    private static void b(final iE.f.e.a a) {
        final List<String> tq = ko.tQ();
        final TextList.Builder as = a.as(tq.size());
        for (int i = 0; i < tq.size(); ++i) {
            as.set(i++, new Text.Reader((String)tq.get(i)));
        }
    }
    
    private static void c(final iE.f.e.a a) {
        int n = 0;
        final List repositoryEntries = Minecraft.getMinecraft().getResourcePackRepository().getRepositoryEntries();
        final TextList.Builder at = a.at(repositoryEntries.size());
        final Iterator<ResourcePackRepository.Entry> iterator = repositoryEntries.iterator();
        while (iterator.hasNext()) {
            at.set(n, new Text.Reader(iterator.next().getResourcePackName()));
            ++n;
        }
    }
    
    private static void d(final iE.f.e.a a) {
        final ArrayList<dW> list = new ArrayList<dW>();
        for (final Map.Entry<dW, dQ<?>> entry : e.s().m().dL().entrySet()) {
            if (!entry.getValue().eS()) {
                continue;
            }
            list.add(entry.getKey());
        }
        final TextList.Builder au = a.au(list.size());
        for (int i = 0; i < list.size(); ++i) {
            au.set(i, new Text.Reader(((dW)list.get(i)).getSlug()));
        }
    }
    
    private static int j(final long n) {
        return (int)(n / 1024L / 1024L);
    }
}
