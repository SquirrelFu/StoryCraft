package com.paradoxicalblock.StoryCraft.util;

import java.util.UUID;

import com.paradoxicalblock.StoryCraft.Social.RelationshipManager;
import com.paradoxicalblock.StoryCraft.entities.SocialVillager;
import com.paradoxicalblock.StoryCraft.util.packets.ResetCharmPacket;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class ResetCharmHandler implements IMessageHandler<ResetCharmPacket, IMessage> {

	@Override
	public IMessage onMessage(ResetCharmPacket message, MessageContext ctx) {
		MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();
		EntityPlayerMP serverPlayer = ctx.getServerHandler().player;
		RelationshipManager manage = RelationshipManager.get(serverPlayer.world);
		SocialVillager target = (SocialVillager) server.getEntityFromUuid(new UUID(message.MSB,message.LSB));
		String serverID = target.getDataManager().get(SocialVillager.uuidKey);
		manage.resetCharmedDaily(serverID);
		return null;
	}

}
