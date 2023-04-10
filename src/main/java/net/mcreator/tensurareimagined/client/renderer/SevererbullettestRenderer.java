
package net.mcreator.tensurareimagined.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.tensurareimagined.entity.SevererbullettestEntity;
import net.mcreator.tensurareimagined.client.model.ModelSevererBullet_Converted;

public class SevererbullettestRenderer extends MobRenderer<SevererbullettestEntity, ModelSevererBullet_Converted<SevererbullettestEntity>> {
	public SevererbullettestRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelSevererBullet_Converted(context.bakeLayer(ModelSevererBullet_Converted.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(SevererbullettestEntity entity) {
		return new ResourceLocation("tensurareimagined:textures/entities/severer2test.png");
	}
}
