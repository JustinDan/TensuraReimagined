
package net.mcreator.tensurareimagined.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import net.mcreator.tensurareimagined.world.inventory.ReincarnationOrcGuiMenu;
import net.mcreator.tensurareimagined.network.ReincarnationOrcGuiButtonMessage;
import net.mcreator.tensurareimagined.TensurareimaginedMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class ReincarnationOrcGuiScreen extends AbstractContainerScreen<ReincarnationOrcGuiMenu> {
	private final static HashMap<String, Object> guistate = ReincarnationOrcGuiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public ReincarnationOrcGuiScreen(ReincarnationOrcGuiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 167;
	}

	private static final ResourceLocation texture = new ResourceLocation("tensurareimagined:textures/screens/reincarnation_orc_gui.png");

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

		RenderSystem.setShaderTexture(0, new ResourceLocation("tensurareimagined:textures/screens/orctemp.png"));
		this.blit(ms, this.leftPos + 113, this.topPos + 23, 0, 0, 16, 16, 16, 16);

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
		this.font.draw(poseStack, "Orc", 78, 25, -1);
		this.font.draw(poseStack, "Stats", 15, 34, -16717607);
		this.font.draw(poseStack, "- 30 HP", 15, 43, -1);
		this.font.draw(poseStack, "- 2.5 Attack Damage", 15, 52, -1);
		this.font.draw(poseStack, "- 3.5 Attack Speed", 15, 61, -1);
		this.font.draw(poseStack, "- 0.8 Movement Speed", 15, 70, -1);
		this.font.draw(poseStack, "- 0.7 Knockback Resistance", 15, 79, -1);
		this.font.draw(poseStack, "Magicule", 15, 88, -16717607);
		this.font.draw(poseStack, "Random: 3,000 to 5,000", 15, 97, -1);
		this.font.draw(poseStack, "Abilities", 15, 106, -16717607);
		this.font.draw(poseStack, "- Axes damage x 1.5", 15, 115, -1);
		this.font.draw(poseStack, "Evolutions", 15, 124, -16717607);
		this.font.draw(poseStack, "- High Orc/Orc Lord", 15, 133, -1);
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
		this.addRenderableWidget(new Button(this.leftPos + 60, this.topPos + 169, 56, 20, Component.literal("Select"), e -> {
			if (true) {
				TensurareimaginedMod.PACKET_HANDLER.sendToServer(new ReincarnationOrcGuiButtonMessage(0, x, y, z));
				ReincarnationOrcGuiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + -38, this.topPos + 79, 30, 20, Component.literal("<"), e -> {
			if (true) {
				TensurareimaginedMod.PACKET_HANDLER.sendToServer(new ReincarnationOrcGuiButtonMessage(1, x, y, z));
				ReincarnationOrcGuiButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}));
	}
}
