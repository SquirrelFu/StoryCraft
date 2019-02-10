package com.paradoxicalblock.StoryCraft.util;

import java.util.UUID;

import com.paradoxicalblock.StoryCraft.entities.SocialVillagerFemale;
import com.paradoxicalblock.StoryCraft.util.packets.ServerUUIDPacket;

import net.minecraft.client.Minecraft;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class ServerUUIDHandler implements IMessageHandler<ServerUUIDPacket, IMessage> {

	@Override
	public IMessage onMessage(ServerUUIDPacket message, MessageContext ctx) {
		SocialVillagerFemale target = (SocialVillagerFemale) Minecraft.getMinecraft().world.getEntityByID(message.entityID);
		if (target != null)
		{
			UUID fullUUID = new UUID(message.MSB,message.LSB);
			target.getDataManager().register(target.uuidKey, fullUUID.toString());
		}
		else
		{
			Minecraft.getMinecraft().player.sendMessage(new TextComponentString("Entity was null"));
		}
		return null;
	}

	
}
