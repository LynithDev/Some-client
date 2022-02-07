package net.digitalingot.feather;

import java.io.*;
import org.jetbrains.annotations.*;
import javax.sound.sampled.*;
import java.util.*;

public class hz implements Closeable
{
    private static final AudioFormat zR;
    private static final AudioFormat zS;
    @Nullable
    private SourceDataLine zT;
    @Nullable
    private TargetDataLine zU;
    
    public hz(@Nullable final String s, @Nullable final String s2) {
        this.g(s, s2);
    }
    
    public void g(@Nullable String s, @Nullable String s2) {
        if (this.zT != null) {
            this.zT.close();
        }
        if (this.zU != null) {
            this.zU.close();
        }
        if (s != null && s.isEmpty()) {
            s = null;
        }
        if (s2 != null && s2.isEmpty()) {
            s2 = null;
        }
        this.zT = this.ar(s2);
        if (this.zT != null) {
            try {
                this.zT.open(hz.zS);
            }
            catch (LineUnavailableException ex) {
                kk.FT.error("Couldn't access speaker line", (Throwable)ex);
                this.zT = null;
            }
        }
        this.zU = this.aq(s);
        if (this.zU != null) {
            try {
                this.zU.open(hz.zR);
            }
            catch (LineUnavailableException ex2) {
                kk.FT.error("Couldn't access microphone line", (Throwable)ex2);
                this.zU = null;
            }
        }
    }
    
    @Nullable
    private TargetDataLine aq(@Nullable final String s) {
        if (s != null && !s.equals("Default")) {
            final TargetDataLine as = this.as(s);
            if (as != null) {
                return as;
            }
        }
        return this.f(TargetDataLine.class);
    }
    
    @Nullable
    private SourceDataLine ar(@Nullable final String s) {
        if (s != null && !s.equals("Default")) {
            final SourceDataLine at = this.at(s);
            if (at != null) {
                return at;
            }
        }
        return this.f(SourceDataLine.class);
    }
    
    @Nullable
    public <T> T f(final Class<T> clazz) {
        final DataLine.Info info = new DataLine.Info(clazz, null);
        try {
            return clazz.cast(AudioSystem.getLine(info));
        }
        catch (Exception ex) {
            return null;
        }
    }
    
    @Nullable
    public TargetDataLine as(final String s) {
        return this.a(TargetDataLine.class, s);
    }
    
    @Nullable
    public SourceDataLine at(final String s) {
        return this.a(SourceDataLine.class, s);
    }
    
    @Nullable
    private <T extends Line> T a(final Class<T> clazz, final String s) {
        for (final Mixer.Info info : AudioSystem.getMixerInfo()) {
            final Mixer mixer = AudioSystem.getMixer(info);
            final Line.Info info2 = new Line.Info(clazz);
            Label_0113: {
                if (mixer.isLineSupported(info2)) {
                    if (info.getName().equals(s)) {
                        Line line;
                        try {
                            line = mixer.getLine(info2);
                        }
                        catch (LineUnavailableException ex) {
                            break Label_0113;
                        }
                        if (clazz.isAssignableFrom(line.getClass())) {
                            return (T)line;
                        }
                    }
                }
            }
        }
        return null;
    }
    
    @Nullable
    public TargetDataLine jT() {
        return this.zU;
    }
    
    @Nullable
    public SourceDataLine jU() {
        return this.zT;
    }
    
    public static List<String> jV() {
        return g(TargetDataLine.class);
    }
    
    public static List<String> jW() {
        return g(SourceDataLine.class);
    }
    
    public static List<String> g(final Class<?> clazz) {
        final ArrayList<String> list = new ArrayList<String>();
        for (final Mixer.Info info : AudioSystem.getMixerInfo()) {
            if (AudioSystem.getMixer(info).isLineSupported(new Line.Info(clazz))) {
                list.add(info.getName());
            }
        }
        return list;
    }
    
    @Override
    public void close() {
        if (this.zT != null) {
            this.zT.close();
        }
        if (this.zU != null) {
            this.zU.close();
        }
    }
    
    static {
        zR = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, 24000.0f, 16, 1, 2, 24000.0f, false);
        zS = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, 24000.0f, 16, 2, 4, 24000.0f, false);
    }
}
