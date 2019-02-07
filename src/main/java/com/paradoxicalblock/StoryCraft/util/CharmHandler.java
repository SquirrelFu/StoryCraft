package com.paradoxicalblock.StoryCraft.util;

import java.util.UUID;

import com.paradoxicalblock.StoryCraft.Social.Personality;
import com.paradoxicalblock.StoryCraft.Social.PersonalityManager;
import com.paradoxicalblock.StoryCraft.Social.Relationship;
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
		  RelationshipManager manage2 = RelationshipManager.getInstance();
		  Relationship relate = manage2.getRelationship(fullUUID, player.getUniqueID());
		  SocialVillager target = (SocialVillager) server.getEntityFromUuid(fullUUID);
		  if (relate.getCharmed() == false)
		  {
			  PersonalityManager manage = PersonalityManager.getInstance();
			  Personality personality = manage.getPersonality(fullUUID);
			  int friendliness = personality.getFriendly();
			  float modifier = (float) friendliness/400;
			  if (Math.random() < 0.75 + modifier)
			  {
				  Minecraft.getMinecraft().player.sendMessage(new TextComponentString(target.getName() + " is impressed!"));
			  }
			  else
			  {
				  Minecraft.getMinecraft().player.sendMessage(new TextComponentString(target.getName() + " doesn't seem swayed."));
			  }
			  relate.setCharmed();
			  target.markForReset();
			  manage2.markDirty();
		  }
		  else
		  {
			  Minecraft.getMinecraft().player.sendMessage(new TextComponentString("You've already tried to charm " + target.getName() + " today!"));
		  }
		  return null;
	  }
}
