package dev.thinkverse.extendedslabs.api.block;

import dev.thinkverse.extendedslabs.blocks.BlockVerticalStairs;
import dev.thinkverse.extendedslabs.core.ExtendedSlabs;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.LazyLoadBase;

import java.util.Locale;

public enum ModVerticalStairs {

    ANDESITE(Blocks.ANDESITE);

    public static final ModVerticalStairs[] VALUES = values();

    private final LazyLoadBase<Block> VerticalStairs;
    private final LazyLoadBase<Item> Item;

    public final Block baseBlock;

    ModVerticalStairs(Block baseBlockIn) {
        this.baseBlock = baseBlockIn;

        VerticalStairs = new LazyLoadBase<>(() -> new BlockVerticalStairs(Block.Properties.from(getBaseBlock())));
        Item = new LazyLoadBase<>(() -> new Item(new Item.Properties().group(ExtendedSlabs.GROUP)));
    }

    public Block getVerticalStairs() { return VerticalStairs.getValue(); }

    public Item getItem() { return Item.getValue(); }

    public String getName() { return name().toLowerCase(Locale.ROOT); }

    public Block getBaseBlock() { return this.baseBlock; }

}
