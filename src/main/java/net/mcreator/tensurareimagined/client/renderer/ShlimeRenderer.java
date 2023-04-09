
package net.mcreator.tensurareimagined.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.tensurareimagined.entity.ShlimeEntity;
import net.mcreator.tensurareimagined.client.model.ModelShlime;

public class ShlimeRenderer extends MobRenderer<ShlimeEntity, ModelShlime<ShlimeEntity>> {
	public ShlimeRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelShlime(context.bakeLayer(ModelShlime.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(ShlimeEntity entity) {
		return new ResourceLocation("tensurareimagined:textures/entities/texture.png");
	}
}
