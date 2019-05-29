package dev.thinkverse.verticalslabsmod.util;

import dev.thinkverse.verticalslabsmod.VerticalSlabsMod;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class CreativeTab extends ItemGroup {
    public CreativeTab() { super(VerticalSlabsMod.MODID); }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(Blocks.CHEST);
    }
}
