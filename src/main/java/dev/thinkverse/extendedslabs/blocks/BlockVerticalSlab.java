package dev.thinkverse.extendedslabs.blocks;

import dev.thinkverse.extendedslabs.blocks.shapes.VerticalSlabShape;
import net.minecraft.block.*;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;

import javax.annotation.Nullable;

public class BlockVerticalSlab extends Block implements IBucketPickupHandler, ILiquidContainer {
    public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final EnumProperty<VerticalSlabShape> SHAPE = EnumProperty.create("shape", VerticalSlabShape.class);

    protected static final VoxelShape NORTH_SHAPE = Block.makeCuboidShape(0.0D, 16.0D, 0.0D, 16.0D, 0.0D, 8.0D);
    protected static final VoxelShape EAST_SHAPE  = Block.makeCuboidShape(8.0D, 16.0D, 0.0D, 16.0D, 0.0D, 16.0D);
    protected static final VoxelShape SOUTH_SHAPE = Block.makeCuboidShape(0.0D, 16.0D, 16.0D, 16.0D, 0.0D, 8.0D);
    protected static final VoxelShape WEST_SHAPE  = Block.makeCuboidShape(0.0D, 16.0D, 0.0D, 8.0D, 0.0D, 16.0D);

    protected static final VoxelShape NORTH_OUTER_SHAPE  = Block.makeCuboidShape(0.0D, 16.0D, 0.0D, 8.0D, 0.0D, 8.0D);
    protected static final VoxelShape EAST_OUTER_SHAPE  = Block.makeCuboidShape(8.0D, 16.0D, 0.0D, 16.0D, 0.0D, 8.0D);
    protected static final VoxelShape SOUTH_OUTER_SHAPE  = Block.makeCuboidShape(8.0D, 16.0D, 16.0D, 16.0D, 0.0D, 8.0D);
    protected static final VoxelShape WEST_OUTER_SHAPE  = Block.makeCuboidShape(0.0D, 16.0D, 8.0D, 8.0D, 0.0D, 16.0D);

