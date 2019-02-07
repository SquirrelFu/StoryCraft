package com.paradoxicalblock.StoryCraft.entities;

import java.util.List;

import com.paradoxicalblock.StoryCraft.Main.StoryCraft;
import com.paradoxicalblock.StoryCraft.Social.PersonalityManager;
import com.paradoxicalblock.StoryCraft.Social.Relationship;
import com.paradoxicalblock.StoryCraft.Social.RelationshipManager;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class SocialVillager extends EntityAgeable {
	private boolean isMale;
	private Long lastReset;
	private boolean resetNeeded;
	public SocialVillager(World worldIn) {
		super(worldIn);
		if (isMale)
		{
			setSize(0.6F, 1.8F);
		}
		else
		{
			setSize(0.5F, 1.65F);
		}
	}
	@Override
	public void entityInit()
	{
		super.entityInit();
		
	}
	@Override
	public EntityAgeable createChild(EntityAgeable ageable) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean processInteract(EntityPlayer player, EnumHand hand)
	{
		world = player.world;
		if (!world.isRemote)
        {	
			//This block of code is for adding a new relationship if the player character hasn't met
			//the villager in question before.
			RelationshipManager manager = RelationshipManager.getInstance();
			PersonalityManager personality = PersonalityManager.getInstance();
			if (manager.getRelationship(this.getUniqueID(), player.getUniqueID()) == null)
			{
				manager.AddRelationship(this.getUniqueID(), player.getUniqueID());
				manager.markDirty();
			}
			if (personality.getPersonality(this.getUniqueID()) == null)
			{
				personality.AddPersonality(getUniqueID());
				personality.markDirty();
			}
			return true;
			
        }
		player.openGui(StoryCraft.instance, 1, world, this.getEntityId(), 0, 0);
		return false;
	}
	public void markForReset()
	{
		this.resetNeeded = true;
	}
	@Override
	public void onLivingUpdate()
	{	
		Long timeOffset = (long) 0;
		if (lastReset != null)
		{
			timeOffset = this.world.getTotalWorldTime() - lastReset;
		}
		else
		{
			lastReset = this.world.getTotalWorldTime();
		}

		Long worldTime = this.world.getWorldTime();
		if ((worldTime == 23250 || timeOffset > 24000) && resetNeeded)
		{
			RelationshipManager manager = RelationshipManager.getInstance();
			List<Relationship> relateList = manager.getAllTargetRelationships(this.getUniqueID());
			for (Relationship relate : relateList)
			{
				if (relate.getCharmed())
				{
					relate.resetCharmed();
				}
			}
			resetNeeded = false;
			lastReset = this.world.getTotalWorldTime();
		}
		super.onLivingUpdate();
	}
}