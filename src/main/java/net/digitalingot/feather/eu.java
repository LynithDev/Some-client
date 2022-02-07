package net.digitalingot.feather;

import java.util.*;
import org.apache.commons.lang3.*;
import org.jetbrains.annotations.*;
import java.lang.reflect.*;

public class eu<T>
{
    @NotNull
    private final Class<T> lw;
    
    public eu(@NotNull final Class<T> lw) {
        this.lw = lw;
    }
    
    @NotNull
    public List<et> go() {
        final ArrayList<et> list = new ArrayList<et>();
        final Field[] fields = this.lw.getFields();
        for (int length = fields.length, i = 0; i < length; ++i) {
            final et a = this.a(fields[i]);
            if (a != null) {
                list.add(a);
            }
        }
        return list;
    }
    
    @Nullable
    private et a(final Field field) {
        final er er = field.getDeclaredAnnotation(er.class);
        if (er == null) {
            return null;
        }
        final ee ee = field.getDeclaredAnnotation(ee.class);
        if (ee != null && !ClassUtils.isAssignable((Class)field.getType(), (Class)Collection.class, true)) {
            throw new IllegalStateException("@Checkbox applied on a non-Collection field");
        }
        final eq eq = field.getDeclaredAnnotation(eq.class);
        if (eq != null && !ClassUtils.isAssignable((Class)field.getType(), (Class)String.class, true)) {
            throw new IllegalStateException("@TextLength applied on a non-String field");
        }
        final eg eg = field.getDeclaredAnnotation(eg.class);
        if (eg != null && !ClassUtils.isAssignable((Class)field.getType(), (Class)Double.TYPE, true)) {
            throw new IllegalStateException("@DoubleRange applied on non-double field");
        }
        final el el = field.getDeclaredAnnotation(el.class);
        if (el != null && !ClassUtils.isAssignable((Class)field.getType(), (Class)Integer.TYPE, true)) {
            throw new IllegalStateException("@IntegerRange applied on non-integer field");
        }
        final eo eo = field.getDeclaredAnnotation(eo.class);
        final eo eo2 = this.lw.getDeclaredAnnotation(eo.class);
        ep ep = null;
        if (eo2 != null) {
            for (final ep ep2 : eo2.fU()) {
                if (ep2.fV().equals(er.fu())) {
                    ep = ep2;
                    break;
                }
            }
        }
        final ec ec = field.getDeclaredAnnotation(ec.class);
        es es;
        if (ec != null) {
            final Method a = this.a(ec);
            if (a == null) {
                throw new IllegalStateException("No matching @AllowedValues found for value = \"" + ec.fu() + "\" in class " + this.lw.getName());
            }
            es = new es(ec, ClassUtils.primitiveToWrapper((Class)field.getType()), a);
        }
        else {
            es = null;
        }
        final eh eh = field.getDeclaredAnnotation(eh.class);
        if (eh != null) {
            if (ClassUtils.isAssignable((Class)field.getType(), (Class)String.class, true)) {
                if (es == null) {
                    throw new IllegalStateException("@Dropdown applied on String field without @AllowedValues");
                }
            }
            else if (!ClassUtils.isAssignable((Class)field.getType(), (Class)Enum.class, true)) {
                throw new IllegalStateException("@Dropdown applied on non-enum or non-String field");
            }
        }
        return new et(field, er, ee, eh, eq, eg, el, ep, eo, es);
    }
    
    @Nullable
    private Method a(@NotNull final ec ec) {
        final String fu = ec.fu();
        for (final Method method : this.lw.getMethods()) {
            final ec ec2 = method.getDeclaredAnnotation(ec.class);
            if (ec2 != null) {
                if (Modifier.isStatic(method.getModifiers())) {
                    if (ec2.fu().equals(fu)) {
                        return method;
                    }
                }
            }
        }
        return null;
    }
}
