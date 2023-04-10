
package net.mcreator.tensurareimagined.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import net.mcreator.tensurareimagined.world.inventory.UniqueSkillGuiMenu;
import net.mcreator.tensurareimagined.network.UniqueSkillGuiButtonMessage;
import net.mcreator.tensurareimagined.TensurareimaginedMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class UniqueSkillGuiScreen extends AbstractContainerScreen<UniqueSkillGuiMenu> {
	private final static HashMap<String, Object> guistate = UniqueSkillGuiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public UniqueSkillGuiScreen(UniqueSkillGuiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 369;
		this.imageHeight = 198;
	}

	private static final ResourceLocation texture = new ResourceLocation("tensurareimagined:textures/screens/unique_skill_gui.png");

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
		this.font.draw(poseStack, "Unique Skills", 4, 5, -12829636);
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
		this.addRenderableWidget(new Button(this.leftPos + 13, this.topPos + 23, 61, 20, Component.literal("Analyst"), e -> {
		}));
		this.addRenderableWidget(new Button(this.leftPos + 94, this.topPos + 23, 67, 20, Component.literal("Beserker"), e -> {
		}));
		this.addRenderableWidget(new Button(this.leftPos + 184, this.topPos + 23, 77, 20, Component.literal("Degenerate"), e -> {
		}));
		this.addRenderableWidget(new Button(this.leftPos + 283, this.topPos + 23, 77, 20, Component.literal("Dilettante"), e -> {
		}));
		this.addRenderableWidget(new Button(this.leftPos + 13, this.topPos + 59, 46, 20, Component.literal("Envy"), e -> {
		}));
		this.addRenderableWidget(new Button(this.leftPos + 85, this.topPos + 59, 93, 20, Component.literal("Generalissimo"), e -> {
		}));
		this.addRenderableWidget(new Button(this.leftPos + 202, this.topPos + 59, 67, 20, Component.literal("Gluttony"), e -> {
		}));
		this.addRenderableWidget(new Button(this.leftPos + 292, this.topPos + 59, 61, 20, Component.literal("Gourmet"), e -> {
		}));
		this.addRenderableWidget(new Button(this.leftPos + 13, this.topPos + 95, 103, 20, Component.literal("Godly Craftsman"), e -> {
		}));
		this.addRenderableWidget(new Button(this.leftPos + 139, this.topPos + 95, 77, 20, Component.literal("Great Sage"), e -> {
		}));
		this.addRenderableWidget(new Button(this.leftPos + 238, this.topPos + 95, 93, 20, Component.literal("Great Wiseman"), e -> {
		}));
		this.addRenderableWidget(new Button(this.leftPos + 13, this.topPos + 131, 51, 20, Component.literal("Greed"), e -> {
		}));
		this.addRenderableWidget(new Button(this.leftPos + 85, this.topPos + 131, 56, 20, Component.literal("Healer"), e -> {
		}));
		this.addRenderableWidget(new Button(this.leftPos + 166, this.topPos + 131, 88, 20, Component.literal("Investigator"), e -> {
		}));
		this.addRenderableWidget(new Button(this.leftPos + 274, this.topPos + 131, 87, 20, Component.literal("Lion's Heart"), e -> {
		}));
		this.addRenderableWidget(new Button(this.leftPos + 283, this.topPos + 167, 72, 20, Component.literal("Next Page"), e -> {
			if (true) {
				TensurareimaginedMod.PACKET_HANDLER.sendToServer(new UniqueSkillGuiButtonMessage(15, x, y, z));
				UniqueSkillGuiButtonMessage.handleButtonAction(entity, 15, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 121, this.topPos + 167, 30, 20, Component.literal("1"), e -> {
			if (true) {
				TensurareimaginedMod.PACKET_HANDLER.sendToServer(new UniqueSkillGuiButtonMessage(16, x, y, z));
				UniqueSkillGuiButtonMessage.handleButtonAction(entity, 16, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 175, this.topPos + 167, 30, 20, Component.literal("2"), e -> {
			if (true) {
				TensurareimaginedMod.PACKET_HANDLER.sendToServer(new UniqueSkillGuiButtonMessage(17, x, y, z));
				UniqueSkillGuiButtonMessage.handleButtonAction(entity, 17, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 229, this.topPos + 167, 30, 20, Component.literal("3"), e -> {
			if (true) {
				TensurareimaginedMod.PACKET_HANDLER.sendToServer(new UniqueSkillGuiButtonMessage(18, x, y, z));
				UniqueSkillGuiButtonMessage.handleButtonAction(entity, 18, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 310, this.topPos + -22, 87, 20, Component.literal("Clear Skills"), e -> {
		}));
	}
}
