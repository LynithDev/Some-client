package net.digitalingot.feather;

import java.util.*;
import org.jetbrains.annotations.*;
import java.nio.charset.*;
import java.net.*;
import java.io.*;

public class hk extends h
{
    public hk() {
        super("featherscreenshot", Collections.emptyList());
    }
    
    @Override
    public void c(@NotNull final String[] p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: arraylength    
        //     2: iconst_2       
        //     3: if_icmpge       7
        //     6: return         
        //     7: aload_1        
        //     8: iconst_0       
        //     9: aaload         
        //    10: astore_2       
        //    11: new             Ljava/util/StringJoiner;
        //    14: dup            
        //    15: ldc             " "
        //    17: invokespecial   java/util/StringJoiner.<init>:(Ljava/lang/CharSequence;)V
        //    20: astore_3       
        //    21: iconst_1       
        //    22: istore          4
        //    24: iload           4
        //    26: aload_1        
        //    27: arraylength    
        //    28: if_icmpge       46
        //    31: aload_3        
        //    32: aload_1        
        //    33: iload           4
        //    35: aaload         
        //    36: invokevirtual   java/util/StringJoiner.add:(Ljava/lang/CharSequence;)Ljava/util/StringJoiner;
        //    39: pop            
        //    40: iinc            4, 1
        //    43: goto            24
        //    46: aload_3        
        //    47: invokevirtual   java/util/StringJoiner.toString:()Ljava/lang/String;
        //    50: astore          4
        //    52: new             Ljava/io/File;
        //    55: dup            
        //    56: aload           4
        //    58: invokespecial   java/io/File.<init>:(Ljava/lang/String;)V
        //    61: astore          5
        //    63: invokestatic    java/util/concurrent/ForkJoinPool.commonPool:()Ljava/util/concurrent/ForkJoinPool;
        //    66: aload_0        
        //    67: aload_2        
        //    68: aload           5
        //    70: invokedynamic   BootstrapMethod #0, run:(Lnet/digitalingot/feather/hk;Ljava/lang/String;Ljava/io/File;)Ljava/lang/Runnable;
        //    75: invokevirtual   java/util/concurrent/ForkJoinPool.execute:(Ljava/lang/Runnable;)V
        //    78: return         
        //    RuntimeInvisibleTypeAnnotations: 00 01 16 00 01 00 00 00 77 00 00
        //    StackMapTable: 00 03 07 FE 00 10 07 00 0D 07 00 19 01 FF 00 15 00 04 07 00 1D 00 07 00 0D 07 00 19 00 00
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Could not infer any expression.
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:374)
        //     at com.strobel.decompiler.ast.TypeAnalysis.run(TypeAnalysis.java:96)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:344)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at us.deathmarine.luyten.FileSaver.doSaveJarDecompiled(FileSaver.java:192)
        //     at us.deathmarine.luyten.FileSaver.access$300(FileSaver.java:45)
        //     at us.deathmarine.luyten.FileSaver$4.run(FileSaver.java:112)
        //     at java.lang.Thread.run(Thread.java:750)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    private String an(@NotNull final String s) {
        String encode;
        try {
            encode = URLEncoder.encode(s, StandardCharsets.UTF_8.toString());
        }
        catch (UnsupportedEncodingException ex) {
            throw new IllegalStateException(ex);
        }
        return "https://twitter.com/intent/tweet?text=Look%20at%20this%20screenshot%20I%20took!%0A" + encode + "%0A%0A%20%40Feather_Client&related=Feather_Client%3AFeather%20Client%20Published%20via&hashtags=minecraft";
    }
    
    private void ao(@NotNull final String s) {
        try {
            io.a(new URL(s).toURI());
        }
        catch (MalformedURLException ex) {}
        catch (URISyntaxException ex2) {}
    }
}
