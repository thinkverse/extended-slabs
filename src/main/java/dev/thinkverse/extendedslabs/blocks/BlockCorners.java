package dev.thinkverse.extendedslabs.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.IBucketPickupHandler;
import net.minecraft.block.ILiquidContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.IFluidState;
import net.minecraft.init.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;

import javax.annotation.Nullable;

public class BlockCorners extends Block implements IBucketPickupHandler, ILiquidContainer {
    public static final DirectionProperty FACING = BlockHorizontal.HORIZONTAL_FACING;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    protected static final VoxelShape NORTH_SHAPE = Block.makeCuboidShape(0.0D, 16.0D, 0.0D, 16.0D, 0.0D, 8.0D);
    protected static final VoxelShape EAST_SHAPE  = Block.makeCuboidShape(8.0D, 16.0D, 0.0D, 16.0D, 0.0D, 16.0D);
    protected static final VoxelShape SOUTH_SHAPE = Block.makeCuboidShape(0.0D, 16.0D, 16.0D, 16.0D, 0.0D, 8.0D);
    protected static final VoxelShape WEST_SHAPE  = Block.makeCuboidShape(0.0D, 16.0D, 0.0D, 8.0D, 0.0D, 16.0D);

    protected static final VoxelShape NORTH_OUTER_SHAPE  = Block.makeCuboidShape(0.0D, 16.0D, 0.0D, 8.0D, 0.0D, 8.0D);
    protected static final VoxelShape EAST_OUTER_SHAPE  = Block.makeCuboidShape(8.0D, 16.0D, 0.0D, 16.0D, 0.0D, 8.0D);
    protected static final VoxelShape SOUTH_OUTER_SHAPE  = Block.makeCuboidShape(8.0D, 16.0D, 16.0D, 16.0D, 0.0D, 8.0D);
    protected static final VoxelShape WEST_OUTER_SHAPE  = Block.makeCuboidShape(0.0D, 16.0D, 8.0D, 8.0D, 0.0D, 16.0D);

    public BlockCorners(Properties properties) {
        super(properties);
        this.setDefaultState(this.stateContainer.getBaseState().with(WATERLOGGED, false));
    }

    @Override
    @SuppressWarnings("deprecation")
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, IBlockState> builder) {
        builder.add(FACING, WATERLOGGED);
    }

    @Nullable
    @Override
    public IBlockState getStateForPlacement(BlockItemUseContext context) {
        EnumFacing enumfacing = context.getFace();
        IFluidState ifluidstate = context.getWorld().getFluidState(context.getPos());
        return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing()).with(WATERLOGGED, Boolean.valueOf(ifluidstate.getFluid() == Fluids.WATER));
    }

    @Override
    public VoxelShape getShape(IBlockState state, IBlockReader worldIn, BlockPos pos) {
        EnumFacing enumFacing = state.get(FACING);
        switch (enumFacing) {
            case WEST:
                return getWestShape();
            case EAST:
                return getEastShape();
            case SOUTH:
                return getSouthShape();
            default:
                return getNorthShape();
        }
    }

    public static VoxelShape getNorthShape() {
        return (VoxelShape) VoxelShapes.or(NORTH_SHAPE, WEST_OUTER_SHAPE);
    }

    public static VoxelShape getEastShape() {
        return (VoxelShape) VoxelShapes.or(EAST_SHAPE, NORTH_OUTER_SHAPE);
    }

    public static VoxelShape getWestShape() {
        return (VoxelShape) VoxelShapes.or(WEST_SHAPE, SOUTH_OUTER_SHAPE);
    }

    public static VoxelShape getSouthShape() {
        return (VoxelShape) VoxelShapes.or(SOUTH_SHAPE, EAST_OUTER_SHAPE);
    }

    @Override
    public IBlockState updatePostPlacement(IBlockState stateIn, EnumFacing facing, IBlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
        if (stateIn.get(WATERLOGGED)) {
            worldIn.getPendingFluidTicks().scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickRate(worldIn));
        }
        return super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
    }

    @Override
    public Fluid pickupFluid(IWorld worldIn, BlockPos pos, IBlockState state) {
        if (state.get(WATERLOGGED)) {
            worldIn.setBlockState(pos, state.with(WATERLOGGED, Boolean.valueOf(false)), 3);
            return Fluids.WATER;
        } else {
            return Fluids.EMPTY;
        }
    }

    @Override
    @SuppressWarnings("deprecation")
    public IFluidState getFluidState(IBlockState state) {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
    }

    @Override
    public boolean canContainFluid(IBlockReader worldIn, BlockPos pos, IBlockState state, Fluid fluidIn) {
        return !state.get(WATERLOGGED) && fluidIn == Fluids.WATER;
    }

    @Override
    public boolean receiveFluid(IWorld worldIn, BlockPos pos, IBlockState state, IFluidState fluidStateIn) {
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
