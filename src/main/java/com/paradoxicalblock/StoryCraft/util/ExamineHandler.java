package com.paradoxicalblock.StoryCraft.util;

import java.util.UUID;

import com.paradoxicalblock.StoryCraft.Social.RelationshipManager;
import com.paradoxicalblock.StoryCraft.util.packets.ExaminePacket;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class ExamineHandler implements IMessageHandler<ExaminePacket, IMessage> {
	  // Do note that the default constructor is required, but implicitly defined in this case

	  @Override public IMessage onMessage(ExaminePacket message, MessageContext ctx) {
		  String opinionStatus  = "";
		  MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();
		  EntityPlayerMP serverPlayer = ctx.getServerHandler().player;
		  UUID fullUUID = new UUID(message.MSB,message.LSB);
		  Entity target = server.getEntityFromUuid(fullUUID);
		  RelationshipManager manager = RelationshipManager.get(serverPlayer.world);
		  int opinionValue = manager.getOpinion(fullUUID, serverPlayer.getUniqueID());
		  if (opinionValue >= 25 && opinionValue < 50)
		  {
			  opinionStatus = " has a favorable opinion of you";
		  }
		  if(opinionValue >= 50 && opinionValue < 75)
		  {
			  opinionStatus = " is quite fond of you";
		  }
		  if(opinionValue >= 75 && opinionValue <= 100)
		  {
			  opinionStatus = " adores your presence";
		  }
		  if (opinionValue >= 0 && opinionValue < 25)
		  {
			  opinionStatus = " is uncertain what to think of you";
		  }
		  if (opinionValue < 0 && opinionValue > -25)
		  {
			  opinionStatus = " is wary of you";
		  }
		  if (opinionValue <= -25 && opinionValue > -50)
		  {
			  opinionStatus = " finds you distasteful";
		  }
		  if (opinionValue <= -50 && opinionValue > -75)
		  {
			  opinionStatus = " strongly dislikes you";
		  }
		  if (opinionValue <= -75 && opinionValue >= -100)
		  {
			  opinionStatus = " hates your guts";
		  }
		  Minecraft.getMinecraft().player.sendMessage(new TextComponentString(target.getName() + opinionStatus));
		  return null;
	  }
}