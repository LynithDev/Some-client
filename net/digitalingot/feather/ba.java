package net.digitalingot.feather;

import java.util.function.*;
import net.minecraft.client.*;
import net.minecraft.util.*;
import net.minecraft.client.settings.*;
import java.util.*;
import java.lang.reflect.*;
import org.jetbrains.annotations.*;

public class ba implements bW<cC, cD, ci>
{
    @Override
    public void a(final cC cc, final Consumer<cD> consumer, final Consumer<ci> consumer2) {
        final int[] array2;
        bH bh;
        final String s;
        br.INSTANCE.getScreen().a(array -> {
            Arrays.stream(array).mapToObj((IntFunction<?>)bN::J).mapToInt(bL::cr).toArray();
            if (Arrays.stream(array2).anyMatch(n -> n == 27)) {
                consumer.accept(new cD(new int[0], "None"));
            }
            else {
                bh = new bH(array);
                this.a(bh.cl());
                if (s != null) {
                    consumer2.accept(new ci(s));
                }
                else {
                    consumer.accept(new cD(array2, bh.getName()));
                }
            }
        });
    }
    
    @Nullable
    public String a(final int[] array) {
        final String b = this.b(array);
        if (b != null) {
            return b;
        }
        return this.c(array);
    }
    
    @Nullable
    private String b(final int[] array) {
        for (final KeyBinding keyBinding : Minecraft.getMinecraft().gameSettings.keyBindings) {
            int a = bn.a(keyBinding);
            if (a < 0) {
                a += 100101;
            }
            if (Arrays.stream(array).allMatch(n -> n == a)) {
                return new ChatComponentTranslation(keyBinding.getKeyDescription(), new Object[0]).func_150260_c();
            }
        }
        return null;
    }
    
    @Nullable
    private String c(final int[] array) {
        for (final Map.Entry<bH, String> entry : this.ba().entrySet()) {
            final bH bh = entry.getKey();
            final String s = entry.getValue();
            if (Arrays.equals(bh.cl(), array)) {
                return s;
            }
        }
        return null;
    }
    
    @NotNull
    private Map<bH, String> ba() {
        final HashMap<bH, String> hashMap = new HashMap<bH, String>();
        for (final dQ<ea> dq : e.s().m().dL().values()) {
            if (!dq.eS()) {
                continue;
            }
            final ea di = dq.dI();
            for (final Field field : di.getClass().getDeclaredFields()) {
                if (field.getType() == bH.class) {
                    final er er = field.getDeclaredAnnotation(er.class);
                    bH bh;
                    try {
                        bh = (bH)field.get(di);
                    }
                    catch (IllegalAccessException ex) {
                        throw new IllegalStateException(ex);
                    }
                    hashMap.put(bh, dq.eR().eM().fh() + ": " + er.fh());
                }
            }
        }
        return hashMap;
    }
    
    public interface a
    {
        void respond(final int[] p0);
    }
}
