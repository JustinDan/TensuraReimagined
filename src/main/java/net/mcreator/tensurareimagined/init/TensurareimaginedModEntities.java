
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.tensurareimagined.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

import net.mcreator.tensurareimagined.entity.ShlimeEntity;
import net.mcreator.tensurareimagined.entity.SevererbullettestEntity;
import net.mcreator.tensurareimagined.entity.SevererRangedEntity;
import net.mcreator.tensurareimagined.TensurareimaginedMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class TensurareimaginedModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, TensurareimaginedMod.MODID);
	public static final RegistryObject<EntityType<ShlimeEntity>> SHLIME = register("shlime",
			EntityType.Builder.<ShlimeEntity>of(ShlimeEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(3).setCustomClientFactory(ShlimeEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<SevererRangedEntity>> SEVERER_RANGED = register("projectile_severer_ranged",
			EntityType.Builder.<SevererRangedEntity>of(SevererRangedEntity::new, MobCategory.MISC).setCustomClientFactory(SevererRangedEntity::new)
					.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<SevererbullettestEntity>> SEVERERBULLETTEST = register("severerbullettest",
			EntityType.Builder.<SevererbullettestEntity>of(SevererbullettestEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(SevererbullettestEntity::new).fireImmune().sized(0.6f, 1.8f));

	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			ShlimeEntity.init();
			SevererbullettestEntity.init();
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(SHLIME.get(), ShlimeEntity.createAttributes().build());
		event.put(SEVERERBULLETTEST.get(), SevererbullettestEntity.createAttributes().build());
	}
}
