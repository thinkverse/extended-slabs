package dev.thinkverse.verticalslabsmod.util;

import dev.thinkverse.verticalslabsmod.api.block.BlockList;
import dev.thinkverse.verticalslabsmod.core.VerticalSlabsMod;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class CreativeTab extends ItemGroup {
    public CreativeTab() { super(VerticalSlabsMod.MODID); }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(BlockList.VERTICAL_OAK_SLAB);
    }
}
