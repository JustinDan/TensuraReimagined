package net.mcreator.tensurareimagined.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import net.mcreator.tensurareimagined.world.inventory.UniqueSkillGuiPage3Menu;
import net.mcreator.tensurareimagined.network.UniqueSkillGuiPage3ButtonMessage;
import net.mcreator.tensurareimagined.TensurareimaginedMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class UniqueSkillGuiPage3Screen extends AbstractContainerScreen<UniqueSkillGuiPage3Menu> {
	private final static HashMap<String, Object> guistate = UniqueSkillGuiPage3Menu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_shadow_striker;
	Button button_sloth;
	Button button_spearhead;
	Button button_starved;
	Button button_survivor;
	Button button_the_chosen_one;
	Button button_traveler;
	Button button_usurper;
	Button button_wrath;
	Button button_previous_page;
	Button button_1;
	Button button_2;
	Button button_3;
	Button button_clear_skills;

	public UniqueSkillGuiPage3Screen(UniqueSkillGuiPage3Menu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 369;
		this.imageHeight = 198;
	}

	private static final ResourceLocation texture = new ResourceLocation("tensurareimagined:textures/screens/unique_skill_gui_page_3.png");

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
		this.font.draw(poseStack, Component.translatable("gui.tensurareimagined.unique_skill_gui_page_3.label_unique_skills"), 4, 5, -12829636);
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
		button_shadow_striker = new Button(this.leftPos + 13, this.topPos + 23, 98, 20, Component.translatable("gui.tensurareimagined.unique_skill_gui_page_3.button_shadow_striker"), e -> {
			if (true) {
				TensurareimaginedMod.PACKET_HANDLER.sendToServer(new UniqueSkillGuiPage3ButtonMessage(0, x, y, z));
				UniqueSkillGuiPage3ButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:button_shadow_striker", button_shadow_striker);
		this.addRenderableWidget(button_shadow_striker);
		button_sloth = new Button(this.leftPos + 130, this.topPos + 23, 51, 20, Component.translatable("gui.tensurareimagined.unique_skill_gui_page_3.button_sloth"), e -> {
			if (true) {
				TensurareimaginedMod.PACKET_HANDLER.sendToServer(new UniqueSkillGuiPage3ButtonMessage(1, x, y, z));
				UniqueSkillGuiPage3ButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:button_sloth", button_sloth);
		this.addRenderableWidget(button_sloth);
		button_spearhead = new Button(this.leftPos + 202, this.topPos + 23, 72, 20, Component.translatable("gui.tensurareimagined.unique_skill_gui_page_3.button_spearhead"), e -> {
			if (true) {
				TensurareimaginedMod.PACKET_HANDLER.sendToServer(new UniqueSkillGuiPage3ButtonMessage(2, x, y, z));
				UniqueSkillGuiPage3ButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		guistate.put("button:button_spearhead", button_spearhead);
		this.addRenderableWidget(button_spearhead);
		button_starved = new Button(this.leftPos + 292, this.topPos + 23, 61, 20, Component.translatable("gui.tensurareimagined.unique_skill_gui_page_3.button_starved"), e -> {
			if (true) {
				TensurareimaginedMod.PACKET_HANDLER.sendToServer(new UniqueSkillGuiPage3ButtonMessage(3, x, y, z));
				UniqueSkillGuiPage3ButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		});
		guistate.put("button:button_starved", button_starved);
		this.addRenderableWidget(button_starved);
		button_survivor = new Button(this.leftPos + 13, this.topPos + 59, 67, 20, Component.translatable("gui.tensurareimagined.unique_skill_gui_page_3.button_survivor"), e -> {
			if (true) {
				TensurareimaginedMod.PACKET_HANDLER.sendToServer(new UniqueSkillGuiPage3ButtonMessage(4, x, y, z));
				UniqueSkillGuiPage3ButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		});
		guistate.put("button:button_survivor", button_survivor);
		this.addRenderableWidget(button_survivor);
		button_the_chosen_one = new Button(this.leftPos + 94, this.topPos + 59, 98, 20, Component.translatable("gui.tensurareimagined.unique_skill_gui_page_3.button_the_chosen_one"), e -> {
			if (true) {
				TensurareimaginedMod.PACKET_HANDLER.sendToServer(new UniqueSkillGuiPage3ButtonMessage(5, x, y, z));
				UniqueSkillGuiPage3ButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		});
		guistate.put("button:button_the_chosen_one", button_the_chosen_one);
		this.addRenderableWidget(button_the_chosen_one);
		button_traveler = new Button(this.leftPos + 211, this.topPos + 59, 67, 20, Component.translatable("gui.tensurareimagined.unique_skill_gui_page_3.button_traveler"), e -> {
			if (true) {
				TensurareimaginedMod.PACKET_HANDLER.sendToServer(new UniqueSkillGuiPage3ButtonMessage(6, x, y, z));
				UniqueSkillGuiPage3ButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		});
		guistate.put("button:button_traveler", button_traveler);
		this.addRenderableWidget(button_traveler);
		button_usurper = new Button(this.leftPos + 292, this.topPos + 59, 61, 20, Component.translatable("gui.tensurareimagined.unique_skill_gui_page_3.button_usurper"), e -> {
			if (true) {
				TensurareimaginedMod.PACKET_HANDLER.sendToServer(new UniqueSkillGuiPage3ButtonMessage(7, x, y, z));
				UniqueSkillGuiPage3ButtonMessage.handleButtonAction(entity, 7, x, y, z);
			}
		});
		guistate.put("button:button_usurper", button_usurper);
		this.addRenderableWidget(button_usurper);
		button_wrath = new Button(this.leftPos + 13, this.topPos + 95, 51, 20, Component.translatable("gui.tensurareimagined.unique_skill_gui_page_3.button_wrath"), e -> {
			if (true) {
				TensurareimaginedMod.PACKET_HANDLER.sendToServer(new UniqueSkillGuiPage3ButtonMessage(8, x, y, z));
				UniqueSkillGuiPage3ButtonMessage.handleButtonAction(entity, 8, x, y, z);
			}
		});
		guistate.put("button:button_wrath", button_wrath);
		this.addRenderableWidget(button_wrath);
		button_previous_page = new Button(this.leftPos + 13, this.topPos + 167, 93, 20, Component.translatable("gui.tensurareimagined.unique_skill_gui_page_3.button_previous_page"), e -> {
			if (true) {
				TensurareimaginedMod.PACKET_HANDLER.sendToServer(new UniqueSkillGuiPage3ButtonMessage(9, x, y, z));
				UniqueSkillGuiPage3ButtonMessage.handleButtonAction(entity, 9, x, y, z);
			}
		});
		guistate.put("button:button_previous_page", button_previous_page);
		this.addRenderableWidget(button_previous_page);
		button_1 = new Button(this.leftPos + 121, this.topPos + 167, 30, 20, Component.translatable("gui.tensurareimagined.unique_skill_gui_page_3.button_1"), e -> {
			if (true) {
				TensurareimaginedMod.PACKET_HANDLER.sendToServer(new UniqueSkillGuiPage3ButtonMessage(10, x, y, z));
				UniqueSkillGuiPage3ButtonMessage.handleButtonAction(entity, 10, x, y, z);
			}
		});
		guistate.put("button:button_1", button_1);
		this.addRenderableWidget(button_1);
		button_2 = new Button(this.leftPos + 175, this.topPos + 167, 30, 20, Component.translatable("gui.tensurareimagined.unique_skill_gui_page_3.button_2"), e -> {
			if (true) {
				TensurareimaginedMod.PACKET_HANDLER.sendToServer(new UniqueSkillGuiPage3ButtonMessage(11, x, y, z));
				UniqueSkillGuiPage3ButtonMessage.handleButtonAction(entity, 11, x, y, z);
			}
		});
		guistate.put("button:button_2", button_2);
		this.addRenderableWidget(button_2);
		button_3 = new Button(this.leftPos + 229, this.topPos + 167, 30, 20, Component.translatable("gui.tensurareimagined.unique_skill_gui_page_3.button_3"), e -> {
			if (true) {
				TensurareimaginedMod.PACKET_HANDLER.sendToServer(new UniqueSkillGuiPage3ButtonMessage(12, x, y, z));
				UniqueSkillGuiPage3ButtonMessage.handleButtonAction(entity, 12, x, y, z);
			}
		});
		guistate.put("button:button_3", button_3);
		this.addRenderableWidget(button_3);
		button_clear_skills = new Button(this.leftPos + 310, this.topPos + -22, 87, 20, Component.translatable("gui.tensurareimagined.unique_skill_gui_page_3.button_clear_skills"), e -> {
			if (true) {
				TensurareimaginedMod.PACKET_HANDLER.sendToServer(new UniqueSkillGuiPage3ButtonMessage(13, x, y, z));
				UniqueSkillGuiPage3ButtonMessage.handleButtonAction(entity, 13, x, y, z);
			}
		});
		guistate.put("button:button_clear_skills", button_clear_skills);
		this.addRenderableWidget(button_clear_skills);
	}
}
