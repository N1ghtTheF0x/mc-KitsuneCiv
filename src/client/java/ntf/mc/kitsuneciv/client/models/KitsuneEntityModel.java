package ntf.mc.kitsuneciv.client.models;

// Made with Blockbench 5.1.2
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.npc.villager.Villager;
import ntf.mc.kitsuneciv.client.states.KitsuneEntityRenderState;
   
public class KitsuneEntityModel extends EntityModel<KitsuneEntityRenderState> {
	private final ModelPart body;
	private final ModelPart left_leg;
	private final ModelPart left_arm;
	private final ModelPart right_arm;
	private final ModelPart right_leg;
	private final ModelPart head;
    public KitsuneEntityModel(ModelPart root) {
        super(root);
        body = root.getChild("body");
		left_leg = body.getChild("left_leg");
		left_arm = body.getChild("left_arm");
		right_arm = body.getChild("right_arm");
		right_leg = body.getChild("right_leg");
		head = body.getChild("head");
    }
    public static LayerDefinition getTextureModelData() {
        MeshDefinition modelData = new MeshDefinition();
        PartDefinition root = modelData.getRoot();
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 12).addBox(-3.0F, -12.0F, -1.5F, 6.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 12.0F, 0.0F));

		PartDefinition left_leg = body.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(30, 30).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.1F))
		.texOffs(18, 12).addBox(-1.5F, 3.5F, -1.5F, 3.0F, 8.0F, 3.0F, new CubeDeformation(-0.2F))
		.texOffs(36, 0).addBox(-1.5F, 11.0F, -2.5F, 3.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(1.5F, 0.0F, 0.0F));

		PartDefinition left_arm = body.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(24, 0).addBox(-0.8F, -0.9F, -1.5F, 3.0F, 7.0F, 3.0F, new CubeDeformation(-0.3F))
		.texOffs(0, 27).addBox(-0.8F, 5.3F, -1.5F, 3.0F, 7.0F, 3.0F, new CubeDeformation(-0.5F)), PartPose.offset(3.5F, -11.4F, 0.0F));

		PartDefinition right_arm = body.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(30, 10).addBox(-2.2F, -0.9F, -1.5F, 3.0F, 7.0F, 3.0F, new CubeDeformation(-0.3F))
		.texOffs(30, 20).addBox(-2.2F, 5.3F, -1.5F, 3.0F, 7.0F, 3.0F, new CubeDeformation(-0.5F)), PartPose.offset(-3.5F, -11.4F, 0.0F));

		PartDefinition right_leg = body.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(12, 34).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.1F))
		.texOffs(18, 23).addBox(-1.5F, 3.5F, -1.5F, 3.0F, 8.0F, 3.0F, new CubeDeformation(-0.2F))
		.texOffs(36, 5).addBox(-1.5F, 11.0F, -2.5F, 3.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.5F, 0.0F, 0.0F));

		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -6.0F, -3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -12.0F, 0.0F));
        return LayerDefinition.create(modelData, 64, 64);
    }
	
	@Override
	public void setupAnim(KitsuneEntityRenderState state) {
		super.setupAnim(state);

		// idk why but mojang uses this value to "fix" head rotation I suppose?
		final float oddHeadConstant = 0.017453292F;

		head.xRot = state.xRot * Mth.RAD_TO_DEG * oddHeadConstant;
		head.yRot = state.yRot * Mth.RAD_TO_DEG * oddHeadConstant;

		final float swingSpeed = 0.5f;
		final float swingDistance = 1.4f;

		left_leg.xRot = Mth.cos(state.walkAnimationPos * swingSpeed + Mth.PI) * swingDistance * state.walkAnimationSpeed;
		right_leg.xRot = Mth.cos(state.walkAnimationPos * swingSpeed) * swingDistance* state.walkAnimationSpeed;

		left_arm.xRot = left_leg.xRot;
		right_arm.xRot = right_leg.xRot;
	}
}