package dev.thinkverse.extendedslabs.blocks.path;

import dev.thinkverse.extendedslabs.blocks.BlockVerticalSlab;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nullable;

public class BlockVerticalPathSlab extends BlockVerticalSlab {
    protected static final VoxelShape NORTH_SHAPE = Block.makeCuboidShape(0.0D, 15.0D, 0.0D, 16.0D, 0.0D, 8.0D);
    protected static final VoxelShape EAST_SHAPE  = Block.makeCuboidShape(8.0D, 15.0D, 0.0D, 16.0D, 0.0D, 16.0D);
    protected static final VoxelShape SOUTH_SHAPE = Block.makeCuboidShape(0.0D, 15.0D, 16.0D, 16.0D, 0.0D, 8.0D);
    protected static final VoxelShape WEST_SHAPE  = Block.makeCuboidShape(0.0D, 15.0D, 0.0D, 8.0D, 0.0D, 16.0D);

    protected static final VoxelShape NORTH_OUTER_SHAPE  = Block.makeCuboidShape(0.0D, 15.0D, 0.0D, 8.0D, 0.0D, 8.0D);
    protected static final VoxelShape EAST_OUTER_SHAPE  = Block.makeCuboidShape(8.0D, 15.0D, 0.0D, 16.0D, 0.0D, 8.0D);
    protected static final VoxelShape SOUTH_OUTER_SHAPE  = Block.makeCuboidShape(8.0D, 15.0D, 16.0D, 16.0D, 0.0D, 8.0D);
    protected static final VoxelShape WEST_OUTER_SHAPE  = Block.makeCuboidShape(0.0D, 15.0D, 8.0D, 8.0D, 0.0D, 16.0D);

    public BlockVerticalPathSlab(Block.Properties builder) {
        super(builder);
    }

    @Override
    protected VoxelShape getStraightFacingShapes(EnumFacing facing) {
        switch (facing) {
            case WEST:
                return (VoxelShape) WEST_SHAPE;
            case EAST:
                return (VoxelShape) EAST_SHAPE;
            case SOUTH:
                return (VoxelShape) SOUTH_SHAPE;
            default:
                return (VoxelShape) NORTH_SHAPE;
        }
    }

    @Override
    protected VoxelShape getOuterLeftFacingShapes(EnumFacing facing) {
        switch (facing) {
            case WEST:
                return (VoxelShape) WEST_OUTER_SHAPE;
            case EAST:
                return (VoxelShape) EAST_OUTER_SHAPE;
            case SOUTH:
                return (VoxelShape) SOUTH_OUTER_SHAPE;
            default:
                return (VoxelShape) NORTH_OUTER_SHAPE;
        }
    }

    @Override
    protected VoxelShape getInnerLeftFacingShapes(EnumFacing facing) {
        switch (facing) {
            case WEST:
                return (VoxelShape) VoxelShapes.or(WEST_SHAPE, SOUTH_SHAPE);
            case EAST:
                return (VoxelShape) VoxelShapes.or(EAST_SHAPE, NORTH_SHAPE);
            case SOUTH:
                return (VoxelShape) VoxelShapes.or(SOUTH_SHAPE, EAST_SHAPE);
            default:
                return (VoxelShape) VoxelShapes.or(NORTH_SHAPE, WEST_SHAPE);
        }
    }

    @Override
    protected VoxelShape getOuterRightFacingShapes(EnumFacing facing) {
        switch (facing) {
            case WEST:
                return (VoxelShape) NORTH_OUTER_SHAPE;
            case EAST:
                return (VoxelShape) SOUTH_OUTER_SHAPE;
            case SOUTH:
                return (VoxelShape) WEST_OUTER_SHAPE;
            default:
                return (VoxelShape) EAST_OUTER_SHAPE;
        }
    }

    @Override
    protected VoxelShape getInnerRightFacingShapes(EnumFacing facing) {
        switch (facing) {
            case WEST:
                return (VoxelShape) VoxelShapes.or(WEST_SHAPE, NORTH_SHAPE);
            case EAST:
                return (VoxelShape) VoxelShapes.or(EAST_SHAPE, SOUTH_SHAPE);
            case SOUTH:
                return (VoxelShape) VoxelShapes.or(SOUTH_SHAPE, WEST_SHAPE);
            default:
                return (VoxelShape) VoxelShapes.or(NORTH_SHAPE, EAST_SHAPE);
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
