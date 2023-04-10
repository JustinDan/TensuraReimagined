package net.mcreator.tensurareimagined.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.tensurareimagined.network.TensurareimaginedModVariables;

public class SelectSkill3Procedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			double _setval = 3;
			entity.getCapability(TensurareimaginedModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.SkillSelect = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
