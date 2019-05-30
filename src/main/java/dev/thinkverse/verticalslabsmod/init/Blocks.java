package dev.thinkverse.verticalslabsmod.init;

import com.google.common.base.Preconditions;
import dev.thinkverse.verticalslabsmod.blocks.BlockVerticalSlab;
import dev.thinkverse.verticalslabsmod.lists.BlockList;
import dev.thinkverse.verticalslabsmod.lists.ItemBlockList;
import dev.thinkverse.verticalslabsmod.VerticalSlabsMod;
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

@Mod.EventBusSubscriber(modid = VerticalSlabsMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
@ObjectHolder(VerticalSlabsMod.MODID)
public class Blocks {

    @SubscribeEvent
    public static void RegisterBlocks(RegistryEvent.Register<Block> event) {
        final Block[] blocks = {
            BlockList.VERTICAL_DARK_OAK_SLAB = new BlockVerticalSlab(Block.Properties.create(Material.WOOD, MaterialColor.BROWN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName(Location("vertical_dark_oak_slab")),
            BlockList.VERTICAL_SPRUCE_SLAB = new BlockVerticalSlab(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName(Location("vertical_spruce_slab")),
            BlockList.VERTICAL_ACACIA_SLAB = new BlockVerticalSlab(Block.Properties.create(Material.WOOD, MaterialColor.ADOBE).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName(Location("vertical_acacia_slab")),
            BlockList.VERTICAL_JUNGLE_SLAB = new BlockVerticalSlab(Block.Properties.create(Material.WOOD, MaterialColor.DIRT).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName(Location("vertical_jungle_slab")),
            BlockList.VERTICAL_BIRCH_SLAB = new BlockVerticalSlab(Block.Properties.create(Material.WOOD, MaterialColor.SAND).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName(Location("vertical_birch_slab")),
            BlockList.VERTICAL_OAK_SLAB = new BlockVerticalSlab(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName(Location("vertical_oak_slab")),

            BlockList.COBBLESTONE = new BlockVerticalSlab(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(2.0F, 6.0F)).setRegistryName(Location("vertical_cobblestone_slab")),
            BlockList.STONEBRICK = new BlockVerticalSlab(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(2.0F, 6.0F)).setRegistryName(Location("vertical_stone_brick_slab")),
            BlockList.STONE = new BlockVerticalSlab(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(2.0F, 6.0F)).setRegistryName(Location("vertical_stone_slab")),

            BlockList.REDSANDSTONE = new BlockVerticalSlab(Block.Properties.create(Material.ROCK, MaterialColor.ADOBE).hardnessAndResistance(2.0F, 6.0F)).setRegistryName(Location("vertical_red_sandstone_slab")),
            BlockList.SANDSTONE = new BlockVerticalSlab(Block.Properties.create(Material.ROCK, MaterialColor.SAND).hardnessAndResistance(2.0F, 6.0F)).setRegistryName(Location("vertical_sandstone_slab")),

            BlockList.BRICK = new BlockVerticalSlab(Block.Properties.create(Material.ROCK, MaterialColor.RED).hardnessAndResistance(2.0F, 6.0F)).setRegistryName(Location("vertical_brick_slab")),

            BlockList.NETHERBRICK = new BlockVerticalSlab(Block.Properties.create(Material.ROCK, MaterialColor.NETHERRACK).hardnessAndResistance(2.0F, 6.0F)).setRegistryName(Location("vertical_nether_brick_slab")),
            BlockList.QUARTZ = new BlockVerticalSlab(Block.Properties.create(Material.ROCK, MaterialColor.QUARTZ).hardnessAndResistance(2.0F, 6.0F)).setRegistryName(Location("vertical_quartz_slab")),

            BlockList.PURPUR = new BlockVerticalSlab(Block.Properties.create(Material.ROCK, MaterialColor.MAGENTA).hardnessAndResistance(2.0F, 6.0F)).setRegistryName(Location("vertical_purpur_slab")),

            BlockList.PRISMARINEBRICK = new BlockVerticalSlab(Block.Properties.create(Material.ROCK, MaterialColor.DIAMOND).hardnessAndResistance(1.5F, 6.0F)).setRegistryName(Location("vertical_prismarine_brick_slab")),
            BlockList.DARKPRISMARINE = new BlockVerticalSlab(Block.Properties.create(Material.ROCK, MaterialColor.DIAMOND).hardnessAndResistance(1.5F, 6.0F)).setRegistryName(Location("vertical_dark_prismarine_slab")),
            BlockList.PRISMARINE = new BlockVerticalSlab(Block.Properties.create(Material.ROCK, MaterialColor.CYAN).hardnessAndResistance(1.5F, 6.0F)).setRegistryName(Location("vertical_prismarine_slab"))
        };

        for (final Block block: blocks) {
            Preconditions.checkNotNull(block.getRegistryName(), "Block: %s has a NULL registry name", block);

            event.getRegistry().register(block);
        }
    }

    @SubscribeEvent
    public static void RegisterItemBlocks(RegistryEvent.Register<Item> event) {
        final ItemBlock[] items = {
            ItemBlockList.VERTICAL_DARK_OAK_SLAB = createItemBlock(BlockList.VERTICAL_DARK_OAK_SLAB, new Item.Properties().group(VerticalSlabsMod.GROUP).maxStackSize(64)),
            ItemBlockList.VERTICAL_SPRUCE_SLAB = createItemBlock(BlockList.VERTICAL_SPRUCE_SLAB, new Item.Properties().group(VerticalSlabsMod.GROUP).maxStackSize(64)),
            ItemBlockList.VERTICAL_ACACIA_SLAB = createItemBlock(BlockList.VERTICAL_ACACIA_SLAB, new Item.Properties().group(VerticalSlabsMod.GROUP).maxStackSize(64)),
            ItemBlockList.VERTICAL_JUNGLE_SLAB = createItemBlock(BlockList.VERTICAL_JUNGLE_SLAB, new Item.Properties().group(VerticalSlabsMod.GROUP).maxStackSize(64)),
            ItemBlockList.VERTICAL_BIRCH_SLAB = createItemBlock(BlockList.VERTICAL_BIRCH_SLAB, new Item.Properties().group(VerticalSlabsMod.GROUP).maxStackSize(64)),
            ItemBlockList.VERTICAL_OAK_SLAB = createItemBlock(BlockList.VERTICAL_OAK_SLAB, new Item.Properties().group(VerticalSlabsMod.GROUP).maxStackSize(64)),

            ItemBlockList.COBBLESTONE = createItemBlock(BlockList.COBBLESTONE, new Item.Properties().group(VerticalSlabsMod.GROUP).maxStackSize(64)),
            ItemBlockList.STONEBRICK = createItemBlock(BlockList.STONEBRICK, new Item.Properties().group(VerticalSlabsMod.GROUP).maxStackSize(64)),
            ItemBlockList.STONE = createItemBlock(BlockList.STONE, new Item.Properties().group(VerticalSlabsMod.GROUP).maxStackSize(64)),

            ItemBlockList.REDSANDSTONE = createItemBlock(BlockList.REDSANDSTONE, new Item.Properties().group(VerticalSlabsMod.GROUP).maxStackSize(64)),
            ItemBlockList.SANDSTONE = createItemBlock(BlockList.SANDSTONE, new Item.Properties().group(VerticalSlabsMod.GROUP).maxStackSize(64)),

            ItemBlockList.BRICK = createItemBlock(BlockList.BRICK, new Item.Properties().group(VerticalSlabsMod.GROUP).maxStackSize(64)),

            ItemBlockList.NETHERBRICK = createItemBlock(BlockList.NETHERBRICK, new Item.Properties().group(VerticalSlabsMod.GROUP).maxStackSize(64)),
            ItemBlockList.QUARTZ = createItemBlock(BlockList.QUARTZ, new Item.Properties().group(VerticalSlabsMod.GROUP).maxStackSize(64)),

            ItemBlockList.PURPUR = createItemBlock(BlockList.PURPUR, new Item.Properties().group(VerticalSlabsMod.GROUP).maxStackSize(64)),

            ItemBlockList.PRISMARINEBRICK = createItemBlock(BlockList.PRISMARINEBRICK, new Item.Properties().group(VerticalSlabsMod.GROUP).maxStackSize(64)),
            ItemBlockList.DARKPRISMARINE = createItemBlock(BlockList.DARKPRISMARINE, new Item.Properties().group(VerticalSlabsMod.GROUP).maxStackSize(64)),
            ItemBlockList.PRISMARINE = createItemBlock(BlockList.PRISMARINE, new Item.Properties().group(VerticalSlabsMod.GROUP).maxStackSize(64))
        };

        for (final ItemBlock item: items) {
            final Block block = item.getBlock();
            final ResourceLocation registryName = Preconditions.checkNotNull(block.getRegistryName(), "BlockItem: %s has a NULL registry name", block);

            event.getRegistry().register(item.setRegistryName(registryName));
        }
    }

    private static ItemBlock createItemBlock(Block block, Item.Properties properties) {
        return (ItemBlock) new ItemBlock(block, properties);
    }

    private static ResourceLocation Location(String name) {
        return new ResourceLocation(VerticalSlabsMod.MODID, name);
    }
}
