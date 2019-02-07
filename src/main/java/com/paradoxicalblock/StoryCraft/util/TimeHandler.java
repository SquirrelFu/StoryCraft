package com.paradoxicalblock.StoryCraft.util;

import com.paradoxicalblock.StoryCraft.util.packets.DailyUpdatePacket;

import net.minecraftforge.event.entity.player.PlayerWakeUpEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class TimeHandler {

	//Used for any particular stuff that has to happen every in-game day.
	//Note, Minecraft lacks an actual concept of "Days". It simply changes
	//the in-game circumstances without advancing the number of ticks. Ergo,
	//the abstraction of days is unique to this mod.
	@SubscribeEvent
	public static void addDay(PlayerWakeUpEvent event)
	{
		StoryCraftPacketHandler.INSTANCE.sendToServer(new DailyUpdatePacket());
	}
}
