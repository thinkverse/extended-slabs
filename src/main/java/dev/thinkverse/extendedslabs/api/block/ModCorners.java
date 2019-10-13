package dev.thinkverse.extendedslabs.api.block;

import dev.thinkverse.extendedslabs.blocks.BlockCorners;
import dev.thinkverse.extendedslabs.core.ExtendedSlabs;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.LazyLoadBase;

import java.util.Locale;

public enum ModCorners {
    OAK(Blocks.OAK_STAIRS);

    public static final ModCorners[] VALUES = values();

    private final LazyLoadBase<Block> CornerBlock;
    private final LazyLoadBase<Item> Item;

    public final Block baseBlock;

    ModCorners(Block baseBlockIn) {
        this.baseBlock = baseBlockIn;

        CornerBlock = new LazyLoadBase<>(() -> new BlockCorners(Block.Properties.from(getBaseBlock())));
        Item = new LazyLoadBase<>(() -> new Item(new Item.Properties().group(ExtendedSlabs.GROUP)));
    }

    public Block getCornerBlock() { return CornerBlock.getValue(); }

    public Item getItem() { return Item.getValue(); }

    public String getName() { return name().toLowerCase(Locale.ROOT); }

    public Block getBaseBlock() { return this.baseBlock; }
}
