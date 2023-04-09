package net.mcreator.tensurareimagined.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.tensurareimagined.network.TensurareimaginedModVariables;
import net.mcreator.tensurareimagined.TensurareimaginedMod;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class MagiculeRegenProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level, event.player);
		}
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(TensurareimaginedModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TensurareimaginedModVariables.PlayerVariables())).Magicules < (entity
						.getCapability(TensurareimaginedModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TensurareimaginedModVariables.PlayerVariables())).MaxMagicules) {
			TensurareimaginedMod.queueServerWork(1, () -> {
				{
					double _setval = (entity.getCapability(TensurareimaginedModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new TensurareimaginedModVariables.PlayerVariables())).Magicules + 1;
					entity.getCapability(TensurareimaginedModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.Magicules = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			});
		}
	}
}
