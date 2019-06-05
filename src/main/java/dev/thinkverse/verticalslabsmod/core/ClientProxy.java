package dev.thinkverse.verticalslabsmod.core;

import dev.thinkverse.verticalslabsmod.api.block.BlockList;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.color.BlockColors;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraft.item.ItemBlock;
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
                BlockList.GRASS_SLAB, BlockList.VERTICAL_GRASS_SLAB, BlockList.GRASS_STAIRS);

        itemcolors.register((stack, tintindex) -> {
                    IBlockState iblockstate = ((ItemBlock)stack.getItem()).getBlock().getDefaultState();
                    return blockcolors.getColor(iblockstate, null, null, tintindex); },
                BlockList.GRASS_SLAB, BlockList.VERTICAL_GRASS_SLAB, BlockList.GRASS_STAIRS);
    }

    public World getClientWorld() { return MC.world; }
}
