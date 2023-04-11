
package net.mcreator.tensurareimagined.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.tensurareimagined.entity.ShlimeEntity;
import net.mcreator.tensurareimagined.client.model.ModelSlime3;

public class ShlimeRenderer extends MobRenderer<ShlimeEntity, ModelSlime3<ShlimeEntity>> {
	public ShlimeRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelSlime3(context.bakeLayer(ModelSlime3.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(ShlimeEntity entity) {
		return new ResourceLocation("tensurareimagined:textures/entities/slime3.png");
	}
}
