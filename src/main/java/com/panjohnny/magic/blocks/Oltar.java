package com.panjohnny.magic.blocks;

import com.panjohnny.magic.PJMagic;
import com.panjohnny.magic.blocks.entities.OltarBlockEntity;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class Oltar extends BlockWithEntity {
    public static final Identifier IDENTIFIER = new Identifier(PJMagic.MOD_ID, "oltar");
    protected Oltar(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        // Hmmmm...
        if(hand == Hand.MAIN_HAND) {
            if (world.getBlockEntity(pos) instanceof OltarBlockEntity entity)
            {
                if(entity.hasStack()) {
                    entity.reset(player);
                } else if(!player.getInventory().getMainHandStack().isEmpty()){
                    ItemStack h = player.getInventory().getMainHandStack();
                    ItemStack h2 = h.copy();

                    entity.setStack(h2);

                    new Thread(() -> {
                        try {
                            Thread.sleep(1000);
                            entity.convert(world, pos);
                        } catch (InterruptedException ignore) {
                        }
                    });

                    h.setCount(0);
                }
            }
        }
        return ActionResult.PASS;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
         return VoxelShapes.cuboid(0.2, 0, 0.2, 0.8, 0.7, 0.8);
    }


    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new OltarBlockEntity(pos, state);
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }
}
