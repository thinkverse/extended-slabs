package dev.thinkverse.extendedslabs.blocks.path;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.state.IBlockState;
import net.minecraft.state.properties.Half;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

import java.util.stream.IntStream;

public class BlockPathStairs extends BlockStairs {
    protected static final VoxelShape AABB_SLAB_TOP = BlockPathSlab.TOP_SHAPE;
    protected static final VoxelShape AABB_SLAB_BOTTOM = BlockPathSlab.BOTTOM_SHAPE;
    protected static final VoxelShape field_196512_A = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 8.0D, 7.0D, 8.0D);
    protected static final VoxelShape field_196513_B = Block.makeCuboidShape(0.0D, 0.0D, 8.0D, 8.0D, 7.0D, 16.0D);
    protected static final VoxelShape field_196514_C = Block.makeCuboidShape(0.0D, 7.0D, 0.0D, 8.0D, 15.0D, 8.0D);
    protected static final VoxelShape field_196515_D = Block.makeCuboidShape(0.0D, 7.0D, 8.0D, 8.0D, 15.0D, 16.0D);
    protected static final VoxelShape field_196516_E = Block.makeCuboidShape(8.0D, 0.0D, 0.0D, 16.0D, 7.0D, 8.0D);
    protected static final VoxelShape field_196517_F = Block.makeCuboidShape(8.0D, 0.0D, 8.0D, 16.0D, 7.0D, 16.0D);
    protected static final VoxelShape field_196518_G = Block.makeCuboidShape(8.0D, 7.0D, 0.0D, 16.0D, 15.0D, 8.0D);
    protected static final VoxelShape field_196519_H = Block.makeCuboidShape(8.0D, 7.0D, 8.0D, 16.0D, 15.0D, 16.0D);
    protected static final VoxelShape[] field_196520_I = func_199779_a(AABB_SLAB_TOP, field_196512_A, field_196516_E, field_196513_B, field_196517_F);
    protected static final VoxelShape[] field_196521_J = func_199779_a(AABB_SLAB_BOTTOM, field_196514_C, field_196518_G, field_196515_D, field_196519_H);
    private static final int[] field_196522_K = new int[]{12, 5, 3, 10, 14, 13, 7, 11, 13, 7, 11, 14, 8, 4, 1, 2, 4, 1, 2, 8};

    public BlockPathStairs(IBlockState state, Block.Properties builder) {
        super(state, builder);
    }

    @Override
    public VoxelShape getShape(IBlockState state, IBlockReader worldIn, BlockPos pos) {
        return (state.get(HALF) == Half.TOP ? field_196520_I : field_196521_J)[field_196522_K[this.func_196511_x(state)]];
    }

    private static VoxelShape[] func_199779_a(VoxelShape p_199779_0_, VoxelShape p_199779_1_, VoxelShape p_199779_2_, VoxelShape p_199779_3_, VoxelShape p_199779_4_) {
        return IntStream.range(0, 16).mapToObj((p_199780_5_) -> {
            return func_199781_a(p_199780_5_, p_199779_0_, p_199779_1_, p_199779_2_, p_199779_3_, p_199779_4_);
        }).toArray((p_199778_0_) -> {
            return new VoxelShape[p_199778_0_];
        });
    }

    private static VoxelShape func_199781_a(int p_199781_0_, VoxelShape p_199781_1_, VoxelShape p_199781_2_, VoxelShape p_199781_3_, VoxelShape p_199781_4_, VoxelShape p_199781_5_) {
        VoxelShape voxelshape = p_199781_1_;
        if ((p_199781_0_ & 1) != 0) {
            voxelshape = VoxelShapes.or(p_199781_1_, p_199781_2_);
        }

        if ((p_199781_0_ & 2) != 0) {
            voxelshape = VoxelShapes.or(voxelshape, p_199781_3_);
        }

        if ((p_199781_0_ & 4) != 0) {
            voxelshape = VoxelShapes.or(voxelshape, p_199781_4_);
        }

        if ((p_199781_0_ & 8) != 0) {
            voxelshape = VoxelShapes.or(voxelshape, p_199781_5_);
        }

        return voxelshape;
    }

    private int func_196511_x(IBlockState p_196511_1_) {
        return p_196511_1_.get(SHAPE).ordinal() * 4 + p_196511_1_.get(FACING).getHorizontalIndex();
    }
}
