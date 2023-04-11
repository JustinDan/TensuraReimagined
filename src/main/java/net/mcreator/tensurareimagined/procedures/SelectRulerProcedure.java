package net.mcreator.tensurareimagined.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.tensurareimagined.network.TensurareimaginedModVariables;

public class SelectRulerProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(TensurareimaginedModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TensurareimaginedModVariables.PlayerVariables())).SkillSelect == 1) {
			{
				String _setval = "Ruler";
				entity.getCapability(TensurareimaginedModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Skill1 = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if ((entity.getCapability(TensurareimaginedModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TensurareimaginedModVariables.PlayerVariables())).SkillSelect == 2) {
			{
				String _setval = "Ruler";
				entity.getCapability(TensurareimaginedModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Skill2 = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if ((entity.getCapability(TensurareimaginedModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TensurareimaginedModVariables.PlayerVariables())).SkillSelect == 3) {
			{
				String _setval = "Ruler";
				entity.getCapability(TensurareimaginedModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Skill3 = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
