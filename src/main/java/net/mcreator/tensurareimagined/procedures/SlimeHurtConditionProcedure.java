package net.mcreator.tensurareimagined.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.tensurareimagined.init.TensurareimaginedModItems;
import net.mcreator.tensurareimagined.entity.ShlimeEntity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class SlimeHurtConditionProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(Entity entity, Entity sourceentity) {
		execute(null, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
				.getItem() == TensurareimaginedModItems.PROOF_SWORD.get()) != entity instanceof ShlimeEntity) {
			if (event != null && event.isCancelable()) {
				event.setCanceled(true);
			}
		}
	}
}
