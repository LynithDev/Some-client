package net.digitalingot.feather;

import org.jetbrains.annotations.*;
import net.minecraft.client.entity.*;
import net.minecraft.util.*;

public class gc extends gj
{
    protected gc(@NotNull final i i, @NotNull final ir ir, @NotNull final fX fx) {
        super(i, ir, fx);
    }
    
    @Override
    public void a(final EntityPlayerSP entityPlayerSP, final String[] array) {
        final ig t = this.qy.T((array.length == 0) ? null : array[0]);
        if (t == null) {
            bn.a(entityPlayerSP, (IChatComponent)new ChatComponentTranslation("feather.commands.featherparty.inviteNotFound", new Object[0]));
            return;
        }
        this.qC.hP().b(t.lw(), false);
        bn.a(entityPlayerSP, (IChatComponent)new ChatComponentTranslation("feather.commands.featherparty.deny.success", new Object[0]));
    }
}
