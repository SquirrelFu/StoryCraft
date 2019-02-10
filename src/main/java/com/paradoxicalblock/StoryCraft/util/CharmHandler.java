package com.paradoxicalblock.StoryCraft.util;

import java.util.UUID;

import com.paradoxicalblock.StoryCraft.Main.StoryCraft;
import com.paradoxicalblock.StoryCraft.Social.PersonalManager;
import com.paradoxicalblock.StoryCraft.Social.RelationshipManager;
import com.paradoxicalblock.StoryCraft.entities.SocialVillager;
import com.paradoxicalblock.StoryCraft.util.packets.CharmPacket;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class CharmHandler implements IMessageHandler<CharmPacket, IMessage> {
	  // Do note that the default constructor is required, but implicitly defined in this case

	  @Override public IMessage onMessage(CharmPacket message, MessageContext ctx) {
		  MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();
		  EntityPlayerMP player = ctx.getServerHandler().player;
		  UUID fullUUID = new UUID(message.MSB,message.LSB);
		  SocialVillager target = (SocialVillager) server.getEntityFromUuid(fullUUID);
		  RelationshipManager manage = RelationshipManager.get(player.world);
		  PersonalManager manage2 = PersonalManager.get(player.world);
		  String serverID = target.getDataManager().get(SocialVillager.uuidKey);
		  if (manage.getCharmed(serverID, player.getUniqueID().toString()))
		  {
			  Minecraft.getMinecraft().player.sendMessage(new TextComponentString("<" + target.getCustomNameTag() + ">: Give it a rest, will you?"));
		  }
		  else
		  {
			  float modifier = (float) manage2.getFriendly(serverID)/400;
			  if (Math.random() < 0.66F + modifier)
			  {
				  Minecraft.getMinecraft().player.sendMessage(new TextComponentString("<"+target.getCustomNameTag() + ">: Hey, neat!"));
				  manage.changeOpinion(serverID, player.getUniqueID(), 5);
				  for (int i = 0; i < 5; i++)
				  {
					  StoryCraft.proxy.generatePleasedParticles(target);
				  }
			  }
			  else
			  {
				  Minecraft.getMinecraft().player.sendMessage(new TextComponentString("<" + target.getCustomNameTag() +">: Am I supposed to be impressed?"));
			  }
			  manage.setCharmed(serverID, player.getUniqueID());
		  }
		  return null;
	  }
}
