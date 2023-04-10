
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
		this.addRenderableWidget(new Button(this.leftPos + 103, this.topPos + 131, 77, 20, Component.literal("Retaliator"), e -> {
		}));
		this.addRenderableWidget(new Button(this.leftPos + 13, this.topPos + 23, 46, 20, Component.literal("Lust"), e -> {
		}));
		this.addRenderableWidget(new Button(this.leftPos + 76, this.topPos + 23, 88, 20, Component.literal("Manufacturer"), e -> {
		}));
		this.addRenderableWidget(new Button(this.leftPos + 184, this.topPos + 23, 98, 20, Component.literal("Martial Master"), e -> {
		}));
		this.addRenderableWidget(new Button(this.leftPos + 13, this.topPos + 59, 93, 20, Component.literal("Mathematician"), e -> {
		}));
		this.addRenderableWidget(new Button(this.leftPos + 121, this.topPos + 59, 72, 20, Component.literal("Merciless"), e -> {
		}));
		this.addRenderableWidget(new Button(this.leftPos + 301, this.topPos + 23, 51, 20, Component.literal("Pride"), e -> {
		}));
		this.addRenderableWidget(new Button(this.leftPos + 211, this.topPos + 59, 67, 20, Component.literal("Musician"), e -> {
		}));
		this.addRenderableWidget(new Button(this.leftPos + 292, this.topPos + 59, 67, 20, Component.literal("Opressor"), e -> {
		}));
		this.addRenderableWidget(new Button(this.leftPos + 13, this.topPos + 95, 72, 20, Component.literal("Perciever"), e -> {
		}));
		this.addRenderableWidget(new Button(this.leftPos + 103, this.topPos + 95, 61, 20, Component.literal("Planner"), e -> {
		}));
		this.addRenderableWidget(new Button(this.leftPos + 184, this.topPos + 95, 67, 20, Component.literal("Predator"), e -> {
		}));
		this.addRenderableWidget(new Button(this.leftPos + 274, this.topPos + 95, 72, 20, Component.literal("Puppeteer"), e -> {
		}));
		this.addRenderableWidget(new Button(this.leftPos + 13, this.topPos + 131, 77, 20, Component.literal("Researcher"), e -> {
		}));
		this.addRenderableWidget(new Button(this.leftPos + 202, this.topPos + 131, 51, 20, Component.literal("Ruler"), e -> {
		}));
		this.addRenderableWidget(new Button(this.leftPos + 274, this.topPos + 131, 61, 20, Component.literal("Severer"), e -> {
			if (true) {
				TensurareimaginedMod.PACKET_HANDLER.sendToServer(new UniqueSkillGuiPage2ButtonMessage(15, x, y, z));
				UniqueSkillGuiPage2ButtonMessage.handleButtonAction(entity, 15, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 283, this.topPos + 167, 72, 20, Component.literal("Next Page"), e -> {
			if (true) {
				TensurareimaginedMod.PACKET_HANDLER.sendToServer(new UniqueSkillGuiPage2ButtonMessage(16, x, y, z));
				UniqueSkillGuiPage2ButtonMessage.handleButtonAction(entity, 16, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 13, this.topPos + 167, 93, 20, Component.literal("Previous Page"), e -> {
			if (true) {
				TensurareimaginedMod.PACKET_HANDLER.sendToServer(new UniqueSkillGuiPage2ButtonMessage(17, x, y, z));
				UniqueSkillGuiPage2ButtonMessage.handleButtonAction(entity, 17, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 121, this.topPos + 167, 30, 20, Component.literal("1"), e -> {
			if (true) {
				TensurareimaginedMod.PACKET_HANDLER.sendToServer(new UniqueSkillGuiPage2ButtonMessage(18, x, y, z));
				UniqueSkillGuiPage2ButtonMessage.handleButtonAction(entity, 18, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 175, this.topPos + 167, 30, 20, Component.literal("2"), e -> {
			if (true) {
				TensurareimaginedMod.PACKET_HANDLER.sendToServer(new UniqueSkillGuiPage2ButtonMessage(19, x, y, z));
				UniqueSkillGuiPage2ButtonMessage.handleButtonAction(entity, 19, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 229, this.topPos + 167, 30, 20, Component.literal("3"), e -> {
			if (true) {
				TensurareimaginedMod.PACKET_HANDLER.sendToServer(new UniqueSkillGuiPage2ButtonMessage(20, x, y, z));
				UniqueSkillGuiPage2ButtonMessage.handleButtonAction(entity, 20, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 310, this.topPos + -22, 87, 20, Component.literal("Clear Skills"), e -> {
		}));
	}
}
