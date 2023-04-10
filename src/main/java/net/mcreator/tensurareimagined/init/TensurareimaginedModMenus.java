
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.tensurareimagined.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import net.mcreator.tensurareimagined.world.inventory.UniqueSkillGuiPage3Menu;
import net.mcreator.tensurareimagined.world.inventory.UniqueSkillGuiPage2Menu;
import net.mcreator.tensurareimagined.world.inventory.UniqueSkillGuiMenu;
import net.mcreator.tensurareimagined.world.inventory.SkillMenuMainGuiMenu;
import net.mcreator.tensurareimagined.world.inventory.ReincarnationOrcGuiMenu;
import net.mcreator.tensurareimagined.world.inventory.ReincarnationGUIMenu;
import net.mcreator.tensurareimagined.TensurareimaginedMod;

public class TensurareimaginedModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, TensurareimaginedMod.MODID);
	public static final RegistryObject<MenuType<ReincarnationGUIMenu>> REINCARNATIONHUMAN_GUI = REGISTRY.register("reincarnationhuman_gui",
			() -> IForgeMenuType.create(ReincarnationGUIMenu::new));
	public static final RegistryObject<MenuType<ReincarnationOrcGuiMenu>> REINCARNATION_ORC_GUI = REGISTRY.register("reincarnation_orc_gui",
			() -> IForgeMenuType.create(ReincarnationOrcGuiMenu::new));
	public static final RegistryObject<MenuType<SkillMenuMainGuiMenu>> SKILL_MENU_MAIN_GUI = REGISTRY.register("skill_menu_main_gui",
			() -> IForgeMenuType.create(SkillMenuMainGuiMenu::new));
	public static final RegistryObject<MenuType<UniqueSkillGuiMenu>> UNIQUE_SKILL_GUI = REGISTRY.register("unique_skill_gui",
			() -> IForgeMenuType.create(UniqueSkillGuiMenu::new));
	public static final RegistryObject<MenuType<UniqueSkillGuiPage2Menu>> UNIQUE_SKILL_GUI_PAGE_2 = REGISTRY.register("unique_skill_gui_page_2",
			() -> IForgeMenuType.create(UniqueSkillGuiPage2Menu::new));
	public static final RegistryObject<MenuType<UniqueSkillGuiPage3Menu>> UNIQUE_SKILL_GUI_PAGE_3 = REGISTRY.register("unique_skill_gui_page_3",
			() -> IForgeMenuType.create(UniqueSkillGuiPage3Menu::new));
}
