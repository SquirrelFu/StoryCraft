package com.paradoxicalblock.StoryCraft.util;

import java.util.UUID;

import com.paradoxicalblock.StoryCraft.Main.StoryCraft;
import com.paradoxicalblock.StoryCraft.Social.PersonalManager;
import com.paradoxicalblock.StoryCraft.Social.RelationshipManager;
import com.paradoxicalblock.StoryCraft.entities.SocialVillager;
import com.paradoxicalblock.StoryCraft.util.packets.CharmPacket;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
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
		  for (String string  : target.getDataManager().get(target.charmKey).getKeySet() )
		  {
			  if (string.contains(player.getUniqueID().toString()))
			  {
				  NBTTagCompound nbt = target.getDataManager().get(target.charmKey).getCompoundTag(string);
				  if (nbt.getBoolean("Charmed") == true)
				  {
					  Minecraft.getMinecraft().player.sendMessage(new TextComponentString("<" + target.getCustomNameTag() + ">: Give it a rest, will you?"));
					  return null;
				  }
				  charmAttempt(fullUUID, player.getUniqueID(), player.world);
				  return null;
			  }
			  charmAttempt(fullUUID, player.getUniqueID(), player.world);
			  return null;
		  }
		  charmAttempt(fullUUID, player.getUniqueID(), player.world);
		  return null;
	  }
	  public void charmAttempt(UUID uuid, UUID object, World world)
	  {
		  MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();
		  RelationshipManager relate = RelationshipManager.get(world);
		  PersonalManager personal = PersonalManager.get(world);
		  SocialVillager target = (SocialVillager) server.getEntityFromUuid(uuid);
		  float modifier = (float) personal.getFriendly(target.getUniqueId())/400;
		  if (Math.random() < 0.66 + modifier)
		  {
			  for (int i = 0; i < 5; i++)
			  {
				  StoryCraft.proxy.generatePleasedParticles(target);
			  }
			  Minecraft.getMinecraft().player.sendMessage(new TextComponentString("<" + target.getCustomNameTag() + ">: Hey, neat!"));
			  relate.changeOpinion(uuid, object, 5);
			  
		  }
		  else
		  {
			  Minecraft.getMinecraft().player.sendMessage(new TextComponentString("<" + target.getCustomNameTag() + ">: Am I supposed to be impressed?"));
		  }
		  relate.setCharmed(uuid, object);
		  target.markForReset();
		  relate.markDirty();
	  }
}
