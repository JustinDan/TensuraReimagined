
package net.mcreator.tensurareimagined.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.tensurareimagined.world.inventory.UniqueSkillGuiMenu;
import net.mcreator.tensurareimagined.procedures.SelectSkill3Procedure;
import net.mcreator.tensurareimagined.procedures.SelectSkill2Procedure;
import net.mcreator.tensurareimagined.procedures.SelectSkill1Procedure;
import net.mcreator.tensurareimagined.procedures.SelectLionsHeartProcedure;
import net.mcreator.tensurareimagined.procedures.SelectInvestigatorProcedure;
import net.mcreator.tensurareimagined.procedures.SelectHealerProcedure;
import net.mcreator.tensurareimagined.procedures.SelectGreedProcedure;
import net.mcreator.tensurareimagined.procedures.SelectGreatWisemanProcedure;
import net.mcreator.tensurareimagined.procedures.SelectGreatSageProcedure;
import net.mcreator.tensurareimagined.procedures.SelectGourmetProcedure;
import net.mcreator.tensurareimagined.procedures.SelectGodlyCraftsmanProcedure;
import net.mcreator.tensurareimagined.procedures.SelectGluttonyProcedure;
import net.mcreator.tensurareimagined.procedures.SelectGeneralissimoProcedure;
import net.mcreator.tensurareimagined.procedures.SelectEvnyProcedure;
import net.mcreator.tensurareimagined.procedures.SelectDilettanteProcedure;
import net.mcreator.tensurareimagined.procedures.SelectDegenerateProcedure;
import net.mcreator.tensurareimagined.procedures.SelectBerserkerProcedure;
import net.mcreator.tensurareimagined.procedures.SelectAnalystProcedure;
import net.mcreator.tensurareimagined.procedures.OpenUSkill2Procedure;
import net.mcreator.tensurareimagined.procedures.ClearSkillsButtonProcedure;
import net.mcreator.tensurareimagined.TensurareimaginedMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class UniqueSkillGuiButtonMessage {
	private final int buttonID, x, y, z;

	public UniqueSkillGuiButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public UniqueSkillGuiButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(UniqueSkillGuiButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(UniqueSkillGuiButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
			Player entity = context.getSender();
			int buttonID = message.buttonID;
			int x = message.x;
			int y = message.y;
			int z = message.z;
			handleButtonAction(entity, buttonID, x, y, z);
		});
		context.setPacketHandled(true);
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level;
		HashMap guistate = UniqueSkillGuiMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			SelectAnalystProcedure.execute(entity);
		}
		if (buttonID == 1) {

			SelectBerserkerProcedure.execute(entity);
		}
		if (buttonID == 2) {

			SelectDegenerateProcedure.execute(entity);
		}
		if (buttonID == 3) {

			SelectDilettanteProcedure.execute(entity);
		}
		if (buttonID == 4) {

			SelectEvnyProcedure.execute(entity);
		}
		if (buttonID == 5) {

			SelectGeneralissimoProcedure.execute(entity);
		}
		if (buttonID == 6) {

			SelectGluttonyProcedure.execute(entity);
		}
		if (buttonID == 7) {

			SelectGourmetProcedure.execute(entity);
		}
		if (buttonID == 8) {

			SelectGodlyCraftsmanProcedure.execute(entity);
		}
		if (buttonID == 9) {

			SelectGreatSageProcedure.execute(entity);
		}
		if (buttonID == 10) {

			SelectGreatWisemanProcedure.execute(entity);
		}
		if (buttonID == 11) {

			SelectGreedProcedure.execute(entity);
		}
		if (buttonID == 12) {

			SelectHealerProcedure.execute(entity);
		}
		if (buttonID == 13) {

			SelectInvestigatorProcedure.execute(entity);
		}
		if (buttonID == 14) {

			SelectLionsHeartProcedure.execute(entity);
		}
		if (buttonID == 15) {

			OpenUSkill2Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 16) {

			SelectSkill1Procedure.execute(entity);
		}
		if (buttonID == 17) {

			SelectSkill2Procedure.execute(entity);
		}
		if (buttonID == 18) {

			SelectSkill3Procedure.execute(entity);
		}
		if (buttonID == 19) {

			ClearSkillsButtonProcedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		TensurareimaginedMod.addNetworkMessage(UniqueSkillGuiButtonMessage.class, UniqueSkillGuiButtonMessage::buffer, UniqueSkillGuiButtonMessage::new, UniqueSkillGuiButtonMessage::handler);
	}
}
