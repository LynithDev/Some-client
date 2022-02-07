package net.digitalingot.feather.mixin.client;

import org.spongepowered.asm.mixin.*;
import net.minecraft.util.*;
import com.google.common.collect.*;
import org.spongepowered.asm.mixin.injection.*;

@Mixin(value = { ClassInheritanceMultiMap.class }, targets = { "net.minecraft.util.ClassInheritanceMultiMap$1" })
public class ClassInheritanceMultiMapFix
{
    @Redirect(method = { "iterator()Ljava/util/Iterator;" }, at = @At(value = "INVOKE", target = "Lcom/google/common/collect/Iterators;emptyIterator()Lcom/google/common/collect/UnmodifiableIterator;", opcode = 184), remap = false)
    private <T> UnmodifiableIterator<T> ur() {
        return (UnmodifiableIterator<T>)ImmutableSet.of().iterator();
    }
}
