package com.paradoxicalblock.StoryCraft.util;

import java.util.UUID;

import com.paradoxicalblock.StoryCraft.Social.Relationship;
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
		RelationshipManager manager = RelationshipManager.getInstance();
		Relationship relate = manager.getRelationship(fullUUID, serverPlayer.getUniqueID());
		if (relate.getOpinion() < 100)
		{
			if((relate.getOpinion() + 5) > 100)
			{
				relate.setOpinion(100);
			}
			else
			{
				relate.modifyOpinion(message.magnitude);	
			}
			
		}
		manager.markDirty();
		return null;
	}
	

}
