package com.paradoxicalblock.StoryCraft.Social;

import java.util.Iterator;
import java.util.UUID;

import com.paradoxicalblock.StoryCraft.Main.StoryCraft;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraft.world.storage.MapStorage;
import net.minecraft.world.storage.WorldSavedData;

public class RelationshipManager extends WorldSavedData {
	private static final String DATA_NAME = StoryCraft.MODID + "_SocialData";
	private NBTTagCompound relationships = new NBTTagCompound();
	public RelationshipManager() {
		super(DATA_NAME);
	}
	public RelationshipManager(String s)
	{
		super(s);
	}
	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		relationships = nbt.getCompoundTag("Relationships");
		
	}
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		compound.setTag("Relationships", relationships);
		return compound;
	}
	public static RelationshipManager get(World world)
	{
		MapStorage storage = world.getMapStorage();
		RelationshipManager instance = (RelationshipManager) storage.getOrLoadData(RelationshipManager.class,DATA_NAME);
		if (instance == null)
		{
			instance = new RelationshipManager();
			storage.setData(DATA_NAME, instance);
		}
		return instance;
	}
	public boolean getCharmed(String subject, String object)
	{
		NBTTagCompound relationship = relationships.getCompoundTag(subject+object);
		return relationship.getBoolean("Charmed");
	}
	public void addRelationship(String identifier, UUID object)
	{
		NBTTagCompound relationship = new NBTTagCompound();
		relationship.setInteger("Opinion", 0);
		relationship.setString("Context", "Neutral");
		relationship.setBoolean("Charmed", false);
		relationship.setBoolean("Apologized", false);
		relationships.setTag(identifier+object.toString(), relationship);
	}
	public boolean getApologized(String subject, UUID object)
	{
		NBTTagCompound relate = relationships.getCompoundTag(subject+object.toString());
		return relate.getBoolean("Apologized");
	}
	public void setApologized(String subject, UUID object)
	{
		NBTTagCompound relate = relationships.getCompoundTag(subject+object.toString());
		relate.setBoolean("Apologized", false);
		relationships.setTag(subject+object.toString(), relate);
	}
	public void setCharmed(String subject, UUID object)
	{
		NBTTagCompound relate = relationships.getCompoundTag(subject+object.toString());
		relate.setBoolean("Charmed", true);
		relationships.setTag(subject+object.toString(), relate);
	}
	public void resetCharmed(String subject, UUID object)
	{
		NBTTagCompound relate = relationships.getCompoundTag(subject+object.toString());
		relate.setBoolean("Charmed", false);
		relationships.setTag(subject+object.toString(), relate);
	}
	public void changeOpinion(String subject, UUID object, int value)
	{
		NBTTagCompound relate = relationships.getCompoundTag(subject+object.toString());
		int oldOpinion = relate.getInteger("Opinion");
		int newOpinion = oldOpinion + value;
		if (newOpinion > 100)
		{
			newOpinion = 100;
		}
		else if(newOpinion < -100)
		{
			newOpinion = -100;
		}
		relate.setInteger("Opinion", newOpinion);
		relationships.setTag(subject+object.toString(), relate);
	}
	public NBTTagCompound getAllCharmed(String subject)
	{
		NBTTagCompound returnTag = new NBTTagCompound();
		Iterator<String> iterate = relationships.getKeySet().iterator();
		while (iterate.hasNext())
		{
			String relationshipKey = iterate.next();
			if(relationshipKey.contains(subject));
			{
				NBTTagCompound intermediary = (NBTTagCompound) relationships.getTag(relationshipKey);
				if (intermediary.getBoolean("Charmed"))
				{
					returnTag.setBoolean(relationshipKey, true);
				}
				
			}
		}
		return returnTag;
	}
	//Method used if the time is NOT skipped forward a day, and instead sunrise occurs naturally.
	public void resetCharmedDaily(String identifier)
	{
			Iterator<String> iterate = relationships.getKeySet().iterator();
			while (iterate.hasNext())
			{
				String relationshipKey = iterate.next();
				if (relationshipKey.contains(identifier))
				{
					NBTTagCompound toReset = relationships.getCompoundTag(relationshipKey);
					toReset.setBoolean("Charmed", false);
				}
			}
	}
	//Method used if time IS skipped forward a day via sleep.
	public void resetAllCharmed()
	{
		Iterator<String> iterate = relationships.getKeySet().iterator();
		while (iterate.hasNext())
		{
			String uuidPair = iterate.next();
			relationships.getCompoundTag(uuidPair).setBoolean("Charmed", false);
		}
	}
	public Integer getOpinion(String subject, UUID object)
	{
		NBTTagCompound relate = relationships.getCompoundTag(subject+object.toString());
		return relate.getInteger("Opinion");
	}
	//Generally only used when the charm action would normally take the opinion higher than 100,
	//and thus must be directly set to 100 instead.
	public void setOpinion(String subject, UUID object, int value)
	{
		NBTTagCompound relate = relationships.getCompoundTag(subject+object.toString());
		relate.setInteger("Opinion", value);
	}
	public String getContext(String subject, UUID object)
	{
		NBTTagCompound relate = relationships.getCompoundTag(subject+object.toString());
		return relate.getString("Context");
	}
}