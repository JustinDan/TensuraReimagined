package net.mcreator.tensurareimagined.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.tensurareimagined.network.TensurareimaginedModVariables;

public class SelectSevererSkillProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			String _setval = "Severer";
			entity.getCapability(TensurareimaginedModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.Skill1 = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
