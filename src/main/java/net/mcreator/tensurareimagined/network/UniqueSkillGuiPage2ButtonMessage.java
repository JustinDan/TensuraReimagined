
package net.mcreator.tensurareimagined.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.tensurareimagined.world.inventory.UniqueSkillGuiPage2Menu;
import net.mcreator.tensurareimagined.procedures.SelectSkill3Procedure;
import net.mcreator.tensurareimagined.procedures.SelectSkill2Procedure;
import net.mcreator.tensurareimagined.procedures.SelectSkill1Procedure;
import net.mcreator.tensurareimagined.procedures.SelectSevererProcedure;
import net.mcreator.tensurareimagined.procedures.OpenUSkill3Procedure;
import net.mcreator.tensurareimagined.procedures.BackUSkill1Procedure;
import net.mcreator.tensurareimagined.TensurareimaginedMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class UniqueSkillGuiPage2ButtonMessage {
	private final int buttonID, x, y, z;

	public UniqueSkillGuiPage2ButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public UniqueSkillGuiPage2ButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(UniqueSkillGuiPage2ButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(UniqueSkillGuiPage2ButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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
		HashMap guistate = UniqueSkillGuiPage2Menu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 15) {

			SelectSevererProcedure.execute(entity);
		}
		if (buttonID == 16) {

			OpenUSkill3Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 17) {

			BackUSkill1Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 18) {

			SelectSkill1Procedure.execute(entity);
		}
		if (buttonID == 19) {

			SelectSkill2Procedure.execute(entity);
		}
		if (buttonID == 20) {

			SelectSkill3Procedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		TensurareimaginedMod.addNetworkMessage(UniqueSkillGuiPage2ButtonMessage.class, UniqueSkillGuiPage2ButtonMessage::buffer,
				UniqueSkillGuiPage2ButtonMessage::new, UniqueSkillGuiPage2ButtonMessage::handler);
	}
}
