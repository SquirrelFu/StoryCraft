package com.paradoxicalblock.StoryCraft.util;

import com.paradoxicalblock.StoryCraft.Main.StoryCraft;
import com.paradoxicalblock.StoryCraft.util.packets.CharmPacket;
import com.paradoxicalblock.StoryCraft.util.packets.DailyUpdatePacket;
import com.paradoxicalblock.StoryCraft.util.packets.ExaminePacket;

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
	}
}
