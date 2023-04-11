package net.mcreator.tensurareimagined.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.tensurareimagined.network.TensurareimaginedModVariables;

public class SkillMenuMainGuiMagiculesValueProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "Magicules: " + Math.round((entity.getCapability(TensurareimaginedModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TensurareimaginedModVariables.PlayerVariables())).Magicules);
	}
}
