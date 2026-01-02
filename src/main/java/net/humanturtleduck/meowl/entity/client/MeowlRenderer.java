package net.humanturtleduck.meowl.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.humanturtleduck.meowl.entity.custom.MeowlEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.humanturtleduck.meowl.MeowlMod;

public class MeowlRenderer extends MobRenderer<MeowlEntity, MeowlModel<MeowlEntity>> {
    public MeowlRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new MeowlModel<>(pContext.bakeLayer(ModModelLayers.meowl_layer)), 2f);
    }

    @Override
    public ResourceLocation getTextureLocation(MeowlEntity pEntity) {
        return ResourceLocation.fromNamespaceAndPath(MeowlMod.MOD_ID,"textures/entity/meowltext.png");
    }

    @Override
    public void render(MeowlEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {
        if(pEntity.isBaby()) {
            pMatrixStack.scale(0.5f, 0.25f, 0.5f);
        }


        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}