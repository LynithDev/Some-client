package net.digitalingot.feather;

import org.jetbrains.annotations.*;
import net.minecraft.client.entity.*;
import java.util.concurrent.*;
import net.minecraft.util.*;

public class gb extends gj
{
    private long qB;
    
    public gb(@NotNull final i i, @NotNull final ir ir, @NotNull final fX fx) {
        super(i, fx, ir, a.NOT_IN_PARTY);
        this.qB = -1L;
    }
    
    @Override
    public void a(final EntityPlayerSP entityPlayerSP, final String[] array) {
        if (System.currentTimeMillis() - this.qB < TimeUnit.SECONDS.toMillis(3L)) {
            return;
        }
        this.qB = System.currentTimeMillis();
        this.qC.hP().mB();
        bn.a(entityPlayerSP, (IChatComponent)new ChatComponentTranslation("feather.commands.featherparty.create.success", new Object[0]));
    }
}
