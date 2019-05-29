package dev.thinkverse.verticalslabsmod.init;

import com.google.common.base.Preconditions;
import dev.thinkverse.verticalslabsmod.lists.BlockList;
import dev.thinkverse.verticalslabsmod.lists.ItemBlockList;
import dev.thinkverse.verticalslabsmod.VerticalSlabsMod;
import dev.thinkverse.verticalslabsmod.blocks.BlockVerticalSlab;
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
            BlockList.VERTICAL_DARK_OAK_SLAB = new BlockVerticalSlab(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName(Location("vertical_dark_oak_slab")),
            BlockList.VERTICAL_SPRUCE_SLAB = new BlockVerticalSlab(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName(Location("vertical_spruce_slab")),
            BlockList.VERTICAL_ACACIA_SLAB = new BlockVerticalSlab(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName(Location("vertical_acacia_slab")),
            BlockList.VERTICAL_JUNGLE_SLAB = new BlockVerticalSlab(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName(Location("vertical_jungle_slab")),
            BlockList.VERTICAL_BIRCH_SLAB = new BlockVerticalSlab(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName(Location("vertical_birch_slab")),
            BlockList.VERTICAL_OAK_SLAB = new BlockVerticalSlab(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName(Location("vertical_oak_slab"))
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
            ItemBlockList.VERTICAL_OAK_SLAB = createItemBlock(BlockList.VERTICAL_OAK_SLAB, new Item.Properties().group(VerticalSlabsMod.GROUP).maxStackSize(64))
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
