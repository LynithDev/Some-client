package net.digitalingot.feather;

import org.jetbrains.annotations.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.*;
import net.minecraft.item.*;
import net.minecraft.entity.player.*;
import net.minecraft.client.settings.*;
import net.minecraft.client.entity.*;
import net.minecraft.util.*;
import net.minecraft.enchantment.*;
import net.minecraft.entity.*;
import net.minecraft.world.biome.*;
import net.minecraft.inventory.*;
import net.minecraft.client.gui.*;
import net.digitalingot.feather.mixin.core.*;

public class bn
{
    public static int a(@NotNull final Gui gui) {
        return (int)((a)gui).getBlitOffset();
    }
    
    public static Entity a(@NotNull final RenderManager renderManager) {
        return renderManager.livingPlayer;
    }
    
    public static boolean a(@NotNull final Minecraft minecraft) {
        return minecraft.gameSettings.thirdPersonView != 0;
    }
    
    public static float b(@NotNull final Minecraft minecraft) {
        return minecraft.thePlayer.field_71109_bG;
    }
    
    public static float c(@NotNull final Minecraft minecraft) {
        return minecraft.thePlayer.field_70726_aT;
    }
    
    public static boolean a(@NotNull final ItemStack itemStack) {
        return itemStack.getItem() instanceof ItemFood;
    }
    
    public static boolean a(@NotNull final Item item) {
        return item instanceof ItemFood;
    }
    
    public static boolean a(@NotNull final EntityPlayer entityPlayer) {
        return entityPlayer.capabilities.isCreativeMode;
    }
    
    public static void d(@NotNull final Minecraft minecraft) {
        minecraft.updateDisplay();
    }
    
    public static void a(@NotNull final KeyBinding keyBinding, final int keyCode) {
        keyBinding.setKeyCode(keyCode);
    }
    
    public static boolean a(@NotNull final Entity entity) {
        return entity.onGround;
    }
    
    public static int a(@NotNull final KeyBinding keyBinding) {
        return keyBinding.getKeyCode();
    }
    
    public static boolean b(@NotNull final KeyBinding keyBinding) {
        return keyBinding.getKeyCode() < 0;
    }
    
    public static void a(@NotNull final EntityPlayerSP entityPlayerSP, final IChatComponent chatComponent) {
        entityPlayerSP.addChatMessage(chatComponent);
    }
    
    public static boolean e(@NotNull final Minecraft minecraft) {
        return minecraft.inGameHasFocus;
    }
    
    public static int a(@NotNull final Enchantment enchantment) {
        return enchantment.effectId;
    }
    
    public static double f(@NotNull final Minecraft minecraft) {
        return new ScaledResolution(minecraft).getScaledWidth();
    }
    
    public static int g(@NotNull final Minecraft minecraft) {
        return new ScaledResolution(minecraft).getScaledHeight();
    }
    
    public static double h(@NotNull final Minecraft minecraft) {
        return new ScaledResolution(minecraft).getScaleFactor();
    }
    
    public static int i(@NotNull final Minecraft minecraft) {
        return minecraft.displayWidth;
    }
    
    public static int j(@NotNull final Minecraft minecraft) {
        return minecraft.displayHeight;
    }
    
    public static int b(@NotNull final ItemStack itemStack) {
        return itemStack.stackSize;
    }
    
    public static ItemStack a(@NotNull final EntityLivingBase entityLivingBase) {
        return entityLivingBase.getHeldItem();
    }
    
    public static Entity b(@NotNull final Entity entity) {
        return entity.ridingEntity;
    }
    
    public static String a(@NotNull final BiomeGenBase biomeGenBase) {
        return biomeGenBase.biomeName;
    }
    
    public static Object b(@NotNull final EntityPlayer entityPlayer) {
        return entityPlayer.capabilities;
    }
    
    public static void a(@NotNull final Entity entity, final float rotationPitch) {
        entity.rotationPitch = rotationPitch;
    }
    
    public static float c(@NotNull final Entity entity) {
        return entity.rotationPitch;
    }
    
    public static void b(@NotNull final Entity entity, final float rotationYaw) {
        entity.rotationYaw = rotationYaw;
    }
    
    public static float d(@NotNull final Entity entity) {
        return entity.rotationYaw;
    }
    
    public static IInventory c(@NotNull final EntityPlayer entityPlayer) {
        return (IInventory)entityPlayer.inventory;
    }
    
    public static boolean c(final ItemStack itemStack) {
        return itemStack == null;
    }
    
    public static <T extends GuiButton> T a(@NotNull final GuiScreen guiScreen, final T t) {
        ((j)guiScreen).getRenderables().add(t);
        return t;
    }
}
