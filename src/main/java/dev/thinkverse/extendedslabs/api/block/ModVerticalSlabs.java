package dev.thinkverse.extendedslabs.api.block;

import dev.thinkverse.extendedslabs.blocks.BlockVerticalSlab;
import dev.thinkverse.extendedslabs.core.ExtendedSlabs;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.LazyLoadBase;

import java.util.Locale;

public enum ModVerticalSlabs {

    OAK(Blocks.OAK_SLAB),
    DARK_OAK(Blocks.DARK_OAK_SLAB),
    SPRUCE(Blocks.SPRUCE_SLAB),
    BIRCH(Blocks.BIRCH_SLAB),
    ACACIA(Blocks.ACACIA_SLAB),
    JUNGLE(Blocks.JUNGLE_SLAB),
    COBBLESTONE(Blocks.COBBLESTONE_SLAB),
    STONE_BRICKS(Blocks.STONE_BRICK_SLAB),
    SMOOTH_STONE(Blocks.STONE_SLAB),
    RED_SANDSTONE(Blocks.RED_SANDSTONE_SLAB),
    SANDSTONE(Blocks.SANDSTONE_SLAB),
    BRICKS(Blocks.BRICK_SLAB),
    NETHER_BRICKS(Blocks.NETHER_BRICK_SLAB),
    QUARTZ(Blocks.QUARTZ_SLAB),
    PURPUR(Blocks.PURPUR_SLAB),
    PRISMARINE_BRICKS(Blocks.PRISMARINE_BRICK_SLAB),
    DARK_PRISMARINE(Blocks.DARK_PRISMARINE_SLAB),
    PRISMARINE(Blocks.PRISMARINE_SLAB),
    ANDESITE(Blocks.ANDESITE),
    POLISHED_ANDESITE(Blocks.POLISHED_ANDESITE),
    GRANITE(Blocks.GRANITE),
    POLISHED_GRANITE(Blocks.POLISHED_GRANITE),
    DIORITE(Blocks.DIORITE),
    POLISHED_DIORITE(Blocks.POLISHED_DIORITE),
    DIRT(Blocks.DIRT),
    STONE(Blocks.STONE),
    MOSSY_COBBLESTONE(Blocks.MOSSY_COBBLESTONE),
    MOSSY_STONE_BRICKS(Blocks.MOSSY_STONE_BRICKS),
    SMOOTH_SANDSTONE(Blocks.SMOOTH_SANDSTONE),
    SMOOTH_RED_SANDSTONE(Blocks.SMOOTH_RED_SANDSTONE),
    SMOOTH_QUARTZ(Blocks.SMOOTH_QUARTZ),
    RED_NETHER_BRICKS(Blocks.RED_NETHER_BRICKS),
    END_STONE_BRICKS(Blocks.END_STONE_BRICKS),
    CUT_SANDSTONE(Blocks.CUT_SANDSTONE),
    CUT_RED_SANDSTONE(Blocks.CUT_RED_SANDSTONE);

    public static final ModVerticalSlabs[] VALUES = values();

    private final LazyLoadBase<Block> VerticalSlab;
    private final LazyLoadBase<Item> Item;

    public final Block baseBlock;

    ModVerticalSlabs(Block baseBlockIn) {
        this.baseBlock = baseBlockIn;

        VerticalSlab = new LazyLoadBase<>(() -> new BlockVerticalSlab(Block.Properties.from(getBaseBlock())));
        Item = new LazyLoadBase<>(() -> new Item(new Item.Properties().group(ExtendedSlabs.GROUP)));
    }

    public Block getVerticalSlab() { return VerticalSlab.getValue(); }

    public Item getItem() { return Item.getValue(); }

    public String getName() { return name().toLowerCase(Locale.ROOT); }

    public Block getBaseBlock() { return this.baseBlock; }

}
