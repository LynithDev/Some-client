package net.digitalingot.feather;

import org.jetbrains.annotations.*;
import net.minecraft.client.entity.*;
import net.minecraft.util.*;
import java.util.*;

public class gf extends gj
{
    public gf(@NotNull final i i, @NotNull final ir ir, @NotNull final fX fx) {
        super(i, fx, ir, a.LEADER);
    }
    
    @Override
    public void a(final EntityPlayerSP entityPlayerSP, final String[] array) {
        if (array.length == 0) {
            bn.a(entityPlayerSP, (IChatComponent)new ChatComponentTranslation("feather.commands.featherparty.leader.usage", new Object[0]));
            return;
        }
        final UUID h = this.F.h(array[0]);
        if (h == null) {
            bn.a(entityPlayerSP, (IChatComponent)new ChatComponentTranslation("feather.commands.targetNotFound", new Object[0]));
            return;
        }
        if (!this.qy.hS().lv().lr().contains(h)) {
            bn.a(entityPlayerSP, (IChatComponent)new ChatComponentTranslation("feather.commands.featherparty.targetNotInParty", new Object[0]));
            return;
        }
        this.qC.hP().o(h);
        bn.a(entityPlayerSP, (IChatComponent)new ChatComponentTranslation("feather.commands.featherparty.leader.success", new Object[] { array[0] }));
    }
}
