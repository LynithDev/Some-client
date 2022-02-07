package net.digitalingot.feather;

import org.jetbrains.annotations.*;
import net.minecraft.client.entity.*;
import net.minecraft.util.*;
import java.util.*;

public class gi extends gj
{
    public gi(@NotNull final i i, @NotNull final ir ir, @NotNull final fX fx) {
        super(i, fx, ir, a.LEADER);
    }
    
    @Override
    public void a(final EntityPlayerSP entityPlayerSP, final String[] array) {
        if (array.length == 0) {
            bn.a(entityPlayerSP, (IChatComponent)new ChatComponentTranslation("feather.commands.featherparty.remove.usage", new Object[0]));
            return;
        }
        final String s = array[0];
        final UUID h = this.F.h(s);
        if (this.qy.hS().lv().lr().contains(h)) {
            bn.a(entityPlayerSP, (IChatComponent)new ChatComponentTranslation("feather.commands.targetNotFound", new Object[0]));
            return;
        }
        this.qC.hP().q(h);
        bn.a(entityPlayerSP, (IChatComponent)new ChatComponentTranslation("feather.commands.featherparty.remove.success", new Object[] { s }));
    }
}
