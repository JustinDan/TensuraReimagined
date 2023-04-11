
package net.mcreator.tensurareimagined.client.screens;

import org.checkerframework.checker.units.qual.h;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.client.event.RenderGuiEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.Minecraft;

import net.mcreator.tensurareimagined.procedures.Skillbar3ValueProcedure;
import net.mcreator.tensurareimagined.procedures.Skillbar2ValueProcedure;
import net.mcreator.tensurareimagined.procedures.Skillbar1ValueProcedure;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager;

@Mod.EventBusSubscriber({Dist.CLIENT})
public class SkillbarOverlay {
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void eventHandler(RenderGuiEvent.Pre event) {
		int w = event.getWindow().getGuiScaledWidth();
		int h = event.getWindow().getGuiScaledHeight();
		int posX = w/2;
		int posY = h/2;
		Level world = null;
		double x = 0;
		double y = 0;
		double z = 0;
		Player entity = Minecraft.getInstance().player;
		if (entity != null) {
			world = entity.level;
			x = entity.getX();
			y = entity.getY();
			z = entity.getZ();
		}
		RenderSystem.disableDepthTest();
		RenderSystem.depthMask(false);
		RenderSystem.enableBlend();
		RenderSystem.setShader(GameRenderer::getPositionTexShader);
		RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
		RenderSystem.setShaderColor(1, 1, 1, 1);
		if (true) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("tensurareimagined:textures/screens/skillbartest.png"));
			Minecraft.getInstance().gui.blit(event.getPoseStack(), posX + -208, posY + 38, 0, 0, 100, 20, 100, 20);

			RenderSystem.setShaderTexture(0, new ResourceLocation("tensurareimagined:textures/screens/skillbartest.png"));
			Minecraft.getInstance().gui.blit(event.getPoseStack(), posX + -208, posY + 60, 0, 0, 100, 20, 100, 20);

			RenderSystem.setShaderTexture(0, new ResourceLocation("tensurareimagined:textures/screens/skillbartest.png"));
			Minecraft.getInstance().gui.blit(event.getPoseStack(), posX + -208, posY + 82, 0, 0, 100, 20, 100, 20);

			Minecraft.getInstance().font.draw(event.getPoseStack(), Component.translatable("gui.tensurareimagined.skillbar.label_empty"), posX + -205, posY + 43, -1);
			Minecraft.getInstance().font.draw(event.getPoseStack(), Component.translatable("gui.tensurareimagined.skillbar.label_empty1"), posX + -205, posY + 65, -1);
			Minecraft.getInstance().font.draw(event.getPoseStack(),

					Skillbar1ValueProcedure.execute(entity), posX + -197, posY + 43, -52429);
			Minecraft.getInstance().font.draw(event.getPoseStack(),

					Skillbar2ValueProcedure.execute(entity), posX + -197, posY + 65, -16711936);
			Minecraft.getInstance().font.draw(event.getPoseStack(),

					Skillbar3ValueProcedure.execute(entity), posX + -197, posY + 87, -205);
			Minecraft.getInstance().font.draw(event.getPoseStack(), Component.translatable("gui.tensurareimagined.skillbar.label_3"), posX + -205, posY + 87, -1);
		}
		RenderSystem.depthMask(true);
		RenderSystem.defaultBlendFunc();
		RenderSystem.enableDepthTest();
		RenderSystem.disableBlend();
		RenderSystem.setShaderColor(1, 1, 1, 1);
	}
}
