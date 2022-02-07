package net.digitalingot.feather;

import java.text.*;
import java.time.*;
import com.google.gson.*;
import java.util.*;
import java.util.concurrent.*;

@dP(eL = dW.TIME_CHANGER, eM = @dV(fh = "Time Changer", fi = "https://assets.feathercdn.net/game/mods/timechanger.svg", fj = "Change the time locally", fk = {}))
public class hp extends dQ<a>
{
    private static final int yP = 21000;
    private boolean yQ;
    private long yR;
    private long yS;
    private int yT;
    
    public hp() {
        this.yR = 21600L;
        this.yS = 64800L;
    }
    
    @Override
    public void initialize() {
        if (((a)this.jC).yV) {
            ForkJoinPool.commonPool().execute(this::jj);
        }
    }
    
    @Override
    public void eP() {
        this.yT = 21000 - (int)(((a)this.jC).yU / 100.0f * 21000.0f);
        if (((a)this.jC).yV && !this.yQ) {
            ForkJoinPool.commonPool().execute(this::jj);
        }
    }
    
    public void jj() {
        if (this.yQ) {
            return;
        }
        this.yQ = true;
        try {
            final ho jg = ho.jg();
            final JsonObject asJsonObject = new JsonParser().parse(jt.aM("http://api.sunrise-sunset.org/json?lat=" + jg.jh() + "&lng=" + jg.ji() + "&formatted=0").tk()).getAsJsonObject().get("results").getAsJsonObject();
            final Calendar instance = Calendar.getInstance();
            instance.set(11, 0);
            instance.set(12, 0);
            instance.set(13, 0);
            final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ssX");
            final Date parse = simpleDateFormat.parse(asJsonObject.get("sunrise").getAsString());
            final Date parse2 = simpleDateFormat.parse(asJsonObject.get("sunset").getAsString());
            this.yR = LocalTime.ofInstant(parse.toInstant(), ZoneId.systemDefault()).toSecondOfDay();
            this.yS = LocalTime.ofInstant(parse2.toInstant(), ZoneId.systemDefault()).toSecondOfDay();
        }
        catch (Exception ex) {
            kk.FT.info("Failed to fetch sunrise & sunset time for TimeChanger", (Throwable)ex);
        }
    }
    
    public long jk() {
        return ((a)this.jC).yV ? this.jl() : this.yT;
    }
    
    public long jl() {
        final long n = LocalTime.now().toSecondOfDay();
        long n2;
        if (n < this.yR) {
            n2 = (long)(18000.0 + n * (6000.0 / this.yR));
        }
        else if (n < this.yS) {
            n2 = (long)(0.0 + (n - this.yR) * (12000.0 / Math.abs(this.yS - this.yR)));
        }
        else {
            n2 = (long)(12000.0 + (n - this.yS) * (6000.0 / (TimeUnit.DAYS.toSeconds(1L) - this.yS)));
        }
        return n2;
    }
    
    public static class a extends ea
    {
        @er(fu = "percentage", fh = "", fW = "100", fm = @em(fS = 1))
        @el(fQ = 0, fP = 100)
        public int yU;
        @er(fu = "useRealWorldTime", fh = "Use Real World Time", fW = "false", fm = @em(fS = 3))
        public boolean yV;
    }
}
