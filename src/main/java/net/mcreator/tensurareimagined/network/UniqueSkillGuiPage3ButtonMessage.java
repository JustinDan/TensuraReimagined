
package net.mcreator.tensurareimagined.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.tensurareimagined.world.inventory.UniqueSkillGuiPage3Menu;
import net.mcreator.tensurareimagined.procedures.SelectWrathProcedure;
import net.mcreator.tensurareimagined.procedures.SelectUsurperProcedure;
import net.mcreator.tensurareimagined.procedures.SelectTravelerProcedure;
import net.mcreator.tensurareimagined.procedures.SelectTheChosenOneProcedure;
import net.mcreator.tensurareimagined.procedures.SelectSurvivorProcedure;
import net.mcreator.tensurareimagined.procedures.SelectStarvedProcedure;
import net.mcreator.tensurareimagined.procedures.SelectSpearheadProcedure;
import net.mcreator.tensurareimagined.procedures.SelectSlothProcedure;
import net.mcreator.tensurareimagined.procedures.SelectSkill3Procedure;
import net.mcreator.tensurareimagined.procedures.SelectSkill2Procedure;
import net.mcreator.tensurareimagined.procedures.SelectSkill1Procedure;
import net.mcreator.tensurareimagined.procedures.SelectShadowStrikerProcedure;
import net.mcreator.tensurareimagined.procedures.ClearSkillsButtonProcedure;
import net.mcreator.tensurareimagined.procedures.BackUSkill2Procedure;
import net.mcreator.tensurareimagined.TensurareimaginedMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class UniqueSkillGuiPage3ButtonMessage {
	private final int buttonID, x, y, z;

	public UniqueSkillGuiPage3ButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public UniqueSkillGuiPage3ButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(UniqueSkillGuiPage3ButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(UniqueSkillGuiPage3ButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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
		HashMap guistate = UniqueSkillGuiPage3Menu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			SelectShadowStrikerProcedure.execute(entity);
		}
		if (buttonID == 1) {

			SelectSlothProcedure.execute(entity);
		}
		if (buttonID == 2) {

			SelectSpearheadProcedure.execute(entity);
		}
		if (buttonID == 3) {

			SelectStarvedProcedure.execute(entity);
		}
		if (buttonID == 4) {

			SelectSurvivorProcedure.execute(entity);
		}
		if (buttonID == 5) {

			SelectTheChosenOneProcedure.execute(entity);
		}
		if (buttonID == 6) {

			SelectTravelerProcedure.execute(entity);
		}
		if (buttonID == 7) {

			SelectUsurperProcedure.execute(entity);
		}
		if (buttonID == 8) {

			SelectWrathProcedure.execute(entity);
		}
		if (buttonID == 9) {

			BackUSkill2Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 10) {

			SelectSkill1Procedure.execute(entity);
		}
		if (buttonID == 11) {

			SelectSkill2Procedure.execute(entity);
		}
		if (buttonID == 12) {

			SelectSkill3Procedure.execute(entity);
		}
		if (buttonID == 13) {

			ClearSkillsButtonProcedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		TensurareimaginedMod.addNetworkMessage(UniqueSkillGuiPage3ButtonMessage.class, UniqueSkillGuiPage3ButtonMessage::buffer, UniqueSkillGuiPage3ButtonMessage::new, UniqueSkillGuiPage3ButtonMessage::handler);
	}
}
