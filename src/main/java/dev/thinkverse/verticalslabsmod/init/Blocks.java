package dev.thinkverse.verticalslabsmod.init;

import com.google.common.base.Preconditions;
import dev.thinkverse.verticalslabsmod.api.block.BlockList;
import dev.thinkverse.verticalslabsmod.blocks.BlockVerticalSlab;
import dev.thinkverse.verticalslabsmod.core.VerticalSlabsMod;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(VerticalSlabsMod.MODID)
public class Blocks {

    @Mod.EventBusSubscriber(modid = VerticalSlabsMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class Register {

        @SubscribeEvent
        public static void RegisterBlocks(RegistryEvent.Register<Block> event) {
            final Block[] blocks = {
                BlockList.VERTICAL_DARK_OAK_SLAB = new BlockVerticalSlab(Block.Properties.create(Material.WOOD, MaterialColor.BROWN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName(VerticalSlabsMod.location("vertical_dark_oak_slab")),
                BlockList.VERTICAL_SPRUCE_SLAB = new BlockVerticalSlab(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName(VerticalSlabsMod.location("vertical_spruce_slab")),
                BlockList.VERTICAL_ACACIA_SLAB = new BlockVerticalSlab(Block.Properties.create(Material.WOOD, MaterialColor.ADOBE).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName(VerticalSlabsMod.location("vertical_acacia_slab")),
                BlockList.VERTICAL_JUNGLE_SLAB = new BlockVerticalSlab(Block.Properties.create(Material.WOOD, MaterialColor.DIRT).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName(VerticalSlabsMod.location("vertical_jungle_slab")),
                BlockList.VERTICAL_BIRCH_SLAB = new BlockVerticalSlab(Block.Properties.create(Material.WOOD, MaterialColor.SAND).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName(VerticalSlabsMod.location("vertical_birch_slab")),
                BlockList.VERTICAL_OAK_SLAB = new BlockVerticalSlab(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName(VerticalSlabsMod.location("vertical_oak_slab")),

                BlockList.COBBLESTONE = new BlockVerticalSlab(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(2.0F, 6.0F)).setRegistryName(VerticalSlabsMod.location("vertical_cobblestone_slab")),
                BlockList.STONEBRICK = new BlockVerticalSlab(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(2.0F, 6.0F)).setRegistryName(VerticalSlabsMod.location("vertical_stone_brick_slab")),
                BlockList.STONE = new BlockVerticalSlab(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(2.0F, 6.0F)).setRegistryName(VerticalSlabsMod.location("vertical_stone_slab")),

                BlockList.REDSANDSTONE = new BlockVerticalSlab(Block.Properties.create(Material.ROCK, MaterialColor.ADOBE).hardnessAndResistance(2.0F, 6.0F)).setRegistryName(VerticalSlabsMod.location("vertical_red_sandstone_slab")),
                BlockList.SANDSTONE = new BlockVerticalSlab(Block.Properties.create(Material.ROCK, MaterialColor.SAND).hardnessAndResistance(2.0F, 6.0F)).setRegistryName(VerticalSlabsMod.location("vertical_sandstone_slab")),

                BlockList.BRICK = new BlockVerticalSlab(Block.Properties.create(Material.ROCK, MaterialColor.RED).hardnessAndResistance(2.0F, 6.0F)).setRegistryName(VerticalSlabsMod.location("vertical_brick_slab")),

                BlockList.NETHERBRICK = new BlockVerticalSlab(Block.Properties.create(Material.ROCK, MaterialColor.NETHERRACK).hardnessAndResistance(2.0F, 6.0F)).setRegistryName(VerticalSlabsMod.location("vertical_nether_brick_slab")),
                BlockList.QUARTZ = new BlockVerticalSlab(Block.Properties.create(Material.ROCK, MaterialColor.QUARTZ).hardnessAndResistance(2.0F, 6.0F)).setRegistryName(VerticalSlabsMod.location("vertical_quartz_slab")),

                BlockList.PURPUR = new BlockVerticalSlab(Block.Properties.create(Material.ROCK, MaterialColor.MAGENTA).hardnessAndResistance(2.0F, 6.0F)).setRegistryName(VerticalSlabsMod.location("vertical_purpur_slab")),

                BlockList.PRISMARINEBRICK = new BlockVerticalSlab(Block.Properties.create(Material.ROCK, MaterialColor.DIAMOND).hardnessAndResistance(1.5F, 6.0F)).setRegistryName(VerticalSlabsMod.location("vertical_prismarine_brick_slab")),
                BlockList.DARKPRISMARINE = new BlockVerticalSlab(Block.Properties.create(Material.ROCK, MaterialColor.DIAMOND).hardnessAndResistance(1.5F, 6.0F)).setRegistryName(VerticalSlabsMod.location("vertical_dark_prismarine_slab")),
                BlockList.PRISMARINE = new BlockVerticalSlab(Block.Properties.create(Material.ROCK, MaterialColor.CYAN).hardnessAndResistance(1.5F, 6.0F)).setRegistryName(VerticalSlabsMod.location("vertical_prismarine_slab"))
            };

            for (final Block block: blocks) {
                Preconditions.checkNotNull(block.getRegistryName(), "Block: %s has a NULL registry name", block);

                event.getRegistry().register(block);
            }
        }

        @SubscribeEvent
        public static void RegisterItemBlocks(final RegistryEvent.Register<Item> event) {
            final ItemBlock[] items = {
                    new ItemBlock(BlockList.VERTICAL_DARK_OAK_SLAB, new Item.Properties().group(VerticalSlabsMod.GROUP).maxStackSize(64)),
                    new ItemBlock(BlockList.VERTICAL_SPRUCE_SLAB, new Item.Properties().group(VerticalSlabsMod.GROUP).maxStackSize(64)),
                    new ItemBlock(BlockList.VERTICAL_ACACIA_SLAB, new Item.Properties().group(VerticalSlabsMod.GROUP).maxStackSize(64)),
                    new ItemBlock(BlockList.VERTICAL_JUNGLE_SLAB, new Item.Properties().group(VerticalSlabsMod.GROUP).maxStackSize(64)),
                    new ItemBlock(BlockList.VERTICAL_BIRCH_SLAB, new Item.Properties().group(VerticalSlabsMod.GROUP).maxStackSize(64)),
                    new ItemBlock(BlockList.VERTICAL_OAK_SLAB, new Item.Properties().group(VerticalSlabsMod.GROUP).maxStackSize(64)),

                    new ItemBlock(BlockList.COBBLESTONE, new Item.Properties().group(VerticalSlabsMod.GROUP).maxStackSize(64)),
                    new ItemBlock(BlockList.STONEBRICK, new Item.Properties().group(VerticalSlabsMod.GROUP).maxStackSize(64)),
                    new ItemBlock(BlockList.STONE, new Item.Properties().group(VerticalSlabsMod.GROUP).maxStackSize(64)),

                    new ItemBlock(BlockList.REDSANDSTONE, new Item.Properties().group(VerticalSlabsMod.GROUP).maxStackSize(64)),
                    new ItemBlock(BlockList.SANDSTONE, new Item.Properties().group(VerticalSlabsMod.GROUP).maxStackSize(64)),

                    new ItemBlock(BlockList.BRICK, new Item.Properties().group(VerticalSlabsMod.GROUP).maxStackSize(64)),

                    new ItemBlock(BlockList.NETHERBRICK, new Item.Properties().group(VerticalSlabsMod.GROUP).maxStackSize(64)),
                    new ItemBlock(BlockList.QUARTZ, new Item.Properties().group(VerticalSlabsMod.GROUP).maxStackSize(64)),

                    new ItemBlock(BlockList.PURPUR, new Item.Properties().group(VerticalSlabsMod.GROUP).maxStackSize(64)),

                    new ItemBlock(BlockList.PRISMARINEBRICK, new Item.Properties().group(VerticalSlabsMod.GROUP).maxStackSize(64)),
                    new ItemBlock(BlockList.DARKPRISMARINE, new Item.Properties().group(VerticalSlabsMod.GROUP).maxStackSize(64)),
                    new ItemBlock(BlockList.PRISMARINE, new Item.Properties().group(VerticalSlabsMod.GROUP).maxStackSize(64))
            };

            for (final ItemBlock item: items) {
                final Block block = item.getBlock();
                final ResourceLocation registryname = Preconditions.checkNotNull(block.getRegistryName(), "BlockItem: %s has a NULL registry name", block);

                event.getRegistry().register(item.setRegistryName(registryname));
            }
        }

    }
}
