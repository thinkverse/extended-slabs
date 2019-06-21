package dev.thinkverse.extendedslabs.core;

import dev.thinkverse.extendedslabs.init.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.color.BlockColors;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraft.item.BlockItem;
import net.minecraft.world.GrassColors;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeColors;

public class ClientProxy extends CommonProxy {
    protected static Minecraft MC = Minecraft.getInstance();

    @Override
    public void init() {
        BlockColors blockcolors = Minecraft.getInstance().getBlockColors();
        ItemColors itemcolors = Minecraft.getInstance().getItemColors();

        blockcolors.register((state, world, pos, tintindex) ->
                        world != null && pos != null ? BiomeColors.getGrassColor(world, pos) : GrassColors.get(0.5D, 1.0D),
                ModBlocks.GRASS_SLAB, ModBlocks.VERTICAL_GRASS_SLAB, ModBlocks.GRASS_STAIRS);

        itemcolors.register((stack, tintindex) -> {
                    BlockState iblockstate = ((BlockItem)stack.getItem()).getBlock().getDefaultState();
                    return blockcolors.getColor(iblockstate, null, null); },
                ModBlocks.GRASS_SLAB, ModBlocks.VERTICAL_GRASS_SLAB, ModBlocks.GRASS_STAIRS);
    }

    public World getClientWorld() { return MC.world; }
}
