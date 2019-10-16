package dev.thinkverse.extendedslabs.blocks.grass;

import dev.thinkverse.extendedslabs.blocks.BlockCorners;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nullable;

public class BlockGrassCorner extends BlockCorners {
    public BlockGrassCorner(Properties properties) { super(properties); }

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
