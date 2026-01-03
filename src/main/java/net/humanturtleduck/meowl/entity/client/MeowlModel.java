package net.humanturtleduck.meowl.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.humanturtleduck.meowl.entity.animations.ModAnimationsDefinitions;
import net.humanturtleduck.meowl.entity.custom.MeowlEntity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

public class MeowlModel<T extends Entity> extends HierarchicalModel<T> {

	private final ModelPart meowl;
	private final ModelPart uppermeowl;
	private final ModelPart h_head;
	private final ModelPart body;
	private final ModelPart leftwing;
	private final ModelPart rightwing;
	private final ModelPart leftleg;
	private final ModelPart rightleg;

	public MeowlModel(ModelPart root) {
		this.meowl = root.getChild("meowl");
		this.uppermeowl = this.meowl.getChild("uppermeowl");
		this.h_head = this.uppermeowl.getChild("h_head");
		this.body = this.uppermeowl.getChild("body");
		this.leftwing = this.body.getChild("leftwing");
		this.rightwing = this.body.getChild("rightwing");
		this.leftleg = this.uppermeowl.getChild("leftleg");
		this.rightleg = this.uppermeowl.getChild("rightleg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition meowl = partdefinition.addOrReplaceChild("meowl", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition uppermeowl = meowl.addOrReplaceChild("uppermeowl", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition h_head = uppermeowl.addOrReplaceChild("h_head", CubeListBuilder.create().texOffs(0, 14).addBox(-1.75F, -2.5F, -1.75F, 3.5F, 2.5F, 3.5F, new CubeDeformation(0.0F))
		.texOffs(16, 18).addBox(1.25F, -1.0F, -1.05F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -6.0F, 0.0F));

		PartDefinition ear_r1 = h_head.addOrReplaceChild("ear_r1", CubeListBuilder.create().texOffs(6, 21).addBox(1.25F, -1.25F, -1.0F, 0.75F, 1.25F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, -2.5F, 0.0F, -1.5708F, 0.0F));

		PartDefinition ear_r2 = h_head.addOrReplaceChild("ear_r2", CubeListBuilder.create().texOffs(0, 21).addBox(1.25F, -1.25F, -1.0F, 0.75F, 1.25F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, -0.75F, 0.0F, -1.5708F, 0.0F));

		PartDefinition body = uppermeowl.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -1.75F, -2.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.25F, 0.0F));

		PartDefinition lowertorso_r1 = body.addOrReplaceChild("lowertorso_r1", CubeListBuilder.create().texOffs(0, 7).addBox(-2.0F, -3.0F, -2.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 3.0F, 0.0F, 0.0F, 0.0F, 0.3054F));

		PartDefinition tail_r1 = body.addOrReplaceChild("tail_r1", CubeListBuilder.create().texOffs(16, 0).addBox(-2.0F, -3.0F, -2.0F, 1.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, 3.5F, 0.0F, 0.0F, 0.0F, 0.5236F));

		PartDefinition leftwing = body.addOrReplaceChild("leftwing", CubeListBuilder.create(), PartPose.offset(0.0F, -1.75F, 2.0F));

		PartDefinition wing_r1 = leftwing.addOrReplaceChild("wing_r1", CubeListBuilder.create().texOffs(16, 8).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 4.0F, 0.5F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.1309F));

		PartDefinition rightwing = body.addOrReplaceChild("rightwing", CubeListBuilder.create(), PartPose.offset(0.0F, -1.75F, -2.0F));

		PartDefinition wing_r2 = rightwing.addOrReplaceChild("wing_r2", CubeListBuilder.create().texOffs(16, 13).addBox(-2.0F, 0.0F, -0.5F, 4.0F, 4.0F, 0.5F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.1309F));

		PartDefinition leftleg = uppermeowl.addOrReplaceChild("leftleg", CubeListBuilder.create().texOffs(18, 21).addBox(0.0F, -1.0F, -0.5F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(20, 21).addBox(0.0F, 1.0F, -0.5F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, -1.0F, 1.0F));

		PartDefinition rightleg = uppermeowl.addOrReplaceChild("rightleg", CubeListBuilder.create().texOffs(12, 21).addBox(0.0F, -1.0F, -0.5F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(14, 21).addBox(0.0F, 1.0F, -0.5F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, -1.0F, -1.0F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.applyHeadRotation(netHeadYaw, headPitch, ageInTicks);
		this.animateWalk(ModAnimationsDefinitions.MEOWL_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
		this.animate(((MeowlEntity) entity).idleAnimationState, ModAnimationsDefinitions.MEOWL_WINGIDLE, ageInTicks, 1f);

	}

	private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
		pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
		pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 45.0F);

		this.h_head.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
		this.h_head.zRot = pHeadPitch * ((float)Math.PI / 180F);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		meowl.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
	@Override
	public ModelPart root() {
		return meowl;
	}
}