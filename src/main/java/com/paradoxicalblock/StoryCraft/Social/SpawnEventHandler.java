package com.paradoxicalblock.StoryCraft.Social;

import java.util.Random;

import com.paradoxicalblock.StoryCraft.entities.SocialVillager;
import com.paradoxicalblock.StoryCraft.entities.SocialVillagerFemale;
import com.paradoxicalblock.StoryCraft.entities.SocialVillagerMale;

import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class SpawnEventHandler {

	
	@SubscribeEvent
	public static void initPersonality(EntityJoinWorldEvent event)
	{
		if (event.getEntity() instanceof SocialVillagerMale || event.getEntity() instanceof SocialVillagerFemale)
		{
			SocialVillager villager = (SocialVillager) event.getEntity();
			if (!villager.world.isRemote)
			{
				villager.world.getPlayerEntityByName("Paradoxicalblock").sendMessage(new TextComponentString("Remote section fired."));
				villager.getDataManager().set(SocialVillager.uuidKey, villager.getUniqueID().toString());
			}
			String villagerID = villager.getDataManager().get(SocialVillager.uuidKey);
			PersonalManager manage = PersonalManager.get(event.getEntity().world);
			if (!manage.personalityExists(villagerID))
			{
				Random rand = new Random();
				int sexualityint = rand.nextInt(9);
				int careerint = rand.nextInt(8);
				villager.setCareer(careerint);
				if (villager instanceof SocialVillagerMale)
				{
					villager.setAppearance(villager.maleCareerSkins.get(careerint) - 1);
				}
				else
				{
					villager.setAppearance(villager.femaleCareerSkins.get(careerint) - 1);
				}
				villager.setFriendly(rand.nextInt(200) - 100);
				villager.setBrave(rand.nextInt(200) - 100);
				villager.setGenerous(rand.nextInt(200) - 100);
				if (sexualityint == 9)
				{
					boolean sexualitybool = rand.nextBoolean();
					if (sexualitybool)
					{
						villager.setSexuality("Bisexual");
					}
					else
					{
						villager.setSexuality("Gay");
					}
				}
				else
				{
					villager.setSexuality("Straight");
				}
				manage.addPersonality(villagerID, villager.getFriendly(), villager.getBrave(), villager.getGenerous(),
						villager.getSexuality(), villager.getAppearance(), villager.getCareer());
				villager.getDataManager().set(SocialVillager.uuidKey, "Blank");
			}
			else
			{
				String uuidString = villager.getDataManager().get(SocialVillager.uuidKey);
				villager.setFriendly(manage.getFriendly(uuidString));
				villager.setBrave(manage.getBrave(uuidString));
				villager.setGenerous(manage.getGenerous(uuidString));
				villager.setSexuality(manage.getOrientation(uuidString));
				villager.setAppearance(manage.getAppearance(uuidString));
				villager.setCareer(manage.getCareer(uuidString));
			}
		}
	}
}
