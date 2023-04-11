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
	Button button_analyst;
	Button button_beserker;
	Button button_degenerate;
	Button button_dilettante;
	Button button_envy;
	Button button_generalissimo;
	Button button_gluttony;
	Button button_gourmet;
	Button button_godly_craftsman;
	Button button_great_sage;
	Button button_great_wiseman;
	Button button_greed;
	Button button_healer;
	Button button_investigator;
	Button button_lions_heart;
	Button button_next_page;
	Button button_1;
	Button button_2;
	Button button_3;
	Button button_clear_skills;

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
		this.font.draw(poseStack, Component.translatable("gui.tensurareimagined.unique_skill_gui.label_unique_skills"), 4, 5, -12829636);
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
		button_analyst = new Button(this.leftPos + 13, this.topPos + 23, 61, 20, Component.translatable("gui.tensurareimagined.unique_skill_gui.button_analyst"), e -> {
			if (true) {
				TensurareimaginedMod.PACKET_HANDLER.sendToServer(new UniqueSkillGuiButtonMessage(0, x, y, z));
				UniqueSkillGuiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:button_analyst", button_analyst);
		this.addRenderableWidget(button_analyst);
		button_beserker = new Button(this.leftPos + 94, this.topPos + 23, 67, 20, Component.translatable("gui.tensurareimagined.unique_skill_gui.button_beserker"), e -> {
			if (true) {
				TensurareimaginedMod.PACKET_HANDLER.sendToServer(new UniqueSkillGuiButtonMessage(1, x, y, z));
				UniqueSkillGuiButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:button_beserker", button_beserker);
		this.addRenderableWidget(button_beserker);
		button_degenerate = new Button(this.leftPos + 184, this.topPos + 23, 77, 20, Component.translatable("gui.tensurareimagined.unique_skill_gui.button_degenerate"), e -> {
			if (true) {
				TensurareimaginedMod.PACKET_HANDLER.sendToServer(new UniqueSkillGuiButtonMessage(2, x, y, z));
				UniqueSkillGuiButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		guistate.put("button:button_degenerate", button_degenerate);
		this.addRenderableWidget(button_degenerate);
		button_dilettante = new Button(this.leftPos + 283, this.topPos + 23, 77, 20, Component.translatable("gui.tensurareimagined.unique_skill_gui.button_dilettante"), e -> {
			if (true) {
				TensurareimaginedMod.PACKET_HANDLER.sendToServer(new UniqueSkillGuiButtonMessage(3, x, y, z));
				UniqueSkillGuiButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		});
		guistate.put("button:button_dilettante", button_dilettante);
		this.addRenderableWidget(button_dilettante);
		button_envy = new Button(this.leftPos + 13, this.topPos + 59, 46, 20, Component.translatable("gui.tensurareimagined.unique_skill_gui.button_envy"), e -> {
			if (true) {
				TensurareimaginedMod.PACKET_HANDLER.sendToServer(new UniqueSkillGuiButtonMessage(4, x, y, z));
				UniqueSkillGuiButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		});
		guistate.put("button:button_envy", button_envy);
		this.addRenderableWidget(button_envy);
		button_generalissimo = new Button(this.leftPos + 85, this.topPos + 59, 93, 20, Component.translatable("gui.tensurareimagined.unique_skill_gui.button_generalissimo"), e -> {
			if (true) {
				TensurareimaginedMod.PACKET_HANDLER.sendToServer(new UniqueSkillGuiButtonMessage(5, x, y, z));
				UniqueSkillGuiButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		});
		guistate.put("button:button_generalissimo", button_generalissimo);
		this.addRenderableWidget(button_generalissimo);
		button_gluttony = new Button(this.leftPos + 202, this.topPos + 59, 67, 20, Component.translatable("gui.tensurareimagined.unique_skill_gui.button_gluttony"), e -> {
			if (true) {
				TensurareimaginedMod.PACKET_HANDLER.sendToServer(new UniqueSkillGuiButtonMessage(6, x, y, z));
				UniqueSkillGuiButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		});
		guistate.put("button:button_gluttony", button_gluttony);
		this.addRenderableWidget(button_gluttony);
		button_gourmet = new Button(this.leftPos + 292, this.topPos + 59, 61, 20, Component.translatable("gui.tensurareimagined.unique_skill_gui.button_gourmet"), e -> {
			if (true) {
				TensurareimaginedMod.PACKET_HANDLER.sendToServer(new UniqueSkillGuiButtonMessage(7, x, y, z));
				UniqueSkillGuiButtonMessage.handleButtonAction(entity, 7, x, y, z);
			}
		});
		guistate.put("button:button_gourmet", button_gourmet);
		this.addRenderableWidget(button_gourmet);
		button_godly_craftsman = new Button(this.leftPos + 13, this.topPos + 95, 103, 20, Component.translatable("gui.tensurareimagined.unique_skill_gui.button_godly_craftsman"), e -> {
			if (true) {
				TensurareimaginedMod.PACKET_HANDLER.sendToServer(new UniqueSkillGuiButtonMessage(8, x, y, z));
				UniqueSkillGuiButtonMessage.handleButtonAction(entity, 8, x, y, z);
			}
		});
		guistate.put("button:button_godly_craftsman", button_godly_craftsman);
		this.addRenderableWidget(button_godly_craftsman);
		button_great_sage = new Button(this.leftPos + 139, this.topPos + 95, 77, 20, Component.translatable("gui.tensurareimagined.unique_skill_gui.button_great_sage"), e -> {
			if (true) {
				TensurareimaginedMod.PACKET_HANDLER.sendToServer(new UniqueSkillGuiButtonMessage(9, x, y, z));
				UniqueSkillGuiButtonMessage.handleButtonAction(entity, 9, x, y, z);
			}
		});
		guistate.put("button:button_great_sage", button_great_sage);
		this.addRenderableWidget(button_great_sage);
		button_great_wiseman = new Button(this.leftPos + 238, this.topPos + 95, 93, 20, Component.translatable("gui.tensurareimagined.unique_skill_gui.button_great_wiseman"), e -> {
			if (true) {
				TensurareimaginedMod.PACKET_HANDLER.sendToServer(new UniqueSkillGuiButtonMessage(10, x, y, z));
				UniqueSkillGuiButtonMessage.handleButtonAction(entity, 10, x, y, z);
			}
		});
		guistate.put("button:button_great_wiseman", button_great_wiseman);
		this.addRenderableWidget(button_great_wiseman);
		button_greed = new Button(this.leftPos + 13, this.topPos + 131, 51, 20, Component.translatable("gui.tensurareimagined.unique_skill_gui.button_greed"), e -> {
			if (true) {
				TensurareimaginedMod.PACKET_HANDLER.sendToServer(new UniqueSkillGuiButtonMessage(11, x, y, z));
				UniqueSkillGuiButtonMessage.handleButtonAction(entity, 11, x, y, z);
			}
		});
		guistate.put("button:button_greed", button_greed);
		this.addRenderableWidget(button_greed);
		button_healer = new Button(this.leftPos + 85, this.topPos + 131, 56, 20, Component.translatable("gui.tensurareimagined.unique_skill_gui.button_healer"), e -> {
			if (true) {
				TensurareimaginedMod.PACKET_HANDLER.sendToServer(new UniqueSkillGuiButtonMessage(12, x, y, z));
				UniqueSkillGuiButtonMessage.handleButtonAction(entity, 12, x, y, z);
			}
		});
		guistate.put("button:button_healer", button_healer);
		this.addRenderableWidget(button_healer);
		button_investigator = new Button(this.leftPos + 157, this.topPos + 131, 88, 20, Component.translatable("gui.tensurareimagined.unique_skill_gui.button_investigator"), e -> {
			if (true) {
				TensurareimaginedMod.PACKET_HANDLER.sendToServer(new UniqueSkillGuiButtonMessage(13, x, y, z));
				UniqueSkillGuiButtonMessage.handleButtonAction(entity, 13, x, y, z);
			}
		});
		guistate.put("button:button_investigator", button_investigator);
		this.addRenderableWidget(button_investigator);
		button_lions_heart = new Button(this.leftPos + 265, this.topPos + 131, 87, 20, Component.translatable("gui.tensurareimagined.unique_skill_gui.button_lions_heart"), e -> {
			if (true) {
				TensurareimaginedMod.PACKET_HANDLER.sendToServer(new UniqueSkillGuiButtonMessage(14, x, y, z));
				UniqueSkillGuiButtonMessage.handleButtonAction(entity, 14, x, y, z);
			}
		});
		guistate.put("button:button_lions_heart", button_lions_heart);
		this.addRenderableWidget(button_lions_heart);
		button_next_page = new Button(this.leftPos + 283, this.topPos + 167, 72, 20, Component.translatable("gui.tensurareimagined.unique_skill_gui.button_next_page"), e -> {
			if (true) {
				TensurareimaginedMod.PACKET_HANDLER.sendToServer(new UniqueSkillGuiButtonMessage(15, x, y, z));
				UniqueSkillGuiButtonMessage.handleButtonAction(entity, 15, x, y, z);
			}
		});
		guistate.put("button:button_next_page", button_next_page);
		this.addRenderableWidget(button_next_page);
		button_1 = new Button(this.leftPos + 121, this.topPos + 167, 30, 20, Component.translatable("gui.tensurareimagined.unique_skill_gui.button_1"), e -> {
			if (true) {
				TensurareimaginedMod.PACKET_HANDLER.sendToServer(new UniqueSkillGuiButtonMessage(16, x, y, z));
				UniqueSkillGuiButtonMessage.handleButtonAction(entity, 16, x, y, z);
			}
		});
		guistate.put("button:button_1", button_1);
		this.addRenderableWidget(button_1);
		button_2 = new Button(this.leftPos + 175, this.topPos + 167, 30, 20, Component.translatable("gui.tensurareimagined.unique_skill_gui.button_2"), e -> {
			if (true) {
				TensurareimaginedMod.PACKET_HANDLER.sendToServer(new UniqueSkillGuiButtonMessage(17, x, y, z));
				UniqueSkillGuiButtonMessage.handleButtonAction(entity, 17, x, y, z);
			}
		});
		guistate.put("button:button_2", button_2);
		this.addRenderableWidget(button_2);
		button_3 = new Button(this.leftPos + 229, this.topPos + 167, 30, 20, Component.translatable("gui.tensurareimagined.unique_skill_gui.button_3"), e -> {
			if (true) {
				TensurareimaginedMod.PACKET_HANDLER.sendToServer(new UniqueSkillGuiButtonMessage(18, x, y, z));
				UniqueSkillGuiButtonMessage.handleButtonAction(entity, 18, x, y, z);
			}
		});
		guistate.put("button:button_3", button_3);
		this.addRenderableWidget(button_3);
		button_clear_skills = new Button(this.leftPos + 310, this.topPos + -22, 87, 20, Component.translatable("gui.tensurareimagined.unique_skill_gui.button_clear_skills"), e -> {
			if (true) {
				TensurareimaginedMod.PACKET_HANDLER.sendToServer(new UniqueSkillGuiButtonMessage(19, x, y, z));
				UniqueSkillGuiButtonMessage.handleButtonAction(entity, 19, x, y, z);
			}
		});
		guistate.put("button:button_clear_skills", button_clear_skills);
		this.addRenderableWidget(button_clear_skills);
	}
}
