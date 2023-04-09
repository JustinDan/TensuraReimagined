
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.tensurareimagined.init;

import org.lwjgl.glfw.GLFW;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import net.mcreator.tensurareimagined.network.UseSkill1Message;
import net.mcreator.tensurareimagined.network.SkillMenuOpenBindMessage;
import net.mcreator.tensurareimagined.TensurareimaginedMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class TensurareimaginedModKeyMappings {
	public static final KeyMapping SKILL_MENU_OPEN_BIND = new KeyMapping("key.tensurareimagined.skill_menu_open_bind", GLFW.GLFW_KEY_B,
			"key.categories.misc") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				TensurareimaginedMod.PACKET_HANDLER.sendToServer(new SkillMenuOpenBindMessage(0, 0));
				SkillMenuOpenBindMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping USE_SKILL_1 = new KeyMapping("key.tensurareimagined.use_skill_1", GLFW.GLFW_KEY_C, "key.categories.misc") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				TensurareimaginedMod.PACKET_HANDLER.sendToServer(new UseSkill1Message(0, 0));
				UseSkill1Message.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(SKILL_MENU_OPEN_BIND);
		event.register(USE_SKILL_1);
	}

	@Mod.EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(TickEvent.ClientTickEvent event) {
			if (Minecraft.getInstance().screen == null) {
				SKILL_MENU_OPEN_BIND.consumeClick();
				USE_SKILL_1.consumeClick();
			}
		}
	}
}
