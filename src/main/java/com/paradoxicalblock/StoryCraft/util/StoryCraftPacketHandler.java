package com.paradoxicalblock.StoryCraft.util;

import com.paradoxicalblock.StoryCraft.Main.StoryCraft;
import com.paradoxicalblock.StoryCraft.util.packets.ApologyPacket;
import com.paradoxicalblock.StoryCraft.util.packets.CharmPacket;
import com.paradoxicalblock.StoryCraft.util.packets.DailyUpdatePacket;
import com.paradoxicalblock.StoryCraft.util.packets.ExaminePacket;
import com.paradoxicalblock.StoryCraft.util.packets.InsultPacket;
import com.paradoxicalblock.StoryCraft.util.packets.ServerUUIDPacket;

import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class StoryCraftPacketHandler {

	public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(StoryCraft.MODID);
	public static void RegisterMessages()
	{
		StoryCraftPacketHandler.INSTANCE.registerMessage(ExamineHandler.class, ExaminePacket.class, 0, Side.SERVER);
		StoryCraftPacketHandler.INSTANCE.registerMessage(ExamineHandler.class, ExaminePacket.class, 0, Side.CLIENT);
		StoryCraftPacketHandler.INSTANCE.registerMessage(CharmHandler.class, CharmPacket.class, 1, Side.SERVER);
		StoryCraftPacketHandler.INSTANCE.registerMessage(CharmHandler.class, CharmPacket.class, 1, Side.CLIENT);
		StoryCraftPacketHandler.INSTANCE.registerMessage(DailyUpdateHandler.class, DailyUpdatePacket.class, 2, Side.SERVER);
		StoryCraftPacketHandler.INSTANCE.registerMessage(DailyUpdateHandler.class, DailyUpdatePacket.class, 2, Side.CLIENT);
		StoryCraftPacketHandler.INSTANCE.registerMessage(ApologyHandler.class, ApologyPacket.class, 3, Side.SERVER);
		StoryCraftPacketHandler.INSTANCE.registerMessage(ApologyHandler.class, ApologyPacket.class, 3, Side.CLIENT);
		StoryCraftPacketHandler.INSTANCE.registerMessage(InsultHandler.class, InsultPacket.class, 4, Side.SERVER);
		StoryCraftPacketHandler.INSTANCE.registerMessage(InsultHandler.class, InsultPacket.class, 4, Side.CLIENT);
		StoryCraftPacketHandler.INSTANCE.registerMessage(ServerUUIDHandler.class, ServerUUIDPacket.class, 5, Side.SERVER);
		StoryCraftPacketHandler.INSTANCE.registerMessage(ServerUUIDHandler.class, ServerUUIDPacket.class, 5, Side.CLIENT);
		
	}
}
