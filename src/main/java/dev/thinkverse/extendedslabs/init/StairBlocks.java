package dev.thinkverse.extendedslabs.init;

import com.google.common.base.Preconditions;
import dev.thinkverse.extendedslabs.api.block.BlockList;
import dev.thinkverse.extendedslabs.blocks.BlockCustomStairs;
import dev.thinkverse.extendedslabs.blocks.grass.BlockGrassStairs;
import dev.thinkverse.extendedslabs.core.ExtendedSlabs;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(ExtendedSlabs.MODID)
public class StairBlocks {

    @Mod.EventBusSubscriber(modid = ExtendedSlabs.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class Register {
        @SubscribeEvent
        public static void RegisterStairBlocks(RegistryEvent.Register<Block> event) {
            final Block[] blocks = {
                BlockList.POLISHED_ANDESITE_STAIRS = new BlockCustomStairs(Blocks.ANDESITE.getDefaultState(), Block.Properties.from(Blocks.ANDESITE)).setRegistryName(ExtendedSlabs.location("polished_andesite_stairs")),
                BlockList.POLISHED_DIORITE_STAIRS = new BlockCustomStairs(Blocks.DIORITE.getDefaultState(), Block.Properties.from(Blocks.DIORITE)).setRegistryName(ExtendedSlabs.location("polished_diorite_stairs")),
                BlockList.POLISHED_GRANITE_STAIRS = new BlockCustomStairs(Blocks.GRANITE.getDefaultState(), Block.Properties.from(Blocks.GRANITE)).setRegistryName(ExtendedSlabs.location("polished_granite_stairs")),
                BlockList.ANDESITE_STAIRS = new BlockCustomStairs(Blocks.ANDESITE.getDefaultState(), Block.Properties.from(Blocks.ANDESITE)).setRegistryName(ExtendedSlabs.location("andesite_stairs")),
                BlockList.DIORITE_STAIRS = new BlockCustomStairs(Blocks.DIORITE.getDefaultState(), Block.Properties.from(Blocks.DIORITE)).setRegistryName(ExtendedSlabs.location("diorite_stairs")),
                BlockList.GRANITE_STAIRS = new BlockCustomStairs(Blocks.GRANITE.getDefaultState(), Block.Properties.from(Blocks.GRANITE)).setRegistryName(ExtendedSlabs.location("granite_stairs")),

                BlockList.MOSSY_COBBLESTONE_STAIRS = new BlockCustomStairs(Blocks.MOSSY_COBBLESTONE.getDefaultState(), Block.Properties.from(Blocks.MOSSY_COBBLESTONE)).setRegistryName(ExtendedSlabs.location("mossy_cobblestone_stairs")),
                BlockList.MOSSY_STONE_BRICKS_STAIRS = new BlockCustomStairs(Blocks.MOSSY_STONE_BRICKS.getDefaultState(), Block.Properties.from(Blocks.MOSSY_STONE_BRICKS)).setRegistryName(ExtendedSlabs.location("mossy_stone_bricks_stairs")),

                BlockList.CUT_SANDSTONE_STAIRS = new BlockCustomStairs(Blocks.CUT_SANDSTONE.getDefaultState(), Block.Properties.from(Blocks.CUT_SANDSTONE)).setRegistryName(ExtendedSlabs.location("cut_sandstone_stairs")),
                BlockList.SMOOTH_SANDSTONE_STAIRS = new BlockCustomStairs(Blocks.SMOOTH_SANDSTONE.getDefaultState(), Block.Properties.from(Blocks.SMOOTH_SANDSTONE)).setRegistryName(ExtendedSlabs.location("smooth_sandstone_stairs")),
                BlockList.CUT_RED_SANDSTONE_STAIRS = new BlockCustomStairs(Blocks.CUT_RED_SANDSTONE.getDefaultState(), Block.Properties.from(Blocks.CUT_RED_SANDSTONE)).setRegistryName(ExtendedSlabs.location("cut_red_sandstone_stairs")),
                BlockList.SMOOTH_RED_SANDSTONE_STAIRS = new BlockCustomStairs(Blocks.SMOOTH_RED_SANDSTONE.getDefaultState(), Block.Properties.from(Blocks.SMOOTH_RED_SANDSTONE)).setRegistryName(ExtendedSlabs.location("smooth_red_sandstone_stairs")),

                BlockList.SMOOTH_QUARTZ_STAIRS = new BlockCustomStairs(Blocks.SMOOTH_QUARTZ.getDefaultState(), Block.Properties.from(Blocks.SMOOTH_QUARTZ)).setRegistryName(ExtendedSlabs.location("smooth_quartz_stairs")),
                BlockList.RED_NETHER_BRICKS_STAIRS = new BlockCustomStairs(Blocks.RED_NETHER_BRICKS.getDefaultState(), Block.Properties.from(Blocks.RED_NETHER_BRICKS)).setRegistryName(ExtendedSlabs.location("red_nether_bricks_stairs")),

                BlockList.END_STONE_BRICKS_STAIRS = new BlockCustomStairs(Blocks.END_STONE_BRICKS.getDefaultState(), Block.Properties.from(Blocks.END_STONE_BRICKS)).setRegistryName(ExtendedSlabs.location("end_stone_bricks_stairs")),

                BlockList.STONE_STAIRS = new BlockGrassStairs(Blocks.STONE.getDefaultState(), Block.Properties.from(Blocks.STONE)).setRegistryName(ExtendedSlabs.location("stone_stairs")),
                BlockList.DIRT_STAIRS = new BlockGrassStairs(Blocks.DIRT.getDefaultState(), Block.Properties.from(Blocks.DIRT)).setRegistryName(ExtendedSlabs.location("dirt_stairs")),
                BlockList.GRASS_STAIRS = new BlockGrassStairs(Blocks.GRASS_BLOCK.getDefaultState(), Block.Properties.from(Blocks.GRASS_BLOCK)).setRegistryName(ExtendedSlabs.location("grass_stairs"))
            };

            for (final Block block: blocks) {
                Preconditions.checkNotNull(block.getRegistryName(), "Block: %s has a NULL registry name", block);

                event.getRegistry().register(block);
            }
        }

        @SubscribeEvent
        public static void RegisterStairItemBlocks(final RegistryEvent.Register<Item> event) {
            final ItemBlock[] items = {
                new ItemBlock(BlockList.POLISHED_ANDESITE_STAIRS, new Item.Properties().group(ExtendedSlabs.GROUP).maxStackSize(64)),
                new ItemBlock(BlockList.POLISHED_DIORITE_STAIRS, new Item.Properties().group(ExtendedSlabs.GROUP).maxStackSize(64)),
                new ItemBlock(BlockList.POLISHED_GRANITE_STAIRS, new Item.Properties().group(ExtendedSlabs.GROUP).maxStackSize(64)),
                new ItemBlock(BlockList.ANDESITE_STAIRS, new Item.Properties().group(ExtendedSlabs.GROUP).maxStackSize(64)),
                new ItemBlock(BlockList.DIORITE_STAIRS, new Item.Properties().group(ExtendedSlabs.GROUP).maxStackSize(64)),
                new ItemBlock(BlockList.GRANITE_STAIRS, new Item.Properties().group(ExtendedSlabs.GROUP).maxStackSize(64)),

                new ItemBlock(BlockList.MOSSY_COBBLESTONE_STAIRS, new Item.Properties().group(ExtendedSlabs.GROUP).maxStackSize(64)),
                new ItemBlock(BlockList.MOSSY_STONE_BRICKS_STAIRS, new Item.Properties().group(ExtendedSlabs.GROUP).maxStackSize(64)),

                new ItemBlock(BlockList.CUT_SANDSTONE_STAIRS, new Item.Properties().group(ExtendedSlabs.GROUP).maxStackSize(64)),
                new ItemBlock(BlockList.SMOOTH_SANDSTONE_STAIRS, new Item.Properties().group(ExtendedSlabs.GROUP).maxStackSize(64)),
                new ItemBlock(BlockList.CUT_RED_SANDSTONE_STAIRS, new Item.Properties().group(ExtendedSlabs.GROUP).maxStackSize(64)),
                new ItemBlock(BlockList.SMOOTH_RED_SANDSTONE_STAIRS, new Item.Properties().group(ExtendedSlabs.GROUP).maxStackSize(64)),

                new ItemBlock(BlockList.SMOOTH_QUARTZ_STAIRS, new Item.Properties().group(ExtendedSlabs.GROUP).maxStackSize(64)),
                new ItemBlock(BlockList.RED_NETHER_BRICKS_STAIRS, new Item.Properties().group(ExtendedSlabs.GROUP).maxStackSize(64)),

                new ItemBlock(BlockList.END_STONE_BRICKS_STAIRS, new Item.Properties().group(ExtendedSlabs.GROUP).maxStackSize(64)),

                new ItemBlock(BlockList.STONE_STAIRS, new Item.Properties().group(ExtendedSlabs.GROUP).maxStackSize(64)),
                new ItemBlock(BlockList.DIRT_STAIRS, new Item.Properties().group(ExtendedSlabs.GROUP).maxStackSize(64)),
                new ItemBlock(BlockList.GRASS_STAIRS, new Item.Properties().group(ExtendedSlabs.GROUP).maxStackSize(64))
            };

            for (final ItemBlock item: items) {
                final Block block = item.getBlock();
                final ResourceLocation registryname = Preconditions.checkNotNull(block.getRegistryName(), "BlockItem: %s has a NULL registry name", block);

                event.getRegistry().register(item.setRegistryName(registryname));
            }
        }
    }
}
