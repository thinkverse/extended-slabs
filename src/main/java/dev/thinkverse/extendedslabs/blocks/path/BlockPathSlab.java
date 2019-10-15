package dev.thinkverse.extendedslabs.blocks.path;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.state.IBlockState;
import net.minecraft.state.properties.SlabType;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nullable;

public class BlockPathSlab extends BlockSlab {
    protected static final VoxelShape DOUBLE_SHAPE = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 15.0D, 16.0D);
    protected static final VoxelShape BOTTOM_SHAPE = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 7.0D, 16.0D);
    protected static final VoxelShape TOP_SHAPE = Block.makeCuboidShape(0.0D, 8.0D, 0.0D, 16.0D, 15.0D, 16.0D);

    public BlockPathSlab(Properties builder) {
        super(builder);
    }

    @Override
    public VoxelShape getShape(IBlockState state, IBlockReader worldIn, BlockPos pos) {
        SlabType slabtype = state.get(TYPE);
        switch(slabtype) {
            case DOUBLE:
                return DOUBLE_SHAPE;
            case TOP:
                return TOP_SHAPE;
            default:
                return BOTTOM_SHAPE;
        }
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
