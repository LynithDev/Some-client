package net.digitalingot.feather;

import org.jetbrains.annotations.*;
import net.minecraft.client.entity.*;
import net.minecraft.util.*;
import java.util.*;

public class gd extends gj
{
    public gd(@NotNull final i i, @NotNull final ir ir, @NotNull final fX fx) {
        super(i, fx, ir, a.IN_PARTY);
    }
    
    @Override
    public void a(final EntityPlayerSP entityPlayerSP, final String[] array) {
        final id lv = this.qy.hS().lv();
        final String a = this.F.a(lv.lq());
        final Map<UUID, String> a2 = this.F.a((UUID[])lv.lr().toArray(new UUID[0]));
        final ChatComponentTranslation chatComponentTranslation = new ChatComponentTranslation("feather.commands.featherparty.info.heading", new Object[0]);
        final ChatComponentTranslation chatComponentTranslation2 = new ChatComponentTranslation((lv.ls() == iF.b.EVERYONE) ? "feather.commands.featherparty.info.modeEveryone" : "feather.commands.featherparty.info.modeProximity", new Object[0]);
        final ChatComponentTranslation chatComponentTranslation3 = new ChatComponentTranslation("feather.commands.featherparty.info.owner", new Object[] { a });
        bn.a(entityPlayerSP, (IChatComponent)chatComponentTranslation);
        bn.a(entityPlayerSP, (IChatComponent)chatComponentTranslation2);
        bn.a(entityPlayerSP, (IChatComponent)chatComponentTranslation3);
        final Iterator<String> iterator = a2.values().iterator();
        while (iterator.hasNext()) {
            bn.a(entityPlayerSP, (IChatComponent)new ChatComponentTranslation("feather.commands.featherparty.info.member", new Object[] { iterator.next() }));
        }
    }
}
