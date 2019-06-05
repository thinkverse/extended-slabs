package dev.thinkverse.verticalslabsmod.init;

import com.google.common.base.Preconditions;
import dev.thinkverse.verticalslabsmod.api.block.BlockList;
import dev.thinkverse.verticalslabsmod.blocks.BlockVerticalSlab;
import dev.thinkverse.verticalslabsmod.blocks.grass.BlockVerticalGrassSlab;
import dev.thinkverse.verticalslabsmod.core.VerticalSlabsMod;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(VerticalSlabsMod.MODID)
public class VerticalBlocks {

    @Mod.EventBusSubscriber(modid = VerticalSlabsMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class Register {
        @SubscribeEvent
        public static void RegisterVerticalBlocks(RegistryEvent.Register<Block> event) {
            final Block[] blocks = {
                BlockList.VERTICAL_DARK_OAK_SLAB = new BlockVerticalSlab(Block.Properties.from(Blocks.DARK_OAK_SLAB)).setRegistryName(VerticalSlabsMod.location("vertical_dark_oak_slab")),
                BlockList.VERTICAL_SPRUCE_SLAB = new BlockVerticalSlab(Block.Properties.from(Blocks.SPRUCE_SLAB)).setRegistryName(VerticalSlabsMod.location("vertical_spruce_slab")),
                BlockList.VERTICAL_ACACIA_SLAB = new BlockVerticalSlab(Block.Properties.from(Blocks.ACACIA_SLAB)).setRegistryName(VerticalSlabsMod.location("vertical_acacia_slab")),
                BlockList.VERTICAL_JUNGLE_SLAB = new BlockVerticalSlab(Block.Properties.from(Blocks.JUNGLE_SLAB)).setRegistryName(VerticalSlabsMod.location("vertical_jungle_slab")),
                BlockList.VERTICAL_BIRCH_SLAB = new BlockVerticalSlab(Block.Properties.from(Blocks.BIRCH_SLAB)).setRegistryName(VerticalSlabsMod.location("vertical_birch_slab")),
                BlockList.VERTICAL_OAK_SLAB = new BlockVerticalSlab(Block.Properties.from(Blocks.OAK_SLAB)).setRegistryName(VerticalSlabsMod.location("vertical_oak_slab")),

                BlockList.VERTICAL_GRASS_SLAB = new BlockVerticalGrassSlab(Block.Properties.from(Blocks.GRASS_BLOCK)).setRegistryName(VerticalSlabsMod.location("vertical_grass_slab")),

                BlockList.VERTICAL_COBBLESTONE_SLAB = new BlockVerticalSlab(Block.Properties.from(Blocks.COBBLESTONE_SLAB)).setRegistryName(VerticalSlabsMod.location("vertical_cobblestone_slab")),
                BlockList.VERTICAL_STONE_BRICKS_SLAB = new BlockVerticalSlab(Block.Properties.from(Blocks.STONE_BRICK_SLAB)).setRegistryName(VerticalSlabsMod.location("vertical_stone_bricks_slab")),
                BlockList.VERTICAL_SMOOTH_STONE_SLAB = new BlockVerticalSlab(Block.Properties.from(Blocks.STONE_SLAB)).setRegistryName(VerticalSlabsMod.location("vertical_smooth_stone_slab")),

                BlockList.VERTICAL_RED_SANDSTONE_SLAB = new BlockVerticalSlab(Block.Properties.from(Blocks.RED_SANDSTONE_SLAB)).setRegistryName(VerticalSlabsMod.location("vertical_red_sandstone_slab")),
                BlockList.VERTICAL_SANDSTONE_SLAB = new BlockVerticalSlab(Block.Properties.from(Blocks.SANDSTONE_SLAB)).setRegistryName(VerticalSlabsMod.location("vertical_sandstone_slab")),

                BlockList.VERTICAL_BRICKS_SLAB = new BlockVerticalSlab(Block.Properties.from(Blocks.BRICK_SLAB)).setRegistryName(VerticalSlabsMod.location("vertical_bricks_slab")),

                BlockList.VERTICAL_NETHER_BRICKS_SLAB = new BlockVerticalSlab(Block.Properties.from(Blocks.NETHER_BRICK_SLAB)).setRegistryName(VerticalSlabsMod.location("vertical_nether_bricks_slab")),
                BlockList.VERTICAL_QUARTZ_SLAB = new BlockVerticalSlab(Block.Properties.from(Blocks.QUARTZ_SLAB)).setRegistryName(VerticalSlabsMod.location("vertical_quartz_slab")),

                BlockList.VERTICAL_PURPUR_SLAB = new BlockVerticalSlab(Block.Properties.from(Blocks.PURPUR_SLAB)).setRegistryName(VerticalSlabsMod.location("vertical_purpur_slab")),

                BlockList.VERTICAL_PRISMARINE_BRICKS_SLAB = new BlockVerticalSlab(Block.Properties.from(Blocks.PRISMARINE_BRICK_SLAB)).setRegistryName(VerticalSlabsMod.location("vertical_prismarine_bricks_slab")),
                BlockList.VERTICAL_DARK_PRISMARINE_SLAB = new BlockVerticalSlab(Block.Properties.from(Blocks.DARK_PRISMARINE_SLAB)).setRegistryName(VerticalSlabsMod.location("vertical_dark_prismarine_slab")),
                BlockList.VERTICAL_PRISMARINE_SLAB = new BlockVerticalSlab(Block.Properties.from(Blocks.PRISMARINE_SLAB)).setRegistryName(VerticalSlabsMod.location("vertical_prismarine_slab")),

                BlockList.VERTICAL_ANDESITE_SLAB = new BlockVerticalSlab(Block.Properties.from(Blocks.ANDESITE)).setRegistryName(VerticalSlabsMod.location("vertical_andesite_slab")),
                BlockList.VERTICAL_POLISHED_ANDESITE_SLAB = new BlockVerticalSlab(Block.Properties.from(Blocks.ANDESITE)).setRegistryName(VerticalSlabsMod.location("vertical_polished_andesite_slab")),
                BlockList.VERTICAL_GRANITE_SLAB = new BlockVerticalSlab(Block.Properties.from(Blocks.GRANITE)).setRegistryName(VerticalSlabsMod.location("vertical_granite_slab")),
                BlockList.VERTICAL_POLISHED_GRANITE_SLAB = new BlockVerticalSlab(Block.Properties.from(Blocks.GRANITE)).setRegistryName(VerticalSlabsMod.location("vertical_polished_granite_slab")),
                BlockList.VERTICAL_DIORITE_SLAB = new BlockVerticalSlab(Block.Properties.from(Blocks.DIORITE)).setRegistryName(VerticalSlabsMod.location("vertical_diorite_slab")),
                BlockList.VERTICAL_POLISHED_DIORITE_SLAB = new BlockVerticalSlab(Block.Properties.from(Blocks.DIORITE)).setRegistryName(VerticalSlabsMod.location("vertical_polished_diorite_slab")),
                BlockList.VERTICAL_DIRT_SLAB = new BlockVerticalSlab(Block.Properties.from(Blocks.DIRT)).setRegistryName(VerticalSlabsMod.location("vertical_dirt_slab")),
                BlockList.VERTICAL_STONE_SLAB = new BlockVerticalSlab(Block.Properties.from(Blocks.STONE)).setRegistryName(VerticalSlabsMod.location("vertical_stone_slab")),
                BlockList.VERTICAL_MOSSY_COBBLESTONE_SLAB = new BlockVerticalSlab(Block.Properties.from(Blocks.MOSSY_COBBLESTONE)).setRegistryName(VerticalSlabsMod.location("vertical_mossy_cobblestone_slab")),
                BlockList.VERTICAL_MOSSY_STONE_BRICKS_SLAB = new BlockVerticalSlab(Block.Properties.from(Blocks.MOSSY_STONE_BRICKS)).setRegistryName(VerticalSlabsMod.location("vertical_mossy_stone_bricks_slab")),
                BlockList.VERTICAL_SMOOTH_SANDSTONE_SLAB = new BlockVerticalSlab(Block.Properties.from(Blocks.SMOOTH_SANDSTONE)).setRegistryName(VerticalSlabsMod.location("vertical_smooth_sandstone_slab")),
                BlockList.VERTICAL_SMOOTH_RED_SANDSTONE_SLAB = new BlockVerticalSlab(Block.Properties.from(Blocks.SMOOTH_RED_SANDSTONE)).setRegistryName(VerticalSlabsMod.location("vertical_smooth_red_sandstone_slab")),
                BlockList.VERTICAL_SMOOTH_QUARTZ_SLAB = new BlockVerticalSlab(Block.Properties.from(Blocks.SMOOTH_QUARTZ)).setRegistryName(VerticalSlabsMod.location("vertical_smooth_quartz_slab")),
                BlockList.VERTICAL_RED_NETHER_BRICKS_SLAB = new BlockVerticalSlab(Block.Properties.from(Blocks.RED_NETHER_BRICKS)).setRegistryName(VerticalSlabsMod.location("vertical_red_nether_bricks_slab")),
                BlockList.VERTICAL_END_STONE_BRICKS_SLAB = new BlockVerticalSlab(Block.Properties.from(Blocks.END_STONE_BRICKS)).setRegistryName(VerticalSlabsMod.location("vertical_end_stone_bricks_slab")),
                BlockList.VERTICAL_CUT_SANDSTONE_SLAB = new BlockVerticalSlab(Block.Properties.from(Blocks.CUT_SANDSTONE)).setRegistryName(VerticalSlabsMod.location("vertical_cut_sandstone_slab")),
                BlockList.VERTICAL_CUT_RED_SANDSTONE_SLAB = new BlockVerticalSlab(Block.Properties.from(Blocks.CUT_RED_SANDSTONE)).setRegistryName(VerticalSlabsMod.location("vertical_cut_red_sandstone_slab"))
            };

            for (final Block block: blocks) {
                Preconditions.checkNotNull(block.getRegistryName(), "Block: %s has a NULL registry name", block);

                event.getRegistry().register(block);
            }
        }

        @SubscribeEvent
        public static void RegisterVerticalItemBlocks(final RegistryEvent.Register<Item> event) {
            final ItemBlock[] items = {
                new ItemBlock(BlockList.VERTICAL_DARK_OAK_SLAB, new Item.Properties().group(VerticalSlabsMod.GROUP).maxStackSize(64)),
                new ItemBlock(BlockList.VERTICAL_SPRUCE_SLAB, new Item.Properties().group(VerticalSlabsMod.GROUP).maxStackSize(64)),
                new ItemBlock(BlockList.VERTICAL_ACACIA_SLAB, new Item.Properties().group(VerticalSlabsMod.GROUP).maxStackSize(64)),
                new ItemBlock(BlockList.VERTICAL_JUNGLE_SLAB, new Item.Properties().group(VerticalSlabsMod.GROUP).maxStackSize(64)),
                new ItemBlock(BlockList.VERTICAL_BIRCH_SLAB, new Item.Properties().group(VerticalSlabsMod.GROUP).maxStackSize(64)),
                new ItemBlock(BlockList.VERTICAL_OAK_SLAB, new Item.Properties().group(VerticalSlabsMod.GROUP).maxStackSize(64)),

                new ItemBlock(BlockList.VERTICAL_GRASS_SLAB, new Item.Properties().group(VerticalSlabsMod.GROUP).maxStackSize(64)),

                new ItemBlock(BlockList.VERTICAL_COBBLESTONE_SLAB, new Item.Properties().group(VerticalSlabsMod.GROUP).maxStackSize(64)),
                new ItemBlock(BlockList.VERTICAL_STONE_BRICKS_SLAB, new Item.Properties().group(VerticalSlabsMod.GROUP).maxStackSize(64)),
                new ItemBlock(BlockList.VERTICAL_SMOOTH_STONE_SLAB, new Item.Properties().group(VerticalSlabsMod.GROUP).maxStackSize(64)),

                new ItemBlock(BlockList.VERTICAL_RED_SANDSTONE_SLAB, new Item.Properties().group(VerticalSlabsMod.GROUP).maxStackSize(64)),
                new ItemBlock(BlockList.VERTICAL_SANDSTONE_SLAB, new Item.Properties().group(VerticalSlabsMod.GROUP).maxStackSize(64)),

                new ItemBlock(BlockList.VERTICAL_BRICKS_SLAB, new Item.Properties().group(VerticalSlabsMod.GROUP).maxStackSize(64)),

                new ItemBlock(BlockList.VERTICAL_NETHER_BRICKS_SLAB, new Item.Properties().group(VerticalSlabsMod.GROUP).maxStackSize(64)),
                new ItemBlock(BlockList.VERTICAL_QUARTZ_SLAB, new Item.Properties().group(VerticalSlabsMod.GROUP).maxStackSize(64)),

                new ItemBlock(BlockList.VERTICAL_PURPUR_SLAB, new Item.Properties().group(VerticalSlabsMod.GROUP).maxStackSize(64)),

                new ItemBlock(BlockList.VERTICAL_PRISMARINE_BRICKS_SLAB, new Item.Properties().group(VerticalSlabsMod.GROUP).maxStackSize(64)),
                new ItemBlock(BlockList.VERTICAL_DARK_PRISMARINE_SLAB, new Item.Properties().group(VerticalSlabsMod.GROUP).maxStackSize(64)),
                new ItemBlock(BlockList.VERTICAL_PRISMARINE_SLAB, new Item.Properties().group(VerticalSlabsMod.GROUP).maxStackSize(64)),

                new ItemBlock(BlockList.VERTICAL_ANDESITE_SLAB, new Item.Properties().group(VerticalSlabsMod.GROUP).maxStackSize(64)),
                new ItemBlock(BlockList.VERTICAL_POLISHED_ANDESITE_SLAB, new Item.Properties().group(VerticalSlabsMod.GROUP).maxStackSize(64)),
                new ItemBlock(BlockList.VERTICAL_GRANITE_SLAB, new Item.Properties().group(VerticalSlabsMod.GROUP).maxStackSize(64)),
                new ItemBlock(BlockList.VERTICAL_POLISHED_GRANITE_SLAB, new Item.Properties().group(VerticalSlabsMod.GROUP).maxStackSize(64)),
                new ItemBlock(BlockList.VERTICAL_DIORITE_SLAB, new Item.Properties().group(VerticalSlabsMod.GROUP).maxStackSize(64)),
                new ItemBlock(BlockList.VERTICAL_POLISHED_DIORITE_SLAB, new Item.Properties().group(VerticalSlabsMod.GROUP).maxStackSize(64)),
                new ItemBlock(BlockList.VERTICAL_DIRT_SLAB, new Item.Properties().group(VerticalSlabsMod.GROUP).maxStackSize(64)),
                new ItemBlock(BlockList.VERTICAL_STONE_SLAB, new Item.Properties().group(VerticalSlabsMod.GROUP).maxStackSize(64)),
                new ItemBlock(BlockList.VERTICAL_MOSSY_COBBLESTONE_SLAB, new Item.Properties().group(VerticalSlabsMod.GROUP).maxStackSize(64)),
                new ItemBlock(BlockList.VERTICAL_MOSSY_STONE_BRICKS_SLAB, new Item.Properties().group(VerticalSlabsMod.GROUP).maxStackSize(64)),
                new ItemBlock(BlockList.VERTICAL_SMOOTH_SANDSTONE_SLAB, new Item.Properties().group(VerticalSlabsMod.GROUP).maxStackSize(64)),
                new ItemBlock(BlockList.VERTICAL_SMOOTH_RED_SANDSTONE_SLAB, new Item.Properties().group(VerticalSlabsMod.GROUP).maxStackSize(64)),
                new ItemBlock(BlockList.VERTICAL_SMOOTH_QUARTZ_SLAB, new Item.Properties().group(VerticalSlabsMod.GROUP).maxStackSize(64)),
                new ItemBlock(BlockList.VERTICAL_RED_NETHER_BRICKS_SLAB, new Item.Properties().group(VerticalSlabsMod.GROUP).maxStackSize(64)),
                new ItemBlock(BlockList.VERTICAL_END_STONE_BRICKS_SLAB, new Item.Properties().group(VerticalSlabsMod.GROUP).maxStackSize(64)),
                new ItemBlock(BlockList.VERTICAL_CUT_SANDSTONE_SLAB, new Item.Properties().group(VerticalSlabsMod.GROUP).maxStackSize(64)),
                new ItemBlock(BlockList.VERTICAL_CUT_RED_SANDSTONE_SLAB, new Item.Properties().group(VerticalSlabsMod.GROUP).maxStackSize(64))
            };

            for (final ItemBlock item: items) {
                final Block block = item.getBlock();
                final ResourceLocation registryname = Preconditions.checkNotNull(block.getRegistryName(), "BlockItem: %s has a NULL registry name", block);

                event.getRegistry().register(item.setRegistryName(registryname));
            }
        }
    }
}
