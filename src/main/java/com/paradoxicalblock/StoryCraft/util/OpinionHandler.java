package com.paradoxicalblock.StoryCraft.util;

import java.util.UUID;

import com.paradoxicalblock.StoryCraft.Social.RelationshipManager;
import com.paradoxicalblock.StoryCraft.util.packets.OpinionPacket;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class OpinionHandler implements IMessageHandler<OpinionPacket, IMessage>{

	@Override
	public IMessage onMessage(OpinionPacket message, MessageContext ctx) {
		EntityPlayerMP serverPlayer = ctx.getServerHandler().player;
		UUID fullUUID = new UUID(message.MSB,message.LSB);
		RelationshipManager manager = RelationshipManager.get(serverPlayer.world);
		int opinionValue = manager.getOpinion(fullUUID, serverPlayer.getUniqueID());
		if (opinionValue < 100)
		{
			if((opinionValue + 5) > 100)
			{
				manager.setOpinion(fullUUID, serverPlayer.getUniqueID(), 100);
			}
			else
			{
				manager.changeOpinion(fullUUID, serverPlayer.getUniqueID(), 5);
			}
			
		}
		manager.markDirty();
		return null;
	}
	

}
