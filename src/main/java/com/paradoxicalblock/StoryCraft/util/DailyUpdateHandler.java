package com.paradoxicalblock.StoryCraft.util;

import com.paradoxicalblock.StoryCraft.Social.RelationshipManager;
import com.paradoxicalblock.StoryCraft.util.packets.DailyUpdatePacket;

import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class DailyUpdateHandler implements IMessageHandler<DailyUpdatePacket, IMessage> {

	@Override
	public IMessage onMessage(DailyUpdatePacket message, MessageContext ctx) {
		RelationshipManager manager = RelationshipManager.get(ctx.getServerHandler().player.world);
		//This segment changes the, "Charmed" value on all relationships to false. It's set to activate every time
		//the player wakes up from their rest.
		manager.resetAllCharmed();
		return null;
	}

}
