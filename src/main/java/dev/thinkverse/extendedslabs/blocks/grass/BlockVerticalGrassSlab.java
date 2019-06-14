package dev.thinkverse.extendedslabs.blocks.grass;

import dev.thinkverse.extendedslabs.blocks.BlockVerticalSlab;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nullable;

public class BlockVerticalGrassSlab extends BlockVerticalSlab {
    public BlockVerticalGrassSlab(Block.Properties builder) {
        super(builder);
    }

    @Override
    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.CUTOUT_MIPPED;
    }

    @Nullable
    @Override
    public ToolType getHarvestTool(BlockState state) {
        return ToolType.SHOVEL;
    }
}
