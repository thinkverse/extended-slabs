package dev.thinkverse.verticalslabsmod.blocks;

import dev.thinkverse.verticalslabsmod.blocks.types.VertSlabType;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.fluid.IFluidState;
import net.minecraft.init.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;

import javax.annotation.Nullable;

public class BlockVerticalSlab extends Block {

    public static final EnumProperty<VertSlabType> TYPE = EnumProperty.create("type", VertSlabType.class);

    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    protected static final VoxelShape NORTH_SHAPE = Block.makeCuboidShape(0.0D, 16.0D, 0.0D, 16.0D, 0.0D, 8.0D);
    protected static final VoxelShape EAST_SHAPE = Block.makeCuboidShape(8.0D, 16.0D, 0.0D, 16.0D, 0.0D, 16.0D);
    protected static final VoxelShape SOUTH_SHAPE = Block.makeCuboidShape(0.0D, 16.0D, 16.0D, 16.0D, 0.0D, 8.0D);
    protected static final VoxelShape WEST_SHAPE = Block.makeCuboidShape(0.0D, 16.0D, 0.0D, 8.0D, 0.0D, 16.0D);

    public BlockVerticalSlab(Block.Properties builder) {
        super(builder);
        this.setDefaultState(this.getDefaultState().with(TYPE, VertSlabType.EAST).with(WATERLOGGED, Boolean.valueOf(false)));
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, IBlockState> builder) {
        builder.add(TYPE, WATERLOGGED);
    }

    @Override
    @SuppressWarnings("deprecation")
    public boolean isFullCube(IBlockState state) {
        return state.get(TYPE) == VertSlabType.DOUBLE;
    }

    @Override
    @SuppressWarnings("deprecation")
    public VoxelShape getShape(IBlockState state, IBlockReader worldIn, BlockPos pos) {
        VertSlabType slabtype = state.get(TYPE);
        switch(slabtype) {
            case DOUBLE:
                return VoxelShapes.fullCube();
            case WEST:
                return WEST_SHAPE;
            case EAST:
                return EAST_SHAPE;
            case SOUTH:
                return SOUTH_SHAPE;
            default:
                return NORTH_SHAPE;
        }
    }

    @Nullable
    @Override
    public IBlockState getStateForPlacement(BlockItemUseContext context) {
        IBlockState iblockstate = context.getWorld().getBlockState(context.getPos());
        if (iblockstate.getBlock() == this) {
            return iblockstate.with(TYPE, VertSlabType.DOUBLE).with(WATERLOGGED, Boolean.valueOf(false));
        } else {
            IFluidState ifluidstate = context.getWorld().getFluidState(context.getPos());
            IBlockState iblockstate1 = this.getDefaultState().with(TYPE, VertSlabType.EAST).with(WATERLOGGED, Boolean.valueOf(ifluidstate.getFluid() == Fluids.WATER));
            EnumFacing enumfacing = context.getNearestLookingDirection();

            switch (enumfacing) {
                case NORTH:
                    return iblockstate1.with(TYPE, VertSlabType.NORTH).with(WATERLOGGED, Boolean.valueOf(ifluidstate.getFluid() == Fluids.WATER));
                case EAST:
                default:
                    return iblockstate1;
                case SOUTH:
                    return iblockstate1.with(TYPE, VertSlabType.SOUTH).with(WATERLOGGED, Boolean.valueOf(ifluidstate.getFluid() == Fluids.WATER));
                case WEST:
                    return iblockstate1.with(TYPE, VertSlabType.WEST).with(WATERLOGGED, Boolean.valueOf(ifluidstate.getFluid() == Fluids.WATER));
            }
        }
    }

    @Override
    @SuppressWarnings("deprecation")
    public IBlockState updatePostPlacement(IBlockState stateIn, EnumFacing facing, IBlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
        if (stateIn.get(WATERLOGGED)) {
            worldIn.getPendingFluidTicks().scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickRate(worldIn));
        }

        return super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
    }

    @Override
    @SuppressWarnings("deprecation")
    public IFluidState getFluidState(IBlockState state) {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
    }
}
