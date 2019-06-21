package dev.thinkverse.extendedslabs.api.block;

import dev.thinkverse.extendedslabs.blocks.BlockCustomStairs;
import dev.thinkverse.extendedslabs.blocks.BlockVerticalSlab;
import dev.thinkverse.extendedslabs.core.ExtendedSlabs;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.LazyLoadBase;

import java.util.Locale;

public enum ModStairs {

    DIRT(Blocks.DIRT),
    STONE(Blocks.STONE),
    ANDESITE(Blocks.ANDESITE),
    POLISHED_ANDESITE(Blocks.POLISHED_ANDESITE),
    GRANITE(Blocks.GRANITE),
    POLISHED_GRANITE(Blocks.POLISHED_GRANITE),
    DIORITE(Blocks.DIORITE),
    POLISHED_DIORITE(Blocks.POLISHED_DIORITE),
    MOSSY_COBBLESTONE(Blocks.MOSSY_COBBLESTONE),
    MOSSY_STONE_BRICKS(Blocks.MOSSY_STONE_BRICKS),
    SMOOTH_SANDSTONE(Blocks.SMOOTH_SANDSTONE),
    SMOOTH_RED_SANDSTONE(Blocks.SMOOTH_RED_SANDSTONE),
    SMOOTH_QUARTZ(Blocks.SMOOTH_QUARTZ),
    RED_NETHER_BRICKS(Blocks.RED_NETHER_BRICKS),
    END_STONE_BRICKS(Blocks.END_STONE_BRICKS),
    CUT_SANDSTONE(Blocks.CUT_SANDSTONE),
    CUT_RED_SANDSTONE(Blocks.CUT_RED_SANDSTONE);

    public static final ModStairs[] VALUES = values();

    private final LazyLoadBase<Block> Stairs;
    private final LazyLoadBase<Item> Item;

    public final Block baseBlock;

    ModStairs(Block baseBlockIn) {
        this.baseBlock = baseBlockIn;

        Stairs = new LazyLoadBase<>(() -> new BlockCustomStairs(getBaseBlock().getDefaultState(), Block.Properties.from(getBaseBlock())));
        Item = new LazyLoadBase<>(() -> new Item(new Item.Properties().group(ExtendedSlabs.GROUP)));
    }

    public Block getStairs() { return Stairs.getValue(); }

    public Item getItem() { return Item.getValue(); }

    public String getName() { return name().toLowerCase(Locale.ROOT); }

    public Block getBaseBlock() { return this.baseBlock; }

}
