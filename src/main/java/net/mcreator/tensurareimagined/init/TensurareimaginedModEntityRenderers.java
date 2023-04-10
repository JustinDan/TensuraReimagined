
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.tensurareimagined.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.tensurareimagined.client.renderer.ShlimeRenderer;
import net.mcreator.tensurareimagined.client.renderer.SevererbullettestRenderer;
import net.mcreator.tensurareimagined.client.renderer.SevererRangedRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class TensurareimaginedModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(TensurareimaginedModEntities.SHLIME.get(), ShlimeRenderer::new);
		event.registerEntityRenderer(TensurareimaginedModEntities.SEVERER_RANGED.get(), SevererRangedRenderer::new);
		event.registerEntityRenderer(TensurareimaginedModEntities.SEVERERBULLETTEST.get(), SevererbullettestRenderer::new);
	}
}
