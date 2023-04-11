package net.mcreator.tensurareimagined.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import net.mcreator.tensurareimagined.world.inventory.ReincarnationGUIMenu;
import net.mcreator.tensurareimagined.network.ReincarnationGUIButtonMessage;
import net.mcreator.tensurareimagined.TensurareimaginedMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class ReincarnationGUIScreen extends AbstractContainerScreen<ReincarnationGUIMenu> {
	private final static HashMap<String, Object> guistate = ReincarnationGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_empty;
	Button button_select;

	public ReincarnationGUIScreen(ReincarnationGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 167;
	}

	private static final ResourceLocation texture = new ResourceLocation("tensurareimagined:textures/screens/reincarnationhuman_gui.png");

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

		RenderSystem.setShaderTexture(0, new ResourceLocation("tensurareimagined:textures/screens/guibordertest.png"));
		this.blit(ms, this.leftPos + 1, this.topPos + 1, 0, 0, 176, 166, 176, 166);

		RenderSystem.setShaderTexture(0, new ResourceLocation("tensurareimagined:textures/screens/fotor_2023-4-7_14_42_59.png"));
		this.blit(ms, this.leftPos + 123, this.topPos + 16, 0, 0, 27, 26, 27, 26);

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
		this.font.draw(poseStack, Component.translatable("gui.tensurareimagined.reincarnationhuman_gui.label_human"), 69, 25, -1);
		this.font.draw(poseStack, Component.translatable("gui.tensurareimagined.reincarnationhuman_gui.label_stats"), 15, 34, -16717607);
		this.font.draw(poseStack, Component.translatable("gui.tensurareimagined.reincarnationhuman_gui.label_20_hp"), 15, 43, -1);
		this.font.draw(poseStack, Component.translatable("gui.tensurareimagined.reincarnationhuman_gui.label_1_attack_damage"), 15, 52, -1);
		this.font.draw(poseStack, Component.translatable("gui.tensurareimagined.reincarnationhuman_gui.label_4_attack_speed"), 15, 61, -1);
		this.font.draw(poseStack, Component.translatable("gui.tensurareimagined.reincarnationhuman_gui.label_01_movement_speed"), 15, 70, -1);
		this.font.draw(poseStack, Component.translatable("gui.tensurareimagined.reincarnationhuman_gui.label_0_knockback_resistance"), 15, 79, -1);
		this.font.draw(poseStack, Component.translatable("gui.tensurareimagined.reincarnationhuman_gui.label_0_armor_point"), 15, 88, -1);
		this.font.draw(poseStack, Component.translatable("gui.tensurareimagined.reincarnationhuman_gui.label_magicule"), 15, 97, -16717607);
		this.font.draw(poseStack, Component.translatable("gui.tensurareimagined.reincarnationhuman_gui.label_random_2000_to_200000"), 15, 106, -1);
		this.font.draw(poseStack, Component.translatable("gui.tensurareimagined.reincarnationhuman_gui.label_spirit"), 15, 115, -16717607);
		this.font.draw(poseStack, Component.translatable("gui.tensurareimagined.reincarnationhuman_gui.label_higher_chance_to_get_chosen"), 15, 124, -1);
		this.font.draw(poseStack, Component.translatable("gui.tensurareimagined.reincarnationhuman_gui.label_by_spirits"), 15, 133, -1);
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
		button_empty = new Button(this.leftPos + 185, this.topPos + 77, 30, 20, Component.translatable("gui.tensurareimagined.reincarnationhuman_gui.button_empty"), e -> {
			if (true) {
				TensurareimaginedMod.PACKET_HANDLER.sendToServer(new ReincarnationGUIButtonMessage(0, x, y, z));
				ReincarnationGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:button_empty", button_empty);
		this.addRenderableWidget(button_empty);
		button_select = new Button(this.leftPos + 60, this.topPos + 169, 56, 20, Component.translatable("gui.tensurareimagined.reincarnationhuman_gui.button_select"), e -> {
			if (true) {
				TensurareimaginedMod.PACKET_HANDLER.sendToServer(new ReincarnationGUIButtonMessage(1, x, y, z));
				ReincarnationGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:button_select", button_select);
		this.addRenderableWidget(button_select);
	}
}
