
package net.mcreator.tensurareimagined.client.screens;

import org.checkerframework.checker.units.qual.h;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.client.event.RenderGuiEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.client.Minecraft;

import net.mcreator.tensurareimagined.network.TensurareimaginedModVariables;

@Mod.EventBusSubscriber({Dist.CLIENT})
public class SkillbarOverlay {
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void eventHandler(RenderGuiEvent.Pre event) {
		int w = event.getWindow().getGuiScaledWidth();
		int h = event.getWindow().getGuiScaledHeight();
		int posX = w / 2;
		int posY = h / 2;
		Level _world = null;
		double _x = 0;
		double _y = 0;
		double _z = 0;
		Player entity = Minecraft.getInstance().player;
		if (entity != null) {
			_world = entity.level;
			_x = entity.getX();
			_y = entity.getY();
			_z = entity.getZ();
		}
		Level world = _world;
		double x = _x;
		double y = _y;
		double z = _z;
		if (true) {
			Minecraft.getInstance().font.draw(event.getPoseStack(), "-", posX + -34, posY + 64, -1);
			Minecraft.getInstance().font.draw(event.getPoseStack(), "-", posX + 29, posY + 64, -1);
			Minecraft.getInstance().font.draw(event.getPoseStack(),
					"" + ((entity.getCapability(TensurareimaginedModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new TensurareimaginedModVariables.PlayerVariables())).Skill1) + "",
					posX + -25, posY + 64, -52429);
			Minecraft.getInstance().font.draw(event.getPoseStack(),
					"" + ((entity.getCapability(TensurareimaginedModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new TensurareimaginedModVariables.PlayerVariables())).Skill2) + "",
					posX + -79, posY + 64, -1);
			Minecraft.getInstance().font.draw(event.getPoseStack(),
					"" + ((entity.getCapability(TensurareimaginedModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new TensurareimaginedModVariables.PlayerVariables())).Skill3) + "",
					posX + 38, posY + 64, -1);
		}
	}
}
