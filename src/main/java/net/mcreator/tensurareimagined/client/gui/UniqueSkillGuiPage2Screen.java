package net.mcreator.tensurareimagined.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import net.mcreator.tensurareimagined.world.inventory.UniqueSkillGuiPage2Menu;
import net.mcreator.tensurareimagined.network.UniqueSkillGuiPage2ButtonMessage;
import net.mcreator.tensurareimagined.TensurareimaginedMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class UniqueSkillGuiPage2Screen extends AbstractContainerScreen<UniqueSkillGuiPage2Menu> {
	private final static HashMap<String, Object> guistate = UniqueSkillGuiPage2Menu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_retaliator;
	Button button_lust;
	Button button_manufacturer;
	Button button_martial_master;
	Button button_mathematician;
	Button button_merciless;
	Button button_pride;
	Button button_musician;
	Button button_opressor;
	Button button_perciever;
	Button button_planner;
	Button button_predator;
	Button button_puppeteer;
	Button button_researcher;
	Button button_ruler;
	Button button_severer;
	Button button_next_page;
	Button button_previous_page;
	Button button_1;
	Button button_2;
	Button button_3;
	Button button_clear_skills;

	public UniqueSkillGuiPage2Screen(UniqueSkillGuiPage2Menu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 369;
		this.imageHeight = 198;
	}

	private static final ResourceLocation texture = new ResourceLocation("tensurareimagined:textures/screens/unique_skill_gui_page_2.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void renderBg(PoseStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		RenderSystem.setShaderTexture(0, texture);
		this.blit(ms, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
		this.font.draw(poseStack, Component.translatable("gui.tensurareimagined.unique_skill_gui_page_2.label_unique_skills"), 4, 5, -12829636);
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardHandler.setSendRepeatsToGui(false);
	}

	@Override
	public void init() {
		super.init();
		this.minecraft.keyboardHandler.setSendRepeatsToGui(true);
		button_retaliator = new Button(this.leftPos + 103, this.topPos + 131, 77, 20, Component.translatable("gui.tensurareimagined.unique_skill_gui_page_2.button_retaliator"), e -> {
			if (true) {
				TensurareimaginedMod.PACKET_HANDLER.sendToServer(new UniqueSkillGuiPage2ButtonMessage(0, x, y, z));
				UniqueSkillGuiPage2ButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:button_retaliator", button_retaliator);
		this.addRenderableWidget(button_retaliator);
		button_lust = new Button(this.leftPos + 13, this.topPos + 23, 46, 20, Component.translatable("gui.tensurareimagined.unique_skill_gui_page_2.button_lust"), e -> {
			if (true) {
				TensurareimaginedMod.PACKET_HANDLER.sendToServer(new UniqueSkillGuiPage2ButtonMessage(1, x, y, z));
				UniqueSkillGuiPage2ButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:button_lust", button_lust);
		this.addRenderableWidget(button_lust);
		button_manufacturer = new Button(this.leftPos + 76, this.topPos + 23, 88, 20, Component.translatable("gui.tensurareimagined.unique_skill_gui_page_2.button_manufacturer"), e -> {
			if (true) {
				TensurareimaginedMod.PACKET_HANDLER.sendToServer(new UniqueSkillGuiPage2ButtonMessage(2, x, y, z));
				UniqueSkillGuiPage2ButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		guistate.put("button:button_manufacturer", button_manufacturer);
		this.addRenderableWidget(button_manufacturer);
		button_martial_master = new Button(this.leftPos + 184, this.topPos + 23, 98, 20, Component.translatable("gui.tensurareimagined.unique_skill_gui_page_2.button_martial_master"), e -> {
			if (true) {
				TensurareimaginedMod.PACKET_HANDLER.sendToServer(new UniqueSkillGuiPage2ButtonMessage(3, x, y, z));
				UniqueSkillGuiPage2ButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		});
		guistate.put("button:button_martial_master", button_martial_master);
		this.addRenderableWidget(button_martial_master);
		button_mathematician = new Button(this.leftPos + 13, this.topPos + 59, 93, 20, Component.translatable("gui.tensurareimagined.unique_skill_gui_page_2.button_mathematician"), e -> {
			if (true) {
				TensurareimaginedMod.PACKET_HANDLER.sendToServer(new UniqueSkillGuiPage2ButtonMessage(4, x, y, z));
				UniqueSkillGuiPage2ButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		});
		guistate.put("button:button_mathematician", button_mathematician);
		this.addRenderableWidget(button_mathematician);
		button_merciless = new Button(this.leftPos + 121, this.topPos + 59, 72, 20, Component.translatable("gui.tensurareimagined.unique_skill_gui_page_2.button_merciless"), e -> {
			if (true) {
				TensurareimaginedMod.PACKET_HANDLER.sendToServer(new UniqueSkillGuiPage2ButtonMessage(5, x, y, z));
				UniqueSkillGuiPage2ButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		});
		guistate.put("button:button_merciless", button_merciless);
		this.addRenderableWidget(button_merciless);
		button_pride = new Button(this.leftPos + 301, this.topPos + 23, 51, 20, Component.translatable("gui.tensurareimagined.unique_skill_gui_page_2.button_pride"), e -> {
			if (true) {
				TensurareimaginedMod.PACKET_HANDLER.sendToServer(new UniqueSkillGuiPage2ButtonMessage(6, x, y, z));
				UniqueSkillGuiPage2ButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		});
		guistate.put("button:button_pride", button_pride);
		this.addRenderableWidget(button_pride);
		button_musician = new Button(this.leftPos + 211, this.topPos + 59, 67, 20, Component.translatable("gui.tensurareimagined.unique_skill_gui_page_2.button_musician"), e -> {
			if (true) {
				TensurareimaginedMod.PACKET_HANDLER.sendToServer(new UniqueSkillGuiPage2ButtonMessage(7, x, y, z));
				UniqueSkillGuiPage2ButtonMessage.handleButtonAction(entity, 7, x, y, z);
			}
		});
		guistate.put("button:button_musician", button_musician);
		this.addRenderableWidget(button_musician);
		button_opressor = new Button(this.leftPos + 292, this.topPos + 59, 67, 20, Component.translatable("gui.tensurareimagined.unique_skill_gui_page_2.button_opressor"), e -> {
			if (true) {
				TensurareimaginedMod.PACKET_HANDLER.sendToServer(new UniqueSkillGuiPage2ButtonMessage(8, x, y, z));
				UniqueSkillGuiPage2ButtonMessage.handleButtonAction(entity, 8, x, y, z);
			}
		});
		guistate.put("button:button_opressor", button_opressor);
		this.addRenderableWidget(button_opressor);
		button_perciever = new Button(this.leftPos + 13, this.topPos + 95, 72, 20, Component.translatable("gui.tensurareimagined.unique_skill_gui_page_2.button_perciever"), e -> {
			if (true) {
				TensurareimaginedMod.PACKET_HANDLER.sendToServer(new UniqueSkillGuiPage2ButtonMessage(9, x, y, z));
				UniqueSkillGuiPage2ButtonMessage.handleButtonAction(entity, 9, x, y, z);
			}
		});
		guistate.put("button:button_perciever", button_perciever);
		this.addRenderableWidget(button_perciever);
		button_planner = new Button(this.leftPos + 103, this.topPos + 95, 61, 20, Component.translatable("gui.tensurareimagined.unique_skill_gui_page_2.button_planner"), e -> {
			if (true) {
				TensurareimaginedMod.PACKET_HANDLER.sendToServer(new UniqueSkillGuiPage2ButtonMessage(10, x, y, z));
				UniqueSkillGuiPage2ButtonMessage.handleButtonAction(entity, 10, x, y, z);
			}
		});
		guistate.put("button:button_planner", button_planner);
		this.addRenderableWidget(button_planner);
		button_predator = new Button(this.leftPos + 184, this.topPos + 95, 67, 20, Component.translatable("gui.tensurareimagined.unique_skill_gui_page_2.button_predator"), e -> {
			if (true) {
				TensurareimaginedMod.PACKET_HANDLER.sendToServer(new UniqueSkillGuiPage2ButtonMessage(11, x, y, z));
				UniqueSkillGuiPage2ButtonMessage.handleButtonAction(entity, 11, x, y, z);
			}
		});
		guistate.put("button:button_predator", button_predator);
		this.addRenderableWidget(button_predator);
		button_puppeteer = new Button(this.leftPos + 274, this.topPos + 95, 72, 20, Component.translatable("gui.tensurareimagined.unique_skill_gui_page_2.button_puppeteer"), e -> {
			if (true) {
				TensurareimaginedMod.PACKET_HANDLER.sendToServer(new UniqueSkillGuiPage2ButtonMessage(12, x, y, z));
				UniqueSkillGuiPage2ButtonMessage.handleButtonAction(entity, 12, x, y, z);
			}
		});
		guistate.put("button:button_puppeteer", button_puppeteer);
		this.addRenderableWidget(button_puppeteer);
		button_researcher = new Button(this.leftPos + 13, this.topPos + 131, 77, 20, Component.translatable("gui.tensurareimagined.unique_skill_gui_page_2.button_researcher"), e -> {
			if (true) {
				TensurareimaginedMod.PACKET_HANDLER.sendToServer(new UniqueSkillGuiPage2ButtonMessage(13, x, y, z));
				UniqueSkillGuiPage2ButtonMessage.handleButtonAction(entity, 13, x, y, z);
			}
		});
		guistate.put("button:button_researcher", button_researcher);
		this.addRenderableWidget(button_researcher);
		button_ruler = new Button(this.leftPos + 202, this.topPos + 131, 51, 20, Component.translatable("gui.tensurareimagined.unique_skill_gui_page_2.button_ruler"), e -> {
			if (true) {
				TensurareimaginedMod.PACKET_HANDLER.sendToServer(new UniqueSkillGuiPage2ButtonMessage(14, x, y, z));
				UniqueSkillGuiPage2ButtonMessage.handleButtonAction(entity, 14, x, y, z);
			}
		});
		guistate.put("button:button_ruler", button_ruler);
		this.addRenderableWidget(button_ruler);
		button_severer = new Button(this.leftPos + 274, this.topPos + 131, 61, 20, Component.translatable("gui.tensurareimagined.unique_skill_gui_page_2.button_severer"), e -> {
			if (true) {
				TensurareimaginedMod.PACKET_HANDLER.sendToServer(new UniqueSkillGuiPage2ButtonMessage(15, x, y, z));
				UniqueSkillGuiPage2ButtonMessage.handleButtonAction(entity, 15, x, y, z);
			}
		});
		guistate.put("button:button_severer", button_severer);
		this.addRenderableWidget(button_severer);
		button_next_page = new Button(this.leftPos + 283, this.topPos + 167, 72, 20, Component.translatable("gui.tensurareimagined.unique_skill_gui_page_2.button_next_page"), e -> {
			if (true) {
				TensurareimaginedMod.PACKET_HANDLER.sendToServer(new UniqueSkillGuiPage2ButtonMessage(16, x, y, z));
				UniqueSkillGuiPage2ButtonMessage.handleButtonAction(entity, 16, x, y, z);
			}
		});
		guistate.put("button:button_next_page", button_next_page);
		this.addRenderableWidget(button_next_page);
		button_previous_page = new Button(this.leftPos + 13, this.topPos + 167, 93, 20, Component.translatable("gui.tensurareimagined.unique_skill_gui_page_2.button_previous_page"), e -> {
			if (true) {
				TensurareimaginedMod.PACKET_HANDLER.sendToServer(new UniqueSkillGuiPage2ButtonMessage(17, x, y, z));
				UniqueSkillGuiPage2ButtonMessage.handleButtonAction(entity, 17, x, y, z);
			}
		});
		guistate.put("button:button_previous_page", button_previous_page);
		this.addRenderableWidget(button_previous_page);
		button_1 = new Button(this.leftPos + 121, this.topPos + 167, 30, 20, Component.translatable("gui.tensurareimagined.unique_skill_gui_page_2.button_1"), e -> {
			if (true) {
				TensurareimaginedMod.PACKET_HANDLER.sendToServer(new UniqueSkillGuiPage2ButtonMessage(18, x, y, z));
				UniqueSkillGuiPage2ButtonMessage.handleButtonAction(entity, 18, x, y, z);
			}
		});
		guistate.put("button:button_1", button_1);
		this.addRenderableWidget(button_1);
		button_2 = new Button(this.leftPos + 175, this.topPos + 167, 30, 20, Component.translatable("gui.tensurareimagined.unique_skill_gui_page_2.button_2"), e -> {
			if (true) {
				TensurareimaginedMod.PACKET_HANDLER.sendToServer(new UniqueSkillGuiPage2ButtonMessage(19, x, y, z));
				UniqueSkillGuiPage2ButtonMessage.handleButtonAction(entity, 19, x, y, z);
			}
		});
		guistate.put("button:button_2", button_2);
		this.addRenderableWidget(button_2);
		button_3 = new Button(this.leftPos + 229, this.topPos + 167, 30, 20, Component.translatable("gui.tensurareimagined.unique_skill_gui_page_2.button_3"), e -> {
			if (true) {
				TensurareimaginedMod.PACKET_HANDLER.sendToServer(new UniqueSkillGuiPage2ButtonMessage(20, x, y, z));
				UniqueSkillGuiPage2ButtonMessage.handleButtonAction(entity, 20, x, y, z);
			}
		});
		guistate.put("button:button_3", button_3);
		this.addRenderableWidget(button_3);
		button_clear_skills = new Button(this.leftPos + 310, this.topPos + -22, 87, 20, Component.translatable("gui.tensurareimagined.unique_skill_gui_page_2.button_clear_skills"), e -> {
			if (true) {
				TensurareimaginedMod.PACKET_HANDLER.sendToServer(new UniqueSkillGuiPage2ButtonMessage(21, x, y, z));
				UniqueSkillGuiPage2ButtonMessage.handleButtonAction(entity, 21, x, y, z);
			}
		});
		guistate.put("button:button_clear_skills", button_clear_skills);
		this.addRenderableWidget(button_clear_skills);
	}
}
