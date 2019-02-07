package com.paradoxicalblock.StoryCraft.util;

import java.util.List;

import com.paradoxicalblock.StoryCraft.Social.PersonalityManager;
import com.paradoxicalblock.StoryCraft.Social.Relationship;
import com.paradoxicalblock.StoryCraft.Social.RelationshipManager;

import net.minecraft.world.storage.MapStorage;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class ManagerStartup {

	@SubscribeEvent
	public static void startInstance(WorldEvent.Load event)
	{
		RelationshipManager.SetInstance(event.getWorld());
		PersonalityManager.SetInstance(event.getWorld());
	}
	@SubscribeEvent
	public static void stopInstance(WorldEvent.Unload event)
	{
		RelationshipManager manager = RelationshipManager.getInstance();
		List<Relationship> relateList = manager.getAllRelationships();
		MapStorage storage = event.getWorld().getMapStorage();
		storage.saveAllData();
	}
}
