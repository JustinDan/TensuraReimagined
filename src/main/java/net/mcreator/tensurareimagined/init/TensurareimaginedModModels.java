
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.tensurareimagined.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.tensurareimagined.client.model.ModelSlime3;
import net.mcreator.tensurareimagined.client.model.ModelShlime;
import net.mcreator.tensurareimagined.client.model.ModelSevererBullet_Converted;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class TensurareimaginedModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(ModelShlime.LAYER_LOCATION, ModelShlime::createBodyLayer);
		event.registerLayerDefinition(ModelSlime3.LAYER_LOCATION, ModelSlime3::createBodyLayer);
		event.registerLayerDefinition(ModelSevererBullet_Converted.LAYER_LOCATION, ModelSevererBullet_Converted::createBodyLayer);
	}
}
