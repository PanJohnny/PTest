package com.panjohnny.magic.blocks;

import com.panjohnny.magic.PJMagic;
import com.panjohnny.magic.blocks.entities.OltarBlockEntityRenderer;
import com.panjohnny.magic.items.MagicItems;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;


public class MagicBlocks {
    public static final Material MAGIC_BLOCK_MATERIAL = new Material(MapColor.DULL_PINK, false, true, false, false, false, false, PistonBehavior.IGNORE);

    public static final Oltar OLTAR = new Oltar(FabricBlockSettings.of(MAGIC_BLOCK_MATERIAL).luminance(2).dropsNothing().allowsSpawning(((state, world, pos, type) -> false)).collidable(true).sounds(BlockSoundGroup.ANCIENT_DEBRIS).nonOpaque().strength(4.5f, 3.4f));
    public static final Item OLTAR_ITEM = new BlockItem(OLTAR, new FabricItemSettings().group(MagicItems.MAGIC_GROUP_BLOCKS));

    public static void register() {
        Registry.register(Registry.BLOCK, Oltar.IDENTIFIER, OLTAR);
        Registry.register(Registry.ITEM, Oltar.IDENTIFIER, OLTAR_ITEM);
        Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(PJMagic.MOD_ID, "oltar_block_entity"), MagicBlockTypes.OLTAR);
        BlockEntityRendererRegistry.register(MagicBlockTypes.OLTAR, (ctx -> new OltarBlockEntityRenderer()));
    }
}
