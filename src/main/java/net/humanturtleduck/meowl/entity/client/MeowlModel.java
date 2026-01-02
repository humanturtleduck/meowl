package net.humanturtleduck.meowl.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.Entity;

public class MeowlModel<T extends Entity> extends HierarchicalModel<T> {

	private final ModelPart hitbox;
	private final ModelPart meowl;
	private final ModelPart rightleg;
	private final ModelPart leftleg;
	private final ModelPart uppermeowl;
	private final ModelPart h_head;
	private final ModelPart body;
	private final ModelPart leftwing;
	private final ModelPart rightwing;

	public MeowlModel(ModelPart root) {
		this.hitbox = root.getChild("hitbox");
		this.meowl = root.getChild("meowl");
		this.rightleg = this.meowl.getChild("rightleg");
		this.leftleg = this.meowl.getChild("leftleg");
		this.uppermeowl = this.meowl.getChild("uppermeowl");
		this.h_head = this.uppermeowl.getChild("h_head");
		this.body = this.uppermeowl.getChild("body");
		this.leftwing = this.body.getChild("leftwing");
		this.rightwing = this.body.getChild("rightwing");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition hitbox = partdefinition.addOrReplaceChild("hitbox", CubeListBuilder.create().texOffs(0, 4).addBox(-2.0F, -8.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition meowl = partdefinition.addOrReplaceChild("meowl", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition rightleg = meowl.addOrReplaceChild("rightleg", CubeListBuilder.create().texOffs(20, 26).addBox(0.0F, -1.0F, -0.5F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(21, 31).addBox(0.0F, 1.0F, -0.5F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, -1.0F, -1.0F));

		PartDefinition leftleg = meowl.addOrReplaceChild("leftleg", CubeListBuilder.create().texOffs(21, 27).addBox(0.0F, -1.0F, -0.5F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(26, 27).addBox(0.0F, 1.0F, -0.5F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, -1.0F, 1.0F));

		PartDefinition uppermeowl = meowl.addOrReplaceChild("uppermeowl", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition h_head = uppermeowl.addOrReplaceChild("h_head", CubeListBuilder.create().texOffs(4, 0).addBox(-1.75F, -2.5F, -1.75F, 3.5F, 2.5F, 3.5F, new CubeDeformation(0.0F))
		.texOffs(25, 0).addBox(1.25F, -1.0F, -1.05F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -6.0F, 0.0F));

		PartDefinition ear_r1 = h_head.addOrReplaceChild("ear_r1", CubeListBuilder.create().texOffs(26, 28).addBox(1.25F, -1.25F, -1.0F, 0.75F, 1.25F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, -2.5F, 0.0F, -1.5708F, 0.0F));

		PartDefinition ear_r2 = h_head.addOrReplaceChild("ear_r2", CubeListBuilder.create().texOffs(19, 28).addBox(1.25F, -1.25F, -1.0F, 0.75F, 1.25F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, -0.75F, 0.0F, -1.5708F, 0.0F));

		PartDefinition body = uppermeowl.addOrReplaceChild("body", CubeListBuilder.create().texOffs(8, 8).addBox(-2.0F, -1.75F, -2.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.25F, 0.0F));

		PartDefinition lowertorso_r1 = body.addOrReplaceChild("lowertorso_r1", CubeListBuilder.create().texOffs(8, 8).addBox(-2.0F, -3.0F, -2.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 3.0F, 0.0F, 0.0F, 0.0F, 0.3054F));

		PartDefinition tail_r1 = body.addOrReplaceChild("tail_r1", CubeListBuilder.create().texOffs(0, 24).addBox(-2.0F, -3.0F, -2.0F, 1.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, 3.5F, 0.0F, 0.0F, 0.0F, 0.5236F));

		PartDefinition leftwing = body.addOrReplaceChild("leftwing", CubeListBuilder.create(), PartPose.offset(0.0F, -1.75F, 2.0F));

		PartDefinition wing_r1 = leftwing.addOrReplaceChild("wing_r1", CubeListBuilder.create().texOffs(20, 20).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 4.0F, 0.5F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.1309F));

		PartDefinition rightwing = body.addOrReplaceChild("rightwing", CubeListBuilder.create(), PartPose.offset(0.0F, -1.75F, -2.0F));

		PartDefinition wing_r2 = rightwing.addOrReplaceChild("wing_r2", CubeListBuilder.create().texOffs(13, 20).mirror().addBox(-2.0F, 0.0F, -0.5F, 4.0F, 4.0F, 0.5F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.1309F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		hitbox.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		meowl.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return null;
	}
}