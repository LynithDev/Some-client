package net.digitalingot.feather;

import java.util.*;
import com.google.gson.annotations.*;
import org.jetbrains.annotations.*;

public class s
{
    @SerializedName("cosmetics")
    @NotNull
    private List<p> al;
    @SerializedName("emotes")
    @NotNull
    private List<t> am;
    
    @NotNull
    public List<p> af() {
        return this.al;
    }
    
    @NotNull
    public List<t> ag() {
        return this.am;
    }
}
