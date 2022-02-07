package net.digitalingot.feather;

import net.minecraftforge.fml.common.*;
import net.minecraftforge.fml.relauncher.*;
import net.minecraft.client.*;
import net.minecraftforge.fml.common.event.*;

@Mod(modid = "feather", name = "Feather Client", version = "1.0.0-SNAPSHOT", clientSideOnly = true, acceptedMinecraftVersions = "[1.8.9]")
public class FeatherMod
{
    @Mod.EventHandler
    public void a(final FMLInitializationEvent fmlInitializationEvent) {
        if (fmlInitializationEvent.getSide() != Side.CLIENT) {
            return;
        }
        new c(Minecraft.getMinecraft()).a(fn.lU);
    }
    
    @Mod.EventHandler
    public void a(final FMLPostInitializationEvent fmlPostInitializationEvent) {
        if (fmlPostInitializationEvent.getSide() != Side.CLIENT) {
            return;
        }
        ad.bk.aH().registerCommands(null);
    }
}
