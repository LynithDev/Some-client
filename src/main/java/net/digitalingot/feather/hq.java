package net.digitalingot.feather;

import org.jetbrains.annotations.*;
import javax.sound.sampled.*;
import java.util.*;

@dP(eL = dW.VOICE, eM = @dV(fh = "Voice", fi = "https://assets.feathercdn.net/game/mods/voice.svg", fj = "", fk = {}))
public class hq extends dQ<a>
{
    @Nullable
    private hu yW;
    
    @Override
    public void eN() {
        final fR fr = e.s().m().b(fR.class);
        if (fr.hL() == null) {
            return;
        }
        final k h = fr.hL().H();
        if (h.K() == null) {
            return;
        }
        final gm hk = fr.hK();
        if (hk == null) {
            return;
        }
        this.yW = hu.a(h, hk.ia().hS(), new hw(this), new hz(((a)this.jC).zd, ((a)this.jC).zg));
    }
    
    @Override
    public void eO() {
        if (this.yW != null) {
            this.yW.close();
            this.yW = null;
        }
    }
    
    @Override
    public void eP() {
        if (this.yW == null) {
            return;
        }
        final hC jc = this.yW.jC();
        if (jc != null) {
            final FloatControl jy = jc.jY();
            if (jy != null) {
                jy.setValue((float)(((a)this.jC).zi * 40.0 / 100.0 - 35.0));
            }
        }
        final hG jb = this.yW.jB();
        if (jb != null) {
            jb.kc();
        }
    }
    
    @Nullable
    public hu jm() {
        return this.yW;
    }
    
    @ef(fC = true)
    public static class a extends ea
    {
        @em(fS = 0)
        public eW mm;
        @er(fu = "receiveMode", fh = "Receive Mode", fW = "everyone", fm = @em(fS = 1))
        public hq.a.a yY;
        @em(fS = 10)
        public eW yZ;
        @er(fu = "keyProximityPTT", fh = "Proximity - Push to Talk", fW = "86", fm = @em(fS = 11))
        public bH za;
        @er(fu = "keyPartyPTT", fh = "Party - Push to Talk", fW = "80", fm = @em(fS = 12))
        public bH zb;
        @em(fS = 20)
        public eW zc;
        @er(fu = "microphone", fh = "Device", fW = "Default", fm = @em(fS = 21))
        @eh
        @ec(fu = "microphones")
        public String zd;
        @er(fu = "microphoneAmplification", fh = "Amplification", fW = "1.0", fm = @em(fS = 22))
        @eg
        public double ze;
        @em(fS = 30)
        public eW zf;
        @er(fu = "speaker", fh = "Device", fW = "Default", fm = @em(fS = 31))
        @eh
        @ec(fu = "speakers")
        public String zg;
        @er(fu = "speakerAmplification", fh = "Amplification", fW = "1.0", fm = @em(fS = 32))
        @eg
        public double zh;
        @er(fu = "maxVolume", fh = "Max Volume", fW = "80", fm = @em(fS = 33))
        @eg(fF = 10.0, fE = 100.0)
        public double zi;
        
        public a() {
            this.mm = new eW("General");
            this.yZ = new eW("Key Settings");
            this.zc = new eW("Capture");
            this.zf = new eW("Playback");
        }
        
        @ec(fu = "microphones")
        public static List<String> jn() {
            final ArrayList<Object> list = new ArrayList<Object>();
            list.add("Default");
            list.addAll(hz.jV());
            return (List<String>)list;
        }
        
        @ec(fu = "speakers")
        public static List<String> jo() {
            final ArrayList<Object> list = new ArrayList<Object>();
            list.add("Default");
            list.addAll(hz.jW());
            return (List<String>)list;
        }
        
        public enum a
        {
            @ei(fu = "everyone", fh = "Everyone")
            EVERYONE, 
            @ei(fu = "partyOnly", fh = "Party Only")
            PARTY_ONLY;
            
            public hT.a toCapnProto() {
                switch (hq$1.yX[this.ordinal()]) {
                    case 1: {
                        return hT.a.EVERYONE;
                    }
                    case 2: {
                        return hT.a.PARTY_ONLY;
                    }
                    default: {
                        throw new IllegalArgumentException();
                    }
                }
            }
            
            private static /* synthetic */ a[] $values() {
                return new a[] { a.EVERYONE, a.PARTY_ONLY };
            }
            
            static {
                $VALUES = $values();
            }
        }
    }
}
