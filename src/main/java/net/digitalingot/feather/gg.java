package net.digitalingot.feather;

import org.jetbrains.annotations.*;
import net.minecraft.client.entity.*;
import net.minecraft.util.*;

public class gg extends gj
{
    public gg(@NotNull final i i, @NotNull final ir ir, @NotNull final fX fx) {
        super(i, fx, ir, a.IN_PARTY);
    }
    
    @Override
    public void a(final EntityPlayerSP entityPlayerSP, final String[] array) {
        this.qy.hS().b(null);
        this.qC.hP().mC();
        bn.a(entityPlayerSP, (IChatComponent)new ChatComponentTranslation("feather.commands.featherparty.leave.success", new Object[0]));
        this.qy.c(System.currentTimeMillis());
    }
}
