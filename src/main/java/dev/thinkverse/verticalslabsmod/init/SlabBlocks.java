package dev.thinkverse.verticalslabsmod.init;

import com.google.common.base.Preconditions;
import dev.thinkverse.verticalslabsmod.api.block.BlockList;
import dev.thinkverse.verticalslabsmod.blocks.grass.BlockGrassSlab;
import dev.thinkverse.verticalslabsmod.core.VerticalSlabsMod;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(VerticalSlabsMod.MODID)
public class SlabBlocks {

    @Mod.EventBusSubscriber(modid = VerticalSlabsMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class Register {
        @SubscribeEvent
        public static void RegisterBlocks(RegistryEvent.Register<Block> event) {
            final Block[] blocks = {
                BlockList.POLISHED_ANDESITE_SLAB = new BlockSlab(Block.Properties.from(Blocks.ANDESITE)).setRegistryName(VerticalSlabsMod.location("polished_andesite_slab")),
                BlockList.POLISHED_DIORITE_SLAB = new BlockSlab(Block.Properties.from(Blocks.DIORITE)).setRegistryName(VerticalSlabsMod.location("polished_diorite_slab")),
                BlockList.POLISHED_GRANITE_SLAB = new BlockSlab(Block.Properties.from(Blocks.GRANITE)).setRegistryName(VerticalSlabsMod.location("polished_granite_slab")),
                BlockList.ANDESITE_SLAB = new BlockSlab(Block.Properties.from(Blocks.ANDESITE)).setRegistryName(VerticalSlabsMod.location("andesite_slab")),
                BlockList.DIORITE_SLAB = new BlockSlab(Block.Properties.from(Blocks.DIORITE)).setRegistryName(VerticalSlabsMod.location("diorite_slab")),
                BlockList.GRANITE_SLAB = new BlockSlab(Block.Properties.from(Blocks.GRANITE)).setRegistryName(VerticalSlabsMod.location("granite_slab")),

                BlockList.MOSSY_COBBLESTONE_SLAB = new BlockSlab(Block.Properties.from(Blocks.MOSSY_COBBLESTONE)).setRegistryName(VerticalSlabsMod.location("mossy_cobblestone_slab")),
                BlockList.MOSSY_STONE_BRICKS_SLAB = new BlockSlab(Block.Properties.from(Blocks.MOSSY_STONE_BRICKS)).setRegistryName(VerticalSlabsMod.location("mossy_stone_bricks_slab")),

                BlockList.CUT_SANDSTONE_SLAB = new BlockSlab(Block.Properties.from(Blocks.CUT_SANDSTONE)).setRegistryName(VerticalSlabsMod.location("cut_sandstone_slab")),
                BlockList.SMOOTH_SANDSTONE_SLAB = new BlockSlab(Block.Properties.from(Blocks.SMOOTH_SANDSTONE)).setRegistryName(VerticalSlabsMod.location("smooth_sandstone_slab")),
                BlockList.CUT_RED_SANDSTONE_SLAB = new BlockSlab(Block.Properties.from(Blocks.CUT_RED_SANDSTONE)).setRegistryName(VerticalSlabsMod.location("cut_red_sandstone_slab")),
                BlockList.SMOOTH_RED_SANDSTONE_SLAB = new BlockSlab(Block.Properties.from(Blocks.SMOOTH_RED_SANDSTONE)).setRegistryName(VerticalSlabsMod.location("smooth_red_sandstone_slab")),

                BlockList.SMOOTH_QUARTZ_SLAB = new BlockSlab(Block.Properties.from(Blocks.SMOOTH_QUARTZ)).setRegistryName(VerticalSlabsMod.location("smooth_quartz_slab")),
                BlockList.RED_NETHER_BRICKS_SLAB = new BlockSlab(Block.Properties.from(Blocks.RED_NETHER_BRICKS)).setRegistryName(VerticalSlabsMod.location("red_nether_bricks_slab")),

                BlockList.END_STONE_BRICKS_SLAB = new BlockSlab(Block.Properties.from(Blocks.END_STONE_BRICKS)).setRegistryName(VerticalSlabsMod.location("end_stone_bricks_slab")),

                BlockList.STONE_SLAB = new BlockGrassSlab(Block.Properties.from(Blocks.STONE)).setRegistryName(VerticalSlabsMod.location("stone_slab")),
                BlockList.DIRT_SLAB = new BlockGrassSlab(Block.Properties.from(Blocks.DIRT)).setRegistryName(VerticalSlabsMod.location("dirt_slab")),
                BlockList.GRASS_SLAB = new BlockGrassSlab(Block.Properties.from(Blocks.GRASS_BLOCK)).setRegistryName(VerticalSlabsMod.location("grass_slab"))
            };

            for (final Block block: blocks) {
                Preconditions.checkNotNull(block.getRegistryName(), "Block: %s has a NULL registry name", block);

                event.getRegistry().register(block);
            }
        }

        @SubscribeEvent
        public static void RegisterItemBlocks(final RegistryEvent.Register<Item> event) {
            final ItemBlock[] items = {
                new ItemBlock(BlockList.POLISHED_ANDESITE_SLAB, new Item.Properties().group(VerticalSlabsMod.GROUP).maxStackSize(64)),
                new ItemBlock(BlockList.POLISHED_DIORITE_SLAB, new Item.Properties().group(VerticalSlabsMod.GROUP).maxStackSize(64)),
                new ItemBlock(BlockList.POLISHED_GRANITE_SLAB, new Item.Properties().group(VerticalSlabsMod.GROUP).maxStackSize(64)),
                new ItemBlock(BlockList.ANDESITE_SLAB, new Item.Properties().group(VerticalSlabsMod.GROUP).maxStackSize(64)),
                new ItemBlock(BlockList.DIORITE_SLAB, new Item.Properties().group(VerticalSlabsMod.GROUP).maxStackSize(64)),
                new ItemBlock(BlockList.GRANITE_SLAB, new Item.Properties().group(VerticalSlabsMod.GROUP).maxStackSize(64)),

                new ItemBlock(BlockList.MOSSY_COBBLESTONE_SLAB, new Item.Properties().group(VerticalSlabsMod.GROUP).maxStackSize(64)),
                new ItemBlock(BlockList.MOSSY_STONE_BRICKS_SLAB, new Item.Properties().group(VerticalSlabsMod.GROUP).maxStackSize(64)),

                new ItemBlock(BlockList.CUT_SANDSTONE_SLAB, new Item.Properties().group(VerticalSlabsMod.GROUP).maxStackSize(64)),
                new ItemBlock(BlockList.SMOOTH_SANDSTONE_SLAB, new Item.Properties().group(VerticalSlabsMod.GROUP).maxStackSize(64)),
                new ItemBlock(BlockList.CUT_RED_SANDSTONE_SLAB, new Item.Properties().group(VerticalSlabsMod.GROUP).maxStackSize(64)),
                new ItemBlock(BlockList.SMOOTH_RED_SANDSTONE_SLAB, new Item.Properties().group(VerticalSlabsMod.GROUP).maxStackSize(64)),

                new ItemBlock(BlockList.SMOOTH_QUARTZ_SLAB, new Item.Properties().group(VerticalSlabsMod.GROUP).maxStackSize(64)),
                new ItemBlock(BlockList.RED_NETHER_BRICKS_SLAB, new Item.Properties().group(VerticalSlabsMod.GROUP).maxStackSize(64)),

                new ItemBlock(BlockList.END_STONE_BRICKS_SLAB, new Item.Properties().group(VerticalSlabsMod.GROUP).maxStackSize(64)),

                new ItemBlock(BlockList.STONE_SLAB, new Item.Properties().group(VerticalSlabsMod.GROUP).maxStackSize(64)),
                new ItemBlock(BlockList.DIRT_SLAB, new Item.Properties().group(VerticalSlabsMod.GROUP).maxStackSize(64)),
                new ItemBlock(BlockList.GRASS_SLAB, new Item.Properties().group(VerticalSlabsMod.GROUP).maxStackSize(64))
            };

            for (final ItemBlock item: items) {
                final Block block = item.getBlock();
                final ResourceLocation registryname = Preconditions.checkNotNull(block.getRegistryName(), "BlockItem: %s has a NULL registry name", block);

                event.getRegistry().register(item.setRegistryName(registryname));
            }
        }
    }
}
