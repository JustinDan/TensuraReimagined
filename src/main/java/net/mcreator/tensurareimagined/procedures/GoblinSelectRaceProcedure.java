package net.mcreator.tensurareimagined.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import net.mcreator.tensurareimagined.network.TensurareimaginedModVariables;
import net.mcreator.tensurareimagined.TensurareimaginedMod;

public class GoblinSelectRaceProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(TensurareimaginedModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TensurareimaginedModVariables.PlayerVariables())).PlayerRace == 0) {
			if (entity instanceof Player _player)
				_player.closeContainer();
			{
				double _setval = 3;
				entity.getCapability(TensurareimaginedModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PlayerRace = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				String _setval = "Goblin";
				entity.getCapability(TensurareimaginedModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Race = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if ((entity.getCapability(TensurareimaginedModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TensurareimaginedModVariables.PlayerVariables())).MagiculesStart == false) {
				{
					double _setval = Math.round(Mth.nextDouble(RandomSource.create(), 1000, 4000));
					entity.getCapability(TensurareimaginedModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.MaxMagicules = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = 1;
					entity.getCapability(TensurareimaginedModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.MagiculesMultiplier = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				TensurareimaginedMod.queueServerWork(20, () -> {
					{
						double _setval = (entity.getCapability(TensurareimaginedModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TensurareimaginedModVariables.PlayerVariables())).MaxMagicules + 1;
						entity.getCapability(TensurareimaginedModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.MaxMagicules = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (entity.getCapability(TensurareimaginedModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TensurareimaginedModVariables.PlayerVariables())).MagiculesMultiplier + 1;
						entity.getCapability(TensurareimaginedModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.MagiculesMultiplier = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				});
				{
					double _setval = (entity.getCapability(TensurareimaginedModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TensurareimaginedModVariables.PlayerVariables())).MaxMagicules;
					entity.getCapability(TensurareimaginedModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.Magicules = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			OrcEffectsProcedure.execute(entity);
		} else {
			TensurareimaginedMod.LOGGER.info("A race has already been picked");
		}
	}
}
