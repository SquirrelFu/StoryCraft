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
	public boolean getCharmed(UUID subject, UUID object)
	{
		NBTTagCompound relationship = relationships.getCompoundTag(subject.toString()+object.toString());
		return relationship.getBoolean("Charmed");
	}
	public void addRelationship(String identifier, UUID object)
	{
		NBTTagCompound relationship = new NBTTagCompound();
		relationship.setInteger("Opinion", 0);
		relationship.setString("Context", "Neutral");
		relationship.setBoolean("Charmed", false);
		relationships.setTag(identifier+object.toString(), relationship);
	}
	public void setCharmed(UUID subject, UUID object)
	{
		NBTTagCompound relate = relationships.getCompoundTag(subject.toString()+object.toString());
		relate.setBoolean("Charmed", true);
		relationships.setTag(subject.toString()+object.toString(), relate);
	}
	public void resetCharmed(UUID subject, UUID object)
	{
		NBTTagCompound relate = relationships.getCompoundTag(subject.toString()+object.toString());
		relate.setBoolean("Charmed", false);
		relationships.setTag(subject.toString()+object.toString(), relate);
	}
	public void changeOpinion(UUID subject, UUID object, int value)
	{
		NBTTagCompound relate = relationships.getCompoundTag(subject.toString()+object.toString());
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
		relationships.setTag(subject.toString()+object.toString(), relate);
	}
	public NBTTagCompound getAllCharmed(UUID subject)
	{
		NBTTagCompound returnTag = new NBTTagCompound();
		Iterator<String> iterate = relationships.getKeySet().iterator();
		while (iterate.hasNext())
		{
			String relationshipKey = iterate.next();
			if(relationshipKey.contains(subject.toString()));
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
	public Integer getOpinion(UUID subject, UUID object)
	{
		NBTTagCompound relate = relationships.getCompoundTag(subject.toString()+object.toString());
		return relate.getInteger("Opinion");
	}
	//Generally only used when the charm action would normally take the opinion higher than 100,
	//and thus must be directly set to 100 instead.
	public void setOpinion(UUID subject, UUID object, int value)
	{
		NBTTagCompound relate = relationships.getCompoundTag(subject.toString()+object.toString());
		relate.setInteger("Opinion", value);
	}
	public String getContext(String identifier, UUID object)
	{
		NBTTagCompound relate = relationships.getCompoundTag(identifier+object.toString());
		return relate.getString("Context");
	}
}