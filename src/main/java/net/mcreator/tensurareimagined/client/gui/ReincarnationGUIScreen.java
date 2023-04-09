
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
		this.font.draw(poseStack, "Human", 69, 25, -1);
		this.font.draw(poseStack, "Stats", 15, 34, -16717607);
		this.font.draw(poseStack, "- 20 HP", 15, 43, -1);
		this.font.draw(poseStack, "- 1 Attack Damage", 15, 52, -1);
		this.font.draw(poseStack, "- 4 Attack Speed", 15, 61, -1);
		this.font.draw(poseStack, "- 0.1 Movement Speed", 15, 70, -1);
		this.font.draw(poseStack, "- 0 Knockback Resistance", 15, 79, -1);
		this.font.draw(poseStack, "- 0 Armor Point", 15, 88, -1);
		this.font.draw(poseStack, "Magicule", 15, 97, -16717607);
		this.font.draw(poseStack, "Random: 2,000 to 200,000", 15, 106, -1);
		this.font.draw(poseStack, "Spirit", 15, 115, -16717607);
		this.font.draw(poseStack, "Higher chance to get chosen", 15, 124, -1);
		this.font.draw(poseStack, "by Spirits", 15, 133, -1);
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
		this.addRenderableWidget(new Button(this.leftPos + 185, this.topPos + 77, 30, 20, Component.literal(">"), e -> {
			if (true) {
				TensurareimaginedMod.PACKET_HANDLER.sendToServer(new ReincarnationGUIButtonMessage(0, x, y, z));
				ReincarnationGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 60, this.topPos + 169, 56, 20, Component.literal("Select"), e -> {
			if (true) {
				TensurareimaginedMod.PACKET_HANDLER.sendToServer(new ReincarnationGUIButtonMessage(1, x, y, z));
				ReincarnationGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}));
	}
}
