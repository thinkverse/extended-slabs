package dev.thinkverse.extendedslabs.api.block;

import dev.thinkverse.extendedslabs.core.ExtendedSlabs;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SlabBlock;
import net.minecraft.item.Item;
import net.minecraft.util.LazyLoadBase;

import java.util.Locale;

public enum ModSlabs {

    DIRT(Blocks.DIRT);

    public static final ModSlabs[] VALUES = values();

    private final LazyLoadBase<Block> Slab;
    private final LazyLoadBase<Item> Item;

    public final Block baseBlock;

    ModSlabs(Block baseBlockIn) {
        this.baseBlock = baseBlockIn;

        Slab = new LazyLoadBase<>(() -> new SlabBlock(Block.Properties.from(getBaseBlock())));
        Item = new LazyLoadBase<>(() -> new Item(new Item.Properties().group(ExtendedSlabs.GROUP)));
    }

    public Block getSlab() { return Slab.getValue(); }

    public Item getItem() { return Item.getValue(); }

    public String getName() { return name().toLowerCase(Locale.ROOT); }

    public Block getBaseBlock() { return this.baseBlock; }

}
