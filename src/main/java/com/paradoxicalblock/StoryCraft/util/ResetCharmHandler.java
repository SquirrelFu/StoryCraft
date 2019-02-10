package com.paradoxicalblock.StoryCraft.util;

import java.util.UUID;

import com.paradoxicalblock.StoryCraft.Social.RelationshipManager;
import com.paradoxicalblock.StoryCraft.entities.SocialVillager;
import com.paradoxicalblock.StoryCraft.util.packets.ResetCharmPacket;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class ResetCharmHandler implements IMessageHandler<ResetCharmPacket, IMessage> {

	@Override
	public IMessage onMessage(ResetCharmPacket message, MessageContext ctx) {
		MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();
		World serverWorld = ctx.getServerHandler().player.world;
		RelationshipManager manage = RelationshipManager.get(serverWorld);
		manage.resetCharmedDaily(new UUID(message.MSB, message.LSB).toString());
		SocialVillager target = (SocialVillager) server.getEntityFromUuid(new UUID(message.MSB, message.LSB));
		NBTTagCompound wipedCharmNBT = new NBTTagCompound();
		target.getDataManager().set(target.charmKey, wipedCharmNBT);
		return null;
	}

}
