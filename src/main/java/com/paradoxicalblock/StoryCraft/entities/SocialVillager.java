package com.paradoxicalblock.StoryCraft.entities;

import java.util.List;

import com.paradoxicalblock.StoryCraft.Social.RelationshipManager;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class SocialVillager extends EntityAgeable {
	private Long lastReset;
	private boolean resetNeeded;
	protected String sexuality;
	protected int appearance;
	protected int career;
	protected int friendliness;
	protected int bravery;
	protected int generosity;
	public List<Integer> maleCareerSkins;
	public List<Integer> femaleCareerSkins;
	public static DataParameter<String> uuidKey;
	
	@Override
	public void entityInit()
	{
		super.entityInit();
		uuidKey = EntityDataManager.createKey(SocialVillager.class, DataSerializers.STRING);
		this.getDataManager().register(uuidKey, "Blank");
	}
	public int getFriendly()
	{
		return this.friendliness;
	}
	public int getBrave()
	{
		return this.bravery;
	}
	public int getGenerous()
	{
		return this.generosity;
	}
	public void setFriendly(int newvalue)
	{
		if (newvalue > 100)
		{
			newvalue = 100;
		}
		if (newvalue < -100)
		{
			newvalue = -100;
		}
		this.friendliness = newvalue;
	}
	public void setBrave(int newvalue)
	{
		if (newvalue > 100)
		{
			newvalue = 100;
		}
		if (newvalue < -100)
		{
			newvalue = -100;
		}
		this.bravery = newvalue;
	}
	public void setGenerous(int newvalue)
	{
		if (newvalue > 100)
		{
			newvalue = 100;
		}
		if (newvalue < -100)
		{
			newvalue = -100;
		}
		this.generosity = newvalue;
	}
	public void setSexuality(String newvalue)
	{
		this.sexuality = newvalue;
	}
	public String getSexuality()
	{
		return this.sexuality;
	}
	public SocialVillager(World worldIn) {
		super(worldIn);
	}
	public void setCareer(int career)
	{
		this.career = career;
	}
	public int getCareer()
	{
		return this.career;
	}
	public int getAppearance()
	{
		return this.appearance;
	}
	public void setAppearance(int appearance)
	{
		this.appearance = appearance;
	}
	@Override
	public boolean attackEntityAsMob(Entity entityTarget)
	{
	    int knockbackModifier = 0;
	    boolean isTargetHurt = entityTarget.attackEntityFrom(DamageSource
	          .causeMobDamage(this), 3.0F);
	    if (isTargetHurt)
	    {
	        if (knockbackModifier  > 0)
	        {
	            entityTarget.addVelocity((double)(-MathHelper.sin(rotationYaw * 
	
	                  (float)Math.PI / 180.0F) * (float)knockbackModifier  * 0.5F), 
	
	                   0.1D, (double)(MathHelper.cos(rotationYaw * 
	
	                  (float)Math.PI / 180.0F) * (float)knockbackModifier  * 0.5F));
	            motionX *= 0.6D;
	            motionZ *= 0.6D;
	        }
	        int fireModifier = EnchantmentHelper.getFireAspectModifier(this);
	        if (fireModifier > 0)
	        {
	            entityTarget.setFire(fireModifier * 4);
	        }
	    }
	    return isTargetHurt ;
	}
	
	@Override
	protected void initEntityAI() {
	    this.tasks.addTask(0, new EntityAISwimming(this));
	    this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
	    this.tasks.addTask(8, new EntityAILookIdle(this));
	    this.applyEntityAI();
	}
	
	private void applyEntityAI() {
	    this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false, null));
	}

	@Override
	public EntityAgeable createChild(EntityAgeable ageable) {
		return null;
	}

	@Override
	public boolean processInteract(EntityPlayer player, EnumHand hand)
	{
		if (!this.world.isRemote)
		{
			player.sendMessage(new TextComponentString("Server UUID: " + this.getUniqueID()));
			return true;
		}
		player.sendMessage(new TextComponentString("Client UUID: " + this.getUniqueID()));
		return false;
	}
	/*@Override
	public boolean processInteract(EntityPlayer player, EnumHand hand)
	{
		world = player.world;
		if (!world.isRemote)
        {	
			//This block of code is for adding a new relationship if the player character hasn't met
			//the villager in question before.
			RelationshipManager manager = RelationshipManager.get(world);
			if (manager.getContext(""+getUniqueID(), player.getUniqueID()) == "")
			{
				manager.addRelationship(""+getUniqueID(), player.getUniqueID());
				manager.markDirty();
			}
			return true;
			
        }
		player.openGui(StoryCraft.instance, 1, world, getEntityId(), 0, 0);
		return false;
	}*/
	public void markForReset()
	{
		resetNeeded = true;
	}
	@Override
	public void onLivingUpdate()
	{	
		if (!world.isRemote)
		{
			Long timeOffset = (long) 0;
			if (lastReset != null)
			{
				timeOffset = world.getTotalWorldTime() - lastReset;
			}
			else
			{
				lastReset = world.getTotalWorldTime();
			}
	
			Long worldTime = world.getWorldTime();
			if ((worldTime == 23250 || timeOffset > 24000) && resetNeeded)
			{
				RelationshipManager manager = RelationshipManager.get(world);
				manager.resetCharmedDaily(""+getUniqueID());
				resetNeeded = false;
				lastReset = world.getTotalWorldTime();
			}
		}
		super.onLivingUpdate();
	}
}