
package net.mcreator.tensurareimagined.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.tensurareimagined.world.inventory.ReincarnationGoblinMenu;
import net.mcreator.tensurareimagined.procedures.OrcSelectRaceProcedure;
import net.mcreator.tensurareimagined.procedures.OpenOrcGuiProcedure;
import net.mcreator.tensurareimagined.procedures.OpenLizardmanRaceProcedure;
import net.mcreator.tensurareimagined.TensurareimaginedMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ReincarnationGoblinButtonMessage {
	private final int buttonID, x, y, z;

	public ReincarnationGoblinButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public ReincarnationGoblinButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(ReincarnationGoblinButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(ReincarnationGoblinButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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
		HashMap guistate = ReincarnationGoblinMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			OrcSelectRaceProcedure.execute(world, entity);
		}
		if (buttonID == 1) {

			OpenOrcGuiProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			OpenLizardmanRaceProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		TensurareimaginedMod.addNetworkMessage(ReincarnationGoblinButtonMessage.class, ReincarnationGoblinButtonMessage::buffer, ReincarnationGoblinButtonMessage::new, ReincarnationGoblinButtonMessage::handler);
	}
}
