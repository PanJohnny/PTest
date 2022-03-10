package com.panjohnny.magic.blocks.entities;

import com.panjohnny.magic.blocks.MagicBlockTypes;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Position;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

import java.util.Arrays;

public class OltarBlockEntity extends BlockEntity {
    private long converting = 0L;
    private boolean conv = false;
    public OltarBlockEntity(BlockPos pos, BlockState state) {
        super(MagicBlockTypes.OLTAR, pos, state);
    }

    private ItemStack stack = Items.POTATO.getDefaultStack();
    public ItemStack getStack() {
        return stack;
    }

    public void setStack(ItemStack stack) {
        this.stack = stack;
        if(hasStack()) {
            conv = true;
        } else {
            conv = false;
        }
    }

    public boolean hasStack() {
        return getStack() != null;
    }

    public void reset(PlayerEntity player) {
        player.getInventory().insertStack(getStack());
        setStack(null);
    }

    public boolean isConverting() {
        return conv;
    }

    public void convert(World world, BlockPos position) {
        if(!hasStack())
            return;

        if (ItemGroup.BREWING.equals(stack.getItem().getGroup())) {
            stack = Items.BREWING_STAND.getDefaultStack();
        } else if (ItemGroup.COMBAT.equals(stack.getItem().getGroup())) {
            stack = Items.ACACIA_BOAT.getDefaultStack();
        } else if (ItemGroup.FOOD.equals(stack.getItem().getGroup())) {
            stack = Items.APPLE.getDefaultStack();
        } else {
            stack = Items.AIR.getDefaultStack();
        }

        ItemEntity entity = new ItemEntity(world, position.getX(),position.getY(),position.getZ() ,stack);
        world.spawnEntity(entity);
        stack = null;
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        nbt.put("stack", stack.getNbt());
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        if(nbt.contains("stack"))
            stack = ItemStack.fromNbt((NbtCompound) nbt.get("stack"));
    }
}
