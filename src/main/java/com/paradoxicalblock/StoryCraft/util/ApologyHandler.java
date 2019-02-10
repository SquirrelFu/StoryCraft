package com.paradoxicalblock.StoryCraft.util;

import java.util.UUID;

import com.paradoxicalblock.StoryCraft.Main.StoryCraft;
import com.paradoxicalblock.StoryCraft.Social.PersonalManager;
import com.paradoxicalblock.StoryCraft.Social.RelationshipManager;
import com.paradoxicalblock.StoryCraft.util.packets.ApologyPacket;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class ApologyHandler implements IMessageHandler<ApologyPacket, IMessage>{

	@Override
	public IMessage onMessage(ApologyPacket message, MessageContext ctx) {
		MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();
		EntityPlayerMP player = ctx.getServerHandler().player;
		UUID fullUUID = new UUID(message.MSB, message.LSB);
		Entity target = server.getEntityFromUuid(fullUUID);
		RelationshipManager manager = RelationshipManager.get(player.getEntityWorld());
		PersonalManager manager2 = PersonalManager.get(player.getEntityWorld());
		int totalOpinion = manager.getOpinion(fullUUID, player.getUniqueID());
		if (totalOpinion < 0)
		{
			float modifier = (float) manager2.getFriendly(target.getUniqueID().toString())/400 + totalOpinion/400;
			if (Math.random() < 0.66 + modifier)
			{
				player.sendMessage(new TextComponentString("<" + target.getCustomNameTag() + ">: ...Sure. I forgive you."));
				manager.changeOpinion(fullUUID, player.getUniqueID(), 10);
				for (int i = 0; i < 10; i++)
				{
					StoryCraft.proxy.generatePleasedParticles(target);
				}
			}
			else
			{
				if (totalOpinion > -25 && totalOpinion < 0)
				{
					player.sendMessage(new TextComponentString("<" + target.getCustomNameTag() + ">: I'm not quite ready, sorry."));
				}
				if (totalOpinion <= -25 && totalOpinion > 50)
				{
					player.sendMessage(new TextComponentString("<" + target.getCustomNameTag() + ">: What you did isn't going away that easily."));
				}
				if (totalOpinion <= -50 && totalOpinion > -75)
				{
					player.sendMessage(new TextComponentString("<" + target.getCustomNameTag() + ">: Buzz off."));
				}
				if (totalOpinion <= -75)
				{
					player.sendMessage(new TextComponentString("<" + target.getCustomNameTag() +">: Leave. NOW!"));
				}
			}
		}
		else
		{
			player.sendMessage(new TextComponentString("<" + target.getCustomNameTag() + ">: What are you apologizing for?"));
		}
		return null;
	}
	
	

}
