
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.tensurareimagined.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.ForgeSpawnEggItem;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;

import net.mcreator.tensurareimagined.item.SevererRangedItem;
import net.mcreator.tensurareimagined.item.ProofSwordItem;
import net.mcreator.tensurareimagined.item.MagiculeTestStickItem;
import net.mcreator.tensurareimagined.TensurareimaginedMod;

public class TensurareimaginedModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, TensurareimaginedMod.MODID);
	public static final RegistryObject<Item> SHLIME = REGISTRY.register("shlime_spawn_egg",
			() -> new ForgeSpawnEggItem(TensurareimaginedModEntities.SHLIME, -16724737, -10027009,
					new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
	public static final RegistryObject<Item> PROOF_SWORD = REGISTRY.register("proof_sword", () -> new ProofSwordItem());
	public static final RegistryObject<Item> MAGICULE_TEST_STICK = REGISTRY.register("magicule_test_stick", () -> new MagiculeTestStickItem());
	public static final RegistryObject<Item> SEVERER_RANGED = REGISTRY.register("severer_ranged", () -> new SevererRangedItem());
}
