package com.paradoxicalblock.StoryCraft.util;

import java.util.List;
import java.util.UUID;

import com.paradoxicalblock.StoryCraft.Social.Relationship;
import com.paradoxicalblock.StoryCraft.Social.RelationshipManager;
import com.paradoxicalblock.StoryCraft.util.packets.ResetCharmPacket;

import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class ResetCharmHandler implements IMessageHandler<ResetCharmPacket, IMessage>{

	@Override
	public IMessage onMessage(ResetCharmPacket message, MessageContext ctx) {
		RelationshipManager manage = RelationshipManager.getInstance();
		if (message.MSB != null)
		{
			UUID fullUUID = new UUID(message.MSB, message.LSB);	
			List<Relationship> relateList = manage.getAllTargetRelationships(fullUUID);
			for (Relationship relate : relateList)
			{
				relate.resetCharmed();
			}
		}
		else
		{
			List<Relationship> relateList = manage.getAllRelationships();
			for (Relationship relate : relateList)
			{
				relate.resetCharmed();
			}
		}
		
		return null;
	}

}
