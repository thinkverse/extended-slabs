package dev.thinkverse.extendedslabs.blocks.path;

import dev.thinkverse.extendedslabs.blocks.BlockCorners;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

public class BlockPathCorner extends BlockCorners {
    protected static final VoxelShape NORTH_SHAPE = Block.makeCuboidShape(0.0D, 15.0D, 0.0D, 16.0D, 0.0D, 8.0D);
    protected static final VoxelShape EAST_SHAPE = Block.makeCuboidShape(8.0D, 15.0D, 0.0D, 16.0D, 0.0D, 16.0D);
    protected static final VoxelShape SOUTH_SHAPE = Block.makeCuboidShape(0.0D, 15.0D, 16.0D, 16.0D, 0.0D, 8.0D);
    protected static final VoxelShape WEST_SHAPE = Block.makeCuboidShape(0.0D, 15.0D, 0.0D, 8.0D, 0.0D, 16.0D);

    protected static final VoxelShape NORTH_OUTER_SHAPE = Block.makeCuboidShape(0.0D, 15.0D, 0.0D, 8.0D, 0.0D, 8.0D);
    protected static final VoxelShape EAST_OUTER_SHAPE = Block.makeCuboidShape(8.0D, 15.0D, 0.0D, 16.0D, 0.0D, 8.0D);
    protected static final VoxelShape SOUTH_OUTER_SHAPE = Block.makeCuboidShape(8.0D, 15.0D, 16.0D, 16.0D, 0.0D, 8.0D);
    protected static final VoxelShape WEST_OUTER_SHAPE = Block.makeCuboidShape(0.0D, 15.0D, 8.0D, 8.0D, 0.0D, 16.0D);

    public BlockPathCorner(Properties properties) { super(properties); }

    @Override
    public VoxelShape getShape(IBlockState state, IBlockReader worldIn, BlockPos pos) {
        EnumFacing enumFacing = state.get(FACING);
        switch (enumFacing) {
            case WEST:
                return (VoxelShape) VoxelShapes.or(WEST_SHAPE, SOUTH_OUTER_SHAPE);
            case EAST:
                return (VoxelShape) VoxelShapes.or(EAST_SHAPE, NORTH_OUTER_SHAPE);
            case SOUTH:
                return (VoxelShape) VoxelShapes.or(SOUTH_SHAPE, EAST_OUTER_SHAPE);
            default:
                return (VoxelShape) VoxelShapes.or(NORTH_SHAPE, WEST_OUTER_SHAPE);
        }
    }
}
