
package net.mcreator.tensurareimagined.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import net.mcreator.tensurareimagined.world.inventory.SkillMenuMainGuiMenu;
import net.mcreator.tensurareimagined.network.TensurareimaginedModVariables;
import net.mcreator.tensurareimagined.network.SkillMenuMainGuiButtonMessage;
import net.mcreator.tensurareimagined.TensurareimaginedMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class SkillMenuMainGuiScreen extends AbstractContainerScreen<SkillMenuMainGuiMenu> {
	private final static HashMap<String, Object> guistate = SkillMenuMainGuiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public SkillMenuMainGuiScreen(SkillMenuMainGuiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 295;
		this.imageHeight = 185;
	}

	private static final ResourceLocation texture = new ResourceLocation("tensurareimagined:textures/screens/skill_menu_main_gui.png");

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

		RenderSystem.setShaderTexture(0, new ResourceLocation("tensurareimagined:textures/screens/skillmenumaintest.png"));
		this.blit(ms, this.leftPos + 0, this.topPos + 0, 0, 0, 296, 185, 296, 185);

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
		this.font.draw(poseStack, "" + ((entity.getCapability(TensurareimaginedModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TensurareimaginedModVariables.PlayerVariables())).Race) + "", 37, 7, -16777216);
		this.font.draw(poseStack, "Race:", 7, 7, -16777216);
		this.font.draw(poseStack, "EP: Unknown", 7, 22, -205);
		this.font.draw(poseStack, "Max Magicule: " + (int) ((entity.getCapability(TensurareimaginedModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TensurareimaginedModVariables.PlayerVariables())).MaxMagicules) + "", 8, 43, -16737793);
		this.font.draw(poseStack, "Magicule: " + ((entity.getCapability(TensurareimaginedModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TensurareimaginedModVariables.PlayerVariables())).Magicules) + "", 8, 65, -16711681);
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
		this.addRenderableWidget(new Button(this.leftPos + 240, this.topPos + 133, 30, 20, Component.literal(" N/A"), e -> {
		}));
		this.addRenderableWidget(new Button(this.leftPos + 152, this.topPos + 137, 30, 20, Component.literal("n"), e -> {
			if (true) {
				TensurareimaginedMod.PACKET_HANDLER.sendToServer(new SkillMenuMainGuiButtonMessage(1, x, y, z));
				SkillMenuMainGuiButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}));
	}
}
