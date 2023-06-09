
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.tensurareimagined.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import net.mcreator.tensurareimagined.client.gui.UniqueSkillGuiScreen;
import net.mcreator.tensurareimagined.client.gui.UniqueSkillGuiPage3Screen;
import net.mcreator.tensurareimagined.client.gui.UniqueSkillGuiPage2Screen;
import net.mcreator.tensurareimagined.client.gui.SkillMenuMainGuiScreen;
import net.mcreator.tensurareimagined.client.gui.ReincarnationWightScreen;
import net.mcreator.tensurareimagined.client.gui.ReincarnationVampireScreen;
import net.mcreator.tensurareimagined.client.gui.ReincarnationSlimeScreen;
import net.mcreator.tensurareimagined.client.gui.ReincarnationOrcGuiScreen;
import net.mcreator.tensurareimagined.client.gui.ReincarnationLizardmanScreen;
import net.mcreator.tensurareimagined.client.gui.ReincarnationLesserDemonScreen;
import net.mcreator.tensurareimagined.client.gui.ReincarnationGoblinScreen;
import net.mcreator.tensurareimagined.client.gui.ReincarnationGUIScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class TensurareimaginedModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(TensurareimaginedModMenus.REINCARNATIONHUMAN_GUI.get(), ReincarnationGUIScreen::new);
			MenuScreens.register(TensurareimaginedModMenus.REINCARNATION_ORC_GUI.get(), ReincarnationOrcGuiScreen::new);
			MenuScreens.register(TensurareimaginedModMenus.SKILL_MENU_MAIN_GUI.get(), SkillMenuMainGuiScreen::new);
			MenuScreens.register(TensurareimaginedModMenus.UNIQUE_SKILL_GUI.get(), UniqueSkillGuiScreen::new);
			MenuScreens.register(TensurareimaginedModMenus.UNIQUE_SKILL_GUI_PAGE_2.get(), UniqueSkillGuiPage2Screen::new);
			MenuScreens.register(TensurareimaginedModMenus.UNIQUE_SKILL_GUI_PAGE_3.get(), UniqueSkillGuiPage3Screen::new);
			MenuScreens.register(TensurareimaginedModMenus.REINCARNATION_GOBLIN.get(), ReincarnationGoblinScreen::new);
			MenuScreens.register(TensurareimaginedModMenus.REINCARNATION_LIZARDMAN.get(), ReincarnationLizardmanScreen::new);
			MenuScreens.register(TensurareimaginedModMenus.REINCARNATION_LESSER_DEMON.get(), ReincarnationLesserDemonScreen::new);
			MenuScreens.register(TensurareimaginedModMenus.REINCARNATION_VAMPIRE.get(), ReincarnationVampireScreen::new);
			MenuScreens.register(TensurareimaginedModMenus.REINCARNATION_SLIME.get(), ReincarnationSlimeScreen::new);
			MenuScreens.register(TensurareimaginedModMenus.REINCARNATION_WIGHT.get(), ReincarnationWightScreen::new);
		});
	}
}
