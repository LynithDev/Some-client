package net.digitalingot.feather;

import net.minecraft.client.*;
import java.io.*;
import org.cef.browser.*;
import org.cef.callback.*;
import org.cef.handler.*;
import org.cef.*;
import net.minecraft.client.gui.*;
import org.jetbrains.annotations.*;

public enum br implements an.a
{
    INSTANCE;
    
    private static final String URL;
    private final dT<fR> coreGetter;
    private Minecraft minecraft;
    private CefApp cefApp;
    private CefClient cefClient;
    private CefBrowser cefBrowser;
    private bq renderer;
    private CefMessageRouter messageRouter;
    private bs screen;
    private int tickCount;
    
    private br() {
        this.coreGetter = dU.a(fR.class);
        this.tickCount = 0;
    }
    
    private static String getUrl() {
        if (net.digitalingot.feather.c.isFeatherTest()) {
            if (System.getenv("FEATHER_LOCAL_TEST") != null) {
                return "http://127.0.0.1:4200/";
            }
            return "https://ig-client.feathermc.com/";
        }
        else {
            switch (br$7.cu[net.digitalingot.feather.a.b().ordinal()]) {
                case 1: {
                    return "https://ig-client.feathermc.com/";
                }
                case 2: {
                    return "https://dev.mc-webapp.feathermc.com/";
                }
                case 3: {
                    return "https://beta.mc-webapp.feathermc.com/";
                }
                default: {
                    return "https://mc-webapp.feathermc.com/";
                }
            }
        }
    }
    
    public void initialize() {
        this.minecraft = Minecraft.getMinecraft();
        this.initializeCef();
        this.registerEvents();
    }
    
    private void initializeCef() {
        Async.setImpl((Async.Impl)new Async.Impl() {
            public void invokeLater(final Runnable runnable) {
                br.this.minecraft.addScheduledTask(runnable);
            }
            
            public void invokeAndWait(final Runnable runnable) {
                if (br.this.minecraft.isCallingFromMinecraftThread()) {
                    runnable.run();
                }
                else {
                    br.this.minecraft.addScheduledTask(runnable).get();
                }
            }
        });
        if (!CefApp.startup((String[])null)) {
            throw new RuntimeException();
        }
        final CefSettings cefSettings = new CefSettings();
        cefSettings.windowless_rendering_enabled = true;
        cefSettings.cache_path = new File(net.digitalingot.feather.e.s().o(), "cef_cache").getAbsolutePath();
        cefSettings.locale = "en-US";
        if (net.digitalingot.feather.c.isFeatherTest()) {
            cefSettings.remote_debugging_port = 9222;
        }
        this.cefApp = CefApp.getInstance((String[])null, cefSettings);
        CefApp.addAppHandler((CefAppHandler)new CefAppHandlerAdapter(new String[] { "--external-message-pump", "--disable-threaded-scrolling=1", "--disable-features=TouchpadAndWheelScrollLatching,AsyncWheelEvents" }) {
            public void onScheduleMessagePumpWork(final long n) {
            }
        });
        (this.cefClient = this.cefApp.createClient()).addContextMenuHandler((CefContextMenuHandler)new CefContextMenuHandlerAdapter() {
            public void onBeforeContextMenu(final CefBrowser cefBrowser, final CefFrame cefFrame, final CefContextMenuParams cefContextMenuParams, final CefMenuModel cefMenuModel) {
                cefMenuModel.clear();
            }
        });
        this.cefClient.removeLifeSpanHandler();
        this.cefClient.addLifeSpanHandler((CefLifeSpanHandler)new CefLifeSpanHandlerAdapter() {
            public void onAfterCreated(final CefBrowser cefBrowser) {
                cefBrowser.setWindowlessFrameRate(144);
                super.onAfterCreated(cefBrowser);
            }
        });
        this.messageRouter = CefMessageRouter.create(new CefMessageRouter.CefMessageRouterConfig());
        this.cefClient.addMessageRouter(this.messageRouter);
        this.messageRouter.addHandler((CefMessageRouterHandler)new CefMessageRouterHandlerAdapter() {
            public boolean onQuery(final CefBrowser cefBrowser, final CefFrame cefFrame, final long n, final String s, final boolean b, final CefQueryCallback cefQueryCallback) {
                bS.s(s);
                return true;
            }
        }, true);
        this.renderer = new bq();
        (this.cefBrowser = this.cefClient.createBrowser(br.URL, true, true, (ICefRenderer)this.renderer, (ICefPlatform)new ICefPlatform() {})).createImmediately();
        this.screen = new bs(this.cefApp, this.cefBrowser, (ICefRenderer)this.renderer);
    }
    
    private void registerEvents() {
        an.bE.a(this);
        am.bD.a(() -> {
            if (this.isOpen()) {
                this.renderer.render();
            }
        });
    }
    
    public void show() {
        this.minecraft.displayGuiScreen((GuiScreen)this.screen);
        if (net.digitalingot.feather.e.s().m().b(fA.class).hr()) {
            eX.a(net.digitalingot.feather.e.s().m());
        }
    }
    
    @Override
    public void tick(@NotNull final an.c c) {
        if (c == an.c.END && this.cefBrowser != null && !(this.minecraft.currentScreen instanceof bs) && ++this.tickCount % 20 == 0) {
            this.screen.bq();
            this.cefApp.N_DoMessageLoopWork();
        }
    }
    
    public int getPreferredWidth() {
        final int mn = ip.mn();
        final fR fr = this.coreGetter.eZ();
        return (int)(mn * ((fr != null) ? fr.dI().pX.getScale() : 1.0f));
    }
    
    public int getPreferredHeight() {
        final int mo = ip.mo();
        final fR fr = this.coreGetter.eZ();
        return (int)(mo * ((fr != null) ? fr.dI().pX.getScale() : 1.0f));
    }
    
    public CefBrowser getCefBrowser() {
        return this.cefBrowser;
    }
    
    public bs getScreen() {
        return this.screen;
    }
    
    public boolean isOpen() {
        return this.minecraft != null && (this.minecraft.currentScreen instanceof bs || this.minecraft.currentScreen instanceof bz);
    }
    
    private static /* synthetic */ br[] $values() {
        return new br[] { br.INSTANCE };
    }
    
    static {
        $VALUES = $values();
        URL = getUrl();
    }
}
