package net.digitalingot.feather;

import java.time.*;
import de.jcm.discordgamesdk.*;
import java.util.concurrent.*;
import java.io.*;
import net.minecraft.client.*;
import org.jetbrains.annotations.*;
import de.jcm.discordgamesdk.activity.*;
import net.minecraft.entity.player.*;
import net.minecraft.client.network.*;

@dP(eL = dW.DISCORD, eM = @dV(fh = "Discord", fi = "https://assets.feathercdn.net/game/mods/discord.svg", fj = "Share your current status on Discord", fk = {}))
public class fu extends dQ<a>
{
    private final Executor mT;
    private final Instant mU;
    private CreateParams mV;
    private Core mW;
    private long mX;
    
    public fu() {
        this.mT = Executors.newSingleThreadExecutor();
        this.mU = Instant.now();
    }
    
    @Override
    public void initialize() {
        final String s;
        final String[] array;
        final int length;
        int i = 0;
        File file;
        this.mT.execute(() -> {
            System.getProperty("java.library.path");
            s.split("[;:]");
            length = array.length;
            while (i < length) {
                file = new File(array[i], "discord_game_sdk.dll");
                if (file.exists()) {
                    Core.init(file);
                    return;
                }
                else {
                    ++i;
                }
            }
            kk.FT.error("Couldn't find discord api path! Tried those paths: " + s);
            return;
        });
        final long mx;
        an.bE.a(c -> {
            if (!this.eS()) {
                return;
            }
            else if (c != an.c.START) {
                return;
            }
            else if (this.mW == null) {
                return;
            }
            else {
                this.mT.execute(() -> this.mW.runCallbacks());
                if (this.hc()) {
                    Instant.now().getEpochSecond();
                    if (mx - this.mX > 1L) {
                        this.mX = mx;
                        this.hd();
                    }
                }
                return;
            }
        });
        String serverIP;
        ab.bq.a((p0, p1) -> {
            if (!this.eS()) {
                return;
            }
            else {
                if (this.hc()) {
                    this.hd();
                }
                else if (Minecraft.getMinecraft().getCurrentServerData() != null) {
                    if (!Minecraft.getMinecraft().isConnectedToRealms()) {
                        serverIP = Minecraft.getMinecraft().getCurrentServerData().serverIP;
                    }
                    else {
                        serverIP = "Realms";
                    }
                    this.b("Multiplayer", serverIP);
                }
                else {
                    this.b("Singleplayer", ((a)this.jC).mY ? this.he() : null);
                }
                return;
            }
        });
        ab.br.a((p0, p1) -> {
            if (!(!this.eS())) {
                this.b("Main Menu", null);
            }
        });
    }
    
    @Override
    public void eN() {
        this.mT.execute(() -> {
            (this.mV = new CreateParams()).setClientID(903733444876582983L);
            this.mV.setFlags(new CreateParams.Flags[] { CreateParams.Flags.NO_REQUIRE_DISCORD });
            this.mW = new Core(this.mV);
            this.hb();
        });
    }
    
    private void hb() {
        if (!this.eS()) {
            return;
        }
        if (this.hc()) {
            this.hd();
        }
        else if (Minecraft.getMinecraft().isSingleplayer()) {
            this.b("Singleplayer", ((a)this.jC).mY ? this.he() : null);
        }
        else if (Minecraft.getMinecraft().getCurrentServerData() != null) {
            String serverIP;
            if (((a)this.jC).mZ) {
                if (!Minecraft.getMinecraft().isConnectedToRealms()) {
                    serverIP = Minecraft.getMinecraft().getCurrentServerData().serverIP;
                }
                else {
                    serverIP = "Realms";
                }
            }
            else {
                serverIP = null;
            }
            this.b("Multiplayer", serverIP);
        }
        else {
            this.b("Main Menu", null);
        }
    }
    
    private boolean hc() {
        return ((a)this.jC).na && jJ.tD();
    }
    
    private void hd() {
        this.b("Hypixel", aP.aO().getDisplayName());
    }
    
    private void b(@NotNull final String state, @Nullable final String details) {
        if (this.mW == null) {
            return;
        }
        Activity activity;
        this.mT.execute(() -> {
            if (this.mW != null) {
                activity = new Activity();
                try {
                    activity.setType(ActivityType.PLAYING);
                    activity.setState(state);
                    if (details != null) {
                        activity.setDetails(details);
                    }
                    activity.timestamps().setStart(this.mU);
                    activity.assets().setLargeImage("app_icon");
                    activity.assets().setLargeText("Feather Client");
                    this.mW.activityManager().updateActivity(activity);
                    activity.close();
                }
                catch (Throwable t) {
                    try {
                        activity.close();
                    }
                    catch (Throwable t2) {
                        t.addSuppressed(t2);
                    }
                    throw t;
                }
            }
        });
    }
    
    private String he() {
        return Minecraft.getMinecraft().getIntegratedServer().func_71221_J();
    }
    
    @Override
    public void eO() {
        try {
            if (this.mV != null) {
                this.mV.close();
            }
            if (this.mW != null) {
                this.mW.close();
            }
        }
        catch (Exception ex) {
            kk.FT.error("Error closing Discord RPC", (Throwable)ex);
        }
    }
    
    @ef(fC = true)
    public static class a extends ea
    {
        @er(fu = "showWorld", fh = "Show Singleplayer World", fW = "true", fm = @em(fS = 0))
        public boolean mY;
        @er(fu = "showServer", fh = "Show Server", fW = "true", fm = @em(fS = 1))
        public boolean mZ;
        @er(fu = "hypixelGamemode", fh = "Show Hypixel Gamemodes", fW = "true", fm = @em(fS = 3))
        public boolean na;
    }
}
