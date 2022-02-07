package net.digitalingot.feather;

import java.io.*;
import org.jetbrains.annotations.*;
import net.minecraft.util.*;
import net.minecraft.event.*;

public class hl
{
    static IChatComponent a(@NotNull final File file, @NotNull final hj.a a) {
        final ChatComponentText chatComponentText = new ChatComponentText("");
        final ChatComponentText chatComponentText2 = new ChatComponentText("Screenshot saved");
        ((IChatComponent)chatComponentText2).setChatStyle(((IChatComponent)chatComponentText2).getChatStyle().setUnderlined(Boolean.valueOf(true)));
        ((IChatComponent)chatComponentText).appendSibling((IChatComponent)chatComponentText2);
        if (a.yG) {
            final ChatComponentText chatComponentText3 = new ChatComponentText("[Open]");
            ((IChatComponent)chatComponentText3).setChatStyle(((IChatComponent)chatComponentText3).getChatStyle().setBold(Boolean.valueOf(true)).setColor(EnumChatFormatting.GOLD).setChatClickEvent(new ClickEvent(ClickEvent.Action.OPEN_FILE, file.getAbsolutePath())).setChatHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, (IChatComponent)new ChatComponentText("Open"))));
            ((IChatComponent)chatComponentText).appendSibling((IChatComponent)new ChatComponentText(" ")).appendSibling((IChatComponent)chatComponentText3);
        }
        if (a.yH) {
            final ChatComponentText chatComponentText4 = new ChatComponentText("[Copy]");
            ((IChatComponent)chatComponentText4).setChatStyle(((IChatComponent)chatComponentText4).getChatStyle().setBold(Boolean.valueOf(true)).setColor(EnumChatFormatting.BLUE).setChatClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/featherscreenshot copy " + file.getAbsolutePath())).setChatHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, (IChatComponent)new ChatComponentText("Copy"))));
            ((IChatComponent)chatComponentText).appendSibling((IChatComponent)new ChatComponentText(" ")).appendSibling((IChatComponent)chatComponentText4);
        }
        if (a.yI) {
            final ChatComponentText chatComponentText5 = new ChatComponentText("[Upload]");
            ((IChatComponent)chatComponentText5).setChatStyle(((IChatComponent)chatComponentText5).getChatStyle().setBold(Boolean.valueOf(true)).setColor(EnumChatFormatting.GREEN).setChatClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/featherscreenshot upload " + file.getAbsolutePath())).setChatHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, (IChatComponent)new ChatComponentText("Upload & Open"))));
            ((IChatComponent)chatComponentText).appendSibling((IChatComponent)new ChatComponentText(" ")).appendSibling((IChatComponent)chatComponentText5);
        }
        if (a.yJ) {
            final ChatComponentText chatComponentText6 = new ChatComponentText("[Tweet]");
            ((IChatComponent)chatComponentText6).setChatStyle(((IChatComponent)chatComponentText6).getChatStyle().setBold(Boolean.valueOf(true)).setColor(EnumChatFormatting.AQUA).setChatClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/featherscreenshot tweet " + file.getAbsolutePath())).setChatHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, (IChatComponent)new ChatComponentText("Upload & Tweet"))));
            ((IChatComponent)chatComponentText).appendSibling((IChatComponent)new ChatComponentText(" ")).appendSibling((IChatComponent)chatComponentText6);
        }
        return (IChatComponent)chatComponentText;
    }
}
