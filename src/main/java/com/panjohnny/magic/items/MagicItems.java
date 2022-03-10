package com.panjohnny.magic.items;

import com.panjohnny.magic.blocks.MagicBlocks;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class MagicItems {
    public static final ItemGroup MAGIC_GROUP_BLOCKS = FabricItemGroupBuilder.build(
            new Identifier("tutorial", "general"),
            () -> new ItemStack(MagicBlocks.OLTAR));

    public static void register() {

    }
}
