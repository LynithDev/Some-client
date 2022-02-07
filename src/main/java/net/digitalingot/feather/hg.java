package net.digitalingot.feather;

import net.minecraft.item.*;

public class hg
{
    public static a j(final ItemStack itemStack) {
        final ItemFood itemFood = (ItemFood)itemStack.getItem();
        return new a(itemFood.getHealAmount(itemStack), itemFood.getSaturationModifier(itemStack));
    }
    
    public static a k(final ItemStack itemStack) {
        return j(itemStack);
    }
    
    public static class a
    {
        public final int yf;
        public final float yg;
        
        public a(final int yf, final float yg) {
            this.yf = yf;
            this.yg = yg;
        }
        
        public float je() {
            return this.yf * this.yg * 2.0f;
        }
    }
}