    public BlockVerticalSlab(Block.Properties builder) {
        super(builder);
        this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH).with(SHAPE, VerticalSlabShape.STRAIGHT).with(WATERLOGGED, Boolean.valueOf(false)));
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING, SHAPE, WATERLOGGED);
    }

    @Override
    @SuppressWarnings("deprecation")
    public boolean func_220074_n(BlockState state) {
        return false;
    }

    @Override
    public BlockRenderLayer getRenderLayer() {
        return super.getRenderLayer();
    }

    public BlockRenderLayer getRenderLayer(IBlockReader worldIn, BlockState state, BlockPos pos, Direction face) {
        VerticalSlabShape verticalslabshape = state.get(SHAPE);
        if (verticalslabshape != VerticalSlabShape.OUTER_LEFT && verticalslabshape != VerticalSlabShape.OUTER_RIGHT) {
            Direction enumfacing = state.get(FACING);
            switch(verticalslabshape) {
                case STRAIGHT:
                    return enumfacing == face ? BlockRenderLayer.SOLID : BlockRenderLayer.TRANSLUCENT;
                case INNER_LEFT:
                case INNER_RIGHT:
                    return enumfacing != face ? BlockRenderLayer.TRANSLUCENT : BlockRenderLayer.SOLID;
                default:
                    return BlockRenderLayer.TRANSLUCENT;
            }
        } else {
            return BlockRenderLayer.TRANSLUCENT;
        }
    }

    @Override
    @SuppressWarnings("deprecation")
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        VerticalSlabShape verticalslabshape = state.get(SHAPE);
        Direction enumfacing = state.get(FACING);

        if (verticalslabshape != VerticalSlabShape.STRAIGHT) {
            switch(verticalslabshape) {
                case OUTER_LEFT:
                    return getOuterLeftFacingShapes(enumfacing);
                case OUTER_RIGHT:
                    return getOuterRightFacingShapes(enumfacing);
                case INNER_LEFT:
                    return getInnerLeftFacingShapes(enumfacing);
                case INNER_RIGHT:
                    return getInnerRightFacingShapes(enumfacing);
                default:
                    return getStraightFacingShapes(enumfacing);
            }
        } else {
            return getStraightFacingShapes(enumfacing);
        }
    }

    private static VoxelShape getStraightFacingShapes(Direction facing) {
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

    private static VoxelShape getOuterLeftFacingShapes(Direction facing) {
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

    private static VoxelShape getInnerLeftFacingShapes(Direction facing) {
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

    private static VoxelShape getOuterRightFacingShapes(Direction facing) {
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

    private static VoxelShape getInnerRightFacingShapes(Direction facing) {
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

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        Direction enumfacing = context.getFace();
        IFluidState ifluidstate = context.getWorld().getFluidState(context.getPos());
        BlockState iblockstate = this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing()).with(WATERLOGGED, Boolean.valueOf(ifluidstate.getFluid() == Fluids.WATER));
        return iblockstate.with(SHAPE, getSlabShape(iblockstate, context.getWorld(), context.getPos()));
    }

    private static VerticalSlabShape getSlabShape(BlockState state, IBlockReader worldIn, BlockPos pos) {
        Direction enumfacing = state.get(FACING);
        BlockState iblockstate = worldIn.getBlockState(pos.offset(enumfacing));
        if (isBlockVerticalSlab(iblockstate)) {
            Direction enumfacing1 = iblockstate.get(FACING);
            if (enumfacing1.getAxis() != state.get(FACING).getAxis() && isDifferentVerticalSlab(state, worldIn, pos, enumfacing1.getOpposite())) {
                if (enumfacing1 == enumfacing.rotateYCCW()) {
                    return VerticalSlabShape.OUTER_LEFT;
                }

                return VerticalSlabShape.OUTER_RIGHT;
            }
        }

        BlockState iblockstate1 = worldIn.getBlockState(pos.offset(enumfacing.getOpposite()));
        if (isBlockVerticalSlab(iblockstate1)) {
            Direction enumfacing2 = iblockstate1.get(FACING);
            if (enumfacing2.getAxis() != state.get(FACING).getAxis() && isDifferentVerticalSlab(state, worldIn, pos, enumfacing2)) {
                if (enumfacing2 == enumfacing.rotateYCCW()) {
                    return VerticalSlabShape.INNER_LEFT;
                }

                return VerticalSlabShape.INNER_RIGHT;
            }
        }

        return VerticalSlabShape.STRAIGHT;
    }

    private static boolean isDifferentVerticalSlab(BlockState state, IBlockReader worldIn, BlockPos pos, Direction enumFacing) {
        BlockState iblockstate = worldIn.getBlockState(pos.offset(enumFacing));
        return !isBlockVerticalSlab(iblockstate) || iblockstate.get(FACING) != state.get(FACING);
    }

    public static boolean isBlockVerticalSlab(BlockState state) {
        return state.getBlock() instanceof BlockVerticalSlab;
    }

    @Override
    @SuppressWarnings("deprecation")
    public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
        if (stateIn.get(WATERLOGGED)) {
            worldIn.getPendingFluidTicks().scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickRate(worldIn));
        }

        return super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
    }

    @Override
    public Fluid pickupFluid(IWorld worldIn, BlockPos pos, BlockState state) {
        if (state.get(WATERLOGGED)) {
            worldIn.setBlockState(pos, state.with(WATERLOGGED, Boolean.valueOf(false)), 3);
            return Fluids.WATER;
        } else {
            return Fluids.EMPTY;
        }
    }

    @Override
    @SuppressWarnings("deprecation")
    public IFluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
    }

    @Override
    public boolean canContainFluid(IBlockReader worldIn, BlockPos pos, BlockState state, Fluid fluidIn) {
        return !state.get(WATERLOGGED) && fluidIn == Fluids.WATER;
    }

    @Override
    public boolean receiveFluid(IWorld worldIn, BlockPos pos, BlockState state, IFluidState fluidStateIn) {
        if (!state.get(WATERLOGGED) && fluidStateIn.getFluid() == Fluids.WATER) {
            if (!worldIn.isRemote()) {
                worldIn.setBlockState(pos, state.with(WATERLOGGED, Boolean.valueOf(true)), 3);
                worldIn.getPendingFluidTicks().scheduleTick(pos, fluidStateIn.getFluid(), fluidStateIn.getFluid().getTickRate(worldIn));
            }

            return true;
        } else {
            return false;
        }
    }

}
