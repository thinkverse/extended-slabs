package dev.thinkverse.extendedslabs.init;

import com.google.common.base.Preconditions;
import dev.thinkverse.extendedslabs.api.block.BlockList;
import dev.thinkverse.extendedslabs.blocks.grass.BlockGrassStairs;
import dev.thinkverse.extendedslabs.core.ExtendedSlabs;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
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
            final BlockItem[] items = {
                new BlockItem(BlockList.DIRT_STAIRS, new Item.Properties().group(ExtendedSlabs.GROUP).maxStackSize(64)),
                new BlockItem(BlockList.GRASS_STAIRS, new Item.Properties().group(ExtendedSlabs.GROUP).maxStackSize(64))
            };

            for (final BlockItem item: items) {
                final Block block = item.getBlock();
                final ResourceLocation registryname = Preconditions.checkNotNull(block.getRegistryName(), "BlockItem: %s has a NULL registry name", block);

                event.getRegistry().register(item.setRegistryName(registryname));
            }
        }
    }
}
