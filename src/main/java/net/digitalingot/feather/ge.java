package net.digitalingot.feather;

import org.jetbrains.annotations.*;
import net.minecraft.client.entity.*;
import net.minecraft.util.*;
import java.util.*;

public class ge extends gj
{
    public ge(@NotNull final i i, @NotNull final ir ir, @NotNull final fX fx) {
        super(i, fx, ir, a.LEADER);
    }
    
    @Override
    public void a(final EntityPlayerSP entityPlayerSP, final String[] array) {
        if (array.length == 0) {
            bn.a(entityPlayerSP, (IChatComponent)new ChatComponentTranslation("feather.commands.featherparty.invite.usage", new Object[0]));
            return;
        }
        final String s = array[0];
        final UUID h = this.F.h(s);
        if (h == null) {
            bn.a(entityPlayerSP, (IChatComponent)new ChatComponentTranslation("feather.commands.targetNotFound", new Object[0]));
            return;
        }
        this.qC.hP().p(h);
        bn.a(entityPlayerSP, (IChatComponent)new ChatComponentTranslation("feather.commands.featherparty.invite.success", new Object[] { s }));
    }
}
