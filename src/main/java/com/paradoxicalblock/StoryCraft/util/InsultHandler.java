package com.paradoxicalblock.StoryCraft.util;

import java.util.UUID;

import com.paradoxicalblock.StoryCraft.Main.StoryCraft;
import com.paradoxicalblock.StoryCraft.Social.PersonalManager;
import com.paradoxicalblock.StoryCraft.Social.RelationshipManager;
import com.paradoxicalblock.StoryCraft.entities.SocialVillager;
import com.paradoxicalblock.StoryCraft.util.packets.InsultPacket;

import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class InsultHandler implements IMessageHandler<InsultPacket, IMessage> {

	@Override
	public IMessage onMessage(InsultPacket message, MessageContext ctx) {
		MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();
		EntityPlayerMP player = ctx.getServerHandler().player;
		UUID fullUUID = new UUID(message.MSB, message.LSB);
		SocialVillager target = (SocialVillager) server.getEntityFromUuid(fullUUID);
		RelationshipManager manager = RelationshipManager.get(player.getEntityWorld());
		PersonalManager manager2 = PersonalManager.get(player.getEntityWorld());
		int totalOpinion = manager.getOpinion(target.getUniqueID(), player.getUniqueID());
		//Target has a 10% chance to attack the player for insulting them, if their bravery is high
		if (target.getDataManager().get(target.braveryKey) >= 75)
		{
			if (Math.random() >= 0.9)
			{
				target.tasks.addTask(2, new EntityAIAttackMelee(target, 1.0D, false));
				target.setAttackTarget(player);
				player.sendMessage(new TextComponentString("<" + target.getDisplayName() + ">: You're gonna pay!"));
				manager.changeOpinion(target.getUniqueID(), player.getUniqueID(), -30);
				for (int i = 0; i < 30; i++)
				{
					StoryCraft.proxy.generateDispleasedParticles(target);
				}
			}
			
		}
		else
		{
			
			if (totalOpinion >= 25 && totalOpinion < 50)
			{
				player.sendMessage(new TextComponentString("<" + target.getCustomNameTag() + ">: You jerk!"));
			}
			else if (totalOpinion >= 50 && totalOpinion < 75)
			{
				player.sendMessage(new TextComponentString("<" + target.getCustomNameTag() + ">: Hey, cut it out!"));
			}
			else if (totalOpinion >= 75)
			{
				player.sendMessage(new TextComponentString("<" + target.getCustomNameTag() + ">: I-I thought you... Nevermind."));
			}
			else
			{
				player.sendMessage(new TextComponentString("<" + target.getCustomNameTag() + ">: How dare you?!"));
			}
			for (int i = 0; i < 15; i++)
			{
				StoryCraft.proxy.generateDispleasedParticles(target);
			}
			manager.changeOpinion(target.getUniqueID(), player.getUniqueID(), -15);
			
		}
		
		return null;
	}

}
