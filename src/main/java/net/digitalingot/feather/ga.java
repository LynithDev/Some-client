package net.digitalingot.feather;

import org.jetbrains.annotations.*;
import net.minecraft.client.entity.*;
import net.minecraft.util.*;

public class ga extends gj
{
    public ga(@NotNull final i i, @NotNull final ir ir, @NotNull final fX fx) {
        super(i, fx, ir, a.NOT_IN_PARTY);
    }
    
    @Override
    public void a(final EntityPlayerSP entityPlayerSP, final String[] array) {
        final ig t = this.qy.T((array.length == 0) ? null : array[0]);
        if (t == null) {
            bn.a(entityPlayerSP, (IChatComponent)new ChatComponentTranslation("feather.commands.featherparty.error.inviteNotFound", new Object[0]));
            return;
        }
        this.qC.hP().b(t.lw(), true);
        bn.a(entityPlayerSP, (IChatComponent)new ChatComponentTranslation("feather.commands.featherparty.accept.success", new Object[0]));
    }
}
