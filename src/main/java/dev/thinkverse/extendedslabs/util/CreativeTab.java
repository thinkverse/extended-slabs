package dev.thinkverse.extendedslabs.util;

import dev.thinkverse.extendedslabs.api.block.BlockList;
import dev.thinkverse.extendedslabs.core.ExtendedSlabs;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class CreativeTab extends ItemGroup {
    public CreativeTab() { super(ExtendedSlabs.MODID); }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(BlockList.VERTICAL_OAK_SLAB);
    }
}
