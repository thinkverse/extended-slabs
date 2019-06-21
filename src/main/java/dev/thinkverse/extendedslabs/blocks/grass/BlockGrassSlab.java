package dev.thinkverse.extendedslabs.blocks.grass;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nullable;

public class BlockGrassSlab extends BlockSlab {
    public BlockGrassSlab(Block.Properties builder) {
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
