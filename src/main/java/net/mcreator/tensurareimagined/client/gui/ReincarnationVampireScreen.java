package net.mcreator.tensurareimagined.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import net.mcreator.tensurareimagined.world.inventory.ReincarnationVampireMenu;
import net.mcreator.tensurareimagined.network.ReincarnationVampireButtonMessage;
import net.mcreator.tensurareimagined.TensurareimaginedMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class ReincarnationVampireScreen extends AbstractContainerScreen<ReincarnationVampireMenu> {
	private final static HashMap<String, Object> guistate = ReincarnationVampireMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_select;
	Button button_empty;
	Button button_empty1;

	public ReincarnationVampireScreen(ReincarnationVampireMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 167;
	}

	private static final ResourceLocation texture = new ResourceLocation("tensurareimagined:textures/screens/reincarnation_vampire.png");

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
		this.font.draw(poseStack, Component.translatable("gui.tensurareimagined.reincarnation_vampire.label_orc"), 15, 16, -1);
		this.font.draw(poseStack, Component.translatable("gui.tensurareimagined.reincarnation_vampire.label_stats"), 15, 34, -16717607);
		this.font.draw(poseStack, Component.translatable("gui.tensurareimagined.reincarnation_vampire.label_30_hp"), 15, 43, -1);
		this.font.draw(poseStack, Component.translatable("gui.tensurareimagined.reincarnation_vampire.label_25_attack_damage"), 15, 52, -1);
		this.font.draw(poseStack, Component.translatable("gui.tensurareimagined.reincarnation_vampire.label_35_attack_speed"), 24, 97, -1);
		this.font.draw(poseStack, Component.translatable("gui.tensurareimagined.reincarnation_vampire.label_08_movement_speed"), 15, 70, -1);
		this.font.draw(poseStack, Component.translatable("gui.tensurareimagined.reincarnation_vampire.label_07_knockback_resistance"), 15, 115, -1);
		this.font.draw(poseStack, Component.translatable("gui.tensurareimagined.reincarnation_vampire.label_magicule"), 15, 61, -16717607);
		this.font.draw(poseStack, Component.translatable("gui.tensurareimagined.reincarnation_vampire.label_random_3000_to_5000"), 15, 88, -1);
		this.font.draw(poseStack, Component.translatable("gui.tensurareimagined.reincarnation_vampire.label_abilities"), 15, 79, -16717607);
		this.font.draw(poseStack, Component.translatable("gui.tensurareimagined.reincarnation_vampire.label_axes_damage_x_15"), 15, 106, -1);
		this.font.draw(poseStack, Component.translatable("gui.tensurareimagined.reincarnation_vampire.label_high_orcorc_lord"), 15, 124, -1);
		this.font.draw(poseStack, Component.translatable("gui.tensurareimagined.reincarnation_vampire.label_race_key_sneak_bat_mode"), 15, 133, -1);
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
		button_select = new Button(this.leftPos + 60, this.topPos + 169, 56, 20, Component.translatable("gui.tensurareimagined.reincarnation_vampire.button_select"), e -> {
			if (true) {
				TensurareimaginedMod.PACKET_HANDLER.sendToServer(new ReincarnationVampireButtonMessage(0, x, y, z));
				ReincarnationVampireButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:button_select", button_select);
		this.addRenderableWidget(button_select);
		button_empty = new Button(this.leftPos + -38, this.topPos + 79, 30, 20, Component.translatable("gui.tensurareimagined.reincarnation_vampire.button_empty"), e -> {
			if (true) {
				TensurareimaginedMod.PACKET_HANDLER.sendToServer(new ReincarnationVampireButtonMessage(1, x, y, z));
				ReincarnationVampireButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:button_empty", button_empty);
		this.addRenderableWidget(button_empty);
		button_empty1 = new Button(this.leftPos + 186, this.topPos + 79, 30, 20, Component.translatable("gui.tensurareimagined.reincarnation_vampire.button_empty1"), e -> {
			if (true) {
				TensurareimaginedMod.PACKET_HANDLER.sendToServer(new ReincarnationVampireButtonMessage(2, x, y, z));
				ReincarnationVampireButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		guistate.put("button:button_empty1", button_empty1);
		this.addRenderableWidget(button_empty1);
	}
}
