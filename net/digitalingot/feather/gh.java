package net.digitalingot.feather;

import org.jetbrains.annotations.*;
import net.minecraft.client.entity.*;
import net.minecraft.util.*;

public class gh extends gj
{
    public gh(@NotNull final i i, @NotNull final ir ir, @NotNull final fX fx) {
        super(i, fx, ir, a.LEADER);
    }
    
    @Override
    public void a(final EntityPlayerSP entityPlayerSP, final String[] array) {
        if (array.length == 0) {
            bn.a(entityPlayerSP, (IChatComponent)new ChatComponentTranslation("feather.commands.featherparty.mode.usage", new Object[0]));
            return;
        }
        final String lowerCase = array[0].toLowerCase();
        int n = -1;
        switch (lowerCase.hashCode()) {
            case -1039745817: {
                if (lowerCase.equals("normal")) {
                    n = 0;
                    break;
                }
                break;
            }
            case 110: {
                if (lowerCase.equals("n")) {
                    n = 1;
                    break;
                }
                break;
            }
            case -490041217: {
                if (lowerCase.equals("proximity")) {
                    n = 2;
                    break;
                }
                break;
            }
            case 112: {
                if (lowerCase.equals("p")) {
                    n = 3;
                    break;
                }
                break;
            }
        }
        iF.b b = null;
        String s = null;
        switch (n) {
            case 0:
            case 1: {
                b = iF.b.EVERYONE;
                s = "feather.commands.featherparty.mode.successNormal";
                break;
            }
            case 2:
            case 3: {
                b = iF.b.PROXIMITY;
                s = "feather.commands.featherparty.mode.successProximity";
                break;
            }
            default: {
                bn.a(entityPlayerSP, (IChatComponent)new ChatComponentTranslation("feather.commands.featherparty.mode.usage", new Object[0]));
                return;
            }
        }
        this.qC.hP().a(b);
        bn.a(entityPlayerSP, (IChatComponent)new ChatComponentTranslation(s, new Object[0]));
    }
}
