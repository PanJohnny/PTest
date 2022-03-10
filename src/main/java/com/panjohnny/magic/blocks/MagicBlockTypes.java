package com.panjohnny.magic.blocks;

import com.panjohnny.magic.blocks.entities.OltarBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;

public class MagicBlockTypes {
    public static final BlockEntityType<OltarBlockEntity> OLTAR = FabricBlockEntityTypeBuilder.create(OltarBlockEntity::new, MagicBlocks.OLTAR).build();
}
