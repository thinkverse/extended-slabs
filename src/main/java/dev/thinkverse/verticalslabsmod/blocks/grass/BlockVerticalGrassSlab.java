package dev.thinkverse.verticalslabsmod.blocks.grass;

import dev.thinkverse.verticalslabsmod.blocks.BlockVerticalSlab;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
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
    public ToolType getHarvestTool(IBlockState state) {
        return ToolType.SHOVEL;
    }
}
