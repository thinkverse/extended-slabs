package dev.thinkverse.extendedslabs.init;

import dev.thinkverse.extendedslabs.api.block.ModCorners;
import dev.thinkverse.extendedslabs.api.block.ModSlabs;
import dev.thinkverse.extendedslabs.api.block.ModStairs;
import dev.thinkverse.extendedslabs.api.block.ModVerticalSlabs;
import dev.thinkverse.extendedslabs.blocks.grass.BlockGrassCorner;
import dev.thinkverse.extendedslabs.blocks.grass.BlockGrassSlab;
import dev.thinkverse.extendedslabs.blocks.grass.BlockGrassStairs;
import dev.thinkverse.extendedslabs.blocks.grass.BlockVerticalGrassSlab;
import dev.thinkverse.extendedslabs.blocks.path.BlockPathCorner;
import dev.thinkverse.extendedslabs.blocks.path.BlockPathSlab;
import dev.thinkverse.extendedslabs.blocks.path.BlockPathStairs;
import dev.thinkverse.extendedslabs.blocks.path.BlockVerticalPathSlab;
import dev.thinkverse.extendedslabs.core.ExtendedSlabs;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber(modid = ExtendedSlabs.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModBlocks {
    public static Block VERTICAL_GRASS_SLAB;
    public static Block GRASS_CORNER;
    public static Block GRASS_STAIRS;
    public static Block GRASS_SLAB;

    public static Block VERTICAL_GRASS_PATH_SLAB;
    public static Block GRASS_PATH_CORNER;
    public static Block GRASS_PATH_STAIRS;
    public static Block GRASS_PATH_SLAB;

    @SubscribeEvent
    public static void RegisterModBlock(final RegistryEvent.Register<Block> event) {
        if (!event.getName().equals(ForgeRegistries.BLOCKS.getRegistryName())) return;

        VERTICAL_GRASS_PATH_SLAB = register("vertical_grass_path_slab", new BlockVerticalPathSlab(Block.Properties.from(Blocks.GRASS_PATH)));
        VERTICAL_GRASS_SLAB = register("vertical_grass_slab", new BlockVerticalGrassSlab(Block.Properties.from(Blocks.GRASS_BLOCK)));

        for (ModVerticalSlabs VerticalSlab : ModVerticalSlabs.VALUES) {
            register("vertical_" + VerticalSlab.getName() + "_slab", VerticalSlab.getVerticalSlab());
        }

        GRASS_PATH_SLAB = register("grass_path_slab", new BlockPathSlab(Block.Properties.from(Blocks.GRASS_PATH)));
        GRASS_SLAB = register("grass_slab", new BlockGrassSlab(Block.Properties.from(Blocks.GRASS_BLOCK)));

        for (ModSlabs Slab : ModSlabs.VALUES) {
            register(Slab.getName() + "_slab", Slab.getSlab());
        }

        GRASS_PATH_STAIRS = register("grass_path_stairs", new BlockPathStairs(Blocks.GRASS_PATH.getDefaultState(), Block.Properties.from(Blocks.GRASS_PATH)));
        GRASS_STAIRS = register("grass_stairs", new BlockGrassStairs(Blocks.GRASS_BLOCK.getDefaultState(), Block.Properties.from(Blocks.GRASS_BLOCK)));

        for (ModStairs Stairs : ModStairs.VALUES) {
            register(Stairs.getName() + "_stairs", Stairs.getStairs());
        }

        GRASS_PATH_CORNER = register("grass_path_corner", new BlockPathCorner(Block.Properties.from(Blocks.GRASS_PATH)));
        GRASS_CORNER = register("grass_corner", new BlockGrassCorner(Block.Properties.from(Blocks.GRASS_BLOCK)));

        for (ModCorners Corners : ModCorners.VALUES) {
            register(Corners.getName() + "_corner", Corners.getCornerBlock());
        }
    }

    private static <T extends Block> T register(String name, T block) {
        ItemBlock item = new ItemBlock(block, new Item.Properties().group(ExtendedSlabs.GROUP));
        return register(name, block, item);
    }

    private static <T extends Block> T register(String name, T block, @Nullable ItemBlock item) {
        ResourceLocation id = ExtendedSlabs.location(name);
        block.setRegistryName(id);
        ForgeRegistries.BLOCKS.register(block);
        if (item != null) {
            ModItems.BLOCKS_TO_REGISTER.put(name, item);
        }
        return block;
    }

}