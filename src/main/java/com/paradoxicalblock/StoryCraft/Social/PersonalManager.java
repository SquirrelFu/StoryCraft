package com.paradoxicalblock.StoryCraft.Social;

import java.util.Random;

import com.paradoxicalblock.StoryCraft.Main.StoryCraft;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraft.world.storage.MapStorage;
import net.minecraft.world.storage.WorldSavedData;

public class PersonalManager extends WorldSavedData {
	private static final String DATA_NAME = StoryCraft.MODID + "_PersonalData";
	private static NBTTagCompound outlooks = new NBTTagCompound();
	public PersonalManager() {
		super(DATA_NAME);
	}
	public PersonalManager(String s)
	{
		super(s);
	}
	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		outlooks = nbt.getCompoundTag("Personalities");
		
	}
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		compound.setTag("Personalities", outlooks);
		return compound;
	}
	public boolean personalityExists(String string)
	{
		StoryCraft.logger.info("String in: " + string);
		StoryCraft.logger.info(outlooks.getKeySet());
		return outlooks.hasKey(string);
	}
	public void addPersonality(String string)
	{
		int friendliness = new Random().nextInt(200) - 100;
		int bravery = new Random().nextInt(200) - 100;
		int generosity = new Random().nextInt(200) - 100;
		NBTTagCompound personality = new NBTTagCompound();
		personality.setInteger("Friendliness", friendliness);
		personality.setInteger("Bravery",bravery);
		personality.setInteger("Generosity", generosity);
		personality.setString("Orientation", "Straight");
		personality.setInteger("Appearance", -1);
		personality.setInteger("Career", -1);
		outlooks.setTag(string, personality);
		markDirty();
	}
	public void addPersonality(String string, int friendliness)
	{
		int bravery = new Random().nextInt(200) - 100;
		int generosity = new Random().nextInt(200) - 100;
		NBTTagCompound personality = new NBTTagCompound();
		personality.setInteger("Friendliness", friendliness);
		personality.setInteger("Bravery",bravery);
		personality.setInteger("Generosity", generosity);
		personality.setString("Orientation", "Straight");
		personality.setInteger("Appearance", -1);
		personality.setInteger("Career", -1);
		outlooks.setTag(string, personality);
		markDirty();
	}
	public void addPersonality(String string, int friendliness, int bravery)
	{
		int generosity = new Random().nextInt(200) - 100;
		NBTTagCompound personality = new NBTTagCompound();
		personality.setInteger("Friendliness", friendliness);
		personality.setInteger("Bravery",bravery);
		personality.setInteger("Generosity", generosity);
		personality.setString("Orientation", "Straight");
		personality.setInteger("Appearance", -1);
		personality.setInteger("Career", -1);
		outlooks.setTag(string, personality);
		markDirty();
	}
	public void addPersonality(String string, int friendliness, int bravery, int generosity)
	{
		NBTTagCompound personality = new NBTTagCompound();
		personality.setInteger("Friendliness", friendliness);
		personality.setInteger("Bravery",bravery);
		personality.setInteger("Generosity", generosity);
		personality.setString("Orientation", "Straight");
		personality.setInteger("Appearance", -1);
		personality.setInteger("Career", -1);
		outlooks.setTag(string, personality);
		markDirty();
	}
	public void addPersonality(String string, int friendliness, int bravery, int generosity, String sexuality)
	{
		NBTTagCompound personality = new NBTTagCompound();
		personality.setInteger("Friendliness", friendliness);
		personality.setInteger("Bravery",bravery);
		personality.setInteger("Generosity", generosity);
		personality.setString("Orientation", sexuality);
		personality.setInteger("Appearance", -1);
		personality.setInteger("Career", -1);
		outlooks.setTag(string, personality);
		markDirty();
	}
	public void addPersonality(String string, int friendliness, int bravery, int generosity, String sexuality, int appearance)
	{
		NBTTagCompound personality = new NBTTagCompound();
		personality.setInteger("Friendliness", friendliness);
		personality.setInteger("Bravery",bravery);
		personality.setInteger("Generosity", generosity);
		personality.setString("Orientation", sexuality);
		personality.setInteger("Appearance", appearance);
		personality.setInteger("Career", -1);
		outlooks.setTag(string, personality);
		markDirty();
	}
	public void addPersonality(String string, int friendliness, int bravery, int generosity, String sexuality, int appearance, int career)
	{
		NBTTagCompound personality = new NBTTagCompound();
		personality.setInteger("Friendliness", friendliness);
		personality.setInteger("Bravery",bravery);
		personality.setInteger("Generosity", generosity);
		personality.setString("Orientation", sexuality);
		personality.setInteger("Appearance", appearance);
		personality.setInteger("Career", career);
		outlooks.setTag(string, personality);
		markDirty();
	}
	public Integer getFriendly(String string)
	{
		String uuidConvert = string;
		if (outlooks.getCompoundTag(uuidConvert).equals(new NBTTagCompound()) == false)
		{
			NBTTagCompound personality = outlooks.getCompoundTag(uuidConvert);
			return personality.getInteger("Friendliness");
		}
		return null;
	}
	public Integer getBrave(String string)
	{
		String uuidConvert = string;
		if (outlooks.getCompoundTag(uuidConvert).equals(new NBTTagCompound()) == false)
		{
			NBTTagCompound personality = outlooks.getCompoundTag(uuidConvert);
			return personality.getInteger("Bravery");
		}
		return null;
	}
	public Integer getGenerous(String string)
	{
		String uuidConvert = string;
		if (outlooks.getCompoundTag(uuidConvert).equals(new NBTTagCompound()) == false)
		{
			NBTTagCompound personality = outlooks.getCompoundTag(uuidConvert);
			return personality.getInteger("Generosity");
		}
		return null;
	}
	public static PersonalManager get(World world)
	{
		MapStorage storage = world.getMapStorage();
		PersonalManager instance = (PersonalManager) storage.getOrLoadData(PersonalManager.class,DATA_NAME);
		if (instance == null)
		{
			instance = new PersonalManager();
			storage.setData(DATA_NAME, instance);
		}
		return instance;
	}
	public void setOrientation(String string, String sexuality)
	{
		if (outlooks.getCompoundTag(string).equals(new NBTTagCompound()) == false)
		{
			NBTTagCompound personality = outlooks.getCompoundTag(string);
			personality.setString("Orientation", sexuality);
		}
		markDirty();
	}
	public String getOrientation(String string)
	{
		if (outlooks.getCompoundTag(string).equals(new NBTTagCompound()) == false)
		{
			NBTTagCompound personality = outlooks.getCompoundTag(string);
			return personality.getString("Orientation");
		}
		return null;
	}
	public void setAppearance(String string, int appearance)
	{
		if (outlooks.getCompoundTag(string).equals(new NBTTagCompound()) == false)
		{
			NBTTagCompound personality = outlooks.getCompoundTag(string);
			personality.setInteger("Appearance", appearance);
		}
		markDirty();
	}
	public void setCareer(String string, int career)
	{
		if (outlooks.getCompoundTag(string).equals(new NBTTagCompound()) == false)
		{
			NBTTagCompound personality = outlooks.getCompoundTag(string);
			personality.setInteger("Career", career);
		}
		markDirty();
	}
	public Integer getCareer(String string)
	{
		if (outlooks.getCompoundTag(string).equals(new NBTTagCompound()) == false)
		{
			NBTTagCompound personality = outlooks.getCompoundTag(string);
			if (personality.hasKey("Career"))
			{
				if (personality.getInteger("Career") != -1)
				{
					return personality.getInteger("Career");
				}
			}
		}
		return null;
	}
	public Integer getAppearance(String string)
	{
		if (outlooks.getCompoundTag(string).equals(new NBTTagCompound()) == false)
		{
			NBTTagCompound personality = outlooks.getCompoundTag(string);
			if (personality.hasKey("Appearance") == true)
			{
				if (personality.getInteger("Appearance") != -1)
				{
					return personality.getInteger("Appearance");
				}
			}
		}
		return null;
	}
}