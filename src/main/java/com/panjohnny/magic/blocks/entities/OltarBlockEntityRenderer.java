package com.panjohnny.magic.blocks.entities;

import net.fabricmc.fabric.api.client.model.BakedModelManagerHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.BlockModelRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.BakedModelManager;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Vec3f;

import java.util.Objects;

public class OltarBlockEntityRenderer implements BlockEntityRenderer<OltarBlockEntity> {
    private final ItemRenderer itemRenderer;

    public OltarBlockEntityRenderer() {
        this.itemRenderer = MinecraftClient.getInstance().getItemRenderer();
    }

    @Override
    public void render(OltarBlockEntity entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        if (!entity.hasStack()) {
            return;
        }
        ItemStack itemStack = entity.getStack();

        matrices.push();

        matrices.translate(0.5, 1, 0.5);
        matrices.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion((Objects.requireNonNull(entity.getWorld()).getTime() + tickDelta)*4));
        itemRenderer.renderItem(itemStack, ModelTransformation.Mode.GROUND, light, overlay, matrices, vertexConsumers, 1);

        matrices.pop();
    }
}
